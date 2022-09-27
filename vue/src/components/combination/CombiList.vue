<template>
  <div class="pt-5">
    <div class="pl-5 pr-5 mb-3">
      <div style="float: left" v-on:click="setfiltering">필터</div>
      <div style="float: right">최신순</div>
    </div>
    <div class="big_card" v-for="sandListItem in scrollSandList" :key="sandListItem.id">
      <combi-list-item :combi-list-item="sandListItem"></combi-list-item>
    </div>
    <div v-if="scrollSandList.length" v-observe-visibility="handleScrolledToBottom"></div>
  </div>
</template>

<script>
import CombiListItem from "@/components/combination/CombiListItem.vue";
import { mapGetters } from "vuex";
import Vue from "vue";
import VueObserveVisibility from "vue-observe-visibility";

Vue.use(VueObserveVisibility);

export default {
  name: "CombiList",
  components: { CombiListItem },
  data() {
    return {
      scrollSandList: [],
      page: 1,
    };
  },
  computed: {
    ...mapGetters(["sandList"]),
  },
  created() {
    console.log(this.sandList);
    this.homeToScroll();
  },
  methods: {
    setfiltering() {},
    handleScrolledToBottom(isVisible) {
      if (!isVisible) {
        return;
      }
      this.page++;
      this.homeToScroll();
    },
    homeToScroll() {
      const nextPush = this.sandList.slice(5 * (this.page - 1), 5 * this.page);
      this.scrollSandList.push(...nextPush);
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
</style>
