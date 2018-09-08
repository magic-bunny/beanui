<#include "/Input.ftl">
<#include "/InputNumber.ftl">
<#include "/Select.ftl">
<#include "/Button.ftl">
<#include "/Switch.ftl">
<#include "/TimePicker.ftl">
<#include "/DatePicker.ftl">
<#include "/DateTimePicker.ftl">
<#include "/Table.ftl">
<#include "/Rate.ftl">
<#include "/FormItem.ftl">
<#include "/Alert.ftl">
<#include "/Slider.ftl">
<#include "/Checkbox.ftl">
<#include "/CheckboxGroup.ftl">
<#include "/Upload.ftl">
<#include "/ColorPicker.ftl">
<#include "/Transfer.ftl">
<#include "/Tag.ftl">
<#include "/Progress.ftl">
<#include "/Pagination.ftl">
<#include "/Autocomplete.ftl">

<#macro createForm id,children>
    <el-form ref="${id}" :model="${id}" label-width="120px">
        <#list children as object>
            <@createFormItem formId=id element=object/>
        </#list>
    </el-form>
</#macro>