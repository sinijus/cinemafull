<template>
  <v-card>
    <v-tabs v-model="tab" align-tabs="center" color="#FFFFFF">
      <v-tab :value="1">Recent</v-tab>
      <v-tab :value="2">Program</v-tab>
      <v-tab :value="3">Recommendations</v-tab>
    </v-tabs>
    <v-window v-model="tab">
      <v-card class="mx-auto" color="#212121" max-width="800">
        <v-layout>
          <v-main>
            <v-window-item v-for="n in 3" :key="n" :value="n">
              <v-container fluid>
                <v-row dense>
                  <v-col v-for="n in 12" :key="n" cols="12">
                    <v-card
                      :subtitle="`Subtitle for Content ${n}`"
                      :title="`Content ${n}`"
                      text="Lorem ipsum dolor sit amet consectetur, adipisicing elit.?"
                    ></v-card>
                  </v-col>
                </v-row>
              </v-container>
            </v-window-item>
          </v-main>
        </v-layout>
      </v-card>
    </v-window>
  </v-card>
</template>

<script>
export default {
  name: "ProgramView",

  data: () => ({
    tab: null,
  }),
}
</script>
