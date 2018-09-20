<#macro createTag formId, scope, element>
<@createBadge scope=scope element=element>
<el-tag <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
${r'{{'}${scope}.${element.id}${r'}}'}
</el-tag>
</@createBadge>
</#macro>