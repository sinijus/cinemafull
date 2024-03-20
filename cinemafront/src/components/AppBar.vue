<template>
  <v-app-bar color="#C62828" height="120" app>

    <v-menu>
      <template v-slot:activator="{ props }">
        <v-btn icon="mdi-dots-vertical" v-bind="props"></v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          @click="addReservationsToAllScreenings"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
    <div class="flex-grow-1"
         style="font-size: 8rem; font-weight: bold; font-style: oblique; font-family: Calibri; color: #111111">
      <span> KINO </span>
    </div>
  </v-app-bar>
</template>

<script>
export default {
  name: "AppBar",
  data() {
    return {
      items: [
        {title: 'Lisa kõikidele seanssidele suvaline arv broneeringuid'},
      ],
    }
  },
  methods:{
    addReservationsToAllScreenings() {


    },
  }
}
</script>
