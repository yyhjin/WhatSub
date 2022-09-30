<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div>
      <recommend-main></recommend-main>
    </div>
    <div>
      <recommend-comb-list :combi-list="combiList"></recommend-comb-list>
    </div>
    <div class="ml-3 mr-3">
      <v-row>
        <v-col class="pa-0 pt-1 pl-5 pb-5">
          <v-btn class="main_btn" elevation="0" rounded @click="goTodayReco">오늘의 추천</v-btn>
        </v-col>
        <v-col class="pa-0 pt-1 pr-5">
          <v-btn class="main_btn" elevation="0" rounded @click="goNutriReco"
            >영양정보로 추천 받기</v-btn
          >
        </v-col>
      </v-row>
    </div>
    <div align="center"><v-img height="130" src="@/assets/subway_ad.jpg"></v-img></div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import RecommendMain from "@/components/home/RecommendMain.vue";
import RecommendCombList from "@/components/home/RecommendCombList.vue";

export default {
  name: "HomeView",
  components: { TopNav, BottomNav, RecommendMain, RecommendCombList },
  data() {
    return {
      combiList: [
        {
          id: 1,
          name: "sand1",
          basic: "에그마요",
          score: 1.5,
          desc: "닭가슴살로 만든 치키 슬라이스를 담백하게 즐겨보세요.",
          nutri: 300,
          ingre: ["플랫브래드", "오이1", "토마토1"],
          price: 5400,
        },
        {
          id: 2,
          name: "sand2",
          basic: "터키 베이컨 아보카도",
          score: 2.5,
          desc: "맛난 샌드위치2~",
          nutri: 250,
          ingre: "토마토2",
          price: 6400,
        },
        {
          id: 3,
          name: "sand3",
          score: 3.5,
          desc: "맛난 샌드위치3~",
          basic: "치킨 슬라이스",
          nutri: 350,
          ingre: "토마토3",
          price: 7400,
        },
        {
          id: 4,
          name: "sand4",
          basic: "스테이크&치즈",
          score: 4.5,
          desc: "맛난 샌드위치4~",
          nutri: 450,
          ingre: "토마토4",
          price: 7400,
        },
        {
          id: 5,
          name: "sand5",
          basic: "터키 베이컨 아보카도",
          score: 5.5,
          desc: "맛난 샌드위치5~",
          nutri: 550,
          ingre: "토마토5",
          price: 7400,
        },
      ],
    };
  },
  methods: {
    goTodayReco() {
      this.$router.push({ name: "recommendtoday" });
    },
    goNutriReco() {
      this.$router.push({ name: "recommendnutrition" });
    },
  },
};
</script>

<style scoped>
@import "@/scss/common.scss";
.top {
  position: fixed;
  width: 100%;
}
.bottom {
  position: fixed;
  width: 100%;
  bottom: 0;
}
</style>
