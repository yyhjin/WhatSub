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
    <v-img
      class="shadow_img"
      height="150"
      width="200"
      :src="combiListItem.menu.img_url"
      alt="sandwitch"
    ></v-img>
    <h2 style="font-size: 16px">
      {{ combiListItem.comb_name }}
    </h2>
    <h3 class="mt-1" style="color: grey; font-size: 16px">({{ combiListItem.menu.menu_name }})</h3>
    <div class="ma-3">
      <div style="font-size: 15px">{{ combiListItem.content }}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CombiInfoSnadPersonal",
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
