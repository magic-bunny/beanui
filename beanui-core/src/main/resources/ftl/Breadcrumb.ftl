<#macro createBreadcrumb formId, scope, element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-breadcrumb v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    <el-breadcrumb-item v-for="item in ${element.content[':data']}" :to="item.to" :replace="item.replace">
    </el-breadcrumb-item>
</el-breadcrumb>
</@createTooltip>
</@createBadge>
</#macro>