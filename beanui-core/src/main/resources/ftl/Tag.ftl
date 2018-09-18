<#macro createTag formId, scope, element>
<@createBadge element=element>
<el-tag <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
${r'{{'}${scope}.${element.id}${r'}}'}
</el-tag>
</@createBadge>
</#macro>