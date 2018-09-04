<#macro createTransfer formId,id,element>
<el-transfer v-model="${formId}.${id}"
<#list element.content?keys as key>
<#if element.content[key]!=''>
<#if key='data'>
:data="${formId}.${element.content[key]}"
<#elseif key='titles'>
:titles="${element.content[key]}"
<#else>
${key}="${element.content[key]}"
</#if>
</#if>
</#list>>
</el-transfer>
</#macro>