<#macro createLink scope element>
<#if element.link??>
<#if element.link.to?starts_with('http:')>
<a href="${element.link.to}">
<#else>
<router-link <@createAttrs scope=scope content=element.link/>>
</#if>
</#if>
<#nested>
<#if element.link??>
<#if element.link.to?starts_with('http:')>
</a>
<#else>
</router-link>
</#if>
</#if>
</#macro>