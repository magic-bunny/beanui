<#macro createDialog element>
<el-dialog
<#list element.content?keys as key>
<#if key=':visible'>
${key}.sync="${element.content[key]}"
<#else>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if>
</#if>
</#list>>
<#list element.children as child>
<#if child.type="Form">
    <@createForm element=child/>
</#if>
</#list>
</el-dialog>
</#macro>