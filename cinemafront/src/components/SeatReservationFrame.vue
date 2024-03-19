<template>
  <v-card max-width="">
    <div class="d-flex flex-column align-center">
      <v-card-subtitle>
        <div>Ekraan</div>
      </v-card-subtitle>
      <v-row>
        <v-col></v-col>
      </v-row>

      <v-row v-for="(row, rowIndex) in reservationHallResponse.seatObjectHall" :key="rowIndex">
        <v-col>
          <v-btn-toggle disabled class="custom-button" variant="text">
            <v-btn>
              {{ rowIndex + 1 }}
            </v-btn>
          </v-btn-toggle>
        </v-col>

        <v-col v-for="(seat, seatIndex) in row" :key="seatIndex">
          <v-btn-toggle :disabled="true" class="custom-button"
                        :class="{ 'selected-color': isSeatSelected(seat.id), 'occupied-color': !seat.available }">
            <v-btn class="text-center"
                   :class="{ 'blue--text': isSeatSelected(seat.id), 'red--text': !seat.available }">
              <span>{{ seatIndex + 1 }}</span>
            </v-btn>
          </v-btn-toggle>
        </v-col>

      </v-row>
      <v-row justify="center">
        <v-col cols="auto">
          <v-btn size="x-large" variant="tonal" @click="emitConfirmReservation">
            Kinnita kohad
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
      seatIds: [0],
      seatObjectHall: [[{ id: Number, available: Boolean }]]
    }
  },
  methods: {
    isSeatSelected(id) {
      return this.reservationHallResponse.seatIds.includes(id);
    },
    emitConfirmReservation() {
      this.$emit("event-confirm-reservation");
    }
  }
};
</script>

<style scoped>
.occupied-color {
  background-color: #B71C1C;
}

.selected-color {
  background-color: #1E88E5;
}

.blue--text {
  color: #1E88E5 !important;
}

.red--text {
  color: #B71C1C !important;
}

.custom-button {
  width: 2.5rem;
}

.custom-button v-btn {
  font-size: 0.7rem;
}
</style>
