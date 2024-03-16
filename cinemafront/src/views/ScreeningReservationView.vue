<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1" @click="emitChangeView">←</v-tab>
      <v-tab :value="2">Seanss</v-tab>
      <v-tab v-if="isTimeToReserveSeats" :value="3">Broneeri</v-tab>
    </v-tabs>
    <v-window v-if="isMovieScreeningLoaded" v-model="tab">
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-window-item :value="2">
          <v-container fluid>
            <v-row dense>
              <ScreeningDescriptionItem :movieScreening="movieScreening" @event-validate-and-make-reservation="validateAndMakeReservation"/>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item v-if="isTimeToReserveSeats" :value="3">
          <v-container fluid>
            <SeatReservationFrame :reservationHallResponse="reservationHallResponse"/>
          </v-container>
        </v-window-item>
      </v-card>
    </v-window>
  </v-card>
</template>

<script>
import ScreeningDescriptionItem from "@/components/ScreeningDescriptionItem.vue";
import SeatReservationFrame from "@/components/SeatReservationFrame.vue";
import {userId} from "@/assets/constant";

export default {
  name: "ScreeningReservationView",
  components: {SeatReservationFrame, ScreeningDescriptionItem},
  props: {
    screeningId: 0
  },
  data() {
    return {
      userIdConst: userId,
      tab: 1,
      isMovieScreeningLoaded: false,
      movieScreening: {
        id: 0,
        movieId: 0,
        movieTitle: '',
        movieDescription: '',
        movieLength: 0,
        movieReleaseYear: 0,
        hallName: '',
        date: '',
        time: '',
        directors: [
          {
            id: 0,
            name: ''
          }
        ],
        genres: [
          {
            id: 0,
            name: ''
          }
        ],
        languages: [
          {
            id: 0,
            name: ''
          }
        ],
        restrictions: [
          {
            id: 0,
            name: ''
          }
        ],
        subtitles: [
          {
            id: 0,
            name: ''
          }
        ],
        countries: [
          {
            id: 0,
            name: ''
          }
        ]
      },
      isTimeToReserveSeats: false,
      numberOfReservedSeats: 1,
      userReservationResponse: {
        id: 0
      },
      userReservationError : {
        message: '',
        errorCode: 0
      },
      reservationHallResponse: {
        seatIds: [
          Number
        ],
        hall: [
          [
            {
              id: Number,
              available: Boolean
            }
          ]
        ]

      },
      reservationHallError : {
        message: '',
        errorCode: 0
      }
    }
  },
  methods: {
    getMovieScreening() {
      this.$http.get("/api/screening", {
          params: {
            screeningId: this.screeningId,
          }
        }
      ).then(response => {
        this.movieScreening = response.data
        this.isMovieScreeningLoaded = true
      }).catch(error => {
        alert("Otsitavat seanssi ei leitud")
        // const errorResponseBody = error.response.data
      })
    },
    getUserReservation() {
      this.$http.get("/api/reservation", {
          params: {
            screeningId: this.screeningId,
            userId: this.userIdConst
          }
        }
      ).then(response => {
        this.userReservationResponse = response.data
      }).catch(error => {
        this.userReservationError = error.response.data
        alert('message: ' + this.userReservationError.message + ' code: ' + this.userReservationError.errorCode)
      })
    },
    createScreeningReservation() {
      this.$http.post("/api/reservation-seats", null, {
          params: {
            screeningId: this.movieScreening.id,
            reservationId: this.movieScreening.id,
            numberOfSeats: this.numberOfReservedSeats
          }
        }
      ).then(response => {
        this.reservationHallResponse = response.data
        // go to reservation tab...
      }).catch(error => {
        this.reservationHallError = error.response.data
        alert('message: ' + this.reservationHallError.message + ' code: ' + this.reservationHallError.errorCode)
      })
    },
    emitChangeView() {
      this.$emit("event-change-page")
    },
    validateAndMakeReservation(numberOfSeats) {

      this.numberOfReservedSeats = numberOfSeats
      this.createScreeningReservation()
      // make reservation if there are enough seats available
      // this.isTimeToReserveSeats = true
      // this.tab = 2
    },
  },
  beforeMount() {
    this.getMovieScreening()
    this.getUserReservation()
  }

}
</script>
