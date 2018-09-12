<#macro createTag formId,id,element>
<el-tag <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
${r'{{'}${formId}.${id}${r'}}'}
</el-tag>
</#macro>