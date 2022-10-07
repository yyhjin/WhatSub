<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-20" align="center">
      <div class="pb-4">
        <v-avatar color="grey lighten-1" size="90"
          ><v-img :src="pro.img" alt="user image"
        /></v-avatar>
      </div>
      <div>
        <h3 style="font-size: 20px">{{ pro.userName }}</h3>
      </div>
      <div>
        <span style="font-size: 13px; font-weight: bold">썹BTI: &nbsp; &nbsp;</span>
        <span style="font-size: 18px; font-weight: bold">{{ pro.subti }}</span>
      </div>
    </div>
    <div>
      <collection-list :pro="pro"></collection-list>
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
import axios from 'axios';
// import { mapActions, mapGetters } from "vuex";

export default {
  name: "MyPageView",
  components: { TopNav, BottomNav, CollectionList },
  // props:{
  //   userName:String
  // },
  data() {
    return {
      pro : null
    };
  },
  watch: {
    '$store.getters.combiDetail' () {
      axios({
      url: `https://j7a105.p.ssafy.io/api/v1/user/${this.$route.params.userName}`,
      method:'get',

    }).then(res => {
      console.log(res)
      this.pro = res.data.data
    })
    },

  },
  mounted () {
    axios({
      url: `https://j7a105.p.ssafy.io/api/v1/user/${this.$route.params.userName}`,
      method:'get',

    }).then(res => {
      console.log(res)
      this.pro = res.data.data
    })
  },
  // methods: {
    
  // },
};
</script>

<style></style>
