<#macro createAutocomplete formId,id,element>
<el-autocomplete v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>></el-autocomplete>
</#macro>