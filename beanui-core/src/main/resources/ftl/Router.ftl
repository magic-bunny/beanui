<#macro createRouter children>
[
    <#list children as r>
      {
        path: '${r.path!r.title}',
        name: '${r.title!r.path}'
        <#if r.component??>,component: () => import('@/views/beanui/${r.component}')</#if>
        ,meta: {
          title: '${r.title!r.path}'
          <#if r.icon??>,icon: '${r.icon}'</#if>
        }
        <#if r.children??>,children:<@createRouter children=r.children/></#if>
      }
      <#if r_has_next>,</#if>
    </#list>
]
</#macro>

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
    <#list router as r>
    {
        path: '/${r.path!r.title}',
        name: '${r.title!r.path}',
        <#if r.menu=false>
        component:() => import('@/views/beanui/${r.component}'),
        hidden: true
        <#else>
        component: Layout
        <#if r.component??>
        ,redirect: <#if r.path??>
        <#if r.path=''>''<#else>'/${r.path!r.title}/index'</#if>
        <#else>
        '/${r.path!r.title}/index'
        </#if>,
        children: [
            {
                path: <#if r.path??><#if r.path=''>''<#else>'index'</#if><#else>'index'</#if>,
                component:() => import('@/views/beanui/${r.component}'),
                name: '${r.title!r.path}',
                meta: {
                  title: '${r.title!r.path}'
                  <#if r.icon??>,icon: '${r.icon}'</#if>
                }
            }
        ]
        <#else>
        ,alwaysShow: true,
        meta: {
          title: '${r.title!r.path}'
          <#if r.icon??>,icon: '${r.icon}'</#if>
        }
        <#if r.children??>,children: <@createRouter children=r.children/></#if>
        </#if>
        </#if>
    }
    <#if r_has_next>,</#if>
    </#list>
]