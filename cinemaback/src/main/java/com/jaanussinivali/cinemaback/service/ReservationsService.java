package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.model.ReservedSeat;
import com.jaanussinivali.cinemaback.dto.SeatReservationResponse;
import com.jaanussinivali.cinemaback.dto.*;
import com.jaanussinivali.cinemaback.exception.BusinessException;
import com.jaanussinivali.cinemaback.exception.Error;
import com.jaanussinivali.cinemaback.mapper.ReservationMapper;
import com.jaanussinivali.cinemaback.mapper.SeatMapper;
import com.jaanussinivali.cinemaback.model.*;
import com.jaanussinivali.cinemaback.util.SeatSelectionGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {

    @Resource
    private ScreeningsService screeningsService;
    @Resource
    private ReservationService reservationService;
    @Resource
    private ScreeningService screeningService;
    @Resource
    private CinemaUserService cinemaUserService;
    @Resource
    private MovieService movieService;
    @Resource
    private HallService hallService;
    @Resource
    private SeatService seatService;
    @Resource
    private ReservationMapper reservationMapper;
    @Resource
    private SeatMapper seatMapper;

    public ReservationResponse findOrCreateScreeningReservation(Integer screeningId, Integer userId) {
        boolean reservationExists = reservationService.activeReservationWithUserIdAndScreeningIdExists(userId, screeningId);
        Reservation reservation = getExistingOrCreatereNewReservation(screeningId, userId, reservationExists);
        return reservationMapper.toReservationResponse(reservation);
    }

    private Reservation getExistingOrCreatereNewReservation(Integer screeningId, Integer userId, boolean reservationExists) {
        Reservation reservation;
        if (reservationExists) {
            reservation = reservationService.findReservationByUserIdAndScreeningId(userId, screeningId);
        } else {
            reservation = new Reservation();
            getAndSetReservationFields(screeningId, userId, reservation);
            reservationService.saveNewReservation(reservation);
        }
        return reservation;
    }

    private void getAndSetReservationFields(Integer screeningId, Integer userId, Reservation reservation) {
        CinemaUser user = cinemaUserService.findUser(userId);
        Screening screening = screeningService.findScreening(screeningId);
        Hall hall = hallService.findHall(screening.getHall().getId());
        Movie movie = movieService.findMovie(screening.getMovie().getId());
        screening.setMovie(movie);
        screening.setHall(hall);
        reservation.setScreening(screening);
        reservation.setCinemaUser(user);
        reservation.setActive(true);
    }

    public SeatReservationResponse validateAndAddReservedSeatsToReservationOffer(Integer screeningId, Integer reservationId, Integer numberOfSeatsRequest) {
        seatService.deletePreviouslyReservedSeatsByScreeningIdAndReservationIdFromActiveReservation(screeningId, reservationId);

        Screening screening = screeningService.findScreening(screeningId);
        Integer hallId = screening.getHall().getId();
        List<Seat> seats = seatService.findSeatsByHallId(hallId);
        List<ReservedSeat> reservedSeats = seatService.findReservedSeatsByScreeningId(screeningId);
        validateNumberOfSeatsRequestedIsAvailable(numberOfSeatsRequest, seats, reservedSeats);

        Seat lastSeat = seats.getLast();
        Integer numberOfRows = lastSeat.getRow();
        Integer numberOfSeatsInARow = lastSeat.getNumber();

        List<List<SeatResponse>> seatObjectHall = setSeatObjectHall(numberOfRows, numberOfSeatsInARow, reservedSeats);

        List<Integer> offeredSeatsForReservation =
                SeatSelectionGenerator.offerSeatIndexes(numberOfSeatsRequest, seatObjectHall, numberOfRows, numberOfSeatsInARow);

        setAndSaveOfferedReservedSeats(reservationId, offeredSeatsForReservation, seats, screening);
        return setSeatReservationResponse(seatObjectHall, offeredSeatsForReservation);
    }

    private List<List<SeatResponse>> setSeatObjectHall(Integer numberOfRows, Integer numberOfSeatsInARow, List<ReservedSeat> reservedSeats) {
        List<List<SeatResponse>> seatObjectHall = new ArrayList<>();
        int seatIndex = 0;
        for (int i = 0; i < numberOfRows; i++) {
            List<SeatResponse> row = new ArrayList<>();
            for (int j = 0; j < numberOfSeatsInARow; j++) {
                seatIndex++;
                SeatResponse seatResponse = new SeatResponse();
                seatResponse.setId(seatIndex);
                seatResponse.setAvailable(true);
                for (ReservedSeat reservedSeat : reservedSeats) {
                    if (reservedSeat.getSeat().getId() == seatIndex) {
                        seatResponse.setAvailable(false);
                        break;
                    }
                }
                row.add(seatResponse);
            }
            seatObjectHall.add(row);
        }
        return seatObjectHall;
    }

    private void setAndSaveOfferedReservedSeats(Integer reservationId, List<Integer> offeredSeatsForReservation, List<Seat> seats, Screening screening) {
        for (Integer offeredSeat : offeredSeatsForReservation) {
            ReservedSeat reservedSeat = new ReservedSeat();
            Reservation reservation = reservationService.findReservation(reservationId);
            Seat seat = seats.get(offeredSeat-1);
            reservedSeat.setSeat(seat);
            reservedSeat.setScreening(screening);
            reservedSeat.setReservation(reservation);
            seatService.saveReservedSeat(reservedSeat);
        }
    }

    private SeatReservationResponse setSeatReservationResponse(List<List<SeatResponse>> seatObjectHall, List<Integer> offeredSeatsForReservation) {
        SeatReservationResponse response = new SeatReservationResponse();
        response.setSeatObjectHall(seatObjectHall);
        response.setSeatIds(offeredSeatsForReservation);
        return response;
    }

    private void validateNumberOfSeatsRequestedIsAvailable(Integer numberOfSeatsRequest, List<Seat> seats, List<ReservedSeat> reservedSeats) {
        if (isThereNotEnoughSeatsAvailable(numberOfSeatsRequest, seats, reservedSeats)) {
            throw new BusinessException(Error.NOT_ENOUGH_AVAILABLE_SEATS.getMessage(), Error.NOT_ENOUGH_AVAILABLE_SEATS.getErrorCode());
        }
    }

    private boolean isThereNotEnoughSeatsAvailable(Integer numberOfSeatsRequest, List<Seat> seats, List<ReservedSeat> reservedSeats) {
        return seats.size() - reservedSeats.size() < numberOfSeatsRequest;
    }

    public void confirmReservation(Integer reservationId) {
        Reservation reservation = reservationService.findReservation(reservationId);
        reservation.setActive(false);
        reservationService.saveReservation(reservation);
    }

    public List<ReservationsResponse> findCompletedReservations(Integer userId) {
        List<ReservationsResponse> reservationsResponse = new ArrayList<>();
        List<Reservation> reservations = reservationService.findCompletedReservationsByUserId(userId);
        if (reservations.isEmpty()) {
            return reservationsResponse;
        } else {
            for (Reservation reservation : reservations) {
                ReservationsResponse response = new ReservationsResponse();
                ScreeningInfoResponse screeningInfoResponse = screeningsService.findMovieScreening(reservation.getScreening().getId());
                screeningInfoResponse.setMovieDescription("");
                List<Seat> seats = seatService.findReservedSeatsByReservationId(reservation.getId());
                List<SeatInfoResponse> seatsReservationResponse = seatMapper.toSeatsReservationResponse(seats);
                response.setReservedSeats(seatsReservationResponse);
                response.setScreeningInfo(screeningInfoResponse);
                reservationsResponse.add(response);
            }
        }
        return reservationsResponse;
    }
}
