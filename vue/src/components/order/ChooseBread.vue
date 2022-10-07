<template>
  <div class="chooseBread">
    <div class="title" style="font-size: 18px !important; font-weight: bold">빵 선택</div>
    <bread-item :bread="bread" v-for="bread in breads" :key="bread.name"></bread-item>
  </div>
</template>

<script>
import BreadItem from "@/components/order/BreadItem.vue";
import { mapGetters } from "vuex";

export default {
  name: "ChooseBread",

  components: { BreadItem },

  computed: {
    ...mapGetters(["breads"]),
  },
};
</script>

<style>
.chooseBread {
  border-top: 1px solid #a8a8a8;
  width: 90%;
  margin: auto;
  padding-bottom: 5px;
}
</style>
