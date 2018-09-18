<#macro createButton formId, scope, element>
<@createBadge element=element>
<el-button <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
    ${element.content.text}
</el-button>
</@createBadge>
</#macro>