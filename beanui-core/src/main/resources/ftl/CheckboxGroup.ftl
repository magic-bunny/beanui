<#macro createCheckboxGroup formId,id,element>
<el-checkbox-group v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}"</#if></#list>>
    <el-checkbox v-for="item in ${formId}.${element.content.checkboxId}" :label="item.label"></el-checkbox>
</el-checkbox-group>
</#macro>