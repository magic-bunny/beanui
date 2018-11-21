
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
        path: '/layout',
        name: 'Layout',
        component: Layout
        ,alwaysShow: true,
        meta: {
          title: 'Layout'
          ,icon: 'example'
          
        }
        ,children: [
      {
        path: '/card',
        name: 'Card'
        ,component: () => import('@/views/beanui/demo.view.layout.card.CardComponent')
        ,meta: {
          title: 'Card'
          
          
        }
        
      }
      ,
      {
        path: '/tabs',
        name: 'Tabs'
        ,component: () => import('@/views/beanui/demo.view.layout.tabs.TabsComponent')
        ,meta: {
          title: 'Tabs'
          
          
        }
        
      }
      ,
      {
        path: '/carousel',
        name: 'Carousel'
        ,component: () => import('@/views/beanui/demo.view.layout.carousel.CarouselComponent')
        ,meta: {
          title: 'Carousel'
          
          
        }
        
      }
      ,
      {
        path: '/collapse',
        name: 'Collapse'
        ,component: () => import('@/views/beanui/demo.view.layout.collapse.CollapseComponent')
        ,meta: {
          title: 'Collapse'
          
          
        }
        
      }
      ,
      {
        path: '/test',
        name: 'Test'
        ,component: () => import('@/views/beanui/demo.view.layout.test2.ABCDComponent')
        ,meta: {
          title: 'Test'
          
          
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