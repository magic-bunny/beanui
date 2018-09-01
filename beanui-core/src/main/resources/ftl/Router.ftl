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
  },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'dashboard',
        meta: { title: 'dashboard', icon: 'dashboard', noCache: true }
      }
    ]
  },
  {
    path: '/documentation',
    component: Layout,
    redirect: '/documentation/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/documentation/index'),
        name: 'documentation',
        meta: { title: 'documentation', icon: 'documentation', noCache: true }
      }
    ]
  },
  {
    path: '/guide',
    component: Layout,
    redirect: '/guide/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/guide/index'),
        name: 'guide',
        meta: { title: 'guide', icon: 'guide', noCache: true }
      }
    ]
  }
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
    <#list router as r>
    {
        path: '/${r.path!r.title}',
        component: Layout,
        alwaysShow: true,
        meta: {
          title: '${r.title!r.path}'
          <#if r.icon??>,icon: '${r.icon}'</#if>
        }
        <#if r.children??>,children: <@createRouter children=r.children/></#if>
    }
    <#if r_has_next>,</#if>
    </#list>
]