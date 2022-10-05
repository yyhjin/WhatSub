import axios from "axios";

export default{
  state: {
    // sandList: [
    //   {
    //     id: 1,
    //     name: "sand1",
    //     basic: "에그마요",
    //     score: 1.5,
    //     desc: "닭가슴살로 만든 치키 슬라이스를 담백하게 즐겨보세요.",
    //     nutri: 300,
    //     ingre: ["플랫브래드", "오이1", "토마토1"],
    //     price: 5400,
    //   },
    //   {
    //     id: 2,
    //     name: "sand2",
    //     basic: "터키 베이컨 아보카도",
    //     score: 2.5,
    //     desc: "맛난 샌드위치2~",
    //     nutri: 250,
    //     ingre: "토마토2",
    //     price: 6400,
    //   },
    //   {
    //     id: 3,
    //     name: "sand3",
    //     score: 3.5,
    //     desc: "맛난 샌드위치3~",
    //     basic: "치킨 슬라이스",
    //     nutri: 350,
    //     ingre: "토마토3",
    //     price: 7400,
    //   },
    //   {
    //     id: 4,
    //     name: "sand4",
    //     basic: "스테이크&치즈",
    //     score: 4.5,
    //     desc: "맛난 샌드위치4~",
    //     nutri: 450,
    //     ingre: "토마토4",
    //     price: 8400,
    //   },
    //   {
    //     id: 5,
    //     name: "sand5",
    //     basic: "터키 베이컨 아보카도",
    //     score: 5.5,
    //     desc: "맛난 샌드위치5~",
    //     nutri: 550,
    //     ingre: "토마토5",
    //     price: 9400,
    //   },
    //   {
    //     id: 6,
    //     name: "sand1",
    //     basic: "에그마요",
    //     score: 1.5,
    //     desc: "닭가슴살로 만든 치키 슬라이스를 담백하게 즐겨보세요.",
    //     nutri: 300,
    //     ingre: ["플랫브래드", "오이1", "토마토1"],
    //     price: 5400,
    //   },
    //   {
    //     id: 7,
    //     name: "sand2",
    //     basic: "터키 베이컨 아보카도",
    //     score: 2.5,
    //     desc: "맛난 샌드위치2~",
    //     nutri: 250,
    //     ingre: "토마토2",
    //     price: 6400,
    //   },
    //   {
    //     id: 8,
    //     name: "sand3",
    //     score: 3.5,
    //     desc: "맛난 샌드위치3~",
    //     basic: "치킨 슬라이스",
    //     nutri: 350,
    //     ingre: "토마토3",
    //     price: 7400,
    //   },
    //   {
    //     id: 9,
    //     name: "sand4",
    //     basic: "스테이크&치즈",
    //     score: 4.5,
    //     desc: "맛난 샌드위치4~",
    //     nutri: 450,
    //     ingre: "토마토4",
    //     price: 7400,
    //   },
    //   {
    //     id: 10,
    //     name: "sand1",
    //     basic: "에그마요",
    //     score: 1.5,
    //     desc: "닭가슴살로 만든 치키 슬라이스를 담백하게 즐겨보세요.",
    //     nutri: 300,
    //     ingre: ["플랫브래드", "오이1", "토마토1"],
    //     price: 5400,
    //   },
    //   {
    //     id: 11,
    //     name: "sand2",
    //     basic: "터키 베이컨 아보카도",
    //     score: 2.5,
    //     desc: "맛난 샌드위치2~",
    //     nutri: 250,
    //     ingre: "토마토2",
    //     price: 6400,
    //   },
    //   {
    //     id: 12,
    //     name: "sand3",
    //     score: 3.5,
    //     desc: "맛난 샌드위치3~",
    //     basic: "치킨 슬라이스",
    //     nutri: 350,
    //     ingre: "토마토3",
    //     price: 7400,
    //   },
    //   {
    //     id: 13,
    //     name: "sand4",
    //     basic: "스테이크&치즈",
    //     score: 4.5,
    //     desc: "맛난 샌드위치4~",
    //     nutri: 450,
    //     ingre: "토마토4",
    //     price: 9400,
    //   },
    //   {
    //     id: 14,
    //     name: "sand5",
    //     basic: "터키 베이컨 아보카도",
    //     score: 5.5,
    //     desc: "맛난 샌드위치5~",
    //     nutri: 550,
    //     ingre: "토마토5",
    //     price: 8400,
    //   },
    //   {
    //     id: 15,
    //     name: "sand5",
    //     basic: "터키 베이컨 아보카도",
    //     score: 5.5,
    //     desc: "맛난 샌드위치5~",
    //     nutri: 550,
    //     ingre: "토마토5",
    //     price: 8400,
    //   },
    //   {
    //     id: 16,
    //     name: "sand5",
    //     basic: "터키 베이컨 아보카도",
    //     score: 5.5,
    //     desc: "맛난 샌드위치5~",
    //     nutri: 550,
    //     ingre: "토마토5",
    //     price: 8400,
    //   },
    // ],
    sampleUserId: 1,
    sampleUserName: "test1",
    userSubti: "icah",
    combiBasedIndividual: {},
    combiBasedSubti: {},
    combiListByOthers: [],
    combiListByNutri: [],
    bestCombi: {},
    combiList: [],
    combiDetail: {},
    filteringMenu: [],

    myList:{}, 
  },
  getters: {
    sampleUserId: (state) => state.sampleUserId,
    sampleUserName: (state) => state.sampleUserName,
    userSubti: (state) => state.userSubti,
    combiListByOthers: (state) => state.combiListByOthers,
    combiListByNutri: (state) => state.combiListByNutri,
    bestCombi: (state) => state.bestCombi,
    combiList: (state) => state.combiList,
    combiDetail: (state) => state.combiDetail,
    combiBasedIndividual: (state) => state.combiBasedIndividual,
    combiBasedSubti: (state) => state.combiBasedSubti,
    filteringMenu: (state) => state.filteringMenu,
    myList: (state) => state.myList,
  },
  mutations: {
    SET_COMBI_LIST_BY_OTHERS: (state, combiListByOthers) => (state.combiListByOthers = combiListByOthers),
    SET_COMBI_LIST_BY_NUTRI: (state, combiListByNutri) => (state.combiListByNutri = combiListByNutri),
    SET_BEST_COMBI: (state, bestCombi) =>(state.bestCombi = bestCombi),
    SET_COMBI_LIST: (state, combiList) =>(state.combiList = combiList),
    SET_COMBI_DETAIL: (state, combiDetail) =>(state.combiDetail = combiDetail),
    SET_COMBI_BASED_INDIVIDUAL: (state, combiBasedIndividual) =>(state.combiBasedIndividual = combiBasedIndividual),
    SET_COMBI_BASED_SUNBTI: (state, combiBasedSubti) =>(state.combiBasedSubti = combiBasedSubti),
    SET_FILTERING_MENU: (state, filteringMenu) =>(state.filteringMenu = filteringMenu),
    SET_MY_LIST: (state, myList) =>(state.myList = myList),
  },
  actions: {
    getCombiListByOthers({commit}) {
      axios({
        method: "get",
        url: "https://j7a105.p.ssafy.io/api/v1/recommendation/postrank",
      })
        .then((res) => {
          commit("SET_COMBI_LIST_BY_OTHERS", res.data.data);
        })
        .catch((err) => console.log("getCombiListByOthers 에러", err));
    },
    getCombiListByNutri({ commit }, {kcalMax, kcalMin, proteinMax, proteinMin, sodiumMax, sodiumMin}) {
      axios({
        method: "post",
        url: "https://j7a105.p.ssafy.io/api/v1/recommendation/nutrition",
        data: {
          kcalMax: kcalMax,
          kcalMin: kcalMin,
          proteinMax: proteinMax,
          proteinMin: proteinMin,
          sodiumMax: sodiumMax,
          sodiumMin: sodiumMin,
        },
      })
        .then((res) => {
          commit("SET_COMBI_LIST_BY_NUTRI", res.data.data);
          console.log(res.data.data);
        })
        .catch((err) => console.log("getCombiListByNutri 에러", err));
    },
    getBestCombi({commit}, {userId}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/comb/best/${userId}`,
        data: {
          userId: userId,
        }
      })
        .then((res) => {
          commit("SET_BEST_COMBI", res.data.data);
        })
        .catch((err) => console.log("getCombiListByOthers 에러", err));
    },
    getCombiDetail({commit}, {combinationPostId, userId}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/comb/${combinationPostId}/${userId}`,
        data: {
          combinationPostId: combinationPostId,
          userId: userId
        }
      })
        .then((res) => {
          commit("SET_COMBI_DETAIL", res.data.data);
          console.log(res.data.data);
        })
        .catch((err) => console.log("getCombiDetail 에러", err));
    },
    getCombiList({commit}, {orderNo, userId}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/comb/order/${orderNo}/${userId}`,
        data: {
          orderNo: orderNo,
          userId: userId
        }
      })
        .then((res) => {
          commit("SET_COMBI_LIST", res.data.data);
        })
        .catch((err) => console.log("getCombiList 에러", err));
    },
    getCombiBasedSubti({commit}, {subti}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/recommendation/subti/${subti}`,
        data: {
          subti: subti,
        }
      })
        .then((res) => {
          commit("SET_COMBI_BASED_SUNBTI", res.data.data);
        })
        .catch((err) => console.log("getCombiBasedSubti 에러", err));
    },
    getCombiBasedIndividual({commit}, {userId}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/recommendations/hybrid/${userId}`,
        data: {
          userId: userId,
        }
      })
        .then((res) => {
          commit("SET_COMBI_BASED_INDIVIDUAL", res.data[0]);
          console.log("dd", res.data[0]);
        })
        .catch((err) => console.log("getCombiBasedIndividual 에러", err));
    },
    
    deleteReview({commit}, {postId, reviewId}) {
      axios({
        method: "delete",
        url: `https://j7a105.p.ssafy.io//api/v1/review/${reviewId}`,
        data: {
          postId: postId,
          reviewId: reviewId,
        }
      })
        .then(() => {
          axios({
            method: "get",
            url: `https://j7a105.p.ssafy.io/api/v1/comb/${postId}/${this.sampleUserId}`,
            data: {
              combinationPostId: postId,
              userId: this.sampleUserId
            }
          })
            .then((res) => {
              commit("SET_COMBI_DETAIL", res.data.data);
            })
            .catch((err) => console.log("getCombiDetail 에러", err));
        })
        .catch((err) => console.log("deleteReview 에러", err));
    },
    getFilteringMenu({commit}, {menuId, userId}) {
      axios({
        method: "get",
        url: `https://j7a105.p.ssafy.io/api/v1/comb/menu/${menuId}/${userId}`,
        data: {
          menuId: menuId,
          userId: userId
        }
      })
        .then((res) => {
          commit("SET_COMBI_LIST", res.data.data);
          console.log(res.data.data);
        })
        .catch((err) => console.log("getFilteringMenu 에러", err));
    },
    updateZzimCombi({commit}, {combPostId, userId}) {
      axios({
        method: "put",
        url: `https://j7a105.p.ssafy.io/api/v1/comb/dib?combPostId=${combPostId}&userId=${userId}`,
        data: {
          combPostId: combPostId,
          userId: userId,
        }
      })
        .then((res) => {
          commit("SET_COMBI_DETAIL", res.data.data);
          axios({
            method: "get",
            url: `https://j7a105.p.ssafy.io/api/v1/comb/${combPostId}/${userId}`,
            data: {
              combinationPostId: combPostId,
              userId: userId
            }
          })
            .then((res) => {
              commit("SET_COMBI_DETAIL", res.data.data);
              console.log("찜한 후 렌더링", res.data.data);
            })
            .catch((err) => console.log("Zzim_getCombiDetail 에러", err));
        })
        .catch((err) => console.log("updateZzimCombi 에러", err));
    },
    //유저 컬렉션, 꿀조합, 찜 목록 불러오기
    getMyList({commit}, {userName}) {
      axios({
        method: "post",
        url: `https://j7a105.p.ssafy.io/api/v1/user/${userName}/list`,
        data: {
          userName: userName,
        }
      })
        .then((res) => {
          commit("SET_MY_LIST", res.datadata);
          console.log("dd", res.data.data);
        })
        .catch((err) => console.log("getMyList 에러", err));
    },
  },
}
