<template>
  <v-card variant="tonal">
    <section>
      <v-card-title>
        <div>
          {{ getDayName(screening.date) }} {{ reformatDate(screening.date) }} {{ reformatTime(screening.time) }}
        </div>
        <div>
          {{ screening.movieTitle }} ({{ screening.movieReleaseYear }})
        </div>
      </v-card-title>
      <div>
        <template v-for="director in screening.directors" :key="director.id">
          <v-card-subtitle> {{ director.name }}</v-card-subtitle>
        </template>
      </div>
      <v-card-text>
        <div> Žanr:
          <template v-for="genre in screening.genres" :key="genre.id">
            <span>{{ genre.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="language in screening.languages" :key="language.id">
            <span> {{ language.name }} keel</span>
            <span> - </span>
          </template>
        </div>
        <div> {{screening.restrictions[0].name }}</div>
      </v-card-text>
    </section>
  </v-card>
</template>

<script>
import {notRestrictionAppliedText} from "@/assets/text";
import {getDayName, reformatDate, reformatTime} from "@/assets/method";

export default {
  name: 'ScreeningListItem',
  props: {
    screening: {
      id: 0,
      movieId: 0,
      movieTitle: '',
      movieReleaseYear: 0,
      hallName: '',
      date: '2024-03-12',
      time: {
        hour: 0,
        minute: 0,
        second: 0,
        nano: 0
      },
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
    },
  },
  data() {
    return{
      restrictionIsApplied: true
    }
  },
  methods: {
    reformatTime,
    reformatDate,
    getDayName
  }
}
</script>
