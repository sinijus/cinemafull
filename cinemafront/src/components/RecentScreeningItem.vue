<template>
  <v-card max-width="800" variant="tonal" fluid>
    <v-row>
      <v-col cols="6">
        <v-card-subtitle>
          <div>
            {{ getDayName(reservationScreening.screeningInfo.date) }}
            {{ reformatDate(reservationScreening.screeningInfo.date) }}
            {{ reformatTime(reservationScreening.screeningInfo.time) }}
          </div>
          <div>
            {{ reservationScreening.screeningInfo.movieTitle }} ({{
              reservationScreening.screeningInfo.movieReleaseYear
            }})
          </div>
          <div>
            <template v-for="director in reservationScreening.screeningInfo.directors" :key="director.id">
              <v-card-subtitle> {{ director.name }}</v-card-subtitle>
            </template>
          </div>
          <div> Žanr:
            <template v-for="genre in reservationScreening.screeningInfo.genres" :key="genre.id">
              <span>{{ genre.name }}</span>
              <span> - </span>
            </template>
          </div>
          <div> Keel:
            <template v-for="language in reservationScreening.screeningInfo.languages" :key="language.id">
              <span> {{ language.name }} keel</span>
              <span> - </span>
            </template>
          </div>
          <div v-if="restrictionIsApplied"> {{ reservationScreening.screeningInfo.restrictions[0].name }}</div>
        </v-card-subtitle>
      </v-col>
      <v-col cols="6">
        <v-card-text>
          <div>
            Istekohad:
            <template v-for="(seat, index) in reservationScreening.reservedSeats" :key="seat">
              <v-card-subtitle>
                <div> {{ index + 1 }}. -
                  <span> rida: {{ seat.row }} ,koht: {{ seat.number }}</span>
                </div>
              </v-card-subtitle>
            </template>
          </div>
        </v-card-text>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import {getDayName, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: "RecentScreeningItem",
  methods: {reformatTime, reformatDate, getDayName},
  props: {
    reservationScreening: {
      reservedSeats: [
        {
          row: 0,
          number: 0
        }
      ],
      screeningInfo: {
        id: 0,
        movieId: 0,
        movieTitle: '',
        movieDescription: '',
        movieLength: 0,
        movieReleaseYear: 0,
        hallName: '',
        date: '2024-03-16',
        time: '00:00',
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
      }
    }
  }
}
</script>

