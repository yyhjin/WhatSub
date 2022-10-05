<template>
  <div class="small_card">
    <v-row>
      <v-col v-for="(SandListItem, index) in combiList" :key="index">
        <sand-small-list-item :sand-list-item="SandListItem"></sand-small-list-item>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import SandSmallListItem from "@/components/common/mypage/SandSmallListItemMyCombi.vue";
import { mapGetters } from "vuex";

export default {
  name: "SandSmallListMyCombi",
  data() {
    return {};
  },
  props: {
    combiList: Array,
  },
  components: { SandSmallListItem },
  computed: {
    ...mapGetters(["combiListByNutri"]),
  },
};
</script>

<style>
.small_card:last-child {
  margin-bottom: 70px;
}
</style>
