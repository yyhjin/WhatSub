<template>
  <div class="bill">
    <div class="orderBox">
      <div class="menuCheck">
        <div class="name">
          {{ bas.menu.menu_name}}
        </div>
        <div class="cntPrice">
          <div class="cnt">
            수량:{{ bas.cnt }}개
          </div>
          <div class="price">
            {{ bas.price * bas.cnt }}원
          </div>
        </div>
      </div>
      <div class="otherCheck">
        <div class="name">
          빵/치즈/소스/야채/추가
        </div>
        <div class="content">
          <div class="bread">
            {{ bas.bread.name }} {{ bas.size }}
          </div>
          <div class="cheese">
            {{ bas.cheese.name }}
          </div>
          <div class="vege">
            {{ vege }}
          </div>
          <div class="sauce">
            {{ sauce }}
          </div>
          <div class="more">
            {{ more }}
          </div>
        </div>
      </div>
    </div> 
  </div>
</template>

<script>
// import { mapGetters } from 'vuex';
export default {
  name: "OrderDetail",

  props: {
    bas:Object
  },

  computed: {
    vege () {
      let vege = ''
      this.bas.vege.forEach(v => vege += v.name + ',')
      vege = vege.slice(0, -1)
      return vege
    },
    sauce () {
      let sauce = ''
      this.bas.sauce.forEach(v => sauce += v.name + ',')
      sauce = sauce.slice(0, -1)
      return sauce
    },
    more () {
      let more = ''
      this.bas.more.forEach(v => more += v.name + ',')
      try {
        more += this.bas.moremeat.name
      }
      catch(err) {
        console.log(err)
      }
      return more
    }
  }

  
};
</script>

<style>
.bill {
  
  width: 90%;
  border: 1px solid;
  margin: auto;
  margin-bottom: 10px;
  
}
.menuCheck {
  border-bottom: 1px solid;
}
.orderBox {
  width: 100%;
  margin: auto;
  background-color: white;
}
.cntPrice {
  display: flex;
  flex-direction: row;
  justify-content: space-around
}
.content {
  width: 90%;
}
</style>
