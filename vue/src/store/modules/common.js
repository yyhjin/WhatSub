import axios from "axios";
import api from "@/api/api";

export default({
    state: {
      dibList: [],
      orderList: []
    },

    getters: {
      dibList: state => state.dibList,
      order: state => state.order
    },

    mutations: {
      SET_DIBLIST: (state, value) => state.dibList = value,

      SET_ORDER: (state, value) => state.order = value,
    },

    actions: {
      fetchDibList ({ commit }, username) {
        axios({
          url: api.accounts.dib("test1"),
          method: 'post',
          // headers: getters.authHeader
        }).then(res => {
          console.log(username)
          console.log(res)
          commit('SET_DIBLIST', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      },

      fetchOrder({ commit }, username) {
        axios({
          url: api.order.order.read("test1"),
          method: 'get',
          // headers: getters.authHeader
        }).then(res => {
          console.log(username)
          console.log(res)
          commit('SET_ORDER', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      }
    },
    
  })