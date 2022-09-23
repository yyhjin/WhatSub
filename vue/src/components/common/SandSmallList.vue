<template>
  <div>
    <v-row>
      <v-col v-for="(SandListItem, index) in sandList" :key="index">
        <sand-small-list-item :sand-list-item="SandListItem"></sand-small-list-item>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import SandSmallListItem from "@/components/common/SandSmallListItem.vue";

export default {
  name: "SandSmallList",
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
  components: { SandSmallListItem },
};
</script>

<style></style>
