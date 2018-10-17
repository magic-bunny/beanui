<#macro createLink scope element>
<#if element.link??>
<router-link <@createAttrs scope=scope content=element.link/>>
</#if>
<#nested>
<#if element.link??>
</router-link>
</#if>
</#macro>