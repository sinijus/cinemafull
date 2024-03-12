<template>
  <v-card :subtitle="`Subtitle for Content ${screening.movieTitle}`"
          :title="`Content ${screening.movieTitle}`"
          text="..."
          variant="tonal">
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
    tab: 0

  }
}
</script>
