
<template>
  <v-card>

  </v-card>
</template>

<script>
export default {
  name: "SeatReservationFrame",
  props:{
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
  }
}
</script>
