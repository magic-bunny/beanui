<#macro createTransfer formId,id,element>
<el-transfer v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-transfer>
</#macro>