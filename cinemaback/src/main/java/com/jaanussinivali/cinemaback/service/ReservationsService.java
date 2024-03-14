package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.ReservationResponse;
import com.jaanussinivali.cinemaback.exception.BusinessException;
import com.jaanussinivali.cinemaback.exception.Error;
import com.jaanussinivali.cinemaback.mapper.ReservationMapper;
import com.jaanussinivali.cinemaback.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    public void validateAndAddReservedSeatsToReservationOffer(Integer screeningId, Integer userId, Integer reservationId, Integer hallId, Integer numberOfSeatsRequest) {
        List<Seat> seats = seatService.findSeatsByHallId(hallId);
        List<ReservedSeat> reservedSeats = seatService.findReservedSeatsByScreeningId(screeningId);
        validateNumberOfSeatsIsAvailable(numberOfSeatsRequest, seats, reservedSeats);



        //TODO pakub algoritmi alusel vabad kohad
        //TODO tagastab saali plaani massiivi(seats,rows) istekoha objektidena[seat_id, available(true/false)] + reserveeritud kohad
    }

    private static void validateNumberOfSeatsIsAvailable(Integer numberOfSeats, List<Seat> seats, List<ReservedSeat> reservedSeats) {
        if (seats.size() - reservedSeats.size() < numberOfSeats) {
            throw new BusinessException(Error.NOT_ENOUGH_AVAILABLE_SEATS.getMessage(), Error.NOT_ENOUGH_AVAILABLE_SEATS.getErrorCode());
        }
    }
}
