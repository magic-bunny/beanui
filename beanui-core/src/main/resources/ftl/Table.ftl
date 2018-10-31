<#macro createTable formId, scope, element>
<el-table <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/> current-change="current_change_${formId}_${element.id}" @selection-change="selection_change__${formId}_${element.id}">
<#list element.children as o> <el-table-column <@createAttrs scope=scope content=o.content/> <@createI18N element=o attr='label'/>>
    <#if o.content.type!='selection'>
    <template slot-scope="scope">
    <#list o.children as object>
    <#if object.type="Select">
        <@createSelect formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Button">
        <@createButton formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Table">
        <@createTable formId=formId scope="scope.row" element=object/>
    <#elseif object.type="CheckboxGroup">
        <@createCheckboxGroup formId=formId scope="scope.row" element=object/>
    <#elseif object.type="CheckboxButtonGroup">
        <@createCheckboxButtonGroup formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Upload">
        <@createUpload formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Tag">
        <@createTag formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Pagination">
        <@createPagination formId=formId scope="scope.row" element=object/>
    <#elseif object.type="RadioGroup">
        <@createRadioGroup formId=formId scope="scope.row" element=object/>
    <#elseif object.type="RadioButtonGroup">
        <@createRadioButtonGroup formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Steps">
        <@createSteps formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Dropdown">
        <@createDropdown formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Cascader">
        <@createCascader formId=formId scope="scope.row" element=object/>
    <#elseif object.type="Tree">
        <@createTree formId=formId scope="scope.row" element=object/>
    <#else>
        <@createElement formId=formId scope="scope.row" element=object/>
    </#if>
    </#list>
    </template>
    </#if>
    </el-table-column>
</#list>
</el-table>
</#macro>