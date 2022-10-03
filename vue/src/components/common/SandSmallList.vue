<template>
  <div class="small_card">
    <v-row>
      <v-col v-for="(SandListItem, index) in combiListByNutri" :key="index">
        <sand-small-list-item :sand-list-item="SandListItem"></sand-small-list-item>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import SandSmallListItem from "@/components/common/SandSmallListItem.vue";
import { mapGetters } from "vuex";

export default {
  name: "SandSmallList",
  data() {
    return {};
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
