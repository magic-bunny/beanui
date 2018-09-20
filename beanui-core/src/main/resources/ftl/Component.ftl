<#include "/Form.ftl">
<#include "/FormItem.ftl">
<#include "/Element.ftl">
<#include "/Select.ftl">
<#include "/Button.ftl">
<#include "/Table.ftl">
<#include "/CheckboxGroup.ftl">
<#include "/CheckboxButtonGroup.ftl">
<#include "/Upload.ftl">
<#include "/Tag.ftl">
<#include "/Pagination.ftl">
<#include "/RadioGroup.ftl">
<#include "/RadioButtonGroup.ftl">
<#include "/I18N.ftl">
<#include "/Dialog.ftl">
<#include "/Badge.ftl">
<#include "/Breadcrumb.ftl">
<#include "/Card.ftl">
<#include "/Carousel.ftl">

<#macro createAttrs scope, content>
<#list content?keys as key><#if content[key]!='' && key!='label' && key!=':label' && key!='tag' && key!='text'>
<#if key?starts_with(':') && !content[key]?contains('.') && !content[key]?starts_with('[') && !content[key]?starts_with('{')>
${key}="${scope}.${content[key]}"
<#else>
${key}="${content[key]}"
</#if>
</#if></#list>
</#macro>

<#macro createEvents formId, element>
<#if element.events??><#list element.events as event>@${event.type}="${event.type}_${formId}_${element.id}" </#list></#if>
</#macro>

<#macro createCreatedEventMethods formId, element>
<#if element??>
<#if element.events??>
<#if element.events?size gt 0>
    <#list element.events as event>
    <#if event.type='created'>
    this.${event.type}_${formId}_${element.id}();
    </#if>
    </#list>
</#if>
</#if>
<#if element.children??>
<#list element.children as object>
<@createCreatedEventMethods formId=formId element=object/>
</#list>
</#if>
</#if>
</#macro>

<#macro createEventMethods formId, element, isFirst>
<#if element??>
<#if element.events??>
<#if element.events?size gt 0>
    <#if isFirst=false>,</#if>
    <#local isFirst=false>
    <#list element.events as event>
    ${event.type}_${formId}_${element.id}() {
        this.${formId}_loading = true;
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
            this.${formId}_loading = false;
        }).catch(err => {
            this.${formId}_loading = false;
        })
      }
    <#if event_has_next>,</#if>
    </#list>
</#if>
</#if>

<#if element.children??>
<#list element.children as object><@createEventMethods formId=formId element=object isFirst=isFirst/></#list>
</#if>

</#if>
</#macro>

<template>
<div class="${component.id}-container">
<div class="${component.id}-inner-container">
<#list component.children as object>
    <#if object.type="Form">
        <@createForm element=object/>
    </#if>
    <#if object.type='Dialog'>
        <@createDialog element=object/>
    </#if>
    <#if object.type='Card'>
        <@createCard element=object/>
    </#if>
    <#if object.type='Carousel'>
        <@createCarousel element=object/>
    </#if>
</#list>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
        <#list component.children as element>
            <@createCreatedEventMethods formId=element.id element=element/>
        </#list>
        },
    data() {
      return {
        <#list component.children as form>
            <#if form.type='Dialog'>
                <#assign form=form.children[0]>
            </#if>
            ${form.id}_loading: false,
            ${form.id}: {}
            <#if form.content[':rules']??>
            ,${form.content[':rules']}: {
            <#list form.children as object>
                <#if object.rules??>${object.id}: ${object.rules}<#if object_has_next>,</#if></#if>
            </#list>
            }
            </#if>
            <#if form_has_next>
            ,
            </#if>
        </#list>
      }
    },
    methods: {
    <#list component.children as element>
        <#if element.type='Dialog'>
            <#assign element=element.children[0]>
        </#if>
        <@createEventMethods formId=element.id element=element isFirst=true/>
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