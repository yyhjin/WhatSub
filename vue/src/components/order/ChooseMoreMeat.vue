<template>
  <div>
    <div class="chooseMoreMeat">
      <div class="title" style="font-size: 18px !important; font-weight: bold">미트 추가 선택</div>
      <more-meat-item
        :moreMeat="moreMeat"
        v-for="moreMeat in moreMeats"
        :key="moreMeat.name"
      ></more-meat-item>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import MoreMeatItem from "./MoreMeatItem.vue";
export default {
  name: "ChooseMoreMeat",

  components: { MoreMeatItem },

  computed: {
    ...mapGetters(["moreMeats"]),
  },
};
</script>

<style>
.chooseMoreMeat {
  border-top: 1px solid #a8a8a8 !important;
  width: 90%;
  margin: auto;
  padding-top: 8px;
  padding-bottom: 5px;
}
</style>
