<template>
  <div class="pt-5">
    <div style="color: black; font-size: 15px; font-weight: 900">빵, 야채, 소스 정보</div>
    <div class="verti_combi no-scroll">
      <div class="pa-2" v-for="(combiIngredient, index) in combiListItem.ingredient" :key="index">
        <v-card class="pt-1" elevation="0" height="120" width="100" align="center">
          <v-img height="65" width="100" src="https://picsum.photos/510/300?random"></v-img>
          <div class="pt-2">
            {{ combiIngredient.name }}
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
