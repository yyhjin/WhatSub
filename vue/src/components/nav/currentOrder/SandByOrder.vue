<template>
  <div>
    <v-card class="sand_big_card" style="position: relative">
      <v-row class="pb-0">
        <v-col class="pa-0 mt-3 ml-3" cols="5" align="center">
          <v-img class="shadow_img" height="70" width="150" :src="imgUrl"></v-img>
        </v-col>
        <v-col class="pb-0" align="start">
          <div class="mt-2 ml-n4">
            <h6 style="font-size: 14px; font-weight: 500">
              추가재료: {{ more.substring(0, 9) }}···<br />소스: {{ sauce }}
            </h6>
          </div>
        </v-col>
      </v-row>
      <v-row class="" align="center">
        <v-col cols="6" class="" align="center">
          <div>
            <h6 style="font-size: 15px; font-weight: bold">{{ name }}</h6>
          </div>
        </v-col>
        <v-col class="ml-n6" align="center">
          <div>
            <v-btn
              class="main_btn regist"
              width="120"
              v-if="isRegisted"
              rounded
              small
              @click="goRegistForm"
              >리뷰 등록</v-btn
            >
            <v-btn class="green_btn regist" v-else width="120" rounded small @click="goRegistForm"
              >조합 등록</v-btn
            >
          </div>
        </v-col>
      </v-row>
    </v-card>
    <alert-combi
      :imgUrl="imgUrl"
      :name="name"
      :combinationId="combination.combinationId"
      :combi="combi"
      :value="openAlert"
      @input="openAlert = $event"
    ></alert-combi>
  </div>
</template>

<script>
import AlertCombi from "@/components/nav/AlertCombi.vue";
import api from "@/api/api";
import axios from "axios";
import { mapGetters } from "vuex";
export default {
  name: "SandByOrder",

  components: { AlertCombi },

  props: {
    combination: Object,
  },
  data() {
    return {
      isRegisted: false,
      openAlert: false,
      combinationPostId: null,
      imgUrl: this.combination.menu.imgUrl,
      name: this.combination.menu.menuName,
      menu: this.combination.menu.menuName,
      combi: null,
    };
  },

  computed: {
    ...mapGetters(["profile"]),
    more() {
      let more = "";
      this.combination.ingredients.forEach((each) => {
        if (
          each.category === "추가" ||
          each.category === "치즈추가" ||
          each.category === "미트추가"
        ) {
          more += each.name + ", ";
        }
      });
      return more.slice(0, -2);
    },

    sauce() {
      let sauce = "";
      this.combination.ingredients.forEach((each) => {
        if (each.category === "소스") {
          sauce += each.name + ", ";
        }
      });

      return sauce.slice(0, -2);
    },
  },

  watch: {
    isRegisted() {
      if (this.isRegisted) {
        axios({
          url: api.comb.comb.read(this.combinationPostId, this.profile.userId),
          method: "get",
        })
          .then((res) => {
            this.imgUrl = res.data.data.imgUrl;
            this.name = res.data.data.combName;
          })
          .catch((err) => {
            console.error(err);
          });
      }
    },
  },

  methods: {
    goRegistForm() {
      //꿀조합 여부 확인

      //리뷰 등록할 꿀조합이 있다면 리뷰 등록 화면으로 이동
      if (this.isRegisted) {
        this.$router.push({
          name: "registreview",
          params: { combinationPostId: parseInt(this.combinationPostId) },
        });
      } else {
        //리뷰 등록할 꿀조합이 없다면 AlertCombi 띄워주기
        this.openAlert = true;
      }
    },
  },

  mounted() {
    axios({
      url: api.comb.comb.exist(this.combination.combinationId),
      method: "get",
    })
      .then((res) => {
        // console.log(res.data)
        console.log(typeof res.data.data);
        if (typeof res.data.data === "number") {
          this.isRegisted = true;
          this.combinationPostId = res.data.data;
        } else {
          this.combi = res.data.data;
        }
      })
      .catch((err) => {
        console.error(err);
      });
  },
};
</script>

<style>
.first {
  width: 40%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.second {
  width: 60%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.imgwrap img {
  display: block;
  height: 100%;
  width: auto;
}
.imgwrap {
  height: 60%;
}
.regist {
  width: 40%;
  margin: auto;
}
</style>
