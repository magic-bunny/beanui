<#macro createSlider formId,id,element>
<el-slider v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
</el-slider>
</#macro>