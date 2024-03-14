package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.ReservationResponse;
import com.jaanussinivali.cinemaback.dto.SeatReservationResponse;
import com.jaanussinivali.cinemaback.dto.SeatResponse;
import com.jaanussinivali.cinemaback.exception.BusinessException;
import com.jaanussinivali.cinemaback.exception.Error;
import com.jaanussinivali.cinemaback.mapper.ReservationMapper;
import com.jaanussinivali.cinemaback.model.*;
import com.jaanussinivali.cinemaback.util.SeatSelectionGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {

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

    public SeatReservationResponse validateAndAddReservedSeatsToReservationOffer(Integer screeningId, Integer reservationId, Integer hallId, Integer numberOfSeatsRequest) {
        List<Seat> seats = seatService.findSeatsByHallId(hallId);
        List<ReservedSeat> reservedSeats = seatService.findReservedSeatsByScreeningId(screeningId);
        validateNumberOfSeatsRequestedIsAvailable(numberOfSeatsRequest, seats, reservedSeats);

        Seat lastSeat = seats.get(seats.size() - 1);
        Integer numberOfRows = lastSeat.getRow();
        Integer seatsInARow = lastSeat.getNumber();

        List<List<SeatResponse>> seatObjectHall = new ArrayList<>();
        List<Integer> reservedSeatIds = new ArrayList<>();

        int seatIndex = 0;
        for (int i = 0; i < numberOfRows; i++) {
            List<SeatResponse> row = new ArrayList<>();
            for (int j = 0; j < seatsInARow; j++) {
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
        List<Integer> offeredSeatsForReservation =
                SeatSelectionGenerator.offerSeatIndexes(numberOfSeatsRequest, reservedSeatIds, seatObjectHall, numberOfRows, seatsInARow);


        //TODO reserve offered seats through reservation

        return setSeatReservationResponse(seatObjectHall, offeredSeatsForReservation);
    }

    private static SeatReservationResponse setSeatReservationResponse(List<List<SeatResponse>> hall, List<Integer> offeredSeatsForReservation) {
        SeatReservationResponse response = new SeatReservationResponse();
        response.setHall(hall);
        response.setSeatIds(offeredSeatsForReservation);
        return response;
    }

    private static void validateNumberOfSeatsRequestedIsAvailable(Integer numberOfSeatsRequest, List<Seat> seats, List<ReservedSeat> reservedSeats) {
        if (isThereNotEnoughSeatsAvailable(numberOfSeatsRequest, seats, reservedSeats)) {
            throw new BusinessException(Error.NOT_ENOUGH_AVAILABLE_SEATS.getMessage(), Error.NOT_ENOUGH_AVAILABLE_SEATS.getErrorCode());
        }
    }

    private static boolean isThereNotEnoughSeatsAvailable(Integer numberOfSeatsRequest, List<Seat> seats, List<ReservedSeat> reservedSeats) {
        return seats.size() - reservedSeats.size() < numberOfSeatsRequest;
    }


}
