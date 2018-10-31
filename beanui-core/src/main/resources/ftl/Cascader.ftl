<#macro createCascader formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-cascader v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
</el-cascader>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>