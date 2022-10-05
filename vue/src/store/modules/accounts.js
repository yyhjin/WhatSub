import axios from "axios";
import api from "@/api/api";

export default({
  state: {
    token : localStorage.getItem('token') || '',
    username: localStorage.getItem('username') || '',
    currentUser: {},
    profile : {},
  },

  getters: {
    isLoggedIn : state => !!state.token,
    authHeader  (state) {
      return {Authorization: `Token ${state.token}`}
    },
    username: state => state.username,
    profile: state => state.profile,
    currentUser : state => state.currentUser,
  },

  mutations: {
    SET_TOKEN (state, token) {
      state.token = token
    },
    SET_USERNAME : (state, username) => state.username = username,
    SET_CURRENT_USER : (state, user) => state.currentUser = user,
    SET_PROFILE : (state, profile) => state.profile = profile,
  },

  actions: {
    saveToken ({ commit }, token) {
      commit('SET_TOKEN', token)
      
      localStorage.setItem('token', token)   // 새로고침 후에도 유지
    },
    saveUserName ({ commit }, username) {
      commit('SET_USERNAME', username)
      localStorage.setItem('username', username)
    },
    removeToken ({ commit }) {
      
      commit('SET_TOKEN', '')
      localStorage.setItem('token', '')
    },

    logout ({ getters, dispatch}) {
      axios({
        url:api.accounts.logout(),
        method:'post',
        headers: getters.authHeader
      })
      .then(() => {
        dispatch('removeToken')
        alert('로그아웃 성공!')
        // router.push({name:'login'})
      })
    },

    fetchCurrentUser ({ commit, getters, dispatch}) { // user 식별 위해
      if (getters.isLoggedIn) {
        axios({
          url: api.accounts.currentUserInfo(),
          method: 'get',
          headers: getters.authHeader
        })
        .then(res => {
          axios({
            url: api.accounts.profile(res.data.username),
            method: 'get',
            headers: getters.authHeader
          })
          .then( res => {
            commit('SET_CURRENT_USER', res.data)
          }) 
        })
        .catch( err => {
          if (err.response.status === 401) {
            dispatch('removeToken')
            // router.push({name:'login'})
          }
        })
      }
    },

    fetchProfile ({  commit, getters }, { username }) {
      axios({
        url: api.accounts.profile(username),
        method: 'get',
        headers: getters.authHeader
      })
      .then( res => {
        commit('SET_PROFILE', res.data.data)
      })
    },

    signup ({ dispatch }, formData) {
      axios({
        url : api.accounts.signup(),
        method : 'post',
        data : formData,
        // headers:{
        //   'Content-Type':'multipart/form-data'
        // }
      })
      .then(res => {
        dispatch('saveToken', res.data.key)
        dispatch('fetchCurrentUser')
        // router.push({name:'home'})    
      })
      .catch(err => {
        console.error(err.response.data)
        // commit('SET_AUTH_ERROR', err.response.data)
      })
  },

}
})
