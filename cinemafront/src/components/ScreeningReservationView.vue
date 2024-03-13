
<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1">Seanss</v-tab>
      <v-tab :value="2">Broneeri</v-tab>
    </v-tabs>
    <v-window v-model="tab" >
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-window-item :value="1">
          <v-container fluid>
            <v-row dense>

            </v-row>
          </v-container>
        </v-window-item>
        <v-window-item :value="2">
<!--          <v-container fluid>-->
<!--            <v-row dense>-->
<!--              <v-col v-for="screening in screenings" :key="screening" cols="12">-->
<!--                <ScreeningListItem :screening="screening" @click=""/>-->
<!--              </v-col>-->
<!--            </v-row>-->
<!--          </v-container>-->
        </v-window-item>
      </v-card>
    </v-window>
  </v-card></template>

<script>
import ScreeningListItem from "@/components/ScreeningListItem.vue";
import ScreeningReservationItem from "@/components/ScreeningReservationItem.vue";

export default {
  name: "ScreeningReservationView",
  components: {ScreeningReservationItem, ScreeningListItem},
  props: {
    recentScreening: {}
  },
}
</script>
