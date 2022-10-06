<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div>
      <user-ranking :userRank="userRank"></user-ranking>
    </div>
    <div class="bottom_r">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import UserRanking from "@/components/rank/UserRanking.vue";
import BottomNav from "../../components/common/BottomNav.vue";
import axios from "axios";
export default {
  name: "RankView",

  data() {
    return {
      userRank: [],
    };
  },

  components: { TopNav, UserRanking, BottomNav },

  mounted() {
    axios({
      url: "https://j7a105.p.ssafy.io/api/v1/ranking",
      method: "get",
    })
      .then((res) => {
        console.log("ranking 성공", res);
        this.userRank = res.data.data;
      })
      .catch((err) => {
        console.log("ranking 실패", err);
      });
  },
};
</script>

<style>
.top {
  position: fixed;
  width: 100%;
}
.main {
  padding-top: 56px;
  text-align: center;
}
.bottom_r {
  position: fixed;
  width: 100%;
  bottom: 0;
  z-index: 2;
}
</style>
