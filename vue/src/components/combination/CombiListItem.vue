<template>
  <div class="mb-n2">
    <v-card class="sand_big_card">
      <v-card-title>{{ combiListItem.name }}</v-card-title>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "CombiListItem",
  props: {
    combiListItem: Object,
  },
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
</style>
