<#macro createTabs element>
<el-tabs <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
    <#list element.children as child>
    <el-tab-pane <#list child.content?keys as k><#if child.content[k]!=''>${k}="${child.content[k]}" </#if></#list>>
    <#if child.children[0].type="Form">
    <@createForm element=child.children[0]/>
    </#if>
    </el-tab-pane>
    </#list>
</el-tabs>
</#macro>