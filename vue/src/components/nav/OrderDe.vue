<template>
  <div class="bill">
    <div class="orderBox">
      <div class="menuCheck">
        <div class="name">
          {{ menu.menu.menu_name}}
        </div>
        <div class="cntPrice">
          <div class="cnt">
            수량:{{ menu.count }}개
          </div>
          
        </div>
      </div>
      <div class="otherCheck">
        <div class="name">
          빵/치즈/소스/야채/추가
        </div>
        <div class="content">
          <div class="bread">
            {{ menu.ingredients[0].name }} 
          </div>
          <div class="cheese">
            {{ menu.ingredients[1].name }}
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
export default {
  name: 'OrderDe',

  props:{
    menu:Object
  },

  computed: {
    vege () {
      let vege = ''
      this.menu.ingredients.forEach(each => {
        if (each.category === "야채") {
          vege += each.name + ', '
        }
      })
      vege = vege.slice(0, -2)
      return vege
    },
    sauce () {
      let sauce = ''
      this.menu.ingredients.forEach(each => {
        if (each.category === "소스") {
          sauce += each.name + ', '
        }
      })
      sauce = sauce.slice(0, -2)
      return sauce
    },
    more () {
      let more = ''
      this.menu.ingredients.forEach(each => {
        if (each.category === "추가" || each.category === "미트추가") {
          more += each.name + ', '
        }
      })
      
      return more.slice(0, -2)
    }
  }
}
</script>

<style scoped>
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