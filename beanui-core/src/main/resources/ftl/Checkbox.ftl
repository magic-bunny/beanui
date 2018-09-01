<#macro createCheckbox formId,id,element>
<el-checkbox v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}"</#if></#list>>
<#if element.content.text=''>${element.id}<#else>${element.content.text}</#if>
</el-checkbox>
</#macro>