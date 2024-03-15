package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.dto.ReservationsResponse;
import com.jaanussinivali.cinemaback.dto.SeatReservationResponse;
import com.jaanussinivali.cinemaback.exception.ApiError;
import com.jaanussinivali.cinemaback.dto.ReservationResponse;
import com.jaanussinivali.cinemaback.service.ReservationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Resource
    private ReservationsService reservationsService;

    @GetMapping("/reservations")
    @Operation(summary = "Leiab kõik kasutaja kinnitatud broneeringud koos seanssi, filmi ja istekohtade infoga")
    public List<ReservationsResponse> findCompletedReservations(@RequestParam @Min(0) Integer userId) {
        return reservationsService.findCompletedReservations(userId);
    }

    @GetMapping("/reservation")
    @Operation(summary = "Leiab olemasoleva või loob uue broneeringu, kasutaja ja seanssi id-de alusel, tagastab  broneeringu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Uue reserveeringu tegemine ei õnnestunud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ReservationResponse findOrCreateScreeningReservation(@RequestParam @Min(1) Integer screeningId, @RequestParam @Min(1) Integer userId) {
        return reservationsService.findOrCreateScreeningReservation(screeningId, userId);
    }

    @PostMapping("/reservation-seats")
    @Operation(summary = "Kontrollib kas valitud arv vabu kohti on saadaval, broneerib need ning tagastab saali plaani koos vabade kohtadega")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Istekohtade lisamine ei õnnestunud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public SeatReservationResponse validateAndAddReservedSeatsToReservation(@RequestParam @Min(1) Integer screeningId,
                                                                            @RequestParam @Min(1) Integer reservationId,
                                                                            @RequestParam(defaultValue = "1") @Min(0) Integer numberOfSeatsRequest) {
        return reservationsService.validateAndAddReservedSeatsToReservationOffer(screeningId, reservationId, numberOfSeatsRequest);
    }

    @PostMapping("/reservation-confirm")
    @Operation(summary = "kinnitab reserveeringu")
    public void confirmReservation(@RequestParam @Min(1) Integer reservationId) {
        reservationsService.confirmReservation(reservationId);
    }
}
