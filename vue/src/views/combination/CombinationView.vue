<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-15 pl-5 pr-5 pb-3">
      <h3 style="font-size: 22px; float: left">꿀조합 추천</h3>
      <v-spacer></v-spacer>
      <v-btn class="green_btn" height="32" rounded style="float: right" @click="goOrderDetail"
        >꿀조합 등록</v-btn
      >
      <div class="mt-6">
        <div class="pt-8 ml-n2 mb-n10">
          <h2 style="position: relative; z-index: 2; transform: rotate(-35deg); width: 10px">
            <span class="fir">BEST</span><span class="sec">!</span>
          </h2>
        </div>
      </div>
      <div class="">
        <v-card class="sand_big_card" style="position: relative; z-index: 1">
          <v-row class="">
            <v-col class="pa-0 mt-3 ml-3" cols="5" align="center" @click="goCombiDetail">
              <v-img class="shadow_img" height="70" width="150" :src="bestCombi.imgUrl"></v-img>
              <div class="mt-1">
                <h6 style="font-size: 15px; font-weight: bold">{{ bestCombi.combName }}</h6>
              </div>
              <div>
                <h6 style="font-size: 13px; font-weight: 400">
                  {{ bestCombi.combination.price | comma }}원
                </h6>
              </div>
            </v-col>
            <v-col>
              <div class="mt-1 ml-n4" @click="goCombiDetail">
                <h6 style="font-size: 14px; font-weight: 500">
                  메뉴: {{ bestCombi.menuName }}<br />추가재료: {{ others[0] }}···<br />소스:
                  {{ sauce[0] }}···
                </h6>
              </div>
              <div class="mt-4 ml-n3">
                <v-icon size="20" color="yellow darken-2">mdi-star</v-icon>
                <span style="font-size: small">{{ bestCombi.scoreAvg }}</span>
                <v-icon class="ml-2" size="17" color="green darken-2">mdi-message-outline</v-icon>
                <span style="font-size: small"> {{ bestCombi.reviewCnt }}</span>
                <v-icon class="ml-2" size="17" color="red">mdi-heart</v-icon>
                <span style="font-size: small"> {{ bestCombi.likesCnt }}</span>
              </div>
            </v-col>
          </v-row>
        </v-card>
      </div>
    </div>
    <v-divider></v-divider>
    <div>
      <combi-list></combi-list>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import CombiList from "@/components/combination/CombiList.vue";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "CombinationView",
  components: { TopNav, BottomNav, CombiList },
  data() {
    return {
      isliked: true,
      others: [],
      sauce: [],
    };
  },
  computed: {
    ...mapGetters(["bestCombi", "sampleUserId"]),
  },
  created() {
    this.getBestCombi({
      userId: this.sampleUserId,
    });
    for (let index = 0; index < this.bestCombi.ingredients.length; index++) {
      if (this.bestCombi.ingredients[index].category == "추가") {
        this.others.push(this.bestCombi.ingredients[index].name);
      } else if (this.bestCombi.ingredients[index].category == "소스") {
        this.sauce.push(this.bestCombi.ingredients[index].name);
      }
    }
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions(["getBestCombi"]),
    goCombiDetail() {
      this.$router.push({
        name: "combinationdetail",
        params: {
          combinationPostId: this.bestCombi.combinationPostId,
        },
      });
    },
    goOrderDetail() {
      this.$router.push({
        name: "orderdetail",
      });
    },
  },
};
</script>

<style></style>
