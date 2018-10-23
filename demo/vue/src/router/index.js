
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/views/layout/Layout'

export const constantRouterMap = [
  {
    path: '/login',
    component: () => import('@/views/beanui/demo.view.LoginComponent'),
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
        name: 'home',
        component: Layout
        ,redirect: '/index',
        children: [
            {
                path: 'index',
                component:() => import('@/views/beanui/demo.view.home.Dashboard'),
                name: 'home',
                meta: {
                  title: 'home'
                  ,icon: 'star'
                  
                }
            }
        ]
    }
    ,
    {
        path: '/test',
        name: 'test',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'test'
          ,icon: 'example'
          
        }
        ,children: [
      {
        path: '/test1',
        name: 'test1'
        ,component: () => import('@/views/beanui/demo.view.test.test1.TestComponent')
        ,meta: {
          title: 'test1'
          
          
        }
        
      }
      ,
      {
        path: '/test2',
        name: 'test2'
        ,component: () => import('@/views/beanui/demo.view.test.test2.ABCDComponent')
        ,meta: {
          title: 'test2'
          
          
        }
        
      }
      
]

    }
    ,
    {
        path: '/table',
        name: 'Table',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'Table'
          ,icon: 'table'
          
        }
        ,children: [
      {
        path: '/dynamic-table',
        name: 'Dynamic Table'
        ,component: () => import('@/views/beanui/demo.view.table.dynamic.DynamicTableComponent')
        ,meta: {
          title: 'Dynamic Table'
          
          ,roles: ['admin']
        }
        
      }
      ,
      {
        path: 'drag-table',
        name: 'Drag Table'
        ,component: () => import('@/views/beanui/demo.view.table.drag.DragTableComponent')
        ,meta: {
          title: 'Drag Table'
          
          
        }
        
      }
      ,
      {
        path: '/inline-edit-table',
        name: 'Inline Edit'
        ,component: () => import('@/views/beanui/demo.view.table.inline.InlineEditTableComponent')
        ,meta: {
          title: 'Inline Edit'
          
          
        }
        
      }
      ,
      {
        path: '/complex-table',
        name: 'Complex Table'
        ,component: () => import('@/views/beanui/demo.view.table.complex.ComplexTableComponent')
        ,meta: {
          title: 'Complex Table'
          
          
        }
        
      }
      
]

    }
    
]