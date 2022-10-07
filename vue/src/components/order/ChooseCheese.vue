<template>
  <div class="chooseCheese">
    <div class="title" style="font-size: 18px !important; font-weight: bold">치즈 선택</div>
    <cheese-item :chee="chee" v-for="chee in cheese" :key="chee.name"></cheese-item>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import CheeseItem from "./CheeseItem.vue";

export default {
  name: "ChooseCheese",

  components: { CheeseItem },

  computed: {
    ...mapGetters(["cheese"]),
  },
};
</script>

<style>
.chooseCheese {
  border-top: 1px solid #a8a8a8 !important;
  width: 90%;
  margin: auto;
  padding-top: 8px;
  padding-bottom: 5px;
}
</style>
