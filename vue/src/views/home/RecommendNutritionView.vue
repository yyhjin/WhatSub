<template>
  <div>
    <div class="top">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-3"><h3>영양정보 선택</h3></v-col>
      </v-row>
    </div>
    <div class="n_card">
      <v-card height="200" width="320">
        <h4 class="pt-5" align="center">영양정보 맞춤 추천</h4>
        <div class="card_font pa-7 pt-3 pb-9" align="center">
          본인이 원하는 영양 정보를 통해 샌드위치를<br />
          추천 받을 수 있습니다.<br /><br />
          영양정보 맞춤 샌드위치 추천을 받기 위해<br />
          열량(kcal), 단백질(g), 나트륨(mg)<br />
          범위를 설정하세요.
        </div>
      </v-card>
    </div>
    <div class="ml-10 mr-10 mt-9">
      <div>
        <div align="center">열량(kcal)</div>
        <v-range-slider
          :max-k="max_k"
          :min_k="min_k"
          v-model="range_k"
          :thumb-size="25"
          color="#239347"
          thumb-color="#239347"
          track-color="#d3d3d3"
          dense
          hide-details
          height="50"
        ></v-range-slider>
        <v-row>
          <v-col cols="2">
            <v-text-field
              :value="range_k[0]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              @change="$set(range_k, 0, $event)"
            ></v-text-field>
          </v-col>
          <v-spacer></v-spacer>
          <v-col cols="2">
            <v-text-field
              :value="range_k[1]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              @change="$set(range_k, 1, $event)"
            ></v-text-field>
          </v-col>
        </v-row>
      </div>
      <div class="mt-6">
        <div align="center">단백질(g)</div>
        <v-range-slider
          :max-g="max_g"
          :min_g="min_g"
          v-model="range_g"
          :thumb-size="25"
          color="#239347"
          thumb-color="#239347"
          track-color="#d3d3d3"
          dense
          hide-details
          height="50"
        ></v-range-slider>
        <v-row>
          <v-col cols="2">
            <v-text-field
              :value="range_g[0]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              @change="$set(range_g, 0, $event)"
            ></v-text-field>
          </v-col>
          <v-spacer></v-spacer>
          <v-col cols="2">
            <v-text-field
              :value="range_g[1]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              @change="$set(range_g, 1, $event)"
            ></v-text-field>
          </v-col>
        </v-row>
      </div>
      <div class="mt-6">
        <div align="center">나트륨(mg)</div>
        <v-range-slider
          :max-m="max_m"
          :min_m="min_m"
          v-model="range_m"
          :thumb-size="25"
          color="#239347"
          thumb-color="#239347"
          track-color="#d3d3d3"
          dense
          hide-details
          height="50"
        ></v-range-slider>
        <v-row>
          <v-col cols="2">
            <v-text-field
              :value="range_m[0]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              @change="$set(range_m, 0, $event)"
            ></v-text-field>
          </v-col>
          <v-spacer></v-spacer>
          <v-col cols="2">
            <v-text-field
              :value="range_m[1]"
              class="nut_text text-style mt-n2 pt-0"
              hide-details
              single-line
              type="number"
              dense
              flat
              @change="$set(range_m, 1, $event)"
            ></v-text-field>
          </v-col>
        </v-row>
      </div>
      <div class="mt-5" align="center">
        <v-btn class="main_btn" width="200" elevation="0" rounded @click="goNutriResult"
          >추천 받기</v-btn
        >
      </div>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from "@/components/common/BottomNav.vue";

export default {
  name: "RecommendNutritionView",
  components: {
    BottomNav,
  },
  data() {
    return {
      min_k: 0,
      max_k: 1000,
      range_k: [0, 100],
      min_g: 0,
      max_g: 100,
      range_g: [0, 100],
      min_m: 0,
      max_m: 100,
      range_m: [0, 100],
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    goNutriResult() {
      this.$router.push({ name: "recommendnutritionresult" });
    },
  },
};
</script>

<style scoped>
.top {
  margin: 10px;
  position: fixed;
  width: 100%;
}
.card_font {
  font-size: 13px;
}
.nut_text {
  font-size: 14px;
  text-align: center;
}
.text-style >>> .v-input__slot::before {
  border-style: none !important;
}
</style>
