<template>
  <div>
    <div class="bill">
      <div class="orderBox">
        <div class="menuCheck">
          <div class="name pt-2" style="font-weight: bold">
            {{ bas.menu.menuName }}
          </div>
          <div>
            <v-row align="center" style="font-size: 13px">
              <v-col class="pa-0 pl-4 ml-n2" cols="5" align="center">
                <v-img class="shadow_img" :src="bas.menu.imgUrl" width="110"></v-img>
              </v-col>
              <v-col cols="7" class="pa-0 pt-5 ml-n2" align="left">
                <div>빵: {{ bas.bread.name }} {{ bas.size }}cm</div>
                <div>치즈: {{ bas.cheese.name }}</div>
                <div>소스: {{ sauce }}</div>
                <div>야채: {{ vege }}</div>
                <div>추가: {{ more }}</div>
              </v-col>
            </v-row>
            <br />
            <v-divider color="#d9d9d9"></v-divider>
            <v-row class="pa-3" align="center">
              <v-col class="pa-0">
                <div class="cnt">
                  <div class="cnt_input">
                    <v-icon slot="append" @click="down(index)"> mdi-minus </v-icon>
                    <div class="value">{{ cnt }}</div>
                    <v-icon slot="prepend" @click="up(index)"> mdi-plus </v-icon>
                  </div>
                </div>
              </v-col>
              <v-col class="pa-0 ml-n5 pt-3 pb-2" cols="4" align="center"
                >수량:{{ bas.cnt }}개
              </v-col>
              <v-col class="pa-0 pt-3 pb-2" align="center"
                >{{ (bas.price * bas.cnt) | comma }}원</v-col
              >
            </v-row>
          </div>
        </div>
      </div>
    </div>
    <br />
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "OrderBasket",

  props: {
    bas: Object,
    index: Number,
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  computed: {
    vege() {
      let vege = "";
      this.bas.vege.forEach((v) => (vege += v.name + ","));
      vege = vege.slice(0, -1);
      return vege;
    },
    sauce() {
      let sauce = "";
      this.bas.sauce.forEach((v) => (sauce += v.name + ","));
      sauce = sauce.slice(0, -1);
      return sauce;
    },
    more() {
      let more = "";
      this.bas.more.forEach((v) => (more += v.name + ","));
      try {
        more += this.bas.moremeat.name;
      } catch (err) {
        console.log(err);
      }
      return more;
    },
    cnt() {
      return this.bas.cnt;
    },
  },

  methods: {
    ...mapActions(["up", "down"]),
  },
};
</script>

<style scoped>
.bill {
  width: 90%;
  border: 1px solid;
  margin: auto;
  /* margin-bottom: 10px; */
}
.menuCheck {
  border-bottom: 1px solid;
}
.orderBox {
  width: 100%;
  margin: auto;
  background-color: white;
}
.cntPrice {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.content {
  width: 90%;
  display: flex;
  flex-direction: column;
  margin: auto;
}
.cnt {
  width: 80%;
  margin: auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.cnt_input {
  margin-left: auto;
  width: 90px;
  height: 24px;
  display: flex;
  flex-direction: row;
  align-items: center;
  border: 1px solid;
  border-radius: 15px;
  justify-content: space-between;
  font-size: 13px;
}
</style>
