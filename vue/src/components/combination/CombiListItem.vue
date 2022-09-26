<template>
  <div>
    <v-card class="sand_big_card">zx</v-card>
  </div>
</template>

<script>
export default {
  name: "CombiListItem",
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
