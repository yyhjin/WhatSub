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
        :src="imgUrl"
        alt="sandwitch"
      ></v-img>
      <div class="pt-3"><h2 style="font-size: 17px">{{ name }}</h2></div>
      <div class="pt-1 pb-8" style="font-size: 15px">{{ combi.price }}원</div>
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
      <v-text-field outlined solo dense v-model="title"></v-text-field>
      <div style="font-size: 15px; font-weight: bold">꿀조합 설명</div>
      <v-textarea style="font-size: 15px" height="200" outlined solo v-model="content"></v-textarea>
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
  props: {
    imgUrl: String,
    name: String,
    combinationId: String,
    combi:String
  },
  data() {
    return {
      tab: null,
      items: ["조합정보", "영양정보"],
      title: '',
      content: '',
      mapDict: {
      '1a': '허니오트', 
      '1b': '하티', 
      '1c': '위트', 
      '1d': '파마산 오레가노', 
      '1e': '화이트', 
      '1f': '플랫브레드', 
      '2a': '아메리칸치즈', 
      '2b': '슈레드치즈', 
      '2c': '모차렐라치즈', 
      '3a': '양상추', 
      '3b': '토마토', 
      '3c': '오이', 
      '3d': '피망', 
      '3e': '양파', 
      '3f': '피클', 
      '3g': '올리브', 
      '3h': '할라피뇨', 
      '4a': '랜치', 
      '4b': '마요네즈', 
      '4c': '스위트 어니언', 
      '4d': '허니 머스타드', 
      '4e': '스위트 칠리', 
      '4f': '핫 칠리', 
      '4g': '사우스웨스트 치폴레', 
      '4h': '머스타드', '4i': '홀스래디쉬', '4j': '올리브 오일', 
      '4k': '레드와인식초', '4l': '소금', '4m': '후추', 
      '4n': '스모크 바비큐', '5a': '아메리칸치즈', '5b': '슈레드치즈', 
      '5c': '모차렐라치즈', '6a': '에그마요', 
      '6b': '베이컨', '6c': '아보카도', '6d': '오믈렛', '6e': '페퍼로니', 
      '7a': '스테이크/치즈', '7b': '치킨베이컨',
      '7c': 'K-바비큐', '7d': '로스트 치킨', '7e': '로티세리 치킨', '6f': '풀드포크', 
      '7g': '쉬림프', '7h': '클럽(치킨)', '7i': '치킨 데리야끼', '7j': '스파이시 이탈리안', 
      '7k': '비엠티', '7l': '비엘티', '7m': '치킨슬라이스', 
      '7n': '머쉬룸', '7o': '참치', '7p': '햄'}
    };
  },

  computed: {
    com () {
      return JSON.parse(this.combi)
    }
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
