import axios from "axios";
import api from "@/api/api";

export default({
    state: {
      dibList: []
    },

    getters: {
      dibList: state => state.dibList
    },

    mutations: {
      SET_DIBLIST: (state, value) => state.dibList = value
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
      }
    },
    
  })