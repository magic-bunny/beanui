<#macro createElement formId,id,element>
<${element.tag} <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
${r'{{'}${formId}.${id}${r'}}'}
</${element.tag}>
</#macro>