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
      fetchDibList ({ commit, getters } ) {
        axios({
          url: api.accounts.dib(getters.username),
          method: 'post',
          // headers: getters.authHeader
        }).then(res => {
          console.log(getters.username)
          console.log(res)
          commit('SET_DIBLIST', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      },

      fetchOrder({ commit, getters }) {
        axios({
          url: api.order.order.read(getters.username),
          method: 'get',
          // headers: getters.authHeader
        }).then(res => {
          console.log(res)
          commit('SET_ORDER', res.data.data)
        }).catch(err => {
          console.error(err)
        })
      }
    },
    
  })