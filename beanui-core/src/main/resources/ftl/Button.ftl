<#macro createButton formId, scope, element>
<@createBadge scope=scope element=element>
<el-button <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    ${element.content.text}
</el-button>
</@createBadge>
</#macro>