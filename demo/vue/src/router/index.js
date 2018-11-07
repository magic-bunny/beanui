
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
        name: 'Home',
        component: Layout
        ,redirect: '/index',
        children: [
            {
                path: 'index',
                component:() => import('@/views/beanui/demo.view.home.Dashboard'),
                name: 'Home',
                meta: {
                  title: 'Home'
                  ,icon: 'star'
                  
                }
            }
        ]
    }
    ,
    {
        path: '/test',
        name: 'Test',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'Test'
          ,icon: 'example'
          
        }
        ,children: [
      {
        path: '/test1',
        name: 'Test1'
        ,component: () => import('@/views/beanui/demo.view.test.test1.TestComponent')
        ,meta: {
          title: 'Test1'
          
          
        }
        
      }
      ,
      {
        path: '/test2',
        name: 'Test2'
        ,component: () => import('@/views/beanui/demo.view.test.test2.ABCDComponent')
        ,meta: {
          title: 'Test2'
          
          
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
    ,
    {
        path: '/component',
        name: 'Component',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'Component'
          ,icon: 'component'
          
        }
        ,children: [
      {
        path: '/word-editor',
        name: 'Word Editor'
        ,component: () => import('@/views/beanui/demo.view.component.WordEditorComponent')
        ,meta: {
          title: 'Word Editor'
          
          
        }
        
      }
      ,
      {
        path: '/json-editor',
        name: 'JSON Editor'
        ,component: () => import('@/views/beanui/demo.view.component.JsonEditorComponent')
        ,meta: {
          title: 'JSON Editor'
          
          
        }
        
      }
      ,
      {
        path: '/markdown-editor',
        name: 'Markdown Editor'
        ,component: () => import('@/views/beanui/demo.view.component.MarkdownEditorComponent')
        ,meta: {
          title: 'Markdown Editor'
          
          
        }
        
      }
      
]

    }
    
]