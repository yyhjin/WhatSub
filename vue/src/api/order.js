

const HOST = 'http://127.0.0.1:8000/api/v1/'
// const KAKAOHOST = "https://kauth.kakao.com"
const ORDER = 'order/'


export default {
  order: {
    makeorder: () => HOST + ORDER ,
    menu: () => HOST + ORDER + 'menu/',
    ingredient: () => HOST + ORDER + 'ingredient/',
    store: () => HOST + ORDER + 'store/',
    read:(username) => HOST + ORDER + `${username}`,
  },
 
}