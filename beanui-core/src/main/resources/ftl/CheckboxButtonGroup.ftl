<#macro createCheckboxButtonGroup formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-checkbox-group v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    <el-checkbox-button v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label" :disabled="item.disabled">
    </el-checkbox-button>
</el-checkbox-group>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>