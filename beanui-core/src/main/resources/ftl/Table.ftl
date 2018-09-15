<#macro createTable formId, scope, element>
<el-form-item>
    <el-table <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>
    <#if element.events??>
    <#list element.events as event>
    @${event.type}="${event.type}_${formId}_${element.id}"
    </#list>
    </#if>>
    <#list element.children as o>
        <el-table-column <#list o.content?keys as key><#if o.content[key]!='' && key!='label' && key!=':label'>${key}="${o.content[key]}" </#if></#list>
        <@createI18N element=o attr='label'/>>
        <template slot-scope="scope">
        <#list o.children as object>
            <#if object.type="Input">
                <@createInput formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Select">
                <@createSelect formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Button">
                <@createButton formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Switch">
                <@createSwitch formId=formId scope="scope.row" element=object/>
            <#elseif object.type="TimerPicker">
                <@createTimerPicker formId=formId scope="scope.row" element=object/>
            <#elseif object.type="DatePicker">
                <@createDatePicker formId=formId scope="scope.row" element=object/>
            <#elseif object.type="DateTimePicker">
                <@createDateTimePicker formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Table">
                <@createTable formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Rate">
                <@createRate formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Alert">
                <@createAlert formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Slider">
                <@createSlider formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Checkbox">
                <@createCheckbox formId=formId scope="scope.row" element=object/>
            <#elseif object.type="CheckboxGroup">
                <@createCheckboxGroup formId=formId scope="scope.row" element=object/>
            <#elseif object.type="CheckboxButton">
                <@createCheckboxButton formId=formId scope="scope.row" element=object/>
            <#elseif object.type="CheckboxButtonGroup">
                <@createCheckboxButtonGroup formId=formId scope="scope.row" element=object/>
            <#elseif object.type="InputNumber">
                <@createInputNumber formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Upload">
                <@createUpload formId=formId scope="scope.row" element=object/>
            <#elseif object.type="ColorPicker">
                <@createColorPicker formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Transfer">
                <@createTransfer formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Tag">
                <@createTag formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Progress">
                <@createProgress formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Autocomplete">
                <@createAutocomplete formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Element">
                <@createElement formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Pagination">
                <@createPagination formId=formId scope="scope.row" element=object/>
            <#elseif object.type="Radio">
                <@createRadio formId=formId scope="scope.row" element=object/>
            <#elseif object.type="RadioGroup">
                <@createRadioGroup formId=formId scope="scope.row" element=object/>
            <#elseif object.type="RadioButton">
                <@createRadioButton formId=formId scope="scope.row" element=object/>
            <#elseif object.type="RadioButtonGroup">
                <@createRadioButtonGroup formId=formId scope="scope.row" element=object/>
            </#if>
        </#list>
         </template>
        </el-table-column>
    </#list>
    </el-table>
</el-form-item>
</#macro>