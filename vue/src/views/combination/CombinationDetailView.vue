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
        v-model="combiDetail.scoreAvg"
        color="yellow darken-2"
        background-color="yellow darken-2"
        size="27"
        half-increments
        hover
        readonly
      ></v-rating>
      <div>{{ combiDetail.scoreAvg }}</div>
      <v-img
        class="shadow_img"
        height="100"
        width="200"
        :src="combiDetail.imgUrl"
        alt="sandwitch"
      ></v-img>
      <v-container>
        <v-row align="center">
          <v-col class="pa-0" align="center">
            <span style="font-size: 18px; font-weight: bold"
              >{{ combiDetail.combName }}&nbsp;&nbsp;&nbsp;
            </span>
            <v-icon v-if="!isliked" color="grey" size="30" @click="clickHeart"
              >mdi-heart-outline</v-icon
            >
            <v-icon v-if="isliked" color="red" size="30" @click="clickHeart">mdi-heart</v-icon>
            <span style="font-size: 13px">{{ combiDetail.likesCnt }}</span>
          </v-col>
        </v-row>
      </v-container>
      <!-- <div class="ml-30">
        <div class="left">
          <h2 style="font-size: 18px">{{ combiDetail.combName }}</h2>
        </div>
        <div class="left ml-2 mt-n1">
          <v-icon v-if="!isliked" color="red" size="30" @click="clickHeart"
            >mdi-heart-outline</v-icon
          >
          <v-icon v-if="isliked" color="red" size="30" @click="clickHeart">mdi-heart</v-icon>
        </div>
      </div> -->
      <div class="ma-4 pb-3">
        <div style="font-size: 15px">{{ combiDetail.content }}</div>
      </div>
      <div class="ml-14 mb-5">
        <div class="left pt-1" style="font-size: 18px; font-weight: 900">
          {{ combiDetail.combination.price | comma }}원
        </div>
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
            <div>
              <div style="font-size: 14px">{{ combiDetail.userName }}</div>
            </div>
            <div>
              <div style="font-size: 13px">{{ createDate }}</div>
            </div>
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
              <combi-detail-info :combi-detail="combiDetail"></combi-detail-info>
            </div>
          </v-card>
          <v-card class="mb-3" v-else-if="item == '영양정보'" flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-nutrition-info :combi-detail="combiDetail.combination"></combi-nutrition-info>
            </div>
          </v-card>
          <v-card v-else flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-statistic :combi-detail="combiDetail.statistics"></combi-statistic>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div>
      <review-list :combi-review="combiDetail.reviews"></review-list>
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
import { mapActions, mapGetters } from "vuex";
import dayjs from "dayjs";

export default {
  name: "CombinationDetailView",
  components: { BottomNav, CombiDetailInfo, CombiNutritionInfo, CombiStatistic, ReviewList },
  data() {
    return {
      isliked: false,
      tab: null,
      items: ["조합정보", "영양정보", "분석정보"],
      createDate: "",
    };
  },
  props: {
    combinationPostId: String,
  },
  computed: {
    ...mapGetters(["combiDetail", "sampleUserId"]),
  },
  // watch: {
  //   "$store.state.combination.combiDetail": function () {
  //     this.getCombiDetail({ combinationPostId: this.combinationPostId, userId: this.sampleUserId });
  //   },
  // },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  created() {
    //combinationPostId 로 api 검색
    this.getCombiDetail({ combinationPostId: this.combinationPostId, userId: this.sampleUserId });
    if (this.combiDetail.dib == 1) {
      this.isliked = true;
    } else {
      this.isliked = false;
    }
    this.createDate = dayjs(this.combiDetail.createdAt).format("YYYY-MM-DD HH:mm");
    //현재 로그인한 유저의 찜 목록(찜 목록 조회)에 해당 꿀조합이 있다면 빨간하트 표시
  },
  methods: {
    ...mapActions(["getCombiDetail", "updateZzimCombi", "sampleUserId"]),
    goBack() {
      this.$router.go(-1);
    },
    clickHeart() {
      if (this.isliked) {
        this.updateZzimCombi({
          combPostId: this.combinationPostId,
          userId: this.sampleUserId,
        });
        this.isliked = false;
      } else {
        this.updateZzimCombi({
          combPostId: this.combinationPostId,
          userId: this.sampleUserId,
        });
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
