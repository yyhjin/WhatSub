<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import BottomNav from "@/components/common/BottomNav.vue";

export default {
  name: "CombinationView",
  components: { TopNav, BottomNav },
};
</script>

<style></style>
