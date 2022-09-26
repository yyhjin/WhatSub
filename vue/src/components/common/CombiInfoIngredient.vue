<template>
  <div class="pt-5">
    <h3 style="color: black; font-size: 15px">빵, 야채, 소스 정보</h3>
    <div class="verti_combi no-scroll">
      <div class="pa-2" v-for="(combiIngredient, index) in combiListItem.ingre" :key="index">
        <v-card class="pt-1" elevation="0" height="100" width="100" align="center">
          <v-img height="65" width="100" src="https://picsum.photos/510/300?random"></v-img>
          <div>
            {{ combiIngredient }}
          </div>
        </v-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CombiInfoIngredient",
  props: {
    combiListItem: Object,
  },
  created() {},
};
</script>

<style></style>
