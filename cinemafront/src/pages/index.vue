<template>
  <ProgramView v-show="showProgramView" @event-change-page="changePage"/>
  <ScreeningReservationView v-if="!showProgramView" :screeningId="screeningId"  @event-change-page="changePage" ></ScreeningReservationView>
</template>

<script>
import ProgramView from "@/views/ProgramView.vue";
import ScreeningReservationView from "@/views/ScreeningReservationView.vue";

export default {
  components: {ScreeningReservationView, ProgramView},
  data() {
    return {
      showProgramView: true,
      screeningId: 0
    }
  },
  methods: {
    changePage(screeningId) {
      this.screeningId = screeningId
      this.showProgramView = !this.showProgramView
    },
  }
}


</script>
<script setup>
</script>
