<#macro createButton element>
<el-button
    <#list element.content?keys as key>
    <#if element.content[key]!=''>
    ${key}="${element.content[key]}"
    </#if>
    </#list>
    <#if element.events??>
    <#list element.events as event>
    @${event.type}="${event.type}_${element.id}"
    </#list>
    </#if>
>
    ${element.content.text}

</el-button>
</#macro>