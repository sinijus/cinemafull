<template>
  <ProgramView v-show="showProgramView"/>
  <ScreeningReservationView v-show="!showProgramView"></ScreeningReservationView>
</template>

<script>
import ProgramView from "@/components/ProgramView.vue";
import ScreeningReservationView from "@/components/ScreeningReservationView.vue";

export default {
  components: {ScreeningReservationView, ProgramView},
  data() {
    return {
      showProgramView: true,
      screeningId: 0
    }
  }

}


</script>
