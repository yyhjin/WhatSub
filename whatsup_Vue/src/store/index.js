import Vue from 'vue'
import Vuex from 'vuex'

import accounts from './modules/accounts';
import combination from './modules/combination';
import common from './modules/common';

Vue.use(Vuex)

export default new Vuex.Store({

  modules: {
    accounts, combination, common
  }
  
})
