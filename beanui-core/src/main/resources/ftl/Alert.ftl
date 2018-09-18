<#macro createAlert formId, scope, element>
<@createBadge element=element>
<el-alert v-model="${scope}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/> show-icon>
</el-alert>
</@createBadge>
</#macro>