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
<#include "/Link.ftl">
<#include "/Tooltip.ftl">
<#include "/Breadcrumb.ftl">
<#include "/Card.ftl">
<#include "/Carousel.ftl">
<#include "/Subplot.ftl">
<#include "/Steps.ftl">
<#include "/Dropdown.ftl">
<#include "/Cascader.ftl">
<#include "/Tree.ftl">
<#include "/Iframe.ftl">

<#macro createAttrs scope, content>
<#list content?keys as key><#if content[key]!='' && key!='label' && key!=':label' && key!='tag' && key!='text'>
<#if key?starts_with(':') && !content[key]?contains('.') && !content[key]?starts_with('[') && !content[key]?starts_with('{')>
${key}="${scope}.${content[key]}"
<#else>
${key}="${content[key]}"
</#if>
</#if></#list>
</#macro>

<#macro createEvents formId, element><#if element.events??><#list element.events as event><#if event.type!='placeholder'> @${event.type}="${event.type}_${formId}_${element.id}"</#if></#list></#if></#macro>

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

<#macro createReturnData form>
${form.id}_loading: false,
${form.id}: ${form.init}
<#if form.content[':rules']??>
,${form.content[':rules']}: {
<#list form.children as object>
    <#if object.rules??>${object.id}: ${object.rules}<#if object_has_next>,</#if></#if>
</#list>
}
</#if>
</#macro>

<#macro createEventMethods formId, element, isFirst>
<#if element??>
<#if element.events??>
<#if element.events?size gt 0>
    <#if isFirst=false>,</#if>
    <#if element.type='Table'>
    current_change_${formId}_${element.id}(val) {
        this.${formId}.${element.id} = [val];
    },
    selection_change__${formId}_${element.id}(val) {
        this.${formId}.${element.id} = val;
    },
    </#if>
    <#local isFirst=false>
    <#list element.events as event>
    ${event.type}_${formId}_${element.id}() {
        <#if event.type!='placeholder'>
        <#if event.requestForm!=''>
        var data = this.${event.requestForm?substring(1)};
        <#else>
        var data = this.${formId};
        </#if>
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.${formId}_loading = true;
            request({
                url: "${event.path}" + (requestParams=="?"?"":requestParams),
                method: "${event.method}"
                <#if event.method=="post">
                ,data
                </#if>
            }).then(res => {
                <#if event.responseForm!=''>
                self.${event.responseForm?substring(1)} = res.data;
                <#else>
                self.${formId} = res.data;
                </#if>
                self.${formId}_loading = false;
                <#if event.message!=''>
                self.$message({
                    type: 'success',
                    message: <#if event.message?starts_with('$t')>this.${event.message}<#else>'${event.message}'</#if>
                  });
                </#if>
            }).catch(err => {
                self.${formId}_loading = false;
            });
        }
        <#if event.confirmMessage!=''>
        this.$confirm(<#if event.confirmMessage?starts_with('$t')>this.${event.confirmMessage}<#else>'${event.confirmMessage}'</#if>, 'Confirm', {
          confirmButtonText: 'Ok',
          cancelButtonText: 'Cancel',
          type: 'warning'
        }).then(() => {
          submitRequest(this);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: 'Cancel this option!'
          });
          this.${formId}_loading = false;
        });
        <#else>
        submitRequest(this);
        </#if>
        </#if>
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
    <@createSubplot values=object.subplot>
    <#if object.type="Form">
        <@createForm element=object/>
    </#if>
    <#if object.type='Dialog'>
        <@createDialog element=object/>
    </#if>
    <#if object.type='Card'>
        <@createCard element=object>
        <#list object.children as child>
        <#if child.type="Form">
        <@createForm element=child/>
        </#if>
        </#list>
        </@createCard>
    </#if>
    <#if object.type='Carousel'>
        <@createCarousel element=object/>
    </#if>
    </@createSubplot>
</#list>
<el-tooltip placement="top" content="Back to top">
  <back-to-top transitionName="fade" :customStyle="myBackToTopStyle" :visibilityHeight="300" :backPosition="50"></back-to-top>
</el-tooltip>
</div>
</div>
</template>
<script>
import request from '@/utils/request'
<#list childComponents as childComponent>
import ${childComponent.name} from '${childComponent.path}'
</#list>

  export default {
    created: function() {
        <#list component.children as element>
            <@createCreatedEventMethods formId=element.id element=element/>
        </#list>
    },
    components: {
    <#list childComponents as childComponent>
        ${childComponent.name}<#if childComponent_has_next>,</#if>
    </#list>
    },
    data() {
      return {
        myBackToTopStyle: {
            right: '50px',
            bottom: '50px',
            width: '40px',
            height: '40px',
            'border-radius': '4px',
            'line-height': '45px',
            background: '#e7eaf1'
        },
        <#list component.children as form>
            <#if form.type='Dialog' || form.type='Card' || form.type='Carousel'>
                <@createReturnData form=form.children[0]/>
            <#else>
                <@createReturnData form=form/>
            </#if><#if form_has_next>,</#if>
        </#list>
      }
    },
    methods: {
    <#list component.children as element>
        <#if element.type='Dialog' || element.type='Card' || element.type='Carousel'>
            <@createEventMethods formId=element.children[0].id element=element.children[0] isFirst=true/>
        <#else>
            <@createEventMethods formId=element.id element=element isFirst=true/>
        </#if><#if element_has_next>,</#if>
    </#list>
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .${component.id}-container {

    }
    .${component.id}-inner-container {
        margin: 20px;
    }
</style>