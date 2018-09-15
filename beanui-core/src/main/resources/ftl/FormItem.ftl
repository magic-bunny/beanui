 <#macro createFormItem formId, element>
<el-form-item <#list element.content?keys as key>
<#if element.content[key]!='' && key!='label' && key!=':label'>${key}="${element.content[key]}" </#if>
</#list>
<@createI18N element=element.children[0] attr='label'/>>
<#list element.children as object>
<#if object.type="Input">
    <@createInput formId=formId scope=formId element=object/>
<#elseif object.type="Select">
    <@createSelect formId=formId scope=formId element=object/>
<#elseif object.type="Button">
    <@createButton formId=formId scope=formId element=object/>
<#elseif object.type="Switch">
    <@createSwitch formId=formId scope=formId element=object/>
<#elseif object.type="TimePicker">
    <@createTimePicker formId=formId scope=formId element=object/>
<#elseif object.type="DateTimePicker">
    <@createDateTimerPicker formId=formId scope=formId element=object/>
<#elseif object.type="DatePicker">
    <@createDatePicker formId=formId scope=formId element=object/>
<#elseif object.type="Table">
    <@createTable formId=formId scope=formId element=object/>
<#elseif object.type="Rate">
    <@createRate formId=formId scope=formId element=object/>
<#elseif object.type="Alert">
    <@createAlert formId=formId scope=formId element=object/>
<#elseif object.type="Slider">
    <@createSlider formId=formId scope=formId element=object/>
<#elseif object.type="Checkbox">
    <@createCheckbox formId=formId scope=formId element=object/>
<#elseif object.type="CheckboxGroup">
    <@createCheckboxGroup formId=formId scope=formId element=object/>
<#elseif object.type="CheckboxButton">
    <@createCheckboxButton formId=formId scope=formId element=object/>
<#elseif object.type="CheckboxButtonGroup">
    <@createCheckboxButtonGroup formId=formId scope=formId element=object/>
<#elseif object.type="InputNumber">
    <@createInputNumber formId=formId scope=formId element=object/>
<#elseif object.type="Upload">
    <@createUpload formId=formId scope=formId element=object/>
<#elseif object.type="ColorPicker">
    <@createColorPicker formId=formId scope=formId element=object/>
<#elseif object.type="Transfer">
    <@createTransfer formId=formId scope=formId element=object/>
<#elseif object.type="Tag">
    <@createTag formId=formId scope=formId element=object/>
<#elseif object.type="Progress">
    <@createProgress formId=formId scope=formId element=object/>
<#elseif object.type="Autocomplete">
    <@createAutocomplete formId=formId scope=formId element=object/>
<#elseif object.type="Element">
    <@createElement formId=formId scope=formId element=object/>
<#elseif object.type="Pagination">
    <@createPagination formId=formId scope=formId element=object/>
<#elseif object.type="Radio">
    <@createRadio formId=formId scope=formId element=object/>
<#elseif object.type="RadioGroup">
    <@createRadioGroup formId=formId scope=formId element=object/>
<#elseif object.type="RadioButton">
    <@createRadioButton formId=formId scope=formId element=object/>
<#elseif object.type="RadioButtonGroup">
    <@createRadioButtonGroup formId=formId scope=formId element=object/>
</#if>
</#list>
</el-form-item>
</#macro>