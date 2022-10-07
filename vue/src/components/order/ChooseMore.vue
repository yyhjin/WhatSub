<template>
  <div>
    <div class="chooseMore">
      <div class="title" style="font-size: 18px !important; font-weight: bold">추가 선택</div>
      <more-item :mo="mo" v-for="mo in more" :key="mo.name"></more-item>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import MoreItem from "./MoreItem.vue";

export default {
  name: "ChooseMore",

  components: { MoreItem },

  computed: {
    ...mapGetters(["more"]),
  },
};
</script>

<style>
.chooseMore {
  border-top: 1px solid #a8a8a8 !important;
  width: 90%;
  margin: auto;
  padding-top: 8px;
  padding-bottom: 5px;
}
</style>
