<template>
  <div class="d-flex flex-column align-center pa-6">
    <v-row v-for="(row, rowIndex) in reservationHallResponse.hall" :key="rowIndex">
      <v-col v-for="(seat, seatIndex) in row" :key="seatIndex">
        <v-btn-toggle v-model="seat.occupied" @change="toggleSeat(rowIndex, seatIndex)">
          <v-btn :disabled="seat.occupied">
            <span>Seat {{ rowIndex + 1 }} - {{ seatIndex + 1 }}</span>
            <v-icon>mdi-chair</v-icon>
          </v-btn>
        </v-btn-toggle>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "SeatReservationFrame",
  props: {
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
    }
  },
  data() {
    return {
      toggle: [],
    }
  },
  methods: {
    toggleSeat(rowIndex, seatIndex) {
      this.reservationHallResponse.hall[rowIndex][seatIndex].occupied = !this.reservationHallResponse.hall[rowIndex][seatIndex].occupied;
    }
  }
}
</script>
