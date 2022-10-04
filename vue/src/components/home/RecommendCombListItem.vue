<template>
  <div>
    <v-card
      class="home_card_s"
      align="center"
      elevation="3"
      outlined
      @click.stop="dialogRecoCombi = true"
      ><v-img class="shadow_img" :src="combiListItem.imgUrl"></v-img>
      <h4 class="mt-n3">{{ combiListItem.combName }}</h4>
      <div style="font-size: 15px">{{ combiListItem.price | comma }}원</div></v-card
    >
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
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style>
.home_card_s {
  height: 130px;
  width: 130px;
}
</style>
