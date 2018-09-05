<#macro createSelect formId,id,element>
<el-select v-model="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
<#if element.content[':options']!=''>
<el-option v-for="item in ${element.content[':options']}" :key="item.value" :label="item.label" :value="item.value">
</el-option>
</#if>
</el-select>
</#macro>