<#macro createElement formId, scope, element>
<@createBadge scope=scope element=element>
<${element.content.tag} v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
${r'{{'}${scope}.${element.id}${r'}}'}
</${element.content.tag}>
</@createBadge>
</#macro>