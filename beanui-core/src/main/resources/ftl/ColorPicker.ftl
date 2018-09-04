<#macro createProgress formId,id,element>
<el-progress v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>></el-progress>
</#macro>