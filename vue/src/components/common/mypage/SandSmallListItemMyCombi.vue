<template>
  <div>
    <v-card class="sand_small_card" align="center" @click.stop="dialogRecoCombi = true">
      <v-img class="shadow_img" :src="SandListItem.imgUrl" width="85%" ></v-img>
      <h4 class="mt-n2" style="font-size: 15px">{{ SandListItem.combName }}</h4>
      <div class="" style="font-size: 13px">{{ SandListItem.combination.price | comma }}원</div>
    </v-card>
    <combi-modal
      :combi-list-item="SandListItem"
      :value="dialogRecoCombi"
      @input="dialogRecoCombi = $event"
    ></combi-modal>
  </div>
</template>

<script>
import CombiModal from "@/components/common/mypage/CombiModalMyCombi.vue";

export default {
  name: "SandSmallListItemMyCombi",
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

<style scoped>
.sand_small_card {
  height: 140px;
  width: 140px;
  
}
.shadow_img {
  top: 5px;
  margin-bottom: 15px;
}
</style>
ㅎ