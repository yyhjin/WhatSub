<template>
  <div class="body">
    <div class="top">
      꿀조합 찜 목록
    </div>
    <sand-big-list></sand-big-list>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import SandBigList from '../../components/common/SandBigList.vue'
export default {
  components: { SandBigList },
  name: 'ZzimView',

  computed: {
    ...mapGetters(['currentUser', ])
  },

  methods: {
    ...mapActions(['fetchDibList']),
  },

  mounted () {
    this.fetchDibList(this.currentUser.username)
  }
}
</script>

<style scoped>
.body {
  padding-top: 46px;
}
.top {
  height: 46px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  background-color: white;
}

</style>