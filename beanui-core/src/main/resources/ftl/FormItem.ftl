<#macro createFormItem formId,element>
<el-form-item
<#if element.children[0].content.label??>
<#if element.children[0].content.label=''>label="${element.children[0].id}"<#else>label="${element.children[0].content.label}"</#if>
</#if>
>
<#list element.children as object>
<#if object.type="Input">
    <@createInput formId=formId id=object.id element=object/>
<#elseif object.type="Select">
    <@createSelect formId=formId id=object.id element=object/>
<#elseif object.type="Button">
    <@createButton element=object/>
<#elseif object.type="Switch">
    <@createSwitch formId=formId id=object.id element=object/>
<#elseif object.type="DatePicker">
    <@createDatePicker formId=formId id=object.id element=object/>
<#elseif object.type="Table">
    <@createTable formId=formId id=object.id element=object/>
<#elseif object.type="Rate">
    <@createRate formId=formId id=object.id element=object/>
<#elseif object.type="Alert">
    <@createAlert formId=formId id=object.id element=object/>
<#elseif object.type="Slider">
    <@createSlider formId=formId id=object.id element=object/>
<#elseif object.type="Checkbox">
    <@createCheckbox formId=formId id=object.id element=object/>
<#elseif object.type="CheckboxGroup">
    <@createCheckboxGroup formId=formId id=object.id element=object/>
</#if>
</#list>
</el-form-item>
</#macro>