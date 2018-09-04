<#macro createDateTimePicker formId,id,element>
<el-date-picker v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-date-picker>
</#macro>