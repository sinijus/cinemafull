package com.jaanussinivali.cinemaback.controller;

import com.jaanussinivali.cinemaback.exception.ApiError;
import com.jaanussinivali.cinemaback.dto.ReservationResponse;
import com.jaanussinivali.cinemaback.service.ReservationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    @Resource
    private ReservationsService reservationsService;

    @GetMapping("/reservation")
    @Operation(summary = "Leiab olemasoleva või loob uue broneeringu, kasutaja ja seanssi id-de alusel, tagastab  broneeringu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Uue reserveeringu tegemine ei õnnestunud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ReservationResponse findOrCreateScreeningReservation(@RequestParam Integer screeningId, @RequestParam Integer userId) {
        return reservationsService.findOrCreateScreeningReservation(screeningId, userId);
    }

    @PostMapping("/reservation-seats")
    @Operation(summary = "Kontrollib kas valitud arv vabu kohti on saadaval, broneerib need ning tagastab saali plaani koos vabade kohtadega")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Istekohtade lisamine ei õnnestunud",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void validateAndAddReservedSeatsToReservation(@RequestParam Integer screeningId, @RequestParam Integer userId, @RequestParam Integer numberOfSeats) {
        reservationsService.validateAndAddReservedSeatsToReservationOffer(screeningId, userId, numberOfSeats);
    }

//    @PutMapping("reservation-seats")
}
