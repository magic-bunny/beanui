
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/views/layout/Layout'

export const constantRouterMap = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/errorPage/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/errorPage/401'),
    hidden: true
  }
]

export default new Router({
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
    {
        path: '',
        name: '',
        component:() => import('@/views/beanui/demo.view.ABCDComponent'),
        hidden: true
    }
    ,
    {
        path: '/complex-table',
        name: '/complex-table',
        component:() => import('@/views/beanui/demo.view.ComplexTableComponent'),
        hidden: true
    }
    ,
    {
        path: '/drag-tabel',
        name: '/drag-tabel',
        component:() => import('@/views/beanui/demo.view.DragTableComponent'),
        hidden: true
    }
    ,
    {
        path: '/dynamic-table',
        name: '/dynamic-table',
        component:() => import('@/views/beanui/demo.view.DynamicTableComponent'),
        hidden: true
    }
    ,
    {
        path: '/inline-edit-table',
        name: '/inline-edit-table',
        component:() => import('@/views/beanui/demo.view.InlineEditTableComponent'),
        hidden: true
    }
    ,
    {
        path: '/test',
        name: '/test',
        component:() => import('@/views/beanui/demo.view.TestComponent'),
        hidden: true
    }
    
]