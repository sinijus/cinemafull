<template>
  <v-card max-width="">
    <div class="d-flex flex-column align-center ">
      <v-card-subtitle>
        <div>Ekraan</div>
      </v-card-subtitle>
      <v-row>
        <v-col></v-col>
      </v-row>

      <v-row v-for="(row, rowIndex) in reservationHallResponse.seatObjectHall" :key="rowIndex">
        <v-col>
          <v-btn-toggle disabled class="custom-button" variant="text">
            <v-btn >
              {{ rowIndex + 1 }}
            </v-btn>
          </v-btn-toggle>
        </v-col>

        <v-col v-for="(seat, seatIndex) in row" :key="seatIndex">
          <v-btn-toggle disabled class="custom-button" v-model="seat.available" @change="toggleSeat(rowIndex, seatIndex)"
                        variant="tonal"
                        :class="{ 'occupied-color': !seat.available, 'selected-color': seat.selected, 'available-color': seat.available }">
            <v-btn  class="text-center"> <!-- Apply the text-center class here -->
              <span>{{ seatIndex + 1 }}</span>
            </v-btn>
          </v-btn-toggle>
        </v-col>

      </v-row>
      <v-row justify="center">
        <v-col cols="auto">
          <v-btn size="x-large" variant="tonal" @Click="emitConfirmReservation">Kinnita kohad
          </v-btn>
        </v-col>
      </v-row>
    </div>
  </v-card>
</template>

<script>
export default {
  name: "SeatReservationFrame",
  props: {
    reservationHallResponse: {
      seatIds: [
        Number
      ],
      seatObjectHall: [
        [
          {
            id: Number,
            available: Boolean
          }
        ]
      ]
    }
  },
  data() {
    return {}
  },
  methods: {
    toggleSeat(rowIndex, seatIndex) {
      this.reservationHallResponse.hall[rowIndex][seatIndex].available = !this.reservationHallResponse.hall[rowIndex][seatIndex].available;
    },
    emitConfirmReservation() {
      this.$emit("event-confirm-reservation")
    },
  }
}
</script>

<style scoped>
.occupied-color {
  background-color: #B71C1C;
}

.selected-color {
  background-color: #1E88E5;
}

.available-color {
  background-color: #696969;
}

.custom-button {
  width: 2.5rem; /* Adjust width as needed */
}

.custom-button v-btn {
  font-size: 0.7rem; /* Adjust font-size as needed */
}
</style>

