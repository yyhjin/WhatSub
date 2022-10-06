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
import { mapActions, mapGetters } from 'vuex';

export default {
  name: "HomeView",
  components: { TopNav, BottomNav, RecommendMain, RecommendCombList },
  data() {
    return {
      combiList: []
    };
  },
  computed: {
    ...mapGetters(['username'])
  },
  methods: {
    ...mapActions(['fetchProfile']),
    goTodayReco() {
      this.$router.push({ name: "recommendtoday" });
    },
    goNutriReco() {
      this.$router.push({ name: "recommendnutrition" });
    },
  },
  mounted() {
    this.fetchProfile({username:this.usernam})
  }
};
</script>

<style scoped>
@import "@/scss/common.scss";
.top {
  z-index: 5;
}
.bottom {
  position: fixed;
  width: 100%;
  bottom: 0;
}
</style>
