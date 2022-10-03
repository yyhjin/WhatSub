<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-9"><h3>추천 조합</h3></v-col>
      </v-row>
    </div>
    <div class="result-view"><sand-small-list></sand-small-list></div>
    <div align="center">
      <v-btn class="grey_btn" width="185" small elevation="0" rounded @click="goNutriReco"
        >영양정보 다시 선택</v-btn
      >
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
import SandSmallList from "@/components/common/SandSmallList.vue";
import { mapGetters } from "vuex";

export default {
  name: "RecommendNutritionResultView",
  components: { BottomNav, SandSmallList },
  computed: {
    ...mapGetters(["combiListByNutri"]),
  },
  created() {},
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    goNutriReco() {
      this.$router.push({ name: "recommendnutrition" });
    },
  },
};
</script>

<style scoped>
.top {
  padding: 10px;
  position: fixed;
  width: 100%;
}
.result-view {
  padding-top: 70px;
  padding-bottom: 10px;
  margin-left: 28px;
  margin-right: 28px;
}
</style>
