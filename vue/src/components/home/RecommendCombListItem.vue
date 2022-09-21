<template>
  <div>
    <v-card class="home_card_s" elevation="3" outlined>{{ combiListItem.name }}</v-card>
  </div>
</template>

<script>
export default {
  name: "RecommendCombListItem",
  props: {
    combiListItem: Object,
  },
};
</script>

<style>
.home_card_s {
  height: 130px;
  width: 130px;
}
</style>
