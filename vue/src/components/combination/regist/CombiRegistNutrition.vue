<template>
  <div style="font-size: 14px" align="center">
    <v-row class="r_border">
      <v-col align="left" cols="6">열량(kcal)</v-col>
      <v-col align="right" cols="6" style="color: #239347">{{ com.kcal }}</v-col>
    </v-row>
    <v-row class="r_border">
      <v-col class="pa-0 pt-3 pl-3" align="left" cols="3">단백질(g)</v-col>
      <v-col class="c_border" align="right" cols="3" style="color: #239347">{{
        com.protein
      }}</v-col>
      <v-col align="left" cols="4">포화지방(g)</v-col>
      <v-col align="right" cols="2" style="color: #239347">{{ com.fat }}</v-col>
    </v-row>
    <v-row class="r_border">
      <v-col align="left" cols="3">당류(g)</v-col>
      <v-col class="c_border" align="right" cols="3" style="color: #239347">{{
        com.sugar
      }}</v-col>
      <v-col class="pa-0 pt-3 pl-3" align="left" cols="4">나트륨(mg)</v-col>
      <v-col class="pa-0 pt-3 pr-3" align="right" cols="2" style="color: #239347">{{
        com.sodium
      }}</v-col>
    </v-row>
    
  </div>
</template>

<script>
export default {
  name: 'CombiRegistNutrition',

  props: {
    com: Object
  }
}
</script>

<style>

</style>