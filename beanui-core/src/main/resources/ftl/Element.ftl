<#macro createElement formId, scope, element>
<@createBadge element=element>
<${element.content.tag} v-model="${formId}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
</@createI18N element=element attr=''>
</${element.content.tag}>
</@createBadge>
</#macro>