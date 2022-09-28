<template>
  <div>
    <div class="top">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1"><h3>메뉴 선택</h3></v-col>
      </v-row>
    </div>
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
    <choose-bread></choose-bread>
    <choose-cheese></choose-cheese>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import ChooseBread from '../../components/order/ChooseBread.vue';
import ChooseCheese from '../../components/order/ChooseCheese.vue';

export default {
  components: { ChooseBread, ChooseCheese },
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
.top {
  margin-top: 10px;
  margin-bottom: 10px;
  position:relative;
  width: 100%;
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

</style>