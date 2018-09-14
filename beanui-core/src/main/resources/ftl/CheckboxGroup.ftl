<#macro createCheckboxGroup formId, scope, element>
<el-checkbox-group v-model="${scope}.${element.id}"
<#list element.content?keys as key>
<#if element.content[key]!=''>
${key}="${element.content[key]}"
</#if></#list>
<#if element.events??>
<#list element.events as event>
@${event.type}="${event.type}_${formId}_${element.id}"
</#list>
</#if>>
    <el-checkbox v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label">
    </el-checkbox>
</el-checkbox-group>
</#macro>