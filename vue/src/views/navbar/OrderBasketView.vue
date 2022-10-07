<template>
  <div class="body">
    <div class="top">
      <v-btn icon class="backbtn pl-3" @click="goHome"><v-icon>mdi-home-outline</v-icon></v-btn>
      <h4 style="font-size: 18px">장바구니</h4>
    </div>
    <div v-if="basket">
      <div class="store">서브웨이 {{ store.branchName }}점</div>
      <div class="orderCheck">
        <order-basket
          :bas="bas"
          :index="index"
          v-for="(bas, index) in basket"
          :key="index"
        ></order-basket>
        <br />
        <br />
        <br />
      </div>
    </div>
    <div v-else>
      <h2 style="text-align: center; margin-top: 240px">장바구니가 비었습니다 ~</h2>
      <h3 class="mt-2" style="text-align: center">
        <v-btn class="grey_btn" color="grey lighten-1" rounded small @click="goOrder"
          >샌드위치 담으러 GO?</v-btn
        >
      </h3>
    </div>
    <div class="bottom">
      <div class="bot">
        <div class="total_price">
          <h4>총 {{ totalPrice | comma }}원&nbsp;&nbsp;&nbsp;&nbsp;</h4>
        </div>
        <button class="order_btn green_btn" @click.prevent="setOrder">주문하기</button>
      </div>
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import api from "@/api/api";
import { mapActions, mapGetters } from "vuex";
// import OrderDetail from '../../components/common/OrderDetail.vue'
import OrderBasket from "../../components/order/OrderBasket.vue";
import BottomNav from "../../components/common/BottomNav.vue";
export default {
  name: "OrderBasketView",

  components: { OrderBasket, BottomNav },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },

  computed: {
    ...mapGetters(["basket", "selectedStore", "profile"]),

    totalPrice() {
      let price = 0;
      if (this.basket) {
        this.basket.forEach((bas) => (price += bas.price * bas.cnt));
      }
      return price;
    },

    store() {
      return this.selectedStore;
    },
  },

  methods: {
    ...mapActions(["fetchBasket", "resetBasket", "resetStore", "fetchProfile"]),
    goHome() {
      this.$router.push({
        name: "home",
      });
    },
    setOrder() {
      let combinationList = [];
      this.basket.forEach((bas) => {
        const count = bas.cnt;
        const price = bas.price;
        let combinationId = "";
        let comList = [];
        let fat = 0;
        let kcal = 0;
        let protein = 0;
        let sodium = 0;
        let sugar = 0;
        let mId = "";

        for (let value in bas) {
          if (value !== "store") {
            // console.log(typeof(bas[value]))
            // console.log(Array.isArray(bas[value]))
            if (typeof bas[value] === "object" && bas[value] !== null) {
              // console.log(bas[value])
              if (Array.isArray(bas[value])) {
                bas[value].forEach((each) => {
                  // console.log(bas[value])
                  // combinationId += each.ingredientId
                  comList.push(each.ingredientId);
                  // console.log(typeof(each.fat))
                  fat += each.fat;
                  kcal += each.kcal;
                  protein += each.protein;
                  sodium += each.sodium;
                  sugar += each.sugar;
                });
              } else {
                if (value === "menu") {
                  // console.log(bas[value].fat)
                  mId += bas[value].menuId;
                  fat += bas[value].fat;
                  kcal += bas[value].kcal;
                  protein += bas[value].protein;
                  sodium += bas[value].sodium;
                  sugar += bas[value].sugar;
                } else {
                  // console.log(bas[value])
                  // console.log(typeof(bas[value].fat))
                  // combinationId += bas[value].ingredientId
                  comList.push(bas[value].ingredientId);
                  fat += bas[value].fat;
                  kcal += bas[value].kcal;
                  protein += bas[value].protein;
                  sodium += bas[value].sodium;
                  sugar += bas[value].sugar;
                }
              }
            }
          }
        }

        let new_comList = comList.sort();
        // console.log(new_comList)
        combinationId = mId + combinationId;
        for (let i = 0; i < new_comList.length; i++) {
          combinationId += new_comList[i];
        }
        // console.log(combinationId)
        fat = Math.ceil(fat);
        kcal = Math.ceil(kcal);
        protein = Math.ceil(protein);
        sodium = Math.ceil(sodium);
        sugar = Math.ceil(sugar);
        combinationList.push({
          combinationId: combinationId,
          count: count,
          fat: fat,
          kcal: kcal,
          price: price,
          protein: protein,
          sodium: sodium,
          sugar: sugar,
        });
      });
      const data = {
        branchId: this.store.branchId,
        combinationList: combinationList,
        orderPrice: this.totalPrice,
        userId: this.profile.userId,
      };
      console.log(data);
      axios({
        url: api.order.order.makeorder(),
        method: "post",
        data: data,
        // headers:getters.authHeader
      })
        .then((res) => {
          localStorage.setItem("store", null);
          localStorage.setItem("basket", null);
          // this.resetBasket()
          this.resetStore();
          this.$router.push({ name: "ordercheck", params: { orderId: res.data.data.orderId } }); // 요청 성공하면 주소 옮기는게 나을수도
        })
        .catch((err) => {
          console.error("makeorder 에러", err);
        });
      // .then((res) => {
      //   console.log(res);
      //   console.log(combinationList);
      //   this.$router.push({ name: "ordercheck", params: { orderId: res.data.data.orderId } }); // 요청 성공하면 주소 옮기는게 나을수도
      // })
      // .catch((err) => {
      //   console.error(err);
      //   console.log(combinationList);
      // });
    },
    goOrder() {
      this.$router.push({
        name: "orderone",
      });
    },
  },

  mounted() {
    this.fetchProfile();
    this.fetchBasket();
    localStorage.removeItem(
      "menu",
      "more",
      "vege",
      "bread",
      "sauce",
      "size",
      "moremeat",
      "cheese",
      "morecheese"
    );
    console.log(this.basket);
  },
};
</script>

<style scoped>
.body {
  padding-top: 50px;
  padding-bottom: 40px;
}
.top {
  background-color: white;
  position: fixed;
  top: 0;
  left: 0;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.store {
  height: 60px;
  width: 100%;
  background-color: #f5f5f5;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 17px;
}
.orderCheck {
  width: 100%;
  /* height: 300px; */
  overflow: scroll;
  background-color: #f5f5f5;
  text-align: center;
}
.top::after {
  content: "";
  position: relative;
}
.backbtn {
  position: absolute;
  left: 0;
}
.bot {
  display: flex;
  margin-top: 15px;
  justify-content: space-evenly;
  align-items: center;
  margin-top: -60px;
}
.bottom {
  height: 120px;
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
  width: 200px;
  height: 30px;
  border-radius: 15px;
}
</style>
