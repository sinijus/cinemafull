<template>
  <v-card class="mx-auto" color="#212121" max-width="800">
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1">Hiljutised</v-tab>
      <v-tab :value="2">Programm</v-tab>
      <v-tab :value="3">Soovitused</v-tab>
    </v-tabs>
    <v-window v-model="tab">
      <v-card v-if="screeningsLoaded" >
        <v-window-item :value="1">
          <RecentScreeningsFrame cols="12"/>
        </v-window-item>
        <v-window-item :value="2">
          <FilterSearchField @event-get-filtered-screenings="setAndGetFilteredMovieScreenings"/>
          <v-container fluid>
            <v-row dense>
              <v-col v-if="screeningIsEmpty">
                <v-card-title>Vasteid ei leitud</v-card-title>
              </v-col>
              <v-col v-for="screening in screenings" :key="screening" cols="12">
                <ScreeningListItem :screening="screening" @click="emitChangePage(screening.id)"/>
              </v-col>
            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="3">
          <RecommendedScreeningsFrame @event-change-page="emitChangePage"/>
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
      startTime: '',
      endTime: '',
      startDate: '',
      endDate: '',
      directorId: 0,
      genreId: 0,
      languageId: 0,
      restrictionId: 0,
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
      screeningIsEmpty: false
    }
  },
  methods: {
    setAndGetFilteredMovieScreenings(time, date, directorId, genreId, languageId, restrictionId) {
      this.startTime = time.start
      this.endTime = time.end
      this.startDate = date.start
      this.endDate = date.end
      this.directorId = directorId === null ? 0 : directorId
      this.genreId = genreId === null ? 0 : genreId
      this.languageId = languageId === null ? 0 : languageId
      this.restrictionId = restrictionId === null ? 0 : restrictionId
      this.getFilteredMovieScreenings()
    },
    getFilteredMovieScreenings() {
      this.$http.get("/api/filtered-screenings", {
          params: {
            startTime: this.startTime,
            endTime: this.endTime,
            startDate: this.startDate,
            endDate: this.endDate,
            directorId: this.directorId,
            genreId: this.genreId,
            languageId: this.languageId,
            restrictionId: this.restrictionId
          }
        }
      ).then(response => {
        this.screenings = response.data
        this.screeningsLoaded = true
        this.validateScreeningIsEmpty()
      }).catch(error => {
      })
    },
    emitChangePage(screeningId) {
      this.$emit("event-change-page", screeningId)
    },
    validateScreeningIsEmpty() {
      this.screeningIsEmpty = Object.keys(this.screenings).length === 0
    },
  },
  beforeMount() {
    this.getFilteredMovieScreenings()
  }
}
</script>
