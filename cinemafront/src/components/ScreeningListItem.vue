<template>
  <v-card variant="tonal">
    <v-col cols="6">
      <v-row>
        <v-card-title> {{ getDayName(screening.date) }}</v-card-title>
        <v-card-title> {{ reformatDate(screening.date) }}</v-card-title>
        <v-card-title> {{ reformatTime(screening.time) }}</v-card-title>
      </v-row>
      <v-row>
        <v-card-title> {{ screening.movieTitle }}</v-card-title>
        <v-card-title> ({{ screening.movieReleaseYear }})</v-card-title>
      </v-row>
      <v-row v-for="director in screening.directors" :key="director">
        <v-card-title> {{ director.name }}</v-card-title>
      </v-row>
    </v-col>
    <v-col cols="6">
      <v-col v-for="genre in screening.genres" :key="genre">
        <v-card-text> {{ genre.name }}</v-card-text>
      </v-col>
      <v-row v-for="language in screening.languages" :key="language">
        <v-card-text> {{ language.name }}</v-card-text>
      </v-row>
        <v-card-text> Piirangud: {{ screening.restrictions[0].name }}</v-card-text>
    </v-col>

  </v-card>
</template>
<script>
import {weekdayPrefixes} from "@/assets/text";

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
  methods: {
    reformatDate(dateString) {
      const [year, month, day] = dateString.split('-');
      const formattedDay = day.startsWith('0') ? day.slice(1) : day;
      const formattedMonth = month.startsWith('0') ? month.slice(1) : month;
      return `${formattedDay}.${formattedMonth}.${year}`;
    },
    reformatTime(timeString) {
      const [hour, minute] = timeString.split(':');
      return `${hour}:${minute}`
    },
    getDayName(dateString) {
      const date = new Date(dateString);
      const weekdayIndex = date.getDay();
      return weekdayPrefixes[weekdayIndex];
    },
  }
}
</script>
