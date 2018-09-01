<#include "/Form.ftl">

<template>
<div class="app-container">
<#list elements as object>
    <#if object.type="Form">
        <@createForm id=object.id children=object.children/>
    </#if>
</#list>
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
            method: "${event.method}",
            data
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
        <#list datas?keys as key>
            <#if key_has_next>
                ${key}: ${datas[key]},
            <#else>
                ${key}: ${datas[key]}
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