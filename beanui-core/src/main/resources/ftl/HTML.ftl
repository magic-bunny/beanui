<#macro createHTML formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<div v-html="${scope}.${element.id}" <@createEvents formId=formId element=element/>></div>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>