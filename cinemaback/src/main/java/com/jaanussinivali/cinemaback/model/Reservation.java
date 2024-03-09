package com.jaanussinivali.cinemaback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reservation", schema = "cinema")
public class Reservation {
    @EmbeddedId
    private ReservationId id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinema_user_id", nullable = false)
    private CinemaUser cinemaUser;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

}