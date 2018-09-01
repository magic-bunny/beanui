<#macro createSwitch formId,id,element>
<el-switch v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-switch>
</#macro>