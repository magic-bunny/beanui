<#macro createSteps formId, scope, element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-steps v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
<#if element.content[':data']!=''>
    <el-step v-for="item in ${scope}.${element.content[':data']}" :icon="item.icon" :title="item.title" :description="item.description" :status="item.status">
    </el-step>
</#if>
</el-steps>
</@createTooltip>
</@createBadge>
</#macro>