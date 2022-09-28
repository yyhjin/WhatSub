<template>
  <div align="center" style="color: black">
    <div>
      <v-rating
        v-model="rating"
        color="yellow darken-2"
        background-color="yellow darken-2"
        size="25"
        half-increments
        hover
        readonly
      ></v-rating>
      <span>{{ combiListItem.score }}</span>
    </div>
    <v-img height="150" width="250" src="" alt="sandwitch"></v-img>
    <h2 style="font-size: 18px">
      {{ combiListItem.name }}
    </h2>
    <h3 style="color: grey">({{ combiListItem.basic }})</h3>
    <div class="ma-3">
      <div style="font-size: 16px">{{ combiListItem.desc }}</div>
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
