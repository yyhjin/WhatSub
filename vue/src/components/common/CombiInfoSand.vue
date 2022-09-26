<template>
  <div align="center" style="color: black">
    <v-row align="center">
      <v-col class="c_btn" align="right">
        <v-rating
          v-model="rating"
          color="yellow darken-2"
          background-color="yellow darken-2"
          size="30"
          half-increments
          hover
          readonly
        ></v-rating>
      </v-col>
      <v-col cols="3" class="c_btn pl-0" align="left">
        <h4>{{ combiListItem.score }}</h4>
      </v-col>
    </v-row>
    <v-img height="150" width="250" src="" alt="sandwitch"></v-img>
    <h2>
      {{ combiListItem.name }}
    </h2>
    <h3 style="color: grey">({{ combiListItem.basic }})</h3>
    <div class="ma-3">
      <h3>{{ combiListItem.desc }}</h3>
    </div>
  </div>
</template>

<script>
export default {
  name: "CombiInfoSnad",
  data() {
    return {
      rating: this.combiListItem.score,
    };
  },
  props: {
    combiListItem: Object,
  },
};
</script>

<style scoped>
.c_btn {
  min-width: 0px !important;
}
</style>
