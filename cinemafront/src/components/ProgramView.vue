<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1">Recent</v-tab>
      <v-tab :value="2">Program</v-tab>
      <v-tab :value="3">Recommendations</v-tab>
    </v-tabs>
    <v-window v-model="tab">
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-window-item :value="1">
          <v-container fluid>
            <v-row dense>
              <v-col v-for="n in 5" :key="n" cols="12">
                RECENT
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="2">
          <v-container fluid>
            <v-row dense>
              <v-col v-for="screening in screenings" :key="screening" cols="12">
                <ScreeningListItem :screening="screening"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="3">
          <v-container fluid>
            <v-row dense>
              <v-col cols="12">
                <ScreeningListItem :screening="screenings[1]"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
      </v-card>
    </v-window>
  </v-card>
</template>

<script>
import ScreeningListItem from "@/components/ScreeningListItem.vue";

export default {
  name: "ProgramView",
  components: {ScreeningListItem},

  data() {
    return {
      tab: null,
      screenings: [
        {
          id: 0,
          movieId: 0,
          movieTitle: '',
          movieReleaseYear: 0,
          hallName: '',
          date: '2024-03-12',
          time: {
            hour: 0,
            minute: 0,
            second: 0,
            nano: 0
          },
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
    getMovieScreenings: function () {
      this.$http.get("/api/screenings"
      ).then(response => {
        this.screenings = response.data
      }).catch(() => {
      })
    },
  },
  beforeMount() {
    this.getMovieScreenings()
  }
}
</script>
