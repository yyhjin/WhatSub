# :bread: WhatSub? - 서브웨이 샌드위치 조합 추천 서비스

## 1. :notebook_with_decorative_cover: PJT summary
- 팀명: A105
- 프로젝트명: WhatSub 
- 주제: 개인 추천 알고리즘을 적용한 SUBWAY 메뉴 추천 모바일웹
- 기간: 2022.08.22 - 2022.10.07

- 사용기술스택:

  - 협업, 버전관리 : [![img](https://camo.githubusercontent.com/a9a95986631c3d4945a63d42d2864e3918a834d672d907e174a29f743a1bc3f1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769742d4630353033323f7374796c653d666f722d7468652d6261646765266c6f676f3d676974266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/a9a95986631c3d4945a63d42d2864e3918a834d672d907e174a29f743a1bc3f1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769742d4630353033323f7374796c653d666f722d7468652d6261646765266c6f676f3d676974266c6f676f436f6c6f723d7768697465) [![img](https://camo.githubusercontent.com/ad176bb5a61237550550e47d7e77dd5d1a846518df44c522d2ba9c0a7da6379c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769746875622d3138313731373f7374796c653d666f722d7468652d6261646765266c6f676f3d676974687562266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/ad176bb5a61237550550e47d7e77dd5d1a846518df44c522d2ba9c0a7da6379c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769746875622d3138313731373f7374796c653d666f722d7468652d6261646765266c6f676f3d676974687562266c6f676f436f6c6f723d7768697465)[![img](https://camo.githubusercontent.com/d20c06f1854face8c434a4fa2ffa62a2c6d52368120cc7dafd77166da5732caf/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4e6f74696f6e2d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d6e6f74696f6e266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/d20c06f1854face8c434a4fa2ffa62a2c6d52368120cc7dafd77166da5732caf/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4e6f74696f6e2d3030303030303f7374796c653d666f722d7468652d6261646765266c6f676f3d6e6f74696f6e266c6f676f436f6c6f723d7768697465)<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=Jira Software&logoColor=white"><img src="https://img.shields.io/badge/Mattermost-0058CC?style=for-the-badge&logo=Mattermost&logoColor=white">

  - 언어 : [![img](https://camo.githubusercontent.com/5d8f10d34ebf49b459c6747dff496c18f5100d8fa8229ddbb88ddc0efd494279/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f707974686f6e2d3337373641423f7374796c653d666f722d7468652d6261646765266c6f676f3d707974686f6e266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/5d8f10d34ebf49b459c6747dff496c18f5100d8fa8229ddbb88ddc0efd494279/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f707974686f6e2d3337373641423f7374796c653d666f722d7468652d6261646765266c6f676f3d707974686f6e266c6f676f436f6c6f723d7768697465) [![img](https://camo.githubusercontent.com/146641825a4dcaf7d047629441f6596b8d9d7327ec8c8104ea54d3b6aa1080b3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176615363726970742d4637444631453f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/146641825a4dcaf7d047629441f6596b8d9d7327ec8c8104ea54d3b6aa1080b3/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176615363726970742d4637444631453f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661736372697074266c6f676f436f6c6f723d7768697465) [![img](https://camo.githubusercontent.com/5a7100155d1a7b75357a90e8810530b21c8723c59f2976d0dafc7950205336d7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d4533344632363f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/5a7100155d1a7b75357a90e8810530b21c8723c59f2976d0dafc7950205336d7/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f68746d6c352d4533344632363f7374796c653d666f722d7468652d6261646765266c6f676f3d68746d6c35266c6f676f436f6c6f723d7768697465) [![img](https://camo.githubusercontent.com/395bcd1fa353e86f422e5f01abf3260b8c76720be050e5f4688ab7fc7634f50f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4353532d3135373242363f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/395bcd1fa353e86f422e5f01abf3260b8c76720be050e5f4688ab7fc7634f50f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4353532d3135373242363f7374796c653d666f722d7468652d6261646765266c6f676f3d63737333266c6f676f436f6c6f723d7768697465)

  - FE/BE framework : [![img](https://camo.githubusercontent.com/d4bf3d84fc3a4e4cc4f10f59cdbae19b2d7cf13bd178f51adea9b9add58c94be/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5675652d3446633038443f7374796c653d666f722d7468652d6261646765266c6f676f3d7675652e6a73266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/d4bf3d84fc3a4e4cc4f10f59cdbae19b2d7cf13bd178f51adea9b9add58c94be/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f5675652d3446633038443f7374796c653d666f722d7468652d6261646765266c6f676f3d7675652e6a73266c6f676f436f6c6f723d7768697465) [![img](https://camo.githubusercontent.com/45a08fd62000319cdc6c0b021cc831dc611df2d23bd94d129dea36fc02dc1a77/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f646a616e676f2d3039324532303f7374796c653d666f722d7468652d6261646765266c6f676f3d646a616e676f266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/45a08fd62000319cdc6c0b021cc831dc611df2d23bd94d129dea36fc02dc1a77/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f646a616e676f2d3039324532303f7374796c653d666f722d7468652d6261646765266c6f676f3d646a616e676f266c6f676f436f6c6f723d7768697465)<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

  - DB : <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

  - 배포 :  [![img](https://camo.githubusercontent.com/c75eb74744dd435c8f353a621e97b392201c530225b32b1be88d6cd38a1b1448/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f416d617a6f6e4157532d4646393930423f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e617773266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/c75eb74744dd435c8f353a621e97b392201c530225b32b1be88d6cd38a1b1448/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f416d617a6f6e4157532d4646393930423f7374796c653d666f722d7468652d6261646765266c6f676f3d616d617a6f6e617773266c6f676f436f6c6f723d7768697465) <img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"><img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"><img src="https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=NGINX&logoColor=white">

  - 디자인 : [![img](https://camo.githubusercontent.com/47e6264f9d0f6ddd400336f6755634301f99d25998f5663caa7f4f6353ce8146/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f537761676765722d3835454132443f7374796c653d666f722d7468652d6261646765266c6f676f3d73776167676572266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/47e6264f9d0f6ddd400336f6755634301f99d25998f5663caa7f4f6353ce8146/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f537761676765722d3835454132443f7374796c653d666f722d7468652d6261646765266c6f676f3d73776167676572266c6f676f436f6c6f723d7768697465) <img src="https://img.shields.io/badge/Vuetify-1867C0?style=for-the-badge&logo=Vuetify&logoColor=white">


## 2. :ferris_wheel: 주요 기술

**Backend**

- Spring boot 2.7.3
- Spring Data JPA
- Spring Web
- Swagger 3.0.0
- QueryDSL
- Mysql DB 8.0.30-0

**Frontend**

- Visual Studio Code IDE
- Vue 2.6.14
- Vue-router 3.5.1
- Vuex 3.6.2
- Vuetify 2.6.7

**Deploy**

- AWS EC2
- ubuntu0.20.04.2
- Docker
- NGINX
- Certbot

## 3. :handshake: 협업 툴

- Git
- Notion
- JIRA
- MatterMost
- Webex
- Discord
- Visual Studio Code Live Share

## 4. :building_construction: 프로젝트 파일 구조 
- 파일 구조

![image](https://user-images.githubusercontent.com/99111030/230043566-d9d8bfba-767a-45a0-b630-a1d4968d96ad.png)


## 5. :family: 팀원 역할 분배

![image (1)](https://user-images.githubusercontent.com/99111030/230043688-7138d960-3577-4c94-bd17-9a11fe87e5c3.png)

## 6. :volcano: 프로젝트 산출물

- [기능정의서](https://evergreen-navy-d7f.notion.site/870e84099d3342359a0fd3ef06531e40)
- [와이어프레임](https://www.figma.com/file/WGOaRdUVENFfuCMPU3m9h3/%5B%ED%8A%B9%ED%99%94-PJT%5D-A105?node-id=54%3A1683)
- [컴포넌트다이어그램](https://www.figma.com/file/WGOaRdUVENFfuCMPU3m9h3/%5B%ED%8A%B9%ED%99%94-PJT%5D-A105?node-id=260%3A5454)
- [API](https://j7a105.p.ssafy.io/api/v1/swagger-ui/)
- [ERD](https://www.erdcloud.com/d/Gyp3shSQq5N24c8ny)
- 기술스택
- [UCC](./README.assets/A105_UCC.mp4)
- (서버)아키텍쳐
![image_architecture](README.assets/A105_아키텍쳐.png)

## 7. :label: 프로젝트 결과물

- [포팅매뉴얼](./exec/A105_포팅_매뉴얼.pdf)
- [중간발표자료](./README.assets/A105_중간발표자료.pdf)
- [최종발표자료](./README.assets/A105_최종발표자료.pdf)

## 8. :film_projector: Whatsub 서비스 화면


### 회원가입

- 카카오 로그인 / 회원가입
(닉네임 중복 검사를 해야 회원가입을 할 수 있습니다)

![회원가입](https://user-images.githubusercontent.com/99111030/230043992-2fdef72f-f9c6-4804-aee8-cf60ebc10661.gif)




### 홈 화면

- 메뉴 추천


![image](/uploads/390c0c4d1db31f2643db3df7ef9e7ea8/image.png)





### 추천

* 홈 화면에서 기본 설문조사를 완료하면 썹BTI와 개인 맞춤 추천을 볼 수 있습니다.
* 추천 카드를 누르면 디테일로 넘어갑니다.

![메인추천](README.assets/메인추천.gif)



![메인위에 두개 상세보기](README.assets/메인위에 두개 상세보기.gif)



* 그날 그날의 상황에 따라 다른 추천을 받을 수 있습니다.

![오늘의추천](README.assets/오늘의추천.gif)



* 본인이 원하는 영양정보에 따라 추천을 받을 수 있습니다.

![영양정보추천](README.assets/영양정보추천.gif)



* 썹bti를 변경하면 그에 따라 추천메뉴가 변경됩니다.

![subti변경](README.assets/subti변경.gif)



### 랭킹 화면

- 매달 각 샌드위치의 랭킹을 볼 수 있습니다.
- 랭킹을 통해 다른 유저의 프로필에 접근할 수 있습니다.

![랭킹](README.assets/랭킹.gif)



### 꿀조합 게시판

- 꿀조합게시판에서 다양한 꿀조합을 평점순, 최신순기준으로 볼 수 있습니다.
- 원하는 메뉴에 대한 꿀조합을 볼 수 있습니다.
- 해당 꿀조합을 누르면 꿀조합 디테일 페이지로 이동합니다.
- 꿀조합 디테일에서 바로 주문하러 갈 수 있습니다.

![꿀조합게시판1](README.assets/꿀조합게시판1-16660928524813.gif)





### 꿀조합디테일

* 꿀조합 디테일에서는 메뉴에 따른 조합정보, 영양정보, 분석정보를 볼 수 있습니다.
* 각 조합에 따른 댓글을 볼 수 있습니다.
* 조합을 찜 할 수 있습니다.

![꿀조합디테일](README.assets/꿀조합디테일.gif)



### 주문 화면

- 원하는 조합에서 주문을 하러 가면 그 조합에 따라 기본값이 지정되어 있습니다.
- 커스텀이 가능합니다.
- 주문에서는 선택한 메뉴에 따라 정보가 즉시 변경됩니다.

![주문하러가기 + 주문커스텀](README.assets/주문하러가기 + 주문커스텀.gif)





### 장바구니

* 장바구니에서는 본인이 담은 메뉴를 볼 수 있습니다.

![장바구니](README.assets/장바구니.gif)



* 주문을 완료했다면 장바구니가 비워지고 다시 주문하러 갈 수 있습니다.

![비어있는장바구니](README.assets/비어있는장바구니.gif)



### 주문내역

* 주문을 완료하면 주문내용이 주문내역으로 이동됩니다.
* 주문한 매장을 다시 한번 확인할 수 있습니다.

![주문완료](README.assets/주문완료.gif)



* 그 전에 주문내역으로 다시  한번 주문이 가능합니다.

![주문내역 주문](README.assets/주문내역 주문.gif)



* 본인이 주문한 주문 내역에서 등록되지 않은 조합을 꿀조합에 등록할 수 있습니다.

![꿀조합등록](README.assets/꿀조합등록.gif)



### 프로필 화면

- 마이페이지에서는 본인이 찜한 목록과 등록한 꿀조합을 볼 수 있습니다.
- 매달 받을 수 있는 컬렉션 목록을 볼 수 있습니다.

![마이페이지](README.assets/마이페이지.gif)





### 취향 설문

- 회원가입 후 불호 재료, 알레르기 설문을 통해 개인 맞춤화된 추천을 받을 수 있습니다.
- 입맛에 대한 설문조사로 썹BTI 검사를 진행하고 이를 꿀조합 추천에 활용합니다.

![exclude_subti](/uploads/242a30bc5b28582976840cb93a60f459/exclude_subti.gif)

