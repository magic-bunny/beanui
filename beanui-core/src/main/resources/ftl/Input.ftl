<#macro createInput formId,id,element>
<el-input v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-input>
</#macro>