<#macro createCheckboxButtonGroup formId, scope, element>
<@createBadge element=element>
<el-checkbox-group v-model="${scope}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
    <el-checkbox-button v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label">
    </el-checkbox-button>
</el-checkbox-group>
</@createBadge>
</#macro>