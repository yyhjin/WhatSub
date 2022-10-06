<template>
  <div >
    <v-app-bar color="white" elevation="0">
      <router-link :to="{ name: 'home' }">
        <img class="navbar__logo" src="@/assets/logo_nav.png" alt="logo" />
      </router-link>
      <v-spacer></v-spacer>

      <v-btn icon @click="goBasket">
        <v-icon color="grey darken-1">mdi-cart-outline</v-icon>
      </v-btn>
      <v-btn icon @click="showMore">
        <v-icon>mdi-account-circle-outline</v-icon>
      </v-btn>
    </v-app-bar>
    <div class="moreBtn">
      <div class="id">
        ssafy07
      </div>
      <div @click="goOrderDetail">
        최근 주문 내역
      </div>
      <div @click="goZzim">
        꿀조합 찜 목록
      </div>
      <div @click="goSub">
        썹bti 재검사
      </div>
      <div class="logout" @click="logout">
        로그아웃
      </div>
    </div>
    
  </div>
</template>

<script>
import router from '@/router'
import { mapActions } from 'vuex';
export default {
  name: "TopNav",

  data() {
    return {
      check: true,
    };
  },

  methods: {
    ...mapActions(['removeToken']),
    goBasket() {
      this.$router.push("/orderbasket");
    },

    showMore() {
      const sideNav = document.querySelector(".moreBtn");
      if (this.check) {
        sideNav.classList.add("active");
        this.check = !this.check;
      } else {
        sideNav.classList.remove("active");
        this.check = !this.check;
      }
    },

    goOrderDetail() {
      this.$router.push({ name: "orderdetail"})
    },
    goZzim () {
      this.$router.push({ name: "zzim"})
    },
    goSub () {
      this.$router.push({ name: "surveysubti"})
    },
    logout() {
      this.removeToken()
      alert('로그아웃 성공!')
      router.push({name:'login'})
    }
  }
};
</script>

<style>
/* .top {
  position: fixed;
  width: 100%;
  z-index: 4;
} */
.moreBtn {
  width: 150px;
  height: 200px;
  border: 1px solid #239347;
  background-color: white;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  position: fixed;
  top: 56px;
  right: 0;
  opacity: 0;
  visibility: hidden;
}
.active {
  opacity: 1;
  animation: more 1s;
  z-index: 3;
  visibility: visible;
}
@keyframes more {
  0% {
    opacity: 0;
    right: -150px;
    
  }
  100% {
    right: 0px;
    opacity: 1;
  }
}
.id {
  width: 100%;
  border-bottom: 1px solid;
  display: flex;
  align-items: center;
}
.logout {
  width: 100%;
  border-top: 1px solid;
  display: flex;
  align-items: center;
  justify-content: center;
}
/* .class {
  margin: 0;
}
a {
  text-decoration: none;
  color: black;
}

.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  padding: 8px 12px;
} */
.navbar__logo {
  margin-top: 3px;
  height: 25px;
}
.navbar-active {
  color: black !important;
}
</style>
