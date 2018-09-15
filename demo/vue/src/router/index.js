
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
        path: '/',
        name: 'test',
        component: Layout
        ,redirect: 
        ''
,
        children: [
            {
                path: '',
                component:() => import('@/views/beanui/demo.view.TestComponent'),
                name: 'test',
                meta: {
                  title: 'test'
                  ,icon: 'star'
                }
            }
        ]
    }
    ,
    {
        path: '/abcde',
        name: 'abcde',
        component: Layout
        ,redirect:         '/abcde/index'
        ,
        children: [
            {
                path: 'index',
                component:() => import('@/views/beanui/demo.view.ABCDComponent'),
                name: 'abcde',
                meta: {
                  title: 'abcde'
                  ,icon: 'example'
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
        path: 'dynamic-table',
        name: 'Dynamic Table'
        ,component: () => import('@/views/beanui/demo.view.DynamicTableComponent')
        ,meta: {
          title: 'Dynamic Table'
          
        }
        
      }
      ,
      {
        path: 'drag-table',
        name: 'Drag Table'
        ,component: () => import('@/views/beanui/demo.view.DragTableComponent')
        ,meta: {
          title: 'Drag Table'
          
        }
        
      }
      ,
      {
        path: 'inline-edit-table',
        name: 'Inline Edit'
        ,component: () => import('@/views/beanui/demo.view.InlineEditTableComponent')
        ,meta: {
          title: 'Inline Edit'
          
        }
        
      }
      ,
      {
        path: 'complex-table',
        name: 'Complex Table'
        ,component: () => import('@/views/beanui/demo.view.ComplexTableComponent')
        ,meta: {
          title: 'Complex Table'
          
        }
        
      }
      
]

    }
    
]