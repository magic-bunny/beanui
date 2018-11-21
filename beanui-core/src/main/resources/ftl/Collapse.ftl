<#macro createCollapse element>
<el-collapse <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
    <#list element.children as child>
    <el-collapse-item <#list child.content?keys as k><#if child.content[k]!=''>${k}="${child.content[k]}" </#if></#list>>
    <#if child.children[0].type="Form">
    <@createForm element=child.children[0]/>
    </#if>
    </el-collapse-item>
    </#list>
</el-collapse>
</#macro>