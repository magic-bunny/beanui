<#macro createDropdown formId, scope, element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-dropdown v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
<#if element.content[':data']!=''>
    <el-dropdown-item v-for="item in ${scope}.${element.content[':data']}" :command="item.command" :disabled="item.disabled" :divided="item.divided">
    ${r'{{'}item.text${r'}}'}
    </el-dropdown-item>
</#if>
</el-dropdown>
</@createTooltip>
</@createBadge>
</#macro>