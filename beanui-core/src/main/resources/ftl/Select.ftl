<#macro createSelect formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-select v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
<#if element.content[':data']!=''>
    <el-option v-for="item in ${scope}.${element.content[':data']}" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</#if>
</el-select>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>