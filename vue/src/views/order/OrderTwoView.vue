<template>
  <div class="body">
    <div class="top">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1"><h3>메뉴 선택</h3></v-col>
      </v-row>
    </div>
    <menu-list></menu-list>
    <div align="center" class="order_btn">
      <v-btn class="main_btn" width="185" small elevation="0" rounded >주문하기</v-btn>
    </div>
  </div>
</template>

<script>
import MenuList from '@/components/order/MenuList.vue'

// import { mapActions } from 'vuex';

export default {
  name: 'OrderTwoView',

  components: { MenuList },


  methods: {
    // ...mapActions(['fetchMenus']),
   goBack() {
      this.$router.go(-1);
    },
    
    // fetchMenus () {
    //   axios({

    //   })
    // }
  },

  created () {
    // fetchMenus()
  }
}
</script>

<style scoped>
.body {
  width: 100vw;
}
.top {
  margin: 10px;
  position:relative;
  width: 100%;
}
.row {
  width: 100%;
}
.order_btn {
  margin: 20px;
}
</style>