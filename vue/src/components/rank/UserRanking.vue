<template>
  <div>
    <div class="main">
      <h2>명예의 전당</h2>
    </div>
    <user-ranking-item :index="index" :sand="sand" v-for="(sand, index) in returnData" :key="index"></user-ranking-item>
  </div>
</template>

<script>
// import UserRankingItem from '@/components/rank/UserRanking.vue';
import UserRankingItem from './UserRankingItem.vue';
export default {
  name: "UserRanking",

  components: { UserRankingItem},

  data () {
    return {
      returnData : [{
        menu: '스테이크',
        menu_imgurl: 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        rank1: {
          username: '준우',
          cnt: 254,
          ranking : 1
        },
          rank2: {
          username: '동환',
          cnt: 254,
          ranking : 2
        },
          rank3: {
          username: '동환',
          cnt: 254,
          ranking : 3
        },
          rank4: {
          username: '나',
          cnt: 254,
          ranking : 1151
        }
      },
      {
        menu: '치즈',
        menu_imgurl: 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
          rank1: {
            username: '동환',
            cnt: 254,
            ranking : 1
          },
            rank2: {
            username: '동환',
            cnt: 254,
            ranking : 2
          },
            rank3: {
            username: '동환',
            cnt: 254,
            ranking : 3
          },
            rank4: {
            username: '나',
            cnt: 254,
            ranking : 1123
          }
      },
      {
        menu: '새우',
        menu_imgurl: 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
          rank1: {
            username: '도현',
            cnt: 254,
            ranking : 1
          },
            rank2: {
            username: '동환',
            cnt: 254,
            ranking : 2
          },
            rank3: {
            username: '동환',
            cnt: 254,
            ranking : 3
          },
            rank4: {
            username: '나',
            cnt: 254,
            ranking : 1123
          }
      }]
    }
  }
}
</script>

<style>
.main {
  padding-top: 56px;
  text-align: center;
}
</style>