<template>
  <div>
    <div class="chooseSauce">
      <div class="title" style="font-size: 18px !important; font-weight: bold">
        소스 선택(최대 3개)
      </div>
      <sauce-item :sa="sa" v-for="sa in sauce" :key="sa.name"></sauce-item>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import SauceItem from "./SauceItem.vue";
export default {
  name: "ChooseSauce",

  components: { SauceItem },

  computed: {
    ...mapGetters(["sauce"]),
  },
};
</script>

<style>
.chooseSauce {
  border-top: 1px solid #a8a8a8 !important;
  width: 90%;
  margin: auto;
  padding-top: 8px;
  padding-bottom: 5px;
}
</style>
