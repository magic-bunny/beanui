<#macro createBadge scope element>
<#if element.badge??>
<el-badge <@createAttrs scope=scope content=element.badge/>>
</#if>
<#nested>
<#if element.badge??>
</el-badge>
</#if>
</#macro>