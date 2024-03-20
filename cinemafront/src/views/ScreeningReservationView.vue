<template>
  <v-card class="mx-auto" color="#212121" max-width="800">
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1" @click="emitChangeView">Tagasi</v-tab>
      <v-tab :value="2" @click="refreshTab">Seanss</v-tab>
      <v-tab v-if="isTimeToReserveSeats" :value="3">Broneeri</v-tab>
    </v-tabs>
    <v-window v-if="isMovieScreeningLoaded" v-model="tab">
      <v-card>
        <v-window-item :value="2">
          <v-container fluid>
            <v-row dense>
              <ScreeningDescriptionItem :movieScreening="movieScreening"
                                        @event-validate-and-make-reservation="validateAndMakeReservation"/>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item v-if="isTimeToReserveSeats" :value="3">
          <v-container fluid>
            <SeatReservationFrame :reservationHallResponse="reservationHallResponse"
                                  @event-confirm-reservation="confirmReservation"/>
          </v-container>
        </v-window-item>
      </v-card>
    </v-window>
  </v-card>

  <div class="text-center pa-4">
    <v-dialog persistent v-model="showConfirmationDialog" width="auto">
      <v-card max-width="400" text="Oma lõpetatud reserveeringuid saab vaadata avalehe alamaknas HILJUTISED."
              title="Kohtade broneerimine õnnestus!">
        <template v-slot:actions>
          <v-btn class="ms-auto" text="Tagasi programmi vaatesse" @click="handleConfirmationDialogClose"></v-btn>
        </template>
      </v-card>
    </v-dialog>
  </div>
  <div class="text-center pa-4">
    <v-dialog v-model="showTooManySeatsRequestedDialog" width="auto">
      <v-card max-width="400" title="Toiming ebõnnestus"
              text="Nii palju kohti ei ole saadaval, palun sisesta väiksem arv.">
        <template v-slot:actions>
          <v-btn class="ms-auto" text="Sulge" @click="showTooManySeatsRequestedDialog = false"></v-btn>
        </template>
      </v-card>
    </v-dialog>
  </div>
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
      showConfirmationDialog: false,
      showTooManySeatsRequestedDialog: false,
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
      numberOfReservedSeats: Number,
      userReservationResponse: {
        id: 0
      },
      userReservationError: {
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
      reservationHallError: {
        message: '',
        errorCode: 0
      }
    }
  },
  watch: {
    isTimeToReserveSeats(isTime) {
      if (isTime) this.tab++
      else this.tab = 2
    },
    showConfirmationDialog() {

    },
    reservationHallError() {
      this.showTooManySeatsRequestedDialog = true
    },
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
            reservationId: this.userReservationResponse.id,
            numberOfSeatsRequest: this.numberOfReservedSeats
          }
        }
      ).then(response => {
        this.reservationHallResponse = response.data
        this.isTimeToReserveSeats = true
      }).catch(error => {
        this.reservationHallError = error.response.data
      })
    },
    confirmReservation() {
      this.$http.post("/api/reservation-confirm", null, {
          params: {
            reservationId: this.userReservationResponse.id
          }
        }
      ).then(response => {
        this.openReservationConfirmationDialog()
      }).catch(error => {
        const errorResponseBody = error.response.data
      })
    },
    emitChangeView() {
      this.$emit("event-change-page")
    },
    refreshTab() {
      this.isTimeToReserveSeats = false
    },
    validateAndMakeReservation(numberOfSeats) {
      this.numberOfReservedSeats = numberOfSeats
      this.createScreeningReservation()
    },
    openReservationConfirmationDialog() {
      this.showConfirmationDialog = true
    },
    handleConfirmationDialogClose() {
      this.showConfirmationDialog = false
      this.emitChangeView()
    },
  },
  beforeMount() {
    this.getMovieScreening()
    this.getUserReservation()
  }
}
</script>
