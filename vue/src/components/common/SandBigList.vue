<template>
  <div>
    <div class="big_card" v-for="(SandListItem, index) in sandList" :key="index">
      <sand-big-list-item :sand-list-item="SandListItem"></sand-big-list-item>
    </div>
  </div>
</template>

<script>
import SandBigListItem from "@/components/common/SandBigListItem.vue";

export default {
  name: "SandBigList",
  data() {
    return {
      sandList: [
        {
          id: 1,
          name: "sand1",
        },
        {
          id: 2,
          name: "sand2",
        },
        {
          id: 3,
          name: "sand3",
        },
        {
          id: 4,
          name: "sand4",
        },
        {
          id: 5,
          name: "sand5",
        },
      ],
    };
  },
  components: { SandBigListItem },
};
</script>

<style>
.big_card {
  padding-top: 15px;
  padding-left: 20px;
  padding-right: 20px;
}
.big_card:last-child {
  margin-bottom: 70px;
}
</style>
