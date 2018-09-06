<#include "/Form.ftl">

<template>
<div class="${component.id}-container">
<div class="${component.id}-inner-container">
<#list elements as object>
    <#if object.type="Form">
        <@createForm id=object.id children=object.children/>
    </#if>
</#list>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    <#list elements as form>
    <#list form.events as event>
    ${event.type}: function() {
        var data = this.${form.id};
        request({
            url: "${event.path}",
            method: "${event.method}"
            <#if event.method='post'>,data</#if>
        }).then(res => {
            <#if event.method=="get">
            this.${form.id} = res.data;
            </#if>
        }).catch(err => {

        })
      },
    </#list>
    </#list>
    data() {
      return {
        <#list elements as form>
            <#if form_has_next>
                ${form.id}: {},
            <#else>
                ${form.id}: {}
            </#if>
        </#list>
      }
    },
    methods: {
    <#list elements as form>
        <#list form.children as formItem>
            <#list formItem.children as o>
            <#list o.events as event>
            ${event.type}_${o.id}() {
                var data = this.${form.id};
                request({
                    url: "${event.path}",
                    method: "${event.method}",
                    data
                }).then(res => {
                    <#if event.method=="get">
                    this.${form.id} = res.data;
                    </#if>
                }).catch(err => {

                })
              }
            <#if form_has_next>
            ,
            </#if>
            </#list>
        </#list>
        </#list>
    </#list>
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .${component.id}-container {
        <#if component.content.background!=''>
        background-color: ${component.content.background};
        </#if>
        <#if component.content.center!=''>
        position: fixed;
        height: 100%;
        width: 100%;
        </#if>
    }
    .${component.id}-inner-container {
        margin: 20px;
        <#if component.content.width!=''>
        width: ${component.content.width};
        </#if>
        <#if component.content.center!=''>
        margin: 120px auto;
        position: absolute;
        left: 0;
        right: 0;
        </#if>
    }
</style>