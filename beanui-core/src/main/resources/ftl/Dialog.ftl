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
<#if element.children[0].type="Form">
    <@createForm element=element.children[0]/>
</#if>
</el-dialog>
</#macro>