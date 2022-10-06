import axios from "axios";
import api from "@/api/api";

export default({
    state: {
      dibList: [],
      order: []
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
      fetchDibList ({ commit, getters }, username ) {
        axios({
          url: api.accounts.dib(username),
          method: 'post',
          headers: getters.authHeader
        }).then(res => {
          
          console.log('fetchdib 성공', res)
          commit('SET_DIBLIST', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      },

      fetchOrder({ commit, getters }, username) {
        axios({
          url: api.order.order.read(username),
          method: 'get',
          headers: getters.authHeader
        }).then(res => {
          console.log(res)
          commit('SET_ORDER', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      }
    },
    
  })