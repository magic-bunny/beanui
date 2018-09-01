<#include "/Input.ftl">
<#include "/Select.ftl">
<#include "/Button.ftl">
<#include "/Switch.ftl">
<#include "/DatePicker.ftl">
<#include "/Table.ftl">
<#include "/Rate.ftl">
<#include "/FormItem.ftl">
<#include "/Alert.ftl">
<#include "/Slider.ftl">
<#include "/Checkbox.ftl">
<#include "/CheckboxGroup.ftl">

<#macro createForm id,children>
    <el-form ref="${id}" :model="${id}" label-width="80px">
        <#list children as object>
            <@createFormItem formId=id element=object/>
        </#list>
    </el-form>
</#macro>