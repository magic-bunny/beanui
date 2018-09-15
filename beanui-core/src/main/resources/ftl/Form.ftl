<#macro createForm element>
    <el-form v-loading="${element.id}_loading" ref="${element.id}" :model="${element.id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
        <#list element.children as object>
            <@createFormItem formId=element.id element=object/>
        </#list>
    </el-form>
</#macro>