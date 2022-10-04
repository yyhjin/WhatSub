

const HOST = 'https://j7a105.p.ssafy.io/api/v1/'
// const KAKAOHOST = "https://kauth.kakao.com"
const ORDER = 'order/'


export default {
  order: {
    makeorder: () => HOST + ORDER ,
    menu: () => HOST + ORDER + 'menu/',
    ingredient: () => HOST + ORDER + 'ingredient/',
    store: () => HOST + ORDER + 'store/',
    read: (username) => HOST + ORDER + `${username}`,
  },
 
}