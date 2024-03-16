<template>
  <v-card variant="tonal" fluid>
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
            <template v-for="(genre, index) in reservationScreening.screeningInfo.genres" :key="genre.id">
              <span>{{ genre.name }}</span>
              <span v-if="notLastElementInArray(index,reservationScreening.screeningInfo.genres.length)"> - </span>
            </template>
          </div>
          <div> Keel:
            <template v-for="(language, index) in reservationScreening.screeningInfo.languages" :key="language.id">
              <span> {{ language.name }} keel</span>
              <span v-if="notLastElementInArray(index, reservationScreening.screeningInfo.languages.length)"> - </span>
            </template>
          </div>
          <div> Subtiitrid:
            <template v-for="(subtitle, index) in reservationScreening.screeningInfo.subtitles" :key="subtitle.id">
              <span> {{ subtitle.name }} keel</span>
              <span v-if="notLastElementInArray(index, reservationScreening.screeningInfo.subtitles.length)"> - </span>
            </template>
          </div>
          <div>
            {{ reservationScreening.screeningInfo.restrictions[0].name }}
          </div>
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
import {getDayName, notLastElementInArray, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: "RecentScreeningItem",
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
  },
  methods: {notLastElementInArray, reformatTime, reformatDate, getDayName},

}
</script>

