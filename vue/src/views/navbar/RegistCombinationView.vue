<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-8"><h3>꿀조합 등록</h3></v-col>
      </v-row>
    </div>
    <div class="pt-20" align="center">
      <v-img
        height="100"
        width="250"
        src="https://picsum.photos/350/165?random"
        alt="sandwitch"
      ></v-img>
      <div class="pt-3"><h2 style="font-size: 17px">스테이크&치즈</h2></div>
      <div class="pt-1 pb-8" style="font-size: 15px">5400원</div>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div>
      <v-tabs v-model="tab" fixed-tabs>
        <v-tabs-slider color="#239347"></v-tabs-slider>
        <v-tab class="tab_text_color" v-for="item in items" :key="item">
          <h3>{{ item }}</h3>
        </v-tab>
      </v-tabs>
      <v-tabs-items v-model="tab">
        <v-tab-item v-for="item in items" :key="item">
          <v-card class="mb-3" v-if="item == '조합정보'" flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-detail-info></combi-detail-info>
            </div>
          </v-card>
          <v-card class="mb-3" v-else flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-nutrition-info></combi-nutrition-info>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div class="pa-5">
      <div style="font-size: 15px; font-weight: bold">꿀조합 이름</div>
      <v-text-field outlined solo dense></v-text-field>
      <div style="font-size: 15px; font-weight: bold">꿀조합 설명</div>
      <v-textarea style="font-size: 15px" height="200" outlined solo></v-textarea>
    </div>
    <div class="mt-n3" align="center">
      <v-btn class="main_btn" rounded>꿀조합 등록하기</v-btn>
    </div>
    <br />
    <br />
    <br />
    <br />
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from "@/components/common/BottomNav.vue";
import CombiDetailInfo from "@/components/combination/detailTab/CombiDetailInfo.vue";
import CombiNutritionInfo from "@/components/combination/detailTab/CombiNutritionInfo.vue";

export default {
  name: "RegistCombinationView",
  components: { BottomNav, CombiDetailInfo, CombiNutritionInfo },
  data() {
    return {
      tab: null,
      items: ["조합정보", "영양정보"],
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped>
.top {
  padding: 10px;
  position: fixed;
  width: 100%;
  z-index: 2;
}
</style>
