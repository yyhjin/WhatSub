<template>
  <div>
    <div class="main">
      <h3 style="font-size: 21px">
        10월 명예의 전당
        <span><v-icon class="mt-n2" size="40" color="amber">mdi-crown-outline</v-icon></span>
      </h3>
    </div>
    <div>
      <user-ranking-item :sand="userRank"></user-ranking-item>
    </div>
  </div>
</template>

<script>
// import UserRankingItem from '@/components/rank/UserRanking.vue';
import UserRankingItem from "./UserRankingItem.vue";
// import dayjs from "dayjs";

export default {
  name: "UserRanking",

  components: { UserRankingItem },

  data() {
    return {
      // date: "",
    };
  },

  props: {
    userRank: Array,
  },
  created() {
    // this.date = dayjs(this.userRank[0].rankDate).format("MM");
  },
};
</script>

<style>
.main {
  padding-top: 56px;
  text-align: center;
}
</style>
