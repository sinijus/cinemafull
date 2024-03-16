<template>
  <v-card>
    <section>
      <v-card-title>
        <div>
          {{ getDayName(movieScreening.date) }} {{ reformatDate(movieScreening.date) }}
          {{ reformatTime(movieScreening.time) }}
        </div>
        <div>
          {{ movieScreening.movieTitle }} ({{ movieScreening.movieReleaseYear }})
        </div>
      </v-card-title>
      <div>
        <template v-for="director in movieScreening.directors" :key="director.id">
          <v-card-subtitle> {{ director.name }}</v-card-subtitle>
        </template>
      </div>
      <v-card-text>
        <div> Maa:
          <template v-for="(country, index) in movieScreening.countries" :key="country.id">
            <span> {{ country.name }}</span>
            <span v-if="notLastElementInArray(index, movieScreening.countries.length)"> - </span>
          </template>
        </div>
        <div> Žanr:
          <template v-for="(genre, index) in movieScreening.genres" :key="genre.id">
            <span>{{ genre.name }}</span>
            <span v-if="notLastElementInArray(index, movieScreening.genres.length)"> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="(language, index) in movieScreening.languages" :key="language.id">
            <span> {{ language.name }} </span>
            <span v-if="notLastElementInArray(index, movieScreening.languages.length)"> - </span>
          </template>
        </div>
        <div> Subtiitrid:
          <template v-for="(subtitle, index) in movieScreening.subtitles" :key="subtitle.id">
            <span> {{ subtitle.name }} </span>
            <span v-if="notLastElementInArray(index, movieScreening.subtitles.length)"> - </span>
          </template>
        </div>
        <div v-if="restrictionIsApplied"> {{ movieScreening.restrictions[0].name }}</div>
      </v-card-text>
      <v-card-text>
        <div>
          {{ movieScreening.movieDescription }}
        </div>
      </v-card-text>
    </section>
    <v-card-actions>
      <v-responsive class="mx-auto" max-width="344">
        <v-text-field
          hint="Sisesta kohtade arv"
          label="Kohad"
          type="number"
          :min="numberOfSeatsMinValue"
          :rules="numberOfSeatsRules"
          v-model="numberOfSeats"
        ></v-text-field>
      </v-responsive>
    </v-card-actions>
    <v-row justify="center">
      <v-col cols="auto">
        <v-btn size="x-large" variant="tonal" @Click="emitValidateAndMakeReservation(this.numberOfSeats)">Broneeri
        </v-btn>
      </v-col>
    </v-row>
  </v-card>
</template>

<script>
import {getDayName, notLastElementInArray, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: "ScreeningDescriptionItem",
  props: {
    movieScreening: {}
  },
  data() {
    return {
      restrictionIsApplied: true,
      numberOfSeats: 1,
      numberOfSeatsMinValue: 1,
      numberOfSeatsRules: [
        v => (v && v > 0) || "Vähemalt üks koht peab olema valitud"
      ]
    }
  },
  methods: {
    notLastElementInArray,
    emitValidateAndMakeReservation(numberOfSeats) {
      this.$emit("event-validate-and-make-reservation", numberOfSeats)
    },
    reformatTime,
    reformatDate,
    getDayName
  }
}
</script>
