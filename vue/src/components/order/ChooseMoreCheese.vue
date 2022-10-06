<template>
  <div class="chooseCheese">
    <div class="title" style="font-size: 18px !important; font-weight: bold">
      치즈 추가 선택(1개)
    </div>
    <more-cheese-item
      :moreChe="moreChe"
      v-for="moreChe in moreCheese"
      :key="moreChe.name"
    ></more-cheese-item>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import MoreCheeseItem from "./MoreCheeseItem.vue";

export default {
  name: "ChooseMoreCheese",

  components: { MoreCheeseItem },

  computed: {
    ...mapGetters(["moreCheese"]),
  },
};
</script>

<style>
.chooseCheese {
  border-top: 1px solid #a8a8a8 !important;
  width: 90%;
  margin: auto;
}
</style>
