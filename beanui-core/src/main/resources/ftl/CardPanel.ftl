<#macro createCardPanel formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<card-panel title="${element.content.title}" svg="${element.content.svg}" :startVal="${element.content.startVal}" :endVal="${element.content.endVal}" :duration="${element.content.duration}"></card-panel>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>