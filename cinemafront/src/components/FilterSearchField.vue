<template>
  <v-row justify="center">
    <form @submit.prevent="submit">
      <v-container>
        <v-col cols="12">
          <v-row align="center" style="height: 120px;">
            <v-select
              clearable
              :item-props="itemProps"
              :items="languages"
              label="Language"
              variant="outlined"
              direction="horizontal"
            >Language
            </v-select>
            <v-select
              clearable
              :item-props="itemProps"
              :items="genres"
              label="Genre"
              :v-model="selectedGenreId"
              variant="outlined"
            ></v-select>
            <v-select
              clearable
              :item-props="itemProps"
              :items="directors"
              label="Director"
              :v-model="selectedDirectorId"
              variant="outlined"
            ></v-select>
            <v-select
              clearable
              :item-props="itemProps"
              :items="restrictions"
              label="restriction"
              :v-model="selectedRestrictionId"
              variant="outlined"
            ></v-select>

          </v-row>
          <v-row style="height:60px" align="center">
            <template>
              <v-range-slider
                v-model="range"
                :max="24"
                :min="0"
                :step="1"
                class="align-center"
                hide-details
              >
              </v-range-slider>
            </template>
            <v-btn variant="tonal" @click="handleReset"> clear</v-btn>
            <v-btn variant="tonal" type="submit"> submit</v-btn>
          </v-row>
        </v-col>

      </v-container>

    </form>
  </v-row>


</template>

<script>

export default {
  name: "FilterSearchField",
  data() {
    return {
      selectedLanguageId: 0,
      languages: [
        {
          id: 0,
          name: ''
        }
      ],
      selectedRestrictionId: 0,
      restrictions: [
        {
          id: 0,
          name: ''
        }
      ],
      selectedDirectorId: 0,
      directors: [
        {
          id: 0,
          name: ''
        }
      ],
      selectedGenreId: 0,
      genres: [
        {
          id: 0,
          name: ''
        }
      ],
      range: [0, 24],
    }
  },
  methods: {
    getLanguages() {
      this.$http.get("/api/languages")
        .then(response => {
          this.languages = response.data
        })
        .catch(error => {
          const errorResponseBody = error.response.data
        })
    },
    getRestrictions() {
      this.$http.get("/api/restrictions")
        .then(response => {
          this.restrictions = response.data
        })
        .catch(error => {
          const errorResponseBody = error.response.data
        })
    },
    getDirectors() {
      this.$http.get("/api/directors")
        .then(response => {
          this.directors = response.data
        })
        .catch(error => {
          const errorResponseBody = error.response.data
        })
    },
    getGenres() {
      this.$http.get("/api/genres")
        .then(response => {
          this.genres = response.data
        })
        .catch(error => {
          const errorResponseBody = error.response.data
        })
    },
    itemProps(item) {
      return {
        title: item.name
      }
    },
    submit() {

    },
    handleReset() {

    },
  },
  beforeMount() {
    this.getLanguages()
    this.getGenres()
    this.getDirectors()
    this.getRestrictions()
  }
}
</script>

