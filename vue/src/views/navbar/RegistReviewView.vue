<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="3">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-10"><h3>리뷰 등록</h3></v-col>
      </v-row>
    </div>
    <div class="pt-20" align="center">
      <v-img
        height="100"
        width="250"
        :src="combiDetail.imgUrl"
        alt="sandwitch"
      ></v-img>
      <div class="pt-3"><h2 style="font-size: 17px">{{ combiDetail.combName }}</h2></div>
      <div class="ma-4 pt-1 pb-1">
        <div style="font-size: 15px">{{ combiDetail.content }}</div>
      </div>
      <h3 class="pt-1 pb-8" style="font-size: 17px">{{ combiDetail.combination.price }}원</h3>
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
              <combi-detail-info :combi-detail="combiDetail"></combi-detail-info>
            </div>
          </v-card>
          <v-card class="mb-3" v-else flat>
            <div class="pt-4 pl-6 pr-6">
              <combi-nutrition-info :combi-detail="combiDetail.combination"></combi-nutrition-info>
            </div>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </div>
    <v-card height="4" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
    <div class="pa-5">
      <div style="font-size: 15px; font-weight: bold">평점</div>
      <div class="mb-7">
        <v-rating
          v-model="rating"
          color="yellow darken-2"
          background-color="yellow darken-2"
          size="35"
          half-increments
          hover
        ></v-rating>
      </div>
      <div style="font-size: 15px; font-weight: bold">리뷰 작성</div>
      <v-textarea style="font-size: 15px" height="200" outlined solo v-model="reviewContent"></v-textarea>
    </div>
    <div class="mt-n3" align="center">
      <v-btn class="main_btn" style="font-size: 15px" width="200" v-if="!isreviewed" small rounded @click="registReview">리뷰 등록</v-btn>
      <v-btn class="main_btn" style="font-size: 15px" width="200" v-else small rounded @click="changeReview">리뷰 수정</v-btn>
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
import CombiDetailInfo from "@/components/combination/detailTab/CombiDetailInfo.vue";
import CombiNutritionInfo from "@/components/combination/detailTab/CombiNutritionInfo.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import { mapActions, mapGetters } from 'vuex';
import axios from 'axios'

export default {
  name: "RegistReviewView",
  components: {
    BottomNav,
    CombiDetailInfo,
    CombiNutritionInfo,
  },
  props: {
    combinationPostId:Number
  },
  data() {
    return {
      tab: null,
      items: ["조합정보", "영양정보"],
      rating: 5,
      reviewContent: '',
      isreviewed: false,
      reviewId: null
    };
  },

  computed: {
    ...mapGetters(['combiDetail', 'profile', 'username'])
  },

  methods: {
    ...mapActions(['getCombiDetail', 'fetchProfile']),

    goBack() {
      this.$router.go(-1);
    },

    registReview() {
      axios({
        url: 'https://j7a105.p.ssafy.io/api/v1/review',
        method: 'post',
        data: {
          "combinationPostId" : this.combinationPostId,
          "content": this.reviewContent,
          "score": this.rating,
          "userId": this.profile.userId
        }
      }).then(res => {
        console.log(res)
        this.$router.push({name: "combinationdetail", params:{combinationPostId:this.combinationPostId}})
      }).catch(err => {
        console.error('registReview 에러', err)
      })
    },

    changeReview () {
      axios({
        url: `https://j7a105.p.ssafy.io/api/v1/review/${this.reviewId}`,
        method: 'put',
        data: {
          "combinationPostId" : this.combinationPostId,
          "content": this.reviewContent,
          "score": this.rating,
          "userId": this.profile.userId
        }
      }).then(res => {
        console.log(res)
        this.$router.push({name: "combinationdetail", params:{combinationPostId:this.combinationPostId, userId: this.profile.userId}})
      }).catch(err => {
        console.error('changeReview 에러', err)
      })
    }
  },

  mounted () {
    console.log(this.combinationPostId)
    this.getCombiDetail({ combinationPostId: this.combinationPostId, userId:this.profile.userId })
    this.fetchProfile({username:this.username})
    axios({
      url: `https://j7a105.p.ssafy.io/api/v1/review/${this.combinationPostId}`,
      method: 'get'
    }).then(res => {
      res.data.data.forEach(each => {
        if (each.userId === this.profile.userId) {
          this.isreviewed = true
          this.rating = each.score
          this.reviewContent = each.content
          this.reviewId = each.reviewId
        }
      })
    })
  }
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
