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
    <div class="ml-5 mr-5">
      <v-row>
        <v-col>
          <v-btn class="main_btn" elevation="0" rounded @click="goTodayReco">오늘의 추천</v-btn>
        </v-col>
        <v-col>
          <v-btn class="main_btn" elevation="0" rounded @click="goNutriReco"
            >영양정보로 추천 받기</v-btn
          >
        </v-col>
      </v-row>
    </div>
    <div class="mt-8" align="center"><h2>광고</h2></div>
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
        },
        {
          id: 2,
          name: "sand2",
        },
        {
          id: 3,
          name: "sand3",
        },
        {
          id: 4,
          name: "sand4",
        },
        {
          id: 5,
          name: "sand5",
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
