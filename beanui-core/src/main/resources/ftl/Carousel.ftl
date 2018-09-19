<#macro createCarousel element>
<el-carousel
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if>
</#list>>
    <#list element.children as child>
    <#if child.type="Form">
    <el-carousel-item>
    <@createForm element=child/>
    </el-carousel-item>
    </#if>
    </#list>
</el-carousel>
</#macro>