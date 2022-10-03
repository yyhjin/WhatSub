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
      <span>{{ combiListItem.scoreAvg }}</span>
    </div>
    <v-img height="150" width="250" src="" alt="sandwitch"></v-img>
    <h2 style="font-size: 16px">
      {{ combiListItem.combName }}
    </h2>
    <h3 style="color: grey; font-size: 16px">({{ combiListItem.menuName }})</h3>
    <div class="ma-3">
      <div style="font-size: 15px">{{ combiListItem.content }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CombiInfoSnad",
  data() {
    return {
      rating: this.combiListItem.scoreAvg,
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
