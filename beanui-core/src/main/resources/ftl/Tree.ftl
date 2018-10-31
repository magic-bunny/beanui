<#macro createTree formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-tree <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/> :data="${scope}.${element.id}">
</el-tree>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>