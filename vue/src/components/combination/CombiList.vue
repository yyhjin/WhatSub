<template>
  <div>
    <v-container class="mb-n8">
      <v-row class="pl-2 pr-2">
        <v-col cols="8" align="center" style="float: left" v-on:click="setfiltering"
          ><v-select
            :items="items"
            color="#239347"
            item-color="#239347"
            full-width
            label="Menu"
            dense
            outlined
          ></v-select
        ></v-col>
        <v-col
          class="pa-0 mt-9 ml-n2"
          align="right"
          style="float: right; font-size: 14px"
          @click="sortByRating"
          >평점순</v-col
        >
        <v-col
          class="pa-0 mt-9 ml-n1"
          align="center"
          style="float: left; font-size: 14px"
          @click="sortByDate"
          >최신순</v-col
        >
      </v-row>
    </v-container>
    <div
      class="big_card"
      v-for="sandListItem in scrollSandList"
      :key="sandListItem.combinationPostId"
    >
      <combi-list-item :combi-list-item="sandListItem"></combi-list-item>
    </div>
    <div v-if="scrollSandList.length" v-observe-visibility="handleScrolledToBottom"></div>
    <br />
    <br />
  </div>
</template>

<script>
import CombiListItem from "@/components/combination/CombiListItem.vue";
import Vue from "vue";
import VueObserveVisibility from "vue-observe-visibility";
import { mapActions, mapGetters } from "vuex";

Vue.use(VueObserveVisibility);

export default {
  name: "CombiList",
  components: { CombiListItem },
  data() {
    return {
      scrollSandList: [],
      page: 1,
      items: [
        "K-바비큐",
        "로스트 치킨",
        "로티세리 바비큐 치킨",
        "머쉬룸",
        "베지",
        "비엘티",
        "쉬림프",
        "스테이크&치즈",
        "스파이시 이탈리안",
        "써브웨이 클럽",
        "에그마요",
        "이탈리안 비엠티",
        "참치",
        "치킨 데리야끼",
        "치킨 베이컨 아보카도",
        "치킨 슬라이스",
        "터키",
        "터키 베이컨 아보카도",
        "풀드 포크 바비큐",
        "햄",
      ],
    };
  },
  computed: {
    ...mapGetters(["combiList"]),
  },
  created() {
    this.getCombiList({
      orderNo: 1,
    });
    console.log(this.combiList);
    this.homeToScroll();
  },
  methods: {
    ...mapActions(["getCombiList"]),
    handleScrolledToBottom(isVisible) {
      if (!isVisible) {
        return;
      }
      this.page++;
      this.homeToScroll();
    },
    homeToScroll() {
      const nextPush = this.combiList.slice(5 * (this.page - 1), 5 * this.page);
      this.scrollSandList.push(...nextPush);
    },
    setfiltering() {},
    sortByRating() {
      this.getCombiList({
        orderNo: 0,
      });
      console.log(this.combiList);
    },
    sortByDate() {
      this.getCombiList({
        orderNo: 1,
      });
      console.log(this.combiList);
    },
  },
};
</script>

<style>
.big_card {
  padding-top: 15px;
  padding-left: 20px;
  padding-right: 20px;
}
.big_card:last-child {
  margin-bottom: 70px;
}
.v-input__slot {
  min-height: 38px !important;
  font-size: 15px;
}
</style>
