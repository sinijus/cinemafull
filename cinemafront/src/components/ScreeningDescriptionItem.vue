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
          <template v-for="country in movieScreening.countries" :key="country.id">
            <span> {{ country.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Žanr:
          <template v-for="genre in movieScreening.genres" :key="genre.id">
            <span>{{ genre.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="language in movieScreening.languages" :key="language.id">
            <span> {{ language.name }} </span>
            <span> - </span>
          </template>
        </div>
        <div> Subtiitrid:
          <template v-for="subtitle in movieScreening.subtitles" :key="subtitle.id">
            <span> {{ subtitle.name }} </span>
            <span> - </span>
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

    </v-card-actions>
  </v-card>
</template>

<script>
import {getDayName, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: "ScreeningDescriptionItem",
  props: {
    movieScreening: {}
  },
  data() {
    return {
      restrictionIsApplied: true
    }
  },
  methods: {reformatTime, reformatDate, getDayName}
}
</script>
