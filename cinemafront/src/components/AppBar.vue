<template>
  <v-app-bar color="#C62828" height="120" app>

    <v-menu>
      <template v-slot:activator="{ props }">
        <v-btn icon="mdi-dots-vertical" v-bind="props"></v-btn>
      </template>
      <v-list v-if="showInsertRandomReservations">
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppBar",
  data() {
    return {
      items: [
        {title: 'Lisa kõikidele seanssidele 8 broneeringut kohtadega 1-10'},
      ],
      randomBookingUserIdConst: 2,
      showInsertRandomReservations: true,
      userReservationResponse: {
        id: 0
      },
      screeningId: 1,
      numberOfSeatsRequest: 1
    }
  },
  methods: {
    addEightRandomReservationsToAllScreenings() {
      alert("clicked")
      const nrOfAllScreenings = 11
      for (let i = 1; i <= nrOfAllScreenings; i++) {
        this.screeningId = i
        for (let j = 0; j < 8; j++) {
          this.numberOfSeatsRequest = 10
            // this.getRandomNumber(1, 10)
          // methods getUserReservation, createScreeningReservation, confirmReservation
          // are calling one another in their response blocks
          this.getUserReservation()
        }
      }
      this.showInsertRandomReservations = false
      alert("all done")
    },
    getRandomNumber(numberFrom, numberUntil) {
      return Math.floor(Math.random() * (numberUntil - numberFrom)) + numberFrom;
    },
    getUserReservation() {
      this.$http.get("/api/reservation", {
          params: {
            screeningId: this.screeningId,
            userId: this.randomBookingUserIdConst
          }
        }
      ).then(response => {
        this.userReservationResponse = response.data
        this.createScreeningReservation()
      }).catch(error => {
      })
    },
    createScreeningReservation() {
      this.$http.post("/api/reservation-seats", null, {
          params: {
            screeningId: this.screeningId,
            reservationId: this.userReservationResponse.id,
            numberOfSeatsRequest: this.numberOfSeatsRequest
          }
        }
      ).then(response => {
        this.confirmReservation()
      }).catch(error => {
      })
    },
    confirmReservation() {
      this.$http.post("/api/reservation-confirm", null, {
          params: {
            reservationId: this.userReservationResponse.id
          }
        }
      ).then(response => {
      }).catch(error => {
      })
    },
  }
}
</script>
