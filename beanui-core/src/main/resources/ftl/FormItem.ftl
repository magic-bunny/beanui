 <#macro createFormItem formId, element>
<el-form-item <@createAttrs scope=formId content=element.content/> <@createEvents formId=formId element=element/> <@createI18N element=element.children[0] attr='label'/>>
<#list element.children as object>
<#if object.type="Select">
    <@createSelect formId=formId scope=formId element=object/>
<#elseif object.type="Button">
    <@createButton formId=formId scope=formId element=object/>
<#elseif object.type="Table">
    <@createTable formId=formId scope=formId element=object/>
<#elseif object.type="CheckboxGroup">
    <@createCheckboxGroup formId=formId scope=formId element=object/>
<#elseif object.type="CheckboxButtonGroup">
    <@createCheckboxButtonGroup formId=formId scope=formId element=object/>
<#elseif object.type="Upload">
    <@createUpload formId=formId scope=formId element=object/>
<#elseif object.type="Tag">
    <@createTag formId=formId scope=formId element=object/>
<#elseif object.type="Pagination">
    <@createPagination formId=formId scope=formId element=object/>
<#elseif object.type="RadioGroup">
    <@createRadioGroup formId=formId scope=formId element=object/>
<#elseif object.type="RadioButtonGroup">
    <@createRadioButtonGroup formId=formId scope=formId element=object/>
<#elseif object.type="Breadcrumb">
    <@createBreadcrumb formId=formId scope=formId element=object/>
<#elseif object.type="Steps">
    <@createSteps formId=formId scope=formId element=object/>
<#elseif object.type="Dropdown">
    <@createDropdown formId=formId scope=formId element=object/>
<#else>
    <@createElement formId=formId scope=formId element=object/>
</#if>
</#list>
</el-form-item>
</#macro>