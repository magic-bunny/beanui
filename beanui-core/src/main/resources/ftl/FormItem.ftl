<#macro createFormItem formId,element>
<el-form-item
<#if element.children[0].i18n??>
:label="${r'$'}t('${element.children[0].i18n}')"
<#else>
<#if element.children[0].content.label??>
<#if element.children[0].content.label=''>label="${element.children[0].id}"<#else>label="${element.children[0].content.label}"</#if>
</#if></#if>>
<#list element.children as object>
<#if object.type="Input">
    <@createInput formId=formId id=object.id element=object/>
<#elseif object.type="Select">
    <@createSelect formId=formId id=object.id element=object/>
<#elseif object.type="Button">
    <@createButton element=object/>
<#elseif object.type="Switch">
    <@createSwitch formId=formId id=object.id element=object/>
<#elseif object.type="TimePicker">
    <@createTimePicker formId=formId id=object.id element=object/>
<#elseif object.type="DateTimePicker">
    <@createDateTimerPicker formId=formId id=object.id element=object/>
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
<#elseif object.type="InputNumber">
    <@createInputNumber formId=formId id=object.id element=object/>
<#elseif object.type="Upload">
    <@createUpload formId=formId id=object.id element=object/>
<#elseif object.type="ColorPicker">
    <@createColorPicker formId=formId id=object.id element=object/>
<#elseif object.type="Transfer">
    <@createTransfer formId=formId id=object.id element=object/>
<#elseif object.type="Tag">
    <@createTag formId=formId id=object.id element=object/>
<#elseif object.type="Progress">
    <@createProgress formId=formId id=object.id element=object/>
<#elseif object.type="Autocomplete">
    <@createAutocomplete formId=formId id=object.id element=object/>
<#elseif object.type="Pagination">
    <@createPagination element=object/>
</#if>
</#list>
</el-form-item>
</#macro>