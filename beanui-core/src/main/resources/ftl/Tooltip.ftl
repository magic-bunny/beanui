<#macro createTooltip scope element>
<#if element.tooltip??>
<el-tooltip <@createAttrs scope=scope content=element.tooltip/>>
</#if>
<#nested>
<#if element.tooltip??>
</el-tooltip>
</#if>
</#macro>