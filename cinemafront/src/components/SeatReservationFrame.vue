<template>
  <v-card>
    <div class="d-flex flex-column align-center">
      <v-row >
        <v-col>
          <v-btn-toggle disabled variant="text" density="compact" style="width: 2dvi">
            <v-btn style="font-size: smaller">
            </v-btn>
          </v-btn-toggle>
        </v-col>
        <v-col v-for="(n,index) in  reservationHallResponse.seatObjectHall[0]" :key="index">
          <v-btn-toggle disabled variant="text" density="compact" style="width: 2dvi">
            <v-btn style="font-size: smaller">
              <span>{{ index }} </span>
            </v-btn>
          </v-btn-toggle>
        </v-col>
      </v-row>
      <v-row v-for="(row, rowIndex) in reservationHallResponse.seatObjectHall" :key="rowIndex">
        <v-col>
          <v-btn-toggle disabled variant="text" density="compact" style="width: 2dvi">
            <v-btn style="font-size: smaller">
            </v-btn>
          </v-btn-toggle>
        </v-col>
        <v-col v-for="(seat, seatIndex) in row" :key="seatIndex">
          <v-btn-toggle disabled v-model="seat.available" @change="toggleSeat(rowIndex, seatIndex)"
                        variant="tonal" density="compact" style="width: 2dvi"
                        :class="{ 'occupied-color': !seat.available, 'selected-color': seat.selected, 'available-color': seat.available }"
          >
            <v-btn style="font-size: smaller">
              <span> {{ seat.id }}</span>
              <!--            <v-icon>mdi-chair</v-icon>-->
            </v-btn>
          </v-btn-toggle>
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
    }
  }
}
</script>
<style scoped>
.occupied-color {
  background-color: #B71C1C;
}

.selected-color {
  background-color: #1E88E5; /* Set the background color for selected seats */
}

.available-color {
  background-color: #388E3C; /* Set the background color for available seats */
}
</style>
