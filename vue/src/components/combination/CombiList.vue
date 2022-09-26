<template>
  <div class="pt-5">
    <div class="pl-5 pr-5 mb-3">
      <div style="float: left" v-on:click="filtering">필터</div>
      <div style="float: right">평점 높은 순</div>
    </div>
    <div class="big_card" v-for="(SandListItem, index) in sandList" :key="index">
      <combi-list-item :snad-list-item="SandListItem"></combi-list-item>
    </div>
  </div>
</template>

<script>
import CombiListItem from "@/components/combination/CombiListItem.vue";

export default {
  name: "CombiList",
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
  components: { CombiListItem },
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
