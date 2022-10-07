import Vue from 'vue'
import VueRouter from 'vue-router'
// import { dispatch } from 'vuex'
import store from '@/store';
import swal from 'sweetalert';

//home
import HomeView from "@/views/home/HomeView.vue";
import RecommendNutritionResultView from "@/views/home/RecommendNutritionResultView.vue";
import RecommendNutritionView from "@/views/home/RecommendNutritionView.vue";
import RecommendTodayView from "@/views/home/RecommendTodayView.vue";

//navbar
import OrderBasketView from "@/views/navbar/OrderBasketView.vue";
import OrderDetailView from "@/views/navbar/OrderDetailView.vue";
import RegistCombinationView from "@/views/navbar/RegistCombinationView.vue";
import RegistReviewView from "@/views/navbar/RegistReviewView.vue";
import ZzimView from '@/views/navbar/ZzimView.vue';

//login
import LoginView from "@/views/login/LoginView.vue";
import SignupView from "@/views/login/SignupView.vue";
import SurveyBasicView from "@/views/login/SurveyBasicView.vue";
import SurveySubtiView from "@/views/login/SurveySubtiView.vue";

//rank
import RankView from "@/views/rank/RankView.vue";

//combination
import CombinationView from "@/views/combination/CombinationView.vue";
import CombinationDetailView from "@/views/combination/CombinationDetailView.vue";

//order
import OrderOneView from "@/views/order/OrderOneView.vue";
import OrderTwoView from "@/views/order/OrderTwoView.vue";
import OrderThreeView from "@/views/order/OrderThreeView.vue";
import OrderFourView from "@/views/order/OrderFourView.vue";
import OrderCheckView from "@/views/order/OrderCheckView.vue";
import StoreInfoView from "@/views/order/StoreInfoView.vue";

//profile
import MyPageView from "@/views/profile/MyPageView.vue";

Vue.use(VueRouter)


const routes = [
  //home
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/recommendnutritionresult",
    name: "recommendnutritionresult",
    component: RecommendNutritionResultView,
  },
  {
    path: "/recommendnutrition",
    name: "recommendnutrition",
    component: RecommendNutritionView
  },
  {
    path: "/recommendtoday",
    name: "recommendtoday",
    component: RecommendTodayView,
  },

  //navbar
  {
    path: "/orderbasket",
    name: "orderbasket",
    component: OrderBasketView,
  },
  {
    path: "/orderdetail",
    name: "orderdetail",
    component: OrderDetailView,
    props: true,
  },
  {
    path: "/registcombination",
    name: "registcombination",
    component: RegistCombinationView,
    props: true,
  },
  {
    path: "/registreview/:combinationPostId",
    name: "registreview",
    component: RegistReviewView,
    props: true,
  },
  {
    path: "/zzim",
    name: "zzim",
    component: ZzimView,
  },

  //login
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  {
    path: "/signup",
    name: "signup",
    component: SignupView,
  },
  {
    path: "/surveybasic",
    name: "surveybasic",
    component: SurveyBasicView,
  },
  {
    path: "/surveysubti",
    name: "surveysubti",
    component: SurveySubtiView,
  },

  //rank
  {
    path: "/rank",
    name: "rank",
    component: RankView,
  },

  //combination
  {
    path: "/combination",
    name: "combination",
    component: CombinationView,
    props: true,
  },
  {
    path: "/combinationdetail/:combinationPostId",
    name: "combinationdetail",
    component: CombinationDetailView,
    props: true,
  },

  //order
  {
    path: "/ordercheck/:orderId",
    name: "ordercheck",
    component: OrderCheckView,
    props: true
  },
  {
    path: "/orderone",
    name: "orderone",
    component: OrderOneView,
    props: true,
    beforeEnter: function(to, from, next) {
      console.log(from.name)
      console.log(to.name)
      next()
      if (from.name !== 'ordertwo' && from.name !== 'orderthree' && from.name !== 'orderfour' && from.name !== 'orderdetail') {
        console.log(1)
        localStorage.setItem('menu', null)
        localStorage.setItem('size', null)
        localStorage.setItem('vege', null)
        localStorage.setItem('more', null)
        localStorage.setItem('sauce', null)
        localStorage.setItem('bread', null)
        localStorage.setItem('cheese', null)
        localStorage.setItem('moremeat', null)
        localStorage.setItem('morecheese', null)
        localStorage.setItem('store', null)
    
        store.dispatch('selectMenu', null)
        store.dispatch('selectSize', null)
        store.dispatch('selectBread', null)
        store.dispatch('selectCheese', null)
        store.dispatch('selectMoreCheese', null)
        store.dispatch('resetMore')
        store.dispatch('resetVege')
        store.dispatch('resetSauce')
        store.dispatch('selectMoreMeat', null)
        store.dispatch('resetStore', null)
        // store.dispatch('letCheck')
        
      } 
    }
  },
  {
    path: "/ordertwo",
    name: "ordertwo",
    component: OrderTwoView,
    beforeEnter: function(to, from, next) {
      if (from.name === 'orderone' || from.name === 'orderthree'|| from.name === 'orderfour') {
        next()
      } else {
        next({name:'orderone'})
      }
    }
  },
  {
    path: "/orderthree",
    name: "orderthree",
    component: OrderThreeView,
    beforeEnter: function(to, from, next) {
      if (from.name === 'orderone' || from.name === 'ordertwo'|| from.name === 'orderfour') {
        next()
      } else {
        next({name:'orderone'})
      }
    }
  },
  {
    path: "/orderfour",
    name: "orderfour",
    component: OrderFourView,
    beforeEnter: function(to, from, next) {
      if (from.name === 'orderone' || from.name === 'ordertwo'|| from.name === 'orderthree') {
        next()
      } else {
        next({name:'orderone'})
      }
    }
  },
  {
    path: "/storeinfo",
    name: "storeinfo",
    component: StoreInfoView,
  },
  
  //profile
  {
    path: "/mypage/:userName",
    name: "mypage",
    component: MyPageView,
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


router.beforeEach((to, from, next) => {
  // 이전 페이지에서 발생한 에러메시지 삭제
  
  const { isLoggedIn } = store.getters

  const noAuthPages = ['login', 'signup']

  const isAuthRequired = !noAuthPages.includes(to.name)

  if (isAuthRequired && !isLoggedIn) {
    swal({
      title: '로그인 필요!',
      text: '로그인해주세요',
      icon: 'error'
    })
    next({ name: 'login' })
  } else {
    next()
  }

  if (!isAuthRequired && isLoggedIn) {
    next({ name: 'home' })
  }
})

export default router
