<#include "/Form.ftl">
<#include "/Dialog.ftl">

<#macro buildCreatedEvent formId, element>
<#if element??>
<#if element.events??>
<#if element.events?size gt 0>
    <#list element.events as event>
    <#if event.type='created'>
    this.${event.type}_${element.id}();
    </#if>
    </#list>
</#if>
</#if>

<#if element.children??>
<#list element.children as object>
<@buildCreatedEvent formId=formId element=object/>
</#list>
</#if>

</#if>
</#macro>

<#macro buildEvent formId, element, isFirst>
<#if element??>

<#if element.events??>
<#if element.events?size gt 0>
    <#if isFirst=false>,</#if>
    <#local isFirst=false>
    <#list element.events as event>
    ${event.type}_${element.id}() {
        request({
            url: "${event.path}",
            method: "${event.method}"
            <#if event.method=="post">
            <#if event.requestForm!=''>
            ,this.${event.requestForm?substring(1)};
            <#else>
            ,this.${formId};
            </#if>
            </#if>
        }).then(res => {
            <#if event.responseForm!=''>
            this.${event.responseForm?substring(1)} = res.data;
            <#else>
            this.${formId} = res.data;
            </#if>
        }).catch(err => {

        })
      }
    <#if event_has_next>,</#if>
    </#list>
</#if>
</#if>

<#if element.children??>
<#list element.children as object><@buildEvent formId=formId element=object isFirst=isFirst/></#list>
</#if>

</#if>
</#macro>

<template>
<div class="${component.id}-container">
<div class="${component.id}-inner-container">
<#list elements as object>
    <#if object.type="Form">
        <@createForm element=object/>
    </#if>
    <#if object.type='Dialog'>
        <@createDialog element=object/>
    </#if>
</#list>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
        <#list elements as element>
            <@buildCreatedEvent formId=element.id element=element/>
        </#list>
        },
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
    <#list elements as element>
        <#if element.type='Dialog'>
            <#assign element=element.children[0]>
        </#if>
        <@buildEvent formId=element.id element=element isFirst=true/>
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