<template>
  <v-card>
    <v-tabs v-model="tabs" align-tabs="center" color="#FFFFFF">
      <v-tab :id="1">Hiljutised</v-tab>
      <v-tab :id="2">Programm</v-tab>
      <v-tab :id="3">Soovitused</v-tab>
    </v-tabs>
    <v-window v-model="tabs" >
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-window-item :id="1">
          <v-container fluid>
            <v-row dense>
              <v-col v-for="recentScreening in recentScreenings" :key="recentScreening" cols="12">
                <ScreeningReservationItem :recentScreening="recentScreening"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :id="2">
          <v-container fluid>
            <v-row dense>
              <v-col v-for="screening in screenings" :key="screening" cols="12">
                <ScreeningListItem :screening="screening" @click=""/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :id="3">
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
import ScreeningReservationItem from "@/components/ScreeningReservationItem.vue";

export default {
  name: "ProgramView",
  components: {ScreeningReservationItem, ScreeningListItem},

  data() {
    return {
      active_tab: 1,
      tabs: null,
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
      recentScreenings: [1],
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
