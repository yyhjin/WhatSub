<template>
  <div>
    <div id="map" style="height: 70vh; width: 90%; margin: auto;"></div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "StoreMap",
  props: {
    lat: { type: Number, default: 37.5016 },
    lng: { type: Number, default: 127.036 },
    storeInfoList: { type: Array, default: () => [] },
    type: { type: Number, default: 0 },
    
  },

  data() {
    return {
      map: null,
      markers: [],
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
      
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.VUE_APP_JAVASCRIPT_KEY}&autoload=false`;
      script.type = "text/javascript";
      document.head.appendChild(script);
      
    }
    // this.setMarkers(this.storeInfoList)
  },

  methods: {
    ...mapActions(["selectStore"]),
    initMap() {
      var mapContainer = document.getElementById("map"),
        mapOption = {
          center: new kakao.maps.LatLng(this.lat, this.lng),
          level: 5,
        };

      this.map = new kakao.maps.Map(mapContainer, mapOption);

      if (this.type === 0) {
        this.getBounds();
        kakao.maps.event.addListener(
          this.map,
          "idle",
          this.getBounds.bind(this)
        );
      }
    },
    getBounds() {
      var bounds = this.map.getBounds();
      this.$emit("store-info", bounds.getSouthWest(), bounds.getNorthEast());
    },
    removeMarker() {
      this.markers.forEach((marker) => {
        marker.setMap(null);
      });
    },
    select(storeInfo) {
      if (this.type === 0) {
        this.selectStore(storeInfo);
      }
    },
    setMarkers(storeInfoList) {
      storeInfoList.forEach((storeInfo) => {
        var imageSrc = require("@/assets/marker.png"), // 마커이미지의 주소입니다
          imageSize = new kakao.maps.Size(34, 45), // 마커이미지의 크기입니다
          imageOption = { offset: new kakao.maps.Point(17, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

        // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        );

        var marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: new kakao.maps.LatLng(storeInfo.lat, storeInfo.lng), // 마커를 표시할 위치
          title: storeInfo.branchName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage,
        });
        this.markers.push(marker);

        var content = document.createElement("div");
        content.className = "customoverlay";
        var box = document.createElement("div");
        box.onclick = () => this.select(storeInfo);
        var title = document.createElement("div");
        title.className = "title";
        title.textContent = `${storeInfo.branchName}점`;
        box.append(title);
        content.append(box);

        var position = new kakao.maps.LatLng(storeInfo.lat, storeInfo.lng);
        var customOverlay = new kakao.maps.CustomOverlay({
          map: this.map,
          position: position,
          content: content,
          yAnchor: 1,
        });
        customOverlay.setMap(this.map);
      });
    },
  },
  

  watch: {
    storeInfoList: function (nv) {
      this.removeMarker();
      if (!nv) return;
      this.setMarkers(nv);
    },
  },
};
</script>

<style>
.customoverlay {
  position: relative;
  bottom: 85px;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  float: left;
}
.customoverlay:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.customoverlay div {
  display: block;
  text-decoration: none;
  color: #000;
  text-align: center;
  border-radius: 6px;
  font-size: 14px;
  font-weight: bold;
  overflow: hidden;
  background: #239347;
  background: #239347
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.customoverlay .title {
  display: block;
  text-align: center;
  background: #fff;
  margin-right: 35px;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
}
.customoverlay:after {
  content: "";
  position: absolute;
  margin-left: -12px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
</style>
