<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-8"><h3>꿀조합 정보</h3></v-col>
      </v-row>
    </div>
    <div align="center" class="pt-13">
      <v-rating
        v-model="rating"
        color="yellow darken-2"
        background-color="yellow darken-2"
        size="27"
        half-increments
        hover
        readonly
      ></v-rating>
      <div>{{ rating }}</div>
      <v-img height="100" width="250" src="" alt="sandwitch"></v-img>
      <div class="ml-30">
        <div class="left"><h2 style="font-size: 18px">단백질 보충원</h2></div>
        <div class="left ml-2 mt-n1">
          <v-icon v-if="!isliked" color="red" size="30" @click="clickHeart"
            >mdi-heart-outline</v-icon
          >
          <v-icon v-if="isliked" color="red" size="30" @click="clickHeart">mdi-heart</v-icon>
        </div>
      </div>
      <div class="ma-4 pt-6 pb-3">
        <div style="font-size: 15px">헬창들을 위한 터키 아보카도 베이컨 샌드위치를 즐겨보세요!</div>
      </div>
      <div class="ml-14 mb-5">
        <div class="left pt-1" style="font-size: 18px; font-weight: 900">7400원</div>
        <v-spacer></v-spacer>
        <v-btn
          class="main_btn left ml-5"
          height="32"
          width="180"
          elevation="0"
          rounded
          small
          style="font-size: 14px"
          @click="goOrderCombi"
          >주문하러 가기</v-btn
        >
      </div>
    </div>
    <br />
    <br />
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <v-container class="ma-n1">
      <div @click="goProfile">
        <v-row align="center">
          <v-col cols="2">
            <v-avatar size="45" color="#d9d9d9"></v-avatar>
          </v-col>
          <v-col>
            <div><div style="font-size: 14px">김계란</div></div>
            <div><div style="font-size: 13px">2022-09-28</div></div>
          </v-col>
        </v-row>
      </div>
    </v-container>
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
          <v-card class="mb-3" v-else-if="item == '영양정보'" flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-nutrition-info></combi-nutrition-info>
            </div>
          </v-card>
          <v-card v-else flat height="200">
            <div class="pt-4 pl-6 pr-6">
              <combi-statistic></combi-statistic>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div>
      <review-list></review-list>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from "@/components/common/BottomNav.vue";
import CombiDetailInfo from "@/components/combination/detailTab/CombiDetailInfo.vue";
import CombiNutritionInfo from "@/components/combination/detailTab/CombiNutritionInfo.vue";
import CombiStatistic from "@/components/combination/detailTab/CombiStatistic.vue";
import ReviewList from "@/components/combination/ReviewList.vue";

export default {
  name: "CombinationDetailView",
  components: { BottomNav, CombiDetailInfo, CombiNutritionInfo, CombiStatistic, ReviewList },
  data() {
    return {
      rating: 5,
      isliked: false,
      tab: null,
      items: ["조합정보", "영양정보", "분석정보"],
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    clickHeart() {
      if (this.isliked) {
        this.isliked = false;
      } else {
        this.isliked = true;
      }
    },
    goProfile() {
      this.$router.push({ name: "mypage" });
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
.left {
  float: left;
}
</style>
