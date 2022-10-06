<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-20" align="center">
      <div class="pb-4">
        <v-avatar color="grey lighten-1" size="90"
          ><img :src="profile.profileImg" alt="user image"
        /></v-avatar>
      </div>
      <div>
        <h3>{{ profile.userName }}</h3>
      </div>
      <div>
        <h3>{{ profile.subti }}</h3>
      </div>
    </div>
    <div>
      <collection-list></collection-list>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import CollectionList from "@/components/profile/CollectionList.vue";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "MyPageView",
  components: { TopNav, BottomNav, CollectionList },
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["profile"]),
  },
  created() {
    this.fetchProfile();
  },
  methods: {
    ...mapActions(["fetchProfile"]),
  },
};
</script>

<style></style>
