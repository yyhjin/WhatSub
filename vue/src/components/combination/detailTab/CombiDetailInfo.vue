<template>
  <div style="font-size: 14px">
    <v-row class="r_border" align="center">
      <v-col align="center" cols="4">기본메뉴</v-col>
      <v-col cols="8" align="center">oo</v-col>
    </v-row>
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2"
        ><v-img width="30" height="30" src="@/assets/combiInfo/bread.png" alt="Logo" />
      </v-col>
      <v-col class="c_border" align="center"> 플랫 브래드 </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/cheese.png" alt="Logo" />
      </v-col>
      <v-col cols="4" align="center"> oo </v-col>
    </v-row>
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/vegetable.png" alt="Logo" />
      </v-col>
      <v-col cols="4" class="c_border" align="center"> oo </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/sauce.png" alt="Logo" />
      </v-col>
      <v-col align="center"> oo </v-col>
    </v-row>
    <v-row align="center">
      <v-col align="center" cols="4"> 추가재료 </v-col>
      <v-col cols="8" align="center"> oo </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "CombiDetailInfo",
};
</script>

<style>
.r_border {
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: #d9d9d9;
}
.c_border {
  border-right-style: solid;
  border-right-width: 1px;
  border-right-color: #d9d9d9;
}
</style>
