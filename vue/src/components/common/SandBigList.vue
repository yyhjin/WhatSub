<template>
  <div>
    <div class="big_card" v-for="(SandListItem, index) in dibList" :key="index">
      <sand-big-list-item :sand-list-item="SandListItem"></sand-big-list-item>
    </div>
  </div>
</template>

<script>
import SandBigListItem from "@/components/common/SandBigListItem.vue";
import { mapGetters } from 'vuex';

export default {
  name: "SandBigList",
  data() {
    return {
    };
  },

  computed: {
    ...mapGetters(['dibList'])
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
