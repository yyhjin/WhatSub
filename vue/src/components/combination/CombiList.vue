<template>
  <div>
    <v-container class="mb-n8">
      <v-row class="pl-2 pr-2">
        <v-col cols="8" align="center" style="float: left" v-on:click="setfiltering"
          ><v-select
            :items="items"
            v-model="selectedMenuId"
            item-text="name"
            item-value="value"
            color="#239347"
            item-color="#239347"
            full-width
            label="Menu"
            dense
            outlined
            @change="setfiltering"
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
        { name: "K-바비큐", value: "n" },
        { name: "로스트 치킨", value: "h" },
        { name: "로티세리 바비큐 치킨", value: "i" },
        { name: "머쉬룸", value: "t" },
        { name: "베지", value: "l" },
        { name: "비엘티", value: "e" },
        { name: "쉬림프", value: "m" },
        { name: "스테이크&치즈", value: "p" },
        { name: "스파이시 이탈리안", value: "r" },
        { name: "써브웨이 클럽", value: "j" },
        { name: "에그마요", value: "c" },
        { name: "이탈리안 비엠티", value: "d" },
        { name: "참치", value: "b" },
        { name: "치킨 데리야끼", value: "s" },
        { name: "치킨 베이컨 아보카도", value: "g" },
        { name: "치킨 슬라이스", value: "f" },
        { name: "터키", value: "k" },
        { name: "터키 베이컨 아보카도", value: "q" },
        { name: "풀드 포크 바비큐", value: "o" },
        { name: "햄", value: "a" },
        // "K-바비큐",
        // "로스트 치킨",
        // "로티세리 바비큐 치킨",
        // "머쉬룸",
        // "베지",
        // "비엘티",
        // "쉬림프",
        // "스테이크&치즈",
        // "스파이시 이탈리안",
        // "써브웨이 클럽",
        // "에그마요",
        // "이탈리안 비엠티",
        // "참치",
        // "치킨 데리야끼",
        // "치킨 베이컨 아보카도",
        // "치킨 슬라이스",
        // "터키",
        // "터키 베이컨 아보카도",
        // "풀드 포크 바비큐",
        // "햄",
      ],
      selectedMenuId: "",
    };
  },
  computed: {
    ...mapGetters(["combiList", "sampleUserId"]),
  },
  created() {
    console.log(this.combiList);
    this.homeToScroll();
  },
  watch: {
    "$store.state.combination.combiList": function () {
      this.scrollSandList = [];
      this.homeToScroll();
    },
  },

  methods: {
    ...mapActions(["getCombiList", "getFilteringMenu"]),
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
    setfiltering() {
      console.log(this.selectedMenuId);
      this.getFilteringMenu({
        menuId: this.selectedMenuId,
        userId: this.sampleUserId,
      });
    },
    sortByRating() {
      this.getCombiList({
        orderNo: 0,
        userId: this.sampleUserId,
      });
      console.log(this.combiList);
    },
    sortByDate() {
      this.getCombiList({
        orderNo: 1,
        userId: this.sampleUserId,
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
  margin-bottom: 90px;
}
.v-input__slot {
  min-height: 38px !important;
  font-size: 15px;
}
</style>
