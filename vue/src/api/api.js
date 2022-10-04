import order from './order'
import comb from './comb'

const HOST = 'https://j7a105.p.ssafy.io/api/v1/'
// const KAKAOHOST = "https://kauth.kakao.com"
const ACCOUNTS = 'user/'


export default {
  accounts: {
    login: () => HOST + 'auth/login',
    // logout: () => HOST + ACCOUNTS + 'logout/',
    signup: () => HOST + ACCOUNTS + 'signup/',
    check: (username) => HOST + ACCOUNTS + 'check/' + username + '/',
    // Token 으로 현재 user 판단
    // currentUserInfo: () => HOST + ACCOUNTS + 'user/',
    // username으로 프로필 제공
    profile: (username) => HOST + ACCOUNTS + username + '/',
    zzim: (username) => HOST + ACCOUNTS + `${username}/dibs`,
    exclude: (username) => HOST + ACCOUNTS + `${username}/exclude`,
    list: (username) => HOST + ACCOUNTS + `${username}/list`,
    subti: () => HOST + ACCOUNTS + 'subti',
    dib: (username)  => HOST + ACCOUNTS + `${username}/dibs`,
    

  },
  order: order,

  comb: comb
}