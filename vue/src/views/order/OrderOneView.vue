<template>
  <div>
    <div class="top">
      <top-nav></top-nav>
    </div>
    <div class="pt-15">
      <div align="center" style="height: 5vh"><h3>지점 선택</h3></div>
      <search-store-map />
    </div>
    <v-container>
      <div style="padding: 10px">
        <div v-if="selectedStore == null">지점을 선택해주세요</div>
        <div v-else>
          <v-row align="center" justify="center">
            <v-col cols="8">
              <h4 style="font-size: 20px">{{ selectedStore.branchName }}점</h4>
              <div>{{ selectedStore.contactNo }}</div>
              <div style="font-size: 15px">{{ selectedStore.streetAddress }}</div>
            </v-col>
            <v-col cols="4" align="center">
              <v-btn class="main_btn" @click="nextOrder">주문하기</v-btn>
            </v-col>
          </v-row>
        </div>
      </div>
      <br />
      <br />
    </v-container>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import TopNav from "@/components/common/TopNav.vue";
import SearchStoreMap from "../../components/order/SearchStoreMap.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import { mapGetters, mapActions } from "vuex";
import axios from "axios";
import api from "@/api/api";

export default {
  components: { SearchStoreMap, TopNav, BottomNav },
  name: "OrderOne",

  props: {
    combinationPostId: Number,
  },

  computed: {
    ...mapGetters(["selectedStore"]),
  },

  methods: {
    ...mapActions([
      "selectMenu",
      "selectBread",
      "selectCheese",
      "selectVege",
      "selectSauce",
      "selectMoreMeat",
      "selectMore",
      "selectMoreCheese",
    ]),
    nextOrder() {
      this.$router.push({ name: "ordertwo" });
    },
  },

  created() {},

  mounted() {
    if (this.combinationPostId) {
      axios({
        url: api.comb.comb.ingre(this.combinationPostId),
        method: "get",
      })
        .then((res) => {
          console.log(res);
          // this.selectMenu(this.orderMenu.combinationList[radio.value].menu)
          this.selectMenu(res.data.data.menu);
          res.data.data.ingredients.forEach((ingredient) => {
            if (ingredient.category === "빵") {
              this.selectBread(ingredient);
            } else if (ingredient.category === "치즈") {
              this.selectCheese(ingredient);
            } else if (ingredient.category === "야채") {
              this.selectVege(ingredient);
            } else if (ingredient.category === "소스") {
              this.selectSauce(ingredient);
            } else if (ingredient.category === "미트추가") {
              this.selectMoreMeat(ingredient);
            } else if (ingredient.category === "추가") {
              this.selectMore(ingredient);
            } else if (ingredient.category === "치즈추가") {
              this.selectMoreCheese(ingredient);
            }
          });
        })
        .catch((err) => {
          console.log("ingre 오류", err);
        });
    }
  },
};
</script>

<style></style>
