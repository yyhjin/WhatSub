<template>
  <div class="body">
    <alert-order
      :cnt="cnt"
      :totalPrice="totalPrice"
      :selectedStore="JSON.stringify(selectedStore)"
    ></alert-order>
    <div class="top pt-2 pb-2">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-5 mb-2"><h3>메뉴 선택</h3></v-col>
      </v-row>
      <v-card class="currentState">
        <div class="menu">
          <div class="imgwrap">
            <img :src="selectedMenu.imgUrl" alt="" />
          </div>
          <div class="title" style="font-size: 17px !important; font-weight: bold">
            {{ selectedMenu.menuName }}
          </div>
        </div>
        <div class="ingred">
          <div class="in_row">
            <div class="imgwrap">
              <img src="@/assets/bread.png" alt="" />
            </div>
            <div class="in_title">{{ bread_name }}</div>
            <div class="imgwrap">
              <img src="@/assets/cheese.png" alt="" />
            </div>
            <div class="in_title">{{ cheese_name }}</div>
          </div>
          <div class="in_row">
            <div class="imgwrap">
              <img src="@/assets/vege.png" alt="" />
            </div>
            <div class="in_title">{{ vege_name }}</div>
            <div class="imgwrap">
              <img src="@/assets/sauce.png" alt="" />
            </div>
            <div class="in_title">{{ sauce_name }}</div>
          </div>
        </div>

        <div class="addingred">
          <div class="imgwrap plus">
            <img src="@/assets/plus.png" alt="" />
          </div>
          <div class="in_title plus_title">{{ more_name }}</div>
        </div>
        <div class="nutr">
          <div class="kcal">칼로리 : {{ calorie }}</div>
          <div class="protein">단백질 : {{ protein }}</div>
          <div class="fat">지방 : {{ fat }}</div>
        </div>
      </v-card>
    </div>
    <choose-bread></choose-bread>
    <choose-cheese></choose-cheese>
    <choose-more-cheese></choose-more-cheese>
    <choose-vege></choose-vege>
    <choose-more></choose-more>
    <choose-more-meat></choose-more-meat>
    <choose-sauce></choose-sauce>
    <div class="cnt">
      <div style="font-size: 17px; font-weight: bold">수량</div>
      <div class="cnt_input">
        <v-icon slot="append" @click="down"> mdi-minus </v-icon>
        <div class="value">{{ cnt }}</div>
        <v-icon slot="prepend" @click="up"> mdi-plus </v-icon>
      </div>
    </div>
    <div class="bottom">
      <div class="total_price" style="font-size: 17px; font-weight: bold">
        총 {{ totalPrice | comma }}원
      </div>

      <button class="order_btn main_btn" @click.prevent="setBasket">장바구니 담기</button>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import ChooseBread from "../../components/order/ChooseBread.vue";
import ChooseCheese from "../../components/order/ChooseCheese.vue";
import ChooseMore from "../../components/order/ChooseMore.vue";
import ChooseMoreMeat from "../../components/order/ChooseMoreMeat.vue";
import ChooseSauce from "../../components/order/ChooseSauce.vue";
import ChooseVege from "../../components/order/ChooseVege.vue";
import AlertOrder from "@/components/order/AlertOrder";
import ChooseMoreCheese from "../../components/order/ChooseMoreCheese.vue";

export default {
  components: {
    AlertOrder,
    ChooseBread,
    ChooseCheese,
    ChooseVege,
    ChooseMore,
    ChooseMoreMeat,
    ChooseSauce,
    ChooseMoreCheese,
  },
  name: "OrderFourView",
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },

  data() {
    return {
      cnt: 1,
    };
  },

  computed: {
    ...mapGetters([
      "selectedStore",
      "selectedMenu",
      "selectedBread",
      "selectedCheese",
      "selectedSauce",
      "selectedMore",
      "selectedVege",
      "selectedMoreMeat",
      "selectedMoreCheese",
    ]),

    bread_name() {
      if (this.selectedBread === null) {
        return "선택해주세요";
      } else {
        return this.selectedBread.name;
      }
    },
    moreCheese_name() {
      if (this.selectedMoreCheese === null) {
        return "";
      } else {
        return this.selectedCheese.name;
      }
    },

    cheese_name() {
      if (this.selectedCheese === null) {
        return "선택해주세요";
      } else {
        return this.selectedCheese.name;
      }
    },

    sauce_name() {
      if (this.selectedSauce.length === 0) {
        return "선택해주세요";
      } else {
        let sauces = "";
        this.selectedSauce.forEach((sauce) => {
          sauces += sauce.name + ",";
        });
        return sauces;
      }
    },
    vege_name() {
      if (this.selectedVege.length === 0) {
        return "선택해주세요";
      } else {
        let veges = "";
        this.selectedVege.forEach((vege) => {
          veges += vege.name + ",";
        });
        return veges;
      }
    },

    more_name() {
      let mores = "";
      if (this.selectedMore.length === 0 && this.selectedMoreMeat === null) {
        return "선택해주세요";
      } else if (this.selectedMore.length !== 0 && this.selectedMoreMeat !== null) {
        this.selectedMore.forEach((more) => {
          mores += more.name + ",";
        });
        mores += this.selectedMoreMeat.name;
        return mores;
      } else if (this.selectedMore.length !== 0 && this.selectedMoreMeat === null) {
        this.selectedMore.forEach((more) => {
          mores += more.name + ",";
        });
        return mores;
      } else {
        mores += this.selectedMoreMeat.name;
        return mores;
      }
    },

    calorie() {
      let kcal = 0;

      kcal +=
        (this.selectedMenu === null ? 0 : this.selectedMenu.kcal) +
        (this.selectedBread === null ? 0 : this.selectedBread.kcal) +
        (this.selectedCheese === null ? 0 : this.selectedCheese.kcal) +
        (this.selectedMoreMeat === null ? 0 : this.selectedMoreMeat.kcal) +
        (this.selectedMoreCheese === null ? 0 : this.selectedMoreCheese.kcal);
      this.selectedMore.forEach((each) => (kcal += each.kcal));
      this.selectedVege.forEach((each) => (kcal += each.kcal));
      this.selectedSauce.forEach((each) => (kcal += each.kcal));

      return Math.ceil(kcal);
    },

    protein() {
      let protein = 0;

      protein +=
        (this.selectedMenu === null ? 0 : this.selectedMenu.protein) +
        (this.selectedBread === null ? 0 : this.selectedBread.protein) +
        (this.selectedCheese === null ? 0 : this.selectedCheese.protein) +
        (this.selectedMoreMeat === null ? 0 : this.selectedMoreMeat.protein) +
        (this.selectedMoreCheese === null ? 0 : this.selectedMoreCheese.protein);
      this.selectedMore.forEach((each) => (protein += each.protein));
      this.selectedVege.forEach((each) => (protein += each.protein));
      this.selectedSauce.forEach((each) => (protein += each.protein));

      return Math.ceil(protein);
    },

    fat() {
      let fat = 0;

      fat +=
        (this.selectedMenu === null ? 0 : this.selectedMenu.fat) +
        (this.selectedBread === null ? 0 : this.selectedBread.fat) +
        (this.selectedCheese === null ? 0 : this.selectedCheese.fat) +
        (this.selectedMoreMeat === null ? 0 : this.selectedMoreMeat.fat) +
        (this.selectedMoreCheese === null ? 0 : this.selectedMoreCheese.fat);
      this.selectedMore.forEach((each) => (fat += each.fat));
      this.selectedVege.forEach((each) => (fat += each.fat));
      this.selectedSauce.forEach((each) => (fat += each.fat));

      return Math.ceil(fat);
    },

    totalPrice() {
      let price = 0;
      price +=
        (this.selectedMenu === null ? 0 : this.selectedMenu.price) +
        (this.selectedBread === null ? 0 : this.selectedBread.price) +
        (this.selectedCheese === null ? 0 : this.selectedCheese.price) +
        (this.selectedMoreMeat === null ? 0 : this.selectedMoreMeat.price) +
        (this.selectedMoreCheese === null ? 0 : this.selectedMoreCheese.price);
      this.selectedMore.forEach((each) => (price += each.price));
      this.selectedVege.forEach((each) => (price += each.price));
      this.selectedSauce.forEach((each) => (price += each.price));

      return price;
    },
  },
  methods: {
    ...mapActions(["fetchIngredient"]),
    goBack() {
      this.$router.push({ name: "orderthree" });
    },

    up() {
      this.cnt += 1;
    },

    down() {
      if (this.cnt > 0) {
        this.cnt -= 1;
      }
    },

    setBasket() {
      if (this.selectedBread === null || this.selectedBread === undefined) {
        alert("빵을 골라주세요");
      } else {
        if (this.selectedCheese === null || this.selectedCheese === undefined) {
          alert("치즈를 골라주세요");
        } else {
          const modal = document.querySelector(".modal");
          modal.style.display = "block";
          document.body.style.overflow = "hidden";
        }
      }
    },

    setOrder() {
      this.$router.push("/ordercheck");
    },
  },

  mounted() {
    this.fetchIngredient();
  },
};
</script>

<style scoped>
.body {
  /* position: relative; */
  padding-top: 360px;
  padding-bottom: 40px;
  font-size: 15px;
}
.body::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
}
.top {
  top: 0;
  /* position:relative; */
  width: 100%;
  background: white;
}
.row {
  width: 100%;
}
.currentState {
  width: 90%;
  height: 300px;
  margin: auto;
  margin-bottom: 12px;
}
.menu {
  width: 100%;
  height: 80px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.imgwrap img {
  display: block;
  height: 100%;
  width: auto;
}
.imgwrap {
  height: 100%;
}
.ingred {
  width: 100%;
  height: 100px;
}
.in_row {
  height: 30px;
  margin-top: 10px;
  margin-bottom: 10px;
  padding-left: 2px;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.in_title {
  font-size: 12px;
}
.addingred {
  height: 60px;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.plus {
  margin-left: 10px;
}
.plus_title {
  margin: auto;
}
.nutr {
  height: 50px;
  border-top: 1px solid;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
}
.cnt {
  width: 80%;
  height: 80px;
  margin: auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  border-top: 1px solid #a8a8a8;
  padding-bottom: 8px;
}
/* .cnt::before {
  width:100%;
  border-top: 1px solid;
} */
.cnt_input {
  width: 150px;
  height: 35px;
  display: flex;
  flex-direction: row;
  align-items: center;
  border: 1px solid;
  border-radius: 5px;
  justify-content: space-between;
}
.bottom {
  height: 55px;
  position: fixed;
  bottom: 0;
  background: white;
  border-top: 1px solid;
  z-index: 4;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
}
.order_btn {
  width: 150px;
  height: 30px;
  border-radius: 15px;
  font-size: 14px;
}
</style>
