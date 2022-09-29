<template>
  <div>
    <div style="color: black; font-size: 17px; font-weight: 900">영양정보</div>
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
