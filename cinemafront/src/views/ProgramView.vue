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
          <RecentScreeningsFrame cols="12"/>
        </v-window-item>
        <v-window-item :value="2">

          <FilterSearchField/>

          <v-container fluid>
            <v-row dense>
              <v-col v-for="screening in screenings" :key="screening" cols="12">
                <ScreeningListItem :screening="screening" @click="emitChangeView(screening.id)"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="3">
          <RecommendedScreeningsFrame :screenings="screenings"/>
        </v-window-item>
      </v-card>
    </v-window>
  </v-card>
</template>

<script>
import ScreeningListItem from "@/components/ScreeningListItem.vue";
import FilterSearchField from "@/components/FilterSearchField.vue";
import RecentScreeningsFrame from "@/components/RecentScreeningsFrame.vue";
import RecommendedScreeningsFrame from "@/components/RecommendedScreeningsFrame.vue";

export default {
  name: "ProgramView",
  components: {RecommendedScreeningsFrame, RecentScreeningsFrame, FilterSearchField, ScreeningListItem},

  data() {
    return {
      trip: {
        name: '',
        location: null,
        start: null,
        end: null,
      },
      locations: ['Australia', 'Barbados', 'Chile', 'Denmark', 'Ecuador', 'France'],


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
    emitChangeView(screeningId) {
      this.$emit("event-change-page", screeningId)
    },
  },
  beforeMount() {
    this.getMovieScreenings()
  }
}
</script>
