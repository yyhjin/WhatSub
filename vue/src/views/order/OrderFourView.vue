<template>
  <div class="body"> 
    <div class="top">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1"><h3>메뉴 선택</h3></v-col>
      </v-row>
      <v-card class="currentState">
        <div class="menu">
          <div class="imgwrap">
            <img :src="selectedMenu.img_url" alt="">
          </div>
          <div class="title">{{ selectedMenu.menu_name }}</div>
        </div>
        <div class="ingred">
          <div class="in_row">
            <div class="imgwrap">
              <img src="@/assets/bread.png" alt="">
            </div>
            <div class="in_title">{{ selectedMenu.menu_name }}</div>
            <div class="imgwrap">
              <img src="@/assets/cheese.png" alt="">
            </div>
            <div class="in_title">{{ selectedMenu.menu_name }}</div>
          </div>
          <div class="in_row">
            <div class="imgwrap">
              <img src="@/assets/vege.png" alt="">
            </div>
            <div class="in_title">{{ selectedMenu.menu_name }}</div>
            <div class="imgwrap">
              <img src="@/assets/sauce.png" alt="">
            </div>
            <div class="in_title">{{ selectedMenu.menu_name }}</div>
          </div>
        </div>

        <div class="addingred">
          <div class="imgwrap plus">
              <img src="@/assets/plus.png" alt="">
            </div>
            <div class="in_title plus_title">{{ selectedMenu.menu_name }}</div>
        </div>
        <div class="nutr">
          <div class="kcal">
            칼로리 : {{ }}
          </div>
          <div class="protein">
            단백질 : {{ }}
          </div>
          <div class="fat">
            지방 : {{ }}
          </div>
        </div>
      </v-card>
    </div>
    <choose-bread></choose-bread>
    <choose-cheese></choose-cheese>
    <choose-vege></choose-vege>
    <choose-more></choose-more>
    <choose-more-meat></choose-more-meat>
    <choose-sauce></choose-sauce>
    <div class="cnt">
      <div>수량</div>
      <div class="cnt_input">
        <v-icon
          slot="append"
        >
          mdi-minus
        </v-icon>
        <div class="value">1</div>
        <v-icon
          slot="prepend"
        >
          mdi-plus
        </v-icon>
      </div>
    </div>
    <div class="bottom">
      <div class="total_price">
        총 계산된 금액
      </div>
      
      <button class="order_btn main_btn">
        장바구니
      </button>
      <button class="order_btn green_btn">
        바로 주문
      </button>
      
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import ChooseBread from '../../components/order/ChooseBread.vue';
import ChooseCheese from '../../components/order/ChooseCheese.vue';
import ChooseMore from '../../components/order/ChooseMore.vue';
import ChooseMoreMeat from '../../components/order/ChooseMoreMeat.vue';
import ChooseSauce from '../../components/order/ChooseSauce.vue';
import ChooseVege from '../../components/order/ChooseVege.vue';

export default {
  components: { ChooseBread, ChooseCheese, ChooseVege, ChooseMore, ChooseMoreMeat, ChooseSauce },
  name: 'OrderFourView',

  computed: {
    ...mapGetters(['selectedMenu', 'selectedBread', 'selectedCheese', 
    'selectedSauce', 'selectedMore', 'selectedVege'])
  },

  methods: {
    goBack() {
      this.$router.go(-1);
    },
  }
}
</script>

<style scoped>
.body {
  padding-top: 360px;
  padding-bottom: 40px;
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
  margin-bottom: 10px;
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
  display:block;
	height:100%;
	width:auto;
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
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
.in_title {
  font-size: 10px;
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
.nutr{
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
  border-top: 1px solid;
}
/* .cnt::before {
  width:100%;
  border-top: 1px solid;
} */
.cnt_input {
  width: 150px;
  height: 40px;
  display: flex;
  flex-direction: row;
  align-items: center;
  border: 1px solid;
  border-radius: 5px;
  justify-content: space-between;
}
.bottom {
  height: 40px;
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
  width: 115px;
  height: 30px;
  border-radius: 15px;
}
</style>