<template>
  <div>
    <v-card class="sand_big_card">{{ SandListItem.name }}</v-card>
  </div>
</template>

<script>
export default {
  name: "SandBigListItem",
  props: {
    SandListItem: Object,
  },
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
.sand_big_card:last-child {
  margin-bottom: 10px;
}
</style>
