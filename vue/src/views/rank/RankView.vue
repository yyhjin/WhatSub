<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <user-ranking></user-ranking>
  </div>
</template>

<script>
import TopNav from '@/components/common/TopNav.vue';
import UserRanking from '@/components/rank/UserRanking.vue';
export default {
  name: "RankView",

  components: { TopNav, UserRanking },

}
        
 
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
</style>