<template>
  <div>
    <store-map
      :lat="userLocation.lat"
      :lng="userLocation.lng"
      :type="0"
      :storeInfoList="storeInfoList"
      @store-info="getStoreInfo"
    />
  </div>
</template>

<script>
import StoreMap from "../common/StoreMap.vue";
import axios from "axios";
import swal from 'sweetalert';
export default {
  components: { StoreMap },
  name: "SearchStoreMap",

  data() {
    return {
      userLocation: { lat: 37.5016, lng: 127.036 },
      storeInfoList: [],
    };
  },

  mounted() {
    this.getUserLocation();
  },

  methods: {
    getUserLocation() {
      if (!navigator.geolocation) {
        console.log("위치 정보가 지원되지 않습니다.");
        return;
      }
      navigator.geolocation.watchPosition(({ coords }) => {
        this.userLocation.lat = coords.latitude;
        this.userLocation.lng = coords.longitude;
      });
    },
    async getStoreInfo(sw, ne) {
      try {
        const data = await axios.get(
          `https://j7a105.p.ssafy.io/api/v1/order/store`,
          {
            params: {
              minlat: sw.Ma,
              minlng: sw.La,
              maxlat: ne.Ma,
              maxlng: ne.La,
            },
          }
        );
        this.storeInfoList = data.data.data;
      } catch (e) {
        swal("지점 정보를 불러올 수 없습니다.");
      }
    },
  },
};
</script>

<style></style>
