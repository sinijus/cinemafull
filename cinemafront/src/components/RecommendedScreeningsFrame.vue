<template>
  <v-container fluid>
    <v-card>
      <v-card-title>
        Soovitatud seanssid:
      </v-card-title>
    </v-card>
    <v-row dense>
      <v-col v-for="screening in recommendedScreenings" :key="screening" cols="12">
        <ScreeningListItem :screening="screening" @click="emitChangePage(screening.id)"/>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import ScreeningListItem from "@/components/ScreeningListItem.vue"

export default {
  name: 'RecommendedScreeningsFrame',
  components: {ScreeningListItem},
  data() {
    return {
      recommendedScreenings: [
        {
          id: 0,
          movieId: 0,
          movieTitle: '',
          movieReleaseYear: 0,
          hallName: '',
          date: '2024-03-19',
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
          ]
        }
      ]
    }
  },
  methods: {
    getMovieScreeningRecommendations() {
      this.$http.get("/api/recommendations")
        .then(response => {
          this.recommendedScreenings = response.data
        })
        .catch(error => {
          const errorResponseBody = error.response.data
        })
    },
    emitChangePage(id) {
      this.$emit("event-change-page", id)
    },
  },
  beforeMount() {
    this.getMovieScreeningRecommendations()
  }
}
</script>
