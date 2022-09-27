// import axios from "axios";



export default({
  state: {
    menus: [
      {
        menu_id : 1,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 2,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 3,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 4,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 5,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 6,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 7,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 8,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 9,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },
      {
        menu_id : 10,
        img_url : 'https://www.subway.co.kr/upload/menu/Steak-&-Cheese_20211231095455613.png',
        menu_name : '스테이크&치즈',
        ingredient : '스테이크 1스쿱, 치즈 2장',
        menu_desc : '스테이크에 치즈 넣은 샌드위치',
        price : 7000,
      },    
    ],
    selectedMenu: null,
    selectedSize: null
  },
  getters: {
    menus : (state) => state.menus,

    selectedMenu: (state) => state.selectedMenu,

    selectedSize: (state) => state.selectedSize,
  },
  mutations: {
    SET_MENUS : (state, value) => state.menus = value,

    SET_SELECTEDMENU : (state, value) => state.selectedMenu = value,

    SET_SELECTEDSIZE : (state, value) => state.selectedSize = value,
  },
  actions: {
    // fetchMenus ({commit}, value) {
    //   axios({
    //     method: 'get',
    //     url: '',

    //   })
    // },

    selectMenu({ commit }, value) {
      commit('SET_SELECTEDMENU', value)
    },

    selectSize({ commit }, value) {
      commit('SET_SELECTEDSIZE', value)
    }
  },

})
