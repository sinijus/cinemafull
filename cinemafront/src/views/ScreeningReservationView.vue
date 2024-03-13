<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1" @click="emitChangeView"> <-</v-tab>
      <v-tab :value="2">Seanss</v-tab>
      <v-tab v-if="isTimeToReserveSeats" :value="3">Broneeri</v-tab>
    </v-tabs>
    <v-window v-model="tab">
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-window-item :value="2">
          <v-container fluid>
            <v-row dense>
              <ScreeningDescription :movieScreening="movieScreening" />
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item v-if="isTimeToReserveSeats" :value="3">
          <v-container fluid>
            Reserve seats
          </v-container>
        </v-window-item>
      </v-card>
    </v-window>
  </v-card>
</template>

<script>
import ScreeningDescription from "@/components/ScreeningDescription.vue";

export default {
  name: "ScreeningReservationView",
  components: {ScreeningDescription},
  props: {
    screeningId: 0
  },
  data() {
    return {
      isTimeToReserveSeats: false,
      movieScreening: {
        id: 0,
        movieId: 0,
        movieTitle: '',
        movieDescription: '',
        movieLength: 0,
        movieReleaseYear: 0,
        hallName: '',
        date: '',
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
  },
  methods: {
    getMovieScreening() {
      this.$http.get("/some/path", {
          params: {
            screeningId: this.screeningId,
          }
        }
      ).then(response => {
        this.movieScreening = response.data
      }).catch(error => {
        alert("Otsitavat seanssi ei leitud")
        // const errorResponseBody = error.response.data
      })
    },
    emitChangeView() {
      this.$emit("event-change-page")
    },
  },
  beforeMount() {
    this.getMovieScreening()
  }

}
</script>
