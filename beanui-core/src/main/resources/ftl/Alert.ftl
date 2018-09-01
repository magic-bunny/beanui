<#macro createAlert formId,id,element>
<el-alert v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}"</#if></#list> show-icon>
</el-alert>
</#macro>