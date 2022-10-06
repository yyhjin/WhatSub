<template>
  <div>
    <div class="main">
      <h2>명예의 전당</h2>
    </div>
    <user-ranking-item :index="index" :sand="sand" v-for="(sand, index) in userRank" :key="index"></user-ranking-item>
  </div>
</template>

<script>
// import UserRankingItem from '@/components/rank/UserRanking.vue';
import UserRankingItem from './UserRankingItem.vue';
export default {
  name: "UserRanking",

  components: { UserRankingItem},

  props:{
    userRank:Array
  },

  
}
</script>

<style>
.main {
  padding-top: 56px;
  text-align: center;
}
</style>