<#macro createSelect formId, scope, element>
<@createBadge element=element>
<el-select v-model="${scope}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
<#if element.content[':options']!=''>
    <el-option v-for="item in ${element.content[':options']}" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</#if>
</el-select>
</@createBadge>
</#macro>