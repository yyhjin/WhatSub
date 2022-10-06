import axios from "axios";
import api from "@/api/api"

export default {
  state: {
    selectedStore: JSON.parse(localStorage.getItem('store')) || null,
    basket: JSON.parse(localStorage.getItem('basket')) || [],
    menus: [],
    breads: [],
    cheese: [],
    moreCheese: [],
    sauce: [],
    more: [],
    veges: [],
    moreMeats: [],
    selectedMoreMeat: JSON.parse(localStorage.getItem('moremeat')) || null,
    selectedMenu: JSON.parse(localStorage.getItem('menu')) || null,
    selectedSize: JSON.parse(localStorage.getItem('size')) || null,
    selectedBread: JSON.parse(localStorage.getItem('bread')) || null,
    
    selectedCheese: JSON.parse(localStorage.getItem('cheese')) || null,
    selectedMoreCheese: JSON.parse(localStorage.getItem('morecheese')) || null,
    selectedSauce: JSON.parse(localStorage.getItem('sauce')) || [],
    selectedMore: JSON.parse(localStorage.getItem('more')) || [],
    selectedVege: JSON.parse(localStorage.getItem('vege')) || [],

  },
  getters: {
    selectedStore: (state) => state.selectedStore,
    basket: (state) => state.basket,
    menus : (state) => state.menus,
    sauce : (state) => state.sauce,
    breads : (state) => state.breads,
    cheese : (state) => state.cheese,
    more : (state) => state.more,
    veges : (state) => state.veges,
    moreMeats : (state) => state.moreMeats,
    moreCheese : (state) => state.moreCheese,

    selectedMenu: (state) => state.selectedMenu,

    selectedSize: (state) => state.selectedSize,

    selectedBread: (state) => state.selectedBread,

    selectedCheese: (state) => state.selectedCheese,

    selectedMoreCheese: (state) => state.selectedMoreCheese,

    selectedSauce: (state) => state.selectedSauce,

    selectedMore: (state) => state.selectedMore,

    selectedVege: (state) => state.selectedVege,

    selectedMoreMeat: (state) => state.selectedMoreMeat,

  },
  mutations: {
    SET_SELECTEDSTORE: (state, value) => (state.selectedStore = value),

    SET_MENUS: (state, value) => (state.menus = value),
    SET_SAUCE : (state, value) => state.sauce = value,
    SET_BREADS : (state, value) => state.breads = value,
    SET_CHEESE : (state, value) => state.cheese = value,
    SET_MORE : (state, value) => state.more = value,
    SET_VEGES : (state, value) => state.veges = value,
    SET_MOREMEATS : (state, value) => state.moreMeats = value,
    SET_MORECHEESE : (state, value) => state.moreCheese = value,
    SET_BASKET: (state, value) => state.basket = value,


    SET_SELECTEDSIZE : (state, value) => state.selectedSize = value,

    SET_SELECTEDBREAD: (state, value) => state.selectedBread = value,

    SET_SELECTEDCHEESE: (state, value) => state.selectedCheese = value,

    SET_SELECTEDMORECHEESE: (state, value) => state.selectedMoreCheese = value,
    
    SET_SELECTEDSAUCE: (state, value) => {
      state.selectedSauce.push(value)
      localStorage.setItem('sauce', JSON.stringify(state.selectedSauce))
    },

    REMOVE_SELECTEDSAUCE: (state, value) => {
      state.selectedSauce = state.selectedSauce.filter(sauce => 
         sauce.ingredientId !== value.ingredientId 
      )
      localStorage.setItem('sauce', JSON.stringify(state.selectedSauce))
    },
    
    SET_SELECTEDMORE: (state, value) => {
      state.selectedMore.push(value)
      localStorage.setItem('more', JSON.stringify(state.selectedMore))
    },

    REMOVE_SELECTEDMORE: (state, value) => {
      state.selectedMore = state.selectedMore.filter(more => 
         more.ingredientId !== value.ingredientId 
      )
      localStorage.setItem('more', JSON.stringify(state.selectedMore))
    },
    
    SET_SELECTEDVEGE: (state, value) => {
      state.selectedVege.push(value)
      localStorage.setItem('vege', JSON.stringify(state.selectedVege))
    },
    
    REMOVE_SELECTEDVEGE: (state, value) => {
      state.selectedVege = state.selectedVege.filter(vege => 
         vege.ingredientId !== value.ingredientId 
      )
      localStorage.setItem('vege', JSON.stringify(state.selectedVege))
    },

    COMBINE_SELECTEDMORE: (state, value) => state.selectedMore = state.selectedMore + value,

    SET_SELECTEDMOREMEAT: (state, value) => state.selectedMoreMeat = value,
    
    SET_SELECTEDMENU: (state, value) => (state.selectedMenu = value),

    UP_CNT: (state, value) => (state.basket[value].cnt += 1),

    DOWN_CNT: (state, value) => {
      if (state.basket[value].cnt > 0){
        (state.basket[value].cnt -= 1)
      }
    },

    RESET_MORE: (state) => state.selectedMore = [],
    RESET_VEGE: (state) => state.selectedVege = [],
    RESET_SAUCE: (state) => state.selectedSauce = [],
    RESET_STORE: (state) => state.selectedStore = null,
    RESET_BASKET: (state) => state.basket = null,
  },
  actions: {
    fetchMenus ({commit}) {
      axios({
        url: api.order.order.menu(),
        method: 'get',
        // headers:getters.authHeader
      }).then(res => {
        commit('SET_MENUS', res.data.data)
      }).catch(err => {
        console.error(err)
      })
    },

    fetchIngredient ({ commit }) {
      axios({
        url: api.order.order.ingredient(),
        method: 'get',
        // headers:getters.authHeader
      }).then(res => {
        const data = res.data.data
        let breads= []
        let cheese= []
        let sauce= []
        let more= []
        let veges= []
        let moreMeats= []
        let moreCheese = []

        data.forEach(each => {
          switch (each.category){
          case "빵": 
            breads.push(each)
            break;
          case "치즈추가":  
            moreCheese.push(each)
            break;
          case "치즈":
            cheese.push(each)
            break;
          case "야채":
            veges.push(each)
            break;
          case "소스":
            sauce.push(each)
            break;
          case "추가":
            more.push(each)
            break;
          case "미트추가":
            moreMeats.push(each)
            break;
          }
        })
        commit('SET_SAUCE', sauce)
        commit('SET_BREADS', breads)
        commit('SET_CHEESE', cheese)
        commit('SET_MORE', more)
        commit('SET_VEGES', veges)
        commit('SET_MOREMEATS', moreMeats)
        commit('SET_MORECHEESE', moreCheese)
      }).catch(err => {
        console.error(err)
      })
    },

    fetchBasket({ commit }) {
      const value = JSON.parse(localStorage.getItem('basket'))
      commit('SET_BASKET', value)
    },

    selectStore({ commit }, value) {
      commit("SET_SELECTEDSTORE", value);
      localStorage.setItem('store', JSON.stringify(value))
    },

    selectMenu({ commit }, value) {
      commit("SET_SELECTEDMENU", value);
      localStorage.setItem('menu', JSON.stringify(value))
    },

    selectSize({ commit }, value) {
      commit('SET_SELECTEDSIZE', value)
      localStorage.setItem('size', JSON.stringify(value))
    },

    selectBread({ commit }, value) {
      commit('SET_SELECTEDBREAD', value)
      localStorage.setItem('bread', JSON.stringify(value))
    },

    selectCheese({ commit }, value) {
      commit('SET_SELECTEDCHEESE', value)
      localStorage.setItem('cheese', JSON.stringify(value))
    },

    selectMoreCheese({ commit }, value) {
      commit('SET_SELECTEDMORECHEESE', value)
      localStorage.setItem('morecheese', JSON.stringify(value))
    },

    selectVege({ commit }, value) {
      commit('SET_SELECTEDVEGE', value)
      
    },

    removeVege({ commit }, value) {
      commit('REMOVE_SELECTEDVEGE', value)
    },

    selectMore({ commit }, value) {
      commit('SET_SELECTEDMORE', value)
      
    },

    removeMore({ commit }, value) {
      commit('REMOVE_SELECTEDMORE', value)
    },

    selectMoreMeat({ commit }, value) {
      commit('SET_SELECTEDMOREMEAT', value)
      localStorage.setItem('moremeat', JSON.stringify(value))
    },

    selectSauce({ commit }, value) {
      commit('SET_SELECTEDSAUCE', value)
    },

    removeSauce({ commit }, value) {
      commit('REMOVE_SELECTEDSAUCE', value)
    },

    up ({ commit }, index) {
      commit('UP_CNT', index)
    },

    down ({ commit }, index) {
      commit('DOWN_CNT', index)   
    },

    resetMore ({ commit }) {
      commit('RESET_MORE')
    },

    resetVege ({ commit }) {
      commit('RESET_VEGE')
    },

    resetSauce ({ commit }) {
      commit('RESET_SAUCE')
    },

    resetStore ({ commit }) {
      commit('RESET_STORE')
    },

    resetBasket ({ commit }) {
      commit('RESET_BASKET')
    },

    // letCheck() {
    //   console.log('!!!!!!!!')
    // }
  },
};
