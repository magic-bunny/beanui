<#macro createProgress formId, scope, element>
<el-progress v-model="${scope}.${element.id}"
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if></#list>
<#if element.events??>
<#list element.events as event>
@${event.type}="${event.type}_${formId}_${element.id}"
</#list>
</#if>>
</el-progress>
</#macro>