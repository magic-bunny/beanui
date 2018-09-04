<#macro createTag formId,id,element>
<el-tag v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>标签二</el-tag>
</#macro>