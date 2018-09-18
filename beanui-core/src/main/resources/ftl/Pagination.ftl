<#macro createPagination formId, scope, element>
<el-pagination <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
</el-pagination>
</#macro>