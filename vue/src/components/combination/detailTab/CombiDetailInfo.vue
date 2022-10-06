<template>
  <div style="font-size: 14px">
    <v-row class="r_border" align="center">
      <v-col align="center" cols="4">기본메뉴</v-col>
      <v-col cols="8" align="center"
        ><h4>{{ combiDetail.menuName }}</h4></v-col
      >
    </v-row>
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2"
        ><v-img width="30" height="30" src="@/assets/combiInfo/bread.png" alt="Logo" />
      </v-col>
      <v-col class="c_border" align="center">
        <div v-for="(breadItem, index) in bread" :key="index">{{ breadItem }}</div>
      </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/cheese.png" alt="Logo" />
      </v-col>
      <v-col cols="4" align="center">
        <div v-for="(cheeseItem, index) in cheese" :key="index">{{ cheeseItem }}</div>
      </v-col>
    </v-row>
    <v-row class="r_border" align="center">
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/vegetable.png" alt="Logo" />
      </v-col>
      <v-col cols="4" class="c_border" align="center">
        <div v-for="(vegeItem, index) in vege" :key="index">{{ vegeItem }}</div>
      </v-col>
      <v-col class="pa-0 pl-3" cols="2">
        <v-img width="30" height="30" src="@/assets/combiInfo/sauce.png" alt="Logo" />
      </v-col>
      <v-col align="center">
        <div v-for="(sauceItem, index) in sauce" :key="index">{{ sauceItem }}</div>
      </v-col>
    </v-row>
    <v-row align="center">
      <v-col align="center" cols="4"> 추가재료 </v-col>
      <v-col cols="8" align="center">
        <div v-for="(additionItem, index) in addition" :key="index">{{ additionItem }}</div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "CombiDetailInfo",
  props: {
    combiDetail: Object,
  },
  data() {
    return {
      bread: [],
      cheese: [],
      vege: [],
      sauce: [],
      addition: [],
    };
  },
  created() {
    for (let index = 0; index < this.combiDetail.ingredients.length; index++) {
      if (this.combiDetail.ingredients[index].category == "빵") {
        this.bread.push(this.combiDetail.ingredients[index].name);
      } else if (this.combiDetail.ingredients[index].category == "치즈") {
        this.cheese.push(this.combiDetail.ingredients[index].name);
      } else if (this.combiDetail.ingredients[index].category == "야채") {
        this.vege.push(this.combiDetail.ingredients[index].name);
      } else if (this.combiDetail.ingredients[index].category == "소스") {
        this.sauce.push(this.combiDetail.ingredients[index].name);
      } else if (this.combiDetail.ingredients[index].category == "추가") {
        this.addition.push(this.combiDetail.ingredients[index].name);
      }
    }
    console.log(this.vege);
  },
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
