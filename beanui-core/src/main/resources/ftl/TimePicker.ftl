<#macro createTimePicker formId,id,element>
<el-time-select v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-time-select>
</#macro>