<#macro createTable formId,id,element>
<el-form-item>
    <el-table <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
    <#list element.children as o>
        <el-table-column
        <#list o.content?keys as key><#if o.content[key]!=''>${key}="${o.content[key]}" </#if></#list>
        <#if o.i18n??>
        :label="${r'$'}t('${o.i18n}')"
        </#if>>
        <template slot-scope="scope">
        <#list o.children as object>
            <#if object.type="Input">
                <@createInput formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Select">
                <@createSelect formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Button">
                <@createButton formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Switch">
                <@createSwitch formId="scope.row" id=object.id element=object/>
            <#elseif object.type="TimerPicker">
                <@createTimerPicker formId="scope.row" id=object.id element=object/>
            <#elseif object.type="DatePicker">
                <@createDatePicker formId="scope.row" id=object.id element=object/>
            <#elseif object.type="DateTimePicker">
                <@createDateTimePicker formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Table">
                <@createTable formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Rate">
                <@createRate formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Alert">
                <@createAlert formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Slider">
                <@createSlider formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Checkbox">
                <@createCheckbox formId="scope.row" id=object.id element=object/>
            <#elseif object.type="CheckboxGroup">
                <@createCheckboxGroup formId="scope.row" id=object.id element=object/>
            <#elseif object.type="InputNumber">
                <@createInputNumber formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Upload">
                <@createUpload formId="scope.row" id=object.id element=object/>
            <#elseif object.type="ColorPicker">
                <@createColorPicker formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Transfer">
                <@createTransfer formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Tag">
                <@createTag formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Progress">
                <@createProgress formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Autocomplete">
                <@createAutocomplete formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Element">
                <@createElement formId="scope.row" id=object.id element=object/>
            <#elseif object.type="Pagination">
                <@createPagination element=object/>
            </#if>
        </#list>
         </template>
        </el-table-column>
    </#list>
    </el-table>
</el-form-item>
</#macro>