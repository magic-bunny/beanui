<#macro createCard element>
<el-card <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
<#if element.children[0].type="Form">
    <@createForm element=element.children[0]/>
</#if>
</el-card>
</#macro>