
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
    path: '/authredirect',
    component: () => import('@/views/login/authredirect'),
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
        path: '/login2',
        component:() => import('@/views/beanui/demo.view.LoginComponent'),
        hidden: true
    }
    ,
    {
        path: '/',
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
                  ,icon: 'example'
                }
            }
        ]
    }
    ,
    {
        path: '/abcde',
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
        path: '/newnewnew',
        component: Layout
        ,redirect:         '/newnewnew/index'
        ,
        children: [
            {
                path: 'index',
                component:() => import('@/views/beanui/demo.view.NewComponent'),
                name: 'newnewnew',
                meta: {
                  title: 'newnewnew'
                  ,icon: 'example'
                }
            }
        ]
    }
    ,
    {
        path: '/example',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'example'
          ,icon: 'example'
        }
        ,children: [
      {
        path: 'demo1',
        name: 'demo1'
        ,component: () => import('@/views/beanui/demo.view.TestComponent')
        ,meta: {
          title: 'demo1'
          ,icon: 'star'
        }
        
      }
      ,
      {
        path: 'demo2',
        name: 'demo2'
        ,component: () => import('@/views/beanui/demo.view.ABCDComponent')
        ,meta: {
          title: 'demo2'
          ,icon: 'lock'
        }
        
      }
      ,
      {
        path: 'demo3',
        name: 'demo3'
        ,component: () => import('@/views/beanui/demo.view.NewComponent')
        ,meta: {
          title: 'demo3'
          ,icon: 'eye'
        }
        
      }
      
]

    }
    
]