<template>
    <v-container fluid>
      <v-card variant="tonal">
        <v-card-title>
            Lõpetatud reserveeringute info:
        </v-card-title>
      </v-card>
      <v-row v-if="reservationScreeningsLoaded">
        <v-col v-for="reservationScreening in reservationScreenings" :key="reservationScreening" cols="12">
          <v-divider :thickness="5"></v-divider>
          <RecentScreeningItem :reservation-screening="reservationScreening"/>
        </v-col>
      </v-row>
    </v-container>


</template>
<script>
import ScreeningReservationItem from "@/components/ScreeningReservationItem.vue"
import RecentScreeningItem from "@/components/RecentScreeningItem.vue";
import {userId} from "@/assets/constant";

export default {
  name: 'RecentScreeningsFrame',
  components: {RecentScreeningItem, ScreeningReservationItem},
  data() {
    return{
      userIdConst: userId,
      reservationScreeningsLoaded: false,
      reservationScreenings: [
        {
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
          }
        }
      ]
    }
  },
  methods: {
    i() {
      return i
    },
    getReservationScreenings() {
      this.$http.get("/api/reservations", {
          params: {
            userId: userId,
          }
        }
      ).then(response => {
        this.reservationScreenings = response.data
        this.reservationScreeningsLoaded = true
      }).catch(error => {
        const errorResponseBody = error.response.data
      })
    },

  },
  beforeMount() {
    this.getReservationScreenings()
  }
}
</script>
