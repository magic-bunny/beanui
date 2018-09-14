<#macro createRadioButtonGroup formId, scope, element>
<el-radio-group v-model="${scope}.${element.id}"
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if></#list>
<#if element.events??>
<#list element.events as event>
@${event.type}="${event.type}_${formId}_${element.id}"
</#list>
</#if>>
    <el-radio-button v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label">
    </el-radio-button>
</el-radio-group>
</#macro>