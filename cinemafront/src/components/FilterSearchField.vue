<template>
  <v-row justify="center">
    <form @submit.prevent="submit">
      <v-container>
        <v-row align="center" style="height: 120px;">

          <v-btn variant="tonal" class="me-4" type="submit"> submit</v-btn>
          <v-btn variant="tonal" @click="handleReset"> clear</v-btn>
        </v-row>
      </v-container>

    </form>
  </v-row>


</template>

<script>

export default {
  name: "FilterSearchField",
  data() {
    return {
      restrictions: []
    }
  },
  methods: {
    submit() {

    },
    handleReset() {

    },
  }
}
</script>

