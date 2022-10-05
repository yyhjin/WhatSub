<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-20" align="center">
      <div class="pb-4">
        <v-avatar color="grey lighten-1" size="90"
          ><img
            src="https://whatsub.s3.ap-northeast-2.amazonaws.com/default/homin.png"
            alt="user image"
        /></v-avatar>
      </div>
      <div>
        <h3>{{ userInfo.nick }}</h3>
      </div>
      <div>
        <h3>{{ userInfo.subti }}</h3>
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
    return {
      userInfo: {
        id: 1,
        nick: "B.L.T 마스터",
        subti: "INFJ",
        collection: [
          {
            menu: "B.L.T",
            rank: 1,
            date: "2022-9",
          },
          {
            menu: "B.L.T",
            rank: 2,
            date: "2022-8",
          },
          {
            menu: "B.L.T",
            rank: 3,
            date: "2022-7",
          },
          {
            menu: "터키 베이컨 아보카도",
            rank: 2,
            date: "2022-6",
          },
        ],
      },
    };
  },
  computed: {
    ...mapGetters(["profile", "sampleUserName"]),
  },
  created() {
    this.fetchProfile({
      username: this.sampleUserName,
    });
  },
  methods: {
    ...mapActions(["fetchProfile"]),
  },
};
</script>

<style></style>
