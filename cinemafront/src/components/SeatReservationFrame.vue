
<template>
  <v-card>
    <section>

      <v-card-text>

        <div> {{  }}i kohtade valik: :
          <template v-for="genre in movieScreening.genres" :key="genre.id">
            <span>{{ genre.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="language in movieScreening.languages" :key="language.id">
            <span> {{ language.name }} </span>
            <span> - </span>
          </template>
        </div>
        <div> Subtiitrid:
          <template v-for="subtitle in movieScreening.subtitles" :key="subtitle.id">
            <span> {{ subtitle.name }} </span>
            <span> - </span>
          </template>
        </div>
        <div v-if="restrictionIsApplied"> {{ movieScreening.restrictions[0].name }}</div>
      </v-card-text>
    </section>

    <v-row justify="center">
      <v-col cols="auto">
        <v-btn size="x-large" variant="tonal" @Click="emitValidateAndMakeReservation(this.numberOfSeats)">Broneeri
        </v-btn>
      </v-col>
    </v-row>
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
