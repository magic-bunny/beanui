<#macro createRadioGroup formId, scope, element>
<@createLink scope=scope element=element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-radio-group v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    <el-radio v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label" :disabled="item.disabled">
    </el-radio>
</el-radio-group>
</@createTooltip>
</@createBadge>
</@createLink>
</#macro>