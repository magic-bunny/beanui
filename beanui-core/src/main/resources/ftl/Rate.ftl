<#macro createRate formId,id,element>
<el-rate v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-rate>
</#macro>