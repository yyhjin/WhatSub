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
      <v-btn class="main_btn" width="185" small elevation="0" rounded @click="goNext">주문하기</v-btn>
    </div>
  </div>
</template>

<script>
import MenuList from '@/components/order/MenuList.vue'
import { mapGetters } from 'vuex';

import { mapActions } from 'vuex';

export default {
  name: 'OrderTwoView',

  components: { MenuList },

  computed: {
    ...mapGetters(['selectedMenu'])
  },

  methods: {
    ...mapActions(['fetchMenus']),
   goBack() {
      this.$router.go(-1);
    },
    
    goNext () {
      if (this.selectedMenu === null || this.selectedMenu === undefined) {
        alert("메뉴를 선택해주세요")
      } else {
        this.$router.push({path:'orderthree'})
      }
    },

  },


  mounted () {
    this.fetchMenus()
  },
  created () {
    // this.fetchMenus()
  }
}
</script>

<style scoped>
.body {
  width: 100vw;
  padding-top: 36px;
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
.order_btn {
  margin: 20px;
}
.select {
  border: 2px solid #239347;
}
</style>