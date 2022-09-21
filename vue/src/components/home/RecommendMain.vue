<template>
  <div>
    <h1>recommendmain</h1>
    <div class="main_card">
      <recommend-personal></recommend-personal>
    </div>
    <div class="main_card">
      <recommend-subti></recommend-subti>
    </div>
  </div>
</template>

<script>
import RecommendPersonal from "./RecommendPersonal.vue";
import RecommendSubti from "./RecommendSubti.vue";

export default {
  name: "RecommendMain",
  components: { RecommendPersonal, RecommendSubti },
};
</script>

<style>
.main_card {
  margin: 20px;
}
</style>
