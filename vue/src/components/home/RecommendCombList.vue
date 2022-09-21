<template>
  <div>
    <div align="center">다른 유저의 추천 꿀조합</div>
    <div class="verti_combi no-scroll">
      <div class="combi_card" v-for="combiListItem in combiList" :key="combiListItem.id">
        <recommend-comb-list-item :combi-list-item="combiListItem"></recommend-comb-list-item>
      </div>
    </div>
  </div>
</template>

<script>
import RecommendCombListItem from "@/components/home/RecommendCombListItem.vue";

export default {
  name: "RecommendCombList",
  components: { RecommendCombListItem },
  props: {
    combiList: Array,
  },
};
</script>

<style>
.verti_combi {
  overflow: scroll;
  white-space: nowrap;
  display: flex;
}
.combi_card {
  margin-left: 20px;
  margin-top: 5px;
  margin-bottom: 20px;
}
.no-scroll::-webkit-scrollbar {
  display: none;
}
</style>
