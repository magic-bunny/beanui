<#macro createCard element>
<el-card
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if>
</#list>>
    <#if element.content.title!=''>
    <div slot="header">
        <span>${element.content.title}</span>
    </div>
    </#if>
    <#list element.children as child>
    <#if child.type="Form">
    <@createForm element=child/>
    </#if>
    </#list>
</el-card>
</#macro>