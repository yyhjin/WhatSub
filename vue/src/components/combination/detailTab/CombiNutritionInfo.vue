<template>
  <div style="font-size: 14px" align="center">
    <v-row class="r_border">
      <v-col align="left" cols="6">열량(kcal)</v-col>
      <v-col align="right" cols="6" style="color: #239347">1000</v-col>
    </v-row>
    <v-row class="r_border">
      <v-col align="left" cols="3">단백질(g)</v-col>
      <v-col class="c_border" align="right" cols="3" style="color: #239347">0000</v-col>
      <v-col align="left" cols="4">포화지방(g)</v-col>
      <v-col align="right" cols="2" style="color: #239347">000</v-col>
    </v-row>
    <v-row class="r_border">
      <v-col align="left" cols="4">당류(g)</v-col>
      <v-col class="c_border" align="right" cols="2" style="color: #239347">000</v-col>
      <v-col align="left" cols="4">나트륨(mg)</v-col>
      <v-col align="right" cols="2" style="color: #239347">000</v-col>
    </v-row>
    <v-row align="center">
      <v-col align="left" cols="5">알레르기 성분</v-col>
      <v-col align="right" cols="7" style="color: #239347">우유, 돼지고기, 밀</v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "CombiNutritionInfo",
};
</script>

<style></style>
