<template>
  <div>
    <div style="color: black; font-size: 15px; font-weight: 900">영양정보</div>
    <div class="pt-3" style="font-size: 14px" align="center">
      <v-row class="r_border">
        <v-col align="left" cols="6">열량(kcal)</v-col>
        <v-col align="right" cols="6" style="color: #239347">{{
          combiListItem.combination.kcal.toFixed(1)
        }}</v-col>
      </v-row>
      <v-row class="r_border" align="center">
        <v-col class="pa-0 pt-3 pl-3" align="left" cols="3">단백질(g)</v-col>
        <v-col class="c_border" align="right" cols="3" style="color: #239347">{{
          combiListItem.combination.protein.toFixed(1)
        }}</v-col>
        <v-col class="pa-0 pt-3 pb-3 pl-3" align="left" cols="4">포화지방(g)</v-col>
        <v-col class="pa-0 pt-3 pb-3 pr-1 ml-n2" align="right" cols="2" style="color: #239347">{{
          combiListItem.combination.fat.toFixed(1)
        }}</v-col>
      </v-row>
      <v-row class="r_border" align="center">
        <v-col align="left" cols="3">당류(g)</v-col>
        <v-col class="c_border" align="right" cols="3" style="color: #239347">{{
          combiListItem.combination.sugar.toFixed(1)
        }}</v-col>
        <v-col class="pa-0 pt-3 pb-3 pl-3" align="left" cols="4">나트륨(mg)</v-col>
        <v-col class="pa-0 pt-3 pb-3 pr-1 ml-n2" align="right" cols="2" style="color: #239347">{{
          combiListItem.combination.sodium.toFixed(1)
        }}</v-col>
      </v-row>
      <v-row align="center">
        <v-col align="left" cols="5">알레르기 성분</v-col>
        <v-col class="pa-0 pt-3 pb-3 pr-1 ml-n2" align="right" cols="7" style="color: #239347">{{
          combiListItem.combination.allergies
        }}</v-col>
      </v-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "CombiInfoNutritionMyCombi",
  props: {
    combiListItem: Object,
  },
  created() {},
};
</script>

<style></style>
