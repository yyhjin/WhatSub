<template>
  <div class="modal">
    <div class="alert">
      <div class="comment" style="font-weight: bold">
        <p class="pt-5">장바구니에 담았습니다.</p>
        <p class="mt-n3">메뉴를 추가로 더 담으시겠습니까?</p>
      </div>
      <button
        class="order_btn main_btn"
        style="font-size: 14px !important"
        @click.prevent="goFirst"
      >
        예, 더 담을게요
      </button>
      <button
        class="order_btn green_btn"
        style="font-size: 14px !important"
        @click.prevent="goBasket"
      >
        장바구니로 이동
      </button>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "AlertOrder",

  props: {
    cnt: Number,
    totalPrice: Number,
    selectedStore: String,
  },

  computed: {
    ...mapGetters([
      "selectedMenu",
      "selectedSize",
      "selectedBread",
      "selectedCheese",
      "selectedMoreCheese",
      "selectedMore",
      "selectedVege",
      "selectedSauce",
      "selectedMoreMeat",
    ]),
    store() {
      return JSON.parse(this.selectedStore);
    },
  },

  methods: {
    ...mapActions([
      "selectMenu",
      "selectSize",
      "selectBread",
      "selectCheese",
      "selectMoreCheese",
      "resetMore",
      "resetVege",
      "resetSauce",
      "selectMoreMeat",
    ]),
    goBasket() {
      this.setBasket();
      this.reset();
      this.$router.push("/orderbasket");
    },

    goFirst() {
      this.setBasket();
      this.reset();
      this.$router.replace("/ordertwo");
    },

    setBasket() {
      const bas = JSON.parse(localStorage.getItem("basket")) || [];
      let order = {
        store: this.store,
        menu: this.selectedMenu,
        size: this.selectedSize,
        vege: this.selectedVege,
        more: this.selectedMore,
        sauce: this.selectedSauce,
        moremeat: this.selectedMoreMeat,
        bread: this.selectedBread,
        cheese: this.selectedCheese,
        cnt: this.cnt,
        price: this.totalPrice,
      };

      bas.push(order);
      localStorage.setItem("basket", JSON.stringify(bas));
    },

    reset() {
      localStorage.setItem("menu", null);
      localStorage.setItem("size", null);
      localStorage.setItem("vege", null);
      localStorage.setItem("more", null);
      localStorage.setItem("sauce", null);
      localStorage.setItem("bread", null);
      localStorage.setItem("cheese", null);
      localStorage.setItem("moremeat", null);
      localStorage.setItem("morecheese", null);

      this.selectMenu(null);
      this.selectSize(null);
      this.selectBread(null);
      this.selectCheese(null);
      this.selectMoreCheese(null);
      this.resetMore();
      this.resetVege();
      this.resetSauce();
      this.selectMoreMeat(null);
    },

    // unmounted () {
    //   this.reset()
    // }
  },
};
</script>

<style scoped>
.alert {
  position: relative;
  top: 250px;
  margin: auto;
  text-align: center;
  height: 220px;
  width: 320px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 3px solid #f4c41f;
  border-radius: 10px;
  background-color: white;
  /* display: none; */
}
.modal {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 1500;
  display: none;
}

.order_btn {
  margin: 5px;
  width: 150px;
  height: 30px;
  border-radius: 15px;
}
</style>
