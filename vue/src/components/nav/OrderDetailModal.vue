<template>
  <v-dialog scrollable :value="openMo" @input="openMo = $event">
    <v-card height="680">
      <v-card-title class="pt-3 pl-4">
        <v-row>
          <v-col>
          </v-col>
          <v-spacer></v-spacer>
          <v-col align="right">
            <v-btn class="c_btn pa-0" text @click.stop="openMo = false">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-col>
        </v-row>
      </v-card-title>
      <div class="date" style="width: 90%; margin:auto;">
        {{date}}
      </div>
      <div class="store">

      </div>

      <v-card-text>
        <div v-for="(menu, index) in orderMenu.combinationList" :key="index" class="selector">
          <order-de  :menu="menu"></order-de>
          <input type="radio" name="order" :value="index">
        </div>
        
      </v-card-text>
      <v-card-actions class="pl-5 pb-5">
        <div style="font-size: 18px; font-weight: 900">
           {{ orderMenu.orderPrice }}원
        </div>
        <v-spacer></v-spacer>
        <v-btn class="main_btn" width="180" elevation="0" rounded @click.prevent="goOrderCombi"
          >주문하러 가기</v-btn
        >
      </v-card-actions>
    </v-card>
    
  </v-dialog>
</template>

<script>
import { mapActions } from 'vuex';
import OrderDe from './OrderDe.vue';
import swal from 'sweetalert';

export default {
  components: { OrderDe },

  name: "OrderDetailModal",

  props: {
    value: {
      type: Boolean,
      required: true,
    },
    orderMenu: Object,
    date:String
  },

  computed: {
    openMo: {
      get() {
        return this.value;
      },
      set(value) {
        this.$emit("input", value);
      },
    },
  },

  watch: {
    openMo () {
      if (!this.openMo) {
        var radio = document.querySelector('input[type=radio][name=order]:checked');
        if (radio !== null) {
          radio.checked=false
        }
      }
    }
  },

  methods: {
    ...mapActions(['selectMenu', 'selectBread', 'selectCheese', 'selectVege', 'selectSauce',
    'selectMoreMeat', 'selectMore', 'selectMoreCheese']),
    goOrderCombi() {  
      var radio = document.querySelector('input[type=radio][name=order]:checked');
      if (radio === null) {
        swal('하나를 선택해주세요')
      } else {
        this.selectMenu(this.orderMenu.combinationList[radio.value].menu)
        this.orderMenu.combinationList[radio.value].ingredients.forEach(ingredient => {
          if (ingredient.category === '빵') {
            this.selectBread(ingredient)
          } else if (ingredient.category === '치즈') {
            this.selectCheese(ingredient)
          } else if (ingredient.category === '야채') {
            this.selectVege(ingredient)
          } else if (ingredient.category === '소스') {
            this.selectSauce(ingredient)
          } else if (ingredient.category === '미트추가') {
            this.selectMoreMeat(ingredient)
          } else if (ingredient.category === '추가') {
            this.selectMore(ingredient)
          } else if (ingredient.category === '치즈추가') {
            this.selectMoreCheese(ingredient)
          } 
        }) 


        this.$router.push({name:'orderone'})
        // this.orderMenu.combinationList[radio.value].ingrdients
      }
  }, 

  unmounted () {

  }

    
  }
}
</script>

<style scoped>
.c_btn {
  min-width: 0px !important;
}
.selector {
  display: flex;
}
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
