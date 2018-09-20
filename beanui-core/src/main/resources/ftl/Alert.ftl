<#macro createAlert formId, scope, element>
<@createBadge scope=scope element=element>
<el-alert v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/> show-icon>
</el-alert>
</@createBadge>
</#macro>