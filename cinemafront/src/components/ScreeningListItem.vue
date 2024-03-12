<template>
  <v-card variant="tonal">
    <v-col align-self="start">
      <v-row>
        <v-card-title> {{ screening.date }}</v-card-title>
      </v-row>
      <v-row>
        <v-card-title> {{ time(screening.time) }}</v-card-title>
      </v-row>
    </v-col>
    <v-col align-self="center">
      <v-row>
        <v-card-title> {{screening.movieTitle}}</v-card-title>
      </v-row>
      <v-row v-for="director in screening.directors" :key="director">
        <v-card-subtitle> {{director.name}}</v-card-subtitle>
      </v-row>

    </v-col>

  </v-card>
</template>
<script>
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
    time(time) {
      return "" + time.hour + ":" + time.minute
    }


  }
}
</script>
