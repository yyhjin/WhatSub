<template>
  <div>
    <h3 style="color: black; font-size: 15px">영양정보</h3>
    {{ combiListItem.nutri }}
  </div>
</template>

<script>
export default {
  name: "CombiInfoNutrition",
  props: {
    combiListItem: Object,
  },
  created() {},
};
</script>

<style></style>
