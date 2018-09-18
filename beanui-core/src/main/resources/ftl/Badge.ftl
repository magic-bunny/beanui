<#macro createBadge element>
<#if element.badge??>
<el-badge <@createAttrs content=element.badge/>>
</#if>
<#nested>
<#if element.badge??>
</el-badge>
</#if>
</#macro>