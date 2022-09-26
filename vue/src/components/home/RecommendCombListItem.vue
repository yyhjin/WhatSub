<template>
  <div>
    <v-card class="home_card_s" elevation="3" outlined @click.stop="dialogRecoCombi = true">{{
      combiListItem.name
    }}</v-card>
    <combi-modal
      :combi-list-item="combiListItem"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import CombiModal from "@/components/common/CombiModal.vue";

export default {
  name: "RecommendCombListItem",
  components: { CombiModal },
  data() {
    return {
      dialogRecoCombi: false,
    };
  },
  props: {
    combiListItem: Object,
  },
};
</script>

<style>
.home_card_s {
  height: 130px;
  width: 130px;
}
</style>
