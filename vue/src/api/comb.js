

const HOST = 'https://j7a105.p.ssafy.io/api/v1/'
// const KAKAOHOST = "https://kauth.kakao.com"
const COMB = 'comb/'


export default {
  comb: {
    read: (combinationPostId) => HOST + COMB + `${combinationPostId}`,
    exist: (combinationId) => HOST + COMB + `exist/${combinationId}`
  },
 
}