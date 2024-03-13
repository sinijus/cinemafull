<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1">Hiljutised</v-tab>
      <v-tab :value="2">Programm</v-tab>
      <v-tab :value="3">Soovitused</v-tab>
    </v-tabs>

    <v-window v-model="tab">
      <v-card v-if="screeningsLoaded" class="mx-auto" color="#212121" max-width="800">
        <v-window-item :value="1">
          <v-container fluid>
            <v-row dense>
              <v-col v-for="recentScreening in recentScreenings" :key="recentScreening" cols="12">
                <ScreeningReservationItem :recentScreening="recentScreening"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="2">
          <v-container fluid>
            <v-row  dense>
              <v-col v-for="screening in screenings" :key="screening" cols="12">
                <ScreeningListItem :screening="screening"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="3">
          <v-container fluid>
            <v-row  dense>
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
import ScreeningReservationItem from "@/components/ScreeningReservationItem.vue";

export default {
  name: "ProgramView",
  components: {ScreeningReservationItem, ScreeningListItem},

  data() {
    return {
      tab: 2,
      screenings: [
        {
          id: 0,
          movieId: 0,
          movieTitle: '',
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
          ]
        }
      ],
      screeningsLoaded: false,
      recentScreenings: [1],
    }
  },
  methods: {
    getMovieScreenings: function () {
      this.$http.get("/api/screenings"
      ).then(response => {
        this.screenings = response.data
        this.screeningsLoaded = true
      }).catch(() => {
      })
    },
  },
  beforeMount() {
    this.getMovieScreenings()
  }
}
</script>
