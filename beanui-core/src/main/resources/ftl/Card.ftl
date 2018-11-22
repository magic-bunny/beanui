<#macro createCard element>
<el-card
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if>
</#list>>
    <#if element.content.title!=''>
    <div slot="header">
        <#if element.content.svg!=''>
        <svg-icon icon-class="${element.content.svg}" />
        </#if>
        <span>${element.content.title}</span>
    </div>
    </#if>
    <#nested>
</el-card>
</#macro>