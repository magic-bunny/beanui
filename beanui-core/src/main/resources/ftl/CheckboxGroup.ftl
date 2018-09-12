<#macro createCheckboxGroup formId,id,element>
<el-checkbox-group v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}"</#if></#list>>
    <el-checkbox v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label"></el-checkbox>
</el-checkbox-group>
</#macro>