<template>
  <v-row justify="center">
    <!-- First Row: Select Elements -->
    <v-container>
      <v-row align="center" style="height: 120px;">
        <v-col cols="3">
          <v-select
            clearable
            :item-props="itemProps"
            :items="languages"
            label="Language"
            variant="outlined"
            direction="horizontal"
          >Language
          </v-select>
        </v-col>
        <v-col cols="3">
          <v-select
            clearable
            :item-props="itemProps"
            :items="genres"
            label="Genre"
            :v-model="selectedGenreId"
            variant="outlined"
          ></v-select>
        </v-col>
        <v-col cols="3">
          <v-select
            clearable
            :item-props="itemProps"
            :items="directors"
            label="Director"
            :v-model="selectedDirectorId"
            variant="outlined"
          ></v-select>
        </v-col>
        <v-col cols="3">
          <v-select
            clearable
            :item-props="itemProps"
            :items="restrictions"
            label="restriction"
            :v-model="selectedRestrictionId"
            variant="outlined"
          ></v-select>
        </v-col>
      </v-row>
    </v-container>

    <!-- Second Row: Range Slider and Buttons -->
    <v-container>
      <v-row align="center">
        <v-col cols="10">
          <v-range-slider
            v-model="range"
            :max="24"
            :min="0"
            :step="1"
            class="align-center"
            hide-details
          >
          </v-range-slider>
        </v-col>
        <v-col cols="1">
          <v-btn variant="outlined" @click="handleReset">Clear</v-btn>
        </v-col>
        <v-col cols="1">
          <v-btn variant="tonal" type="submit">Filter</v-btn>
        </v-col>
      </v-row>
    </v-container>
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

