<template>
  <div>
    <div class="big_card mb-n4" v-for="(SandListItem, index) in zzimList" :key="index">
      <sand-big-list-item :sand-list-item="SandListItem"></sand-big-list-item>
    </div>
    <br />
    <br />
    <br />
  </div>
</template>

<script>
import SandBigListItem from "@/components/common/mypage/SandBigListItemMyPage.vue";

export default {
  name: "SandBigListMyPage",
  data() {
    return {};
  },
  props: {
    zzimList: Array,
  },
  computed: {},
  components: { SandBigListItem },
};
</script>

<style scoped>
.big_card {
  padding-top: 15px;
  padding-left: 20px;
  padding-right: 20px;
}
.big_card:last-child {
  margin-bottom: 70px;
}
</style>
