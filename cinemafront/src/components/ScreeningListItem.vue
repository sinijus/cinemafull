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
        <template v-for="director in screening.directors" :key="director">
          <v-card-subtitle> {{ director.name }}</v-card-subtitle>
        </template>
      </div>
      <v-card-text>
        <div> Žanr:
          <template v-for="genre in screening.genres" :key="genre">
            <span>{{ genre.name }}</span>
            <span> - </span>
          </template>
        </div>
        <div> Keel:
          <template v-for="language in screening.languages" :key="language">
            <span> {{ language.name }} keel</span>
            <span> - </span>
          </template>
        </div>
        <div> Piirangud: {{ screening.restrictions[0].name }}</div>
      </v-card-text>
    </section>
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
