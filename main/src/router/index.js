import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Emps',
      name: 'Emps',
      component: ()=>import("../components/Emps")
    }
  ]
})
