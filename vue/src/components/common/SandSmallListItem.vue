<template>
  <div>
    <v-card class="sand_small_card" align="center" @click.stop="dialogRecoCombi = true">
      <v-img height="75" width="80"></v-img>
      <h4 class="pt-2">{{ SandListItem.combName }}</h4>
      <div style="font-size: 15px">{{ SandListItem.price | comma }}원</div>
    </v-card>
    <combi-modal
      :combi-list-item="SandListItem"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import CombiModal from "@/components/common/CombiModal.vue";

export default {
  name: "SandSmallListItem",
  components: { CombiModal },
  data() {
    return {
      dialogRecoCombi: false,
    };
  },
  props: {
    SandListItem: Object,
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style>
.sand_small_card {
  height: 140px;
  width: 140px;
}
</style>
