<#macro createSelect formId, scope, element>
<el-select v-model="${scope}.${element.id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>
<#if element.events??>
<#list element.events as event>
@${event.type}="${event.type}_${formId}_${element.id}"
</#list>
</#if>>
<#if element.content[':options']!=''>
<el-option v-for="item in ${element.content[':options']}" :key="item.value" :label="item.label" :value="item.value">
</el-option>
</#if>
</el-select>
</#macro>