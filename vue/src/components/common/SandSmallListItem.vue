<template>
  <div>
    <v-card class="sand_small_card">{{ SandListItem.name }}</v-card>
  </div>
</template>

<script>
export default {
  name: "SandSmallListItem",
  props: {
    SandListItem: Object,
  },
};
</script>

<style>
.sand_small_card {
  height: 140px;
  width: 140px;
}
</style>
