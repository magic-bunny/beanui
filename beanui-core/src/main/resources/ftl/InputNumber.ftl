<#macro createInputNumber formId,id,element>
<el-input-number v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-input-number>
</#macro>