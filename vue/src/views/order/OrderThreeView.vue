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
    <div class="content">
      <v-card class="home_card_b box_btn size30" elevation="3"  outlined @click="changeSize($event, '30')">30cm</v-card>
      <v-card class="home_card_b box_btn size15" elevation="3"  outlined @click="changeSize($event, '15')">15cm</v-card>
    </div>
    <div align="center" class="order_btn">
      <v-btn class="main_btn" width="185" small elevation="0" rounded @click="goNext">다음</v-btn>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import BottomNav from '@/components/common/BottomNav.vue'
import { mapActions, mapGetters } from 'vuex';
export default {
  name: 'OrderThreeView',

  components: {BottomNav},

  computed: {
    ...mapGetters(['selectedSize'])
  },

  methods: {
    ...mapActions(['selectSize']),

    goBack() {
      this.$router.push({name:'ordertwo'});
    },

    changeSize (event, value) {
      if (this.selectedSize === value) {
        event.target.classList.remove('select')
        this.selectSize()
        } else {
        this.removeSelect()
        event.target.classList.add('select')
        this.selectSize(value)
      }
    },
    removeSelect () {
      document.querySelectorAll(".box_btn").forEach(select =>{
        select.classList.remove('select')
      })
    },

    goNext () {
      if (this.selectedSize === null || this.selectedSize === undefined) {
        alert("길이를 선택해주세요")
      } else {
        this.$router.push({path:'orderfour'})
      }
    }
  },

  mounted () {
    if (this.selectedSize === "15") {
      document.querySelector(".size15").classList.add('select')
    } else if (this.selectedSize === "30") {
      document.querySelector(".size30").classList.add('select')
    }
  }
}
</script>

<style scoped>
.body {
  height: 100vh;
  width: 100vw;
}
.top {
  margin-top: 10px;
  margin-bottom: 10px;
  position:relative;
  width: 100%;
}
.row {
  width: 100%;
}
.order_btn {
  margin: 20px;
}
.content {
  display: flex;
  flex-direction: row;
  height: 70%;
  width: 100%;
  justify-content: space-evenly;
  align-items: center;

}
.box_btn {
  width: 140px;
  height: 100px;
  border-radius: 4px;
  display: flex;
  align-items: center;
  justify-content: center;
  
}
.bottom {
  position: fixed;
  width: 100vw;
  bottom: 0;
}
.select {
  border: 2px solid #239347;
}
</style>