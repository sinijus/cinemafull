<template>
  <v-container fluid>
    <v-card>
      <v-card-title>
        Soovitatud seanssid:
      </v-card-title>
    </v-card>
    <v-row dense>
      <v-col v-for="screening in screenings" :key="screening" cols="12">
        <ScreeningListItem :screening="screening"/>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import ScreeningListItem from "@/components/ScreeningListItem.vue"

export default {
  name: 'RecommendedScreeningsFrame',
  components: {ScreeningListItem},
  props: {
    emitChangeView: {},
    screenings: {}
  }
}
</script>
