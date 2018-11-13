<#macro createIframe formId, scope, element>
<@createTooltip scope=scope element=element>
<${element.content.tag} src="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
</${element.content.tag}>
</@createTooltip>
</#macro>