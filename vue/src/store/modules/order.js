// import axios from "axios";

export default {
  state: {
    selectedStore: null,
    menus: [
      {
        menu_id : 1,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 2,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 3,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 4,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 5,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 6,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 7,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
    ],
    veges: [
      {
        menu_id : 8,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 9,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },
      {
        menu_id : 10,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
        kcal : 100.5,
        protein : 30.2,
        fat : 3.5
      },    
    ],
    breads: [
      {
        ingredient_id: 1,
        name: '허니오트',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 2,
        name: '하티',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 3,
        name: '위트',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 4,
        name: '파마산 오레가노',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 5,
        name: '화이트',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 6,
        name: '플렛 브래드',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
    ],
    cheese: [
      {
        ingredient_id: 7,
        name: '아메리칸 치즈',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 8,
        name: '슈레드 치즈',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '모짜렐라 치즈',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      }
    ],
    sauce: [
      {
        ingredient_id: 9,
        name: '렌치',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '후추',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '올리브오일',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
    ],
    more: [
      {
        ingredient_id: 9,
        name: '에그마요',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 1800,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '베이컨',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 1800,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '아보카도',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 1800,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '오믈렛',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 1800,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '페퍼로니',
        img_url: 'https://www.subway.co.kr/upload/menu/img_toppping_02.png',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 1800,
        allergies: ''
      },
    ],
    veges: [
      {
        ingredient_id: 9,
        name: '양상추',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '양파',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      }
    ],
    moreMeats:[
      {
        ingredient_id: 9,
        name: 'k-바베큐',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '스테이크치즈',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      },
      {
        ingredient_id: 9,
        name: '로티세리',
        img_url: 'https://www.subway.co.kr/images/menu/img_recipe_b01.jpg',
        kcal: 100,
        protein: 10,
        fat: 10,
        price: 0,
        allergies: ''
      }
    ],
    selectedMoreMeat: null,
    selectedMenu: null,
    selectedSize: null,
    selectedBread: null,
    selectedCheese: null,
    selectedSauce: [],
    selectedMore: [],
    selectedVege: []

  },
  getters: {
    selectedStore: (state) => state.selectedStore,
    
    menus : (state) => state.menus,

    selectedMenu: (state) => state.selectedMenu,

    selectedSize: (state) => state.selectedSize,

    selectedBread: (state) => state.selectedBread,

    selectedCheese: (state) => state.selectedCheese,

    selectedSauce: (state) => state.selectedSauce,

    selectedMore: (state) => state.selectedMore,

    selectedVege: (state) => state.selectedVege

  },
  mutations: {
    SET_SELECTEDSTORE: (state, value) => (state.selectedStore = value),

    SET_MENUS: (state, value) => (state.menus = value),

    SET_SELECTEDSIZE : (state, value) => state.selectedSize = value,

    SET_SELECTEDBREAD: (state, value) => state.selectedBread = value,

    SET_SELECTEDCHEESE: (state, value) => state.selectedCheese = value,

    
    SET_SELECTEDSAUCE: (state, value) => state.selectedSauce.push(value),

    REMOVE_SELECTEDSAUCE: (state, value) => {
      state.selectedSauce = state.selectedSauce.filter(sauce => 
         sauce !== value 
      )
    },
    
    SET_SELECTEDMORE: (state, value) => state.selectedMore.push(value),

    REMOVE_SELECTEDMORE: (state, value) => {
      state.selectedMore = state.selectedMore.filter(more => 
         more !== value 
      )
    },
    
    SET_SELECTEDVEGE: (state, value) => state.selectedVege.push(value),
    
    REMOVE_SELECTEDVEGE: (state, value) => {
      state.selectedVege = state.selectedVege.filter(vege => 
         vege !== value 
      )
    },

    COMBINE_SELECTEDMORE: (state, value) => state.selectedMore = state.selectedMore + value,

    SET_SELECTEDMOREMEAT: (state, value) => state.selectedMoreMeat = value,
    
    SET_SELECTEDMENU: (state, value) => (state.selectedMenu = value),

    
  },
  actions: {
    // fetchMenus ({commit}, value) {
    //   axios({
    //     method: 'get',
    //     url: '',

    //   })
    // },
    selectStore({ commit }, value) {
      commit("SET_SELECTEDSTORE", value);
    },

    selectMenu({ commit }, value) {
      commit("SET_SELECTEDMENU", value);
    },

    selectSize({ commit }, value) {
      commit('SET_SELECTEDSIZE', value)
    },

    selectBread({ commit }, value) {
      commit('SET_SELECTEDBREAD', value)
    },

    selectCheese({ commit }, value) {
      commit('SET_SELECTEDCHEESE', value)
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
    },

    selectSauce({ commit }, value) {
      commit('SET_SELECTEDSAUCE', value)
    },

    removeSauce({ commit }, value) {
      commit('REMOVE_SELECTEDSAUCE', value)
    },

    
  },
};
