<template>
  <v-card variant="tonal">
    <section>
      <v-card-title>
        <div>
          {{ getDayName(screening.date) }} {{ reformatDate(screening.date) }} {{ reformatTime(screening.time) }}
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
        <div> Žanr:
          <template v-for="genre in movieScreening.genres" :key="genre.id">
            <span>{{ genre.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="language in movieScreening.languages" :key="language.id">
            <span> {{ language.name }} keel</span>
            <span> - </span>
          </template>
        </div>
        <div v-if="restrictionIsApplied"> {{movieScreening.restrictions[0].name }}</div>
      </v-card-text>
    </section>
  </v-card>
</template>

<script>
import {getDayName, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: "ScreeningDescription",
  props:{
    movieScreening:{}
  },
  data() {
    return{
      restrictionIsApplied: true
    }
  },
  methods: {reformatTime, reformatDate, getDayName}
}
</script>
