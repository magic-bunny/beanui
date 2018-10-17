<#macro createButton formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-button <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    ${element.content.text}
</el-button>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>