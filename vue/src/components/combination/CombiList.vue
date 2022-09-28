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
        <v-col class="mt-3" align="right" style="float: right">최신순</v-col>
      </v-row>
    </v-container>
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
      items: ["에그마요", "스테이크&치즈"],
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
.v-input__slot {
  min-height: 38px !important;
  font-size: 15px;
}
</style>
