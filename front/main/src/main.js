
import Vue from 'vue'
import App from './App'

import router from './router'


import lodash from 'lodash'

import ElementUI from 'element-ui'
//分割线没反应
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/theme/index.css'


import '@/assets/icon/iconfont.css'
import axios from 'axios'
import Qs from 'qs'
//QS是axios库中带的，不需要我们再npm安装一个

Vue.prototype.axios = axios;
Vue.prototype.qs = Qs;


Vue.config.productionTip = false

Vue.use(ElementUI)

Object.defineProperty(Vue.prototype, '$_', { value: lodash })

//runtime

new Vue({
  router,
  render: h => h(App)
}).$mount("#app")

