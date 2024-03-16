<template>
  <v-expansion-panels variant="accordion">
    <v-expansion-panel>
      <v-expansion-panel-title>
        <template v-slot:default="{ expanded }">
          <v-row no-gutters>
            <v-col class="d-flex justify-start" cols="4">
              Filtreeri tulemusi
            </v-col>
            <v-col class="text-grey" cols="8">
              <v-fade-transition leave-absolute>
                <span v-if="expanded" key="0"></span>
              </v-fade-transition>
            </v-col>
          </v-row>
        </template>
      </v-expansion-panel-title>
      <v-expansion-panel-text>

        <v-row justify="center">
          <v-container>
            <v-row align="center" style="height: 120px;">
              <v-col>
                <v-select clearable :item-props="itemProps" :items="languages" label="Language" variant="outlined"
                          direction="horizontal"/>
              </v-col>
              <v-col>
                <v-select clearable :item-props="itemProps" :items="genres" label="Genre" :v-model="selectedGenreId"
                          variant="outlined"/>
              </v-col>
              <v-col>
                <v-select clearable :item-props="itemProps" :items="directors" label="Director"
                          :v-model="selectedDirectorId"
                          variant="outlined"/>
              </v-col>
              <v-col>
                <v-select clearable :item-props="itemProps" :items="restrictions" label="Restriction"
                          :v-model="selectedRestrictionId" variant="outlined"/>
              </v-col>
            </v-row>
            <v-row align="center">
              <v-col>
                <v-range-slider title="Kellaaeg" v-model="range" :max="24" :min="0" :step="1" class="align-center"
                                hide-details/>
              </v-col>
              <v-col>
                <v-text-field disabled v-model="date.start" label="Start date" type="date" variant="outlined"/>
              </v-col>
              <v-col>
                <v-text-field disabled v-model="date.end" label="Start date" type="date" variant="outlined"/>
              </v-col>
              <v-col>
                <v-btn variant="outlined" @click="handleReset">Clear</v-btn>
                <v-btn variant="tonal" type="submit">Filter</v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-row>

      </v-expansion-panel-text>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
export default {
  name: "FilterSearchField",
  data() {
    return {
      date: {
        start: '2024-05-06',
        end: '2024-05-12'
      },
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

