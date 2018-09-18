<#macro createBreadcrumb formId, scope, element>
<@createBadge element=element>
<el-breadcrumb v-model="${scope}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
    <el-breadcrumb-item v-for="item in ${element.content[':data']}" :to="item.to" :replace="item.replace">
    </el-breadcrumb-item>
</el-breadcrumb>
</@createBadge>
</#macro>