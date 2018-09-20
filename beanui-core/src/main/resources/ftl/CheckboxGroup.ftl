<#macro createCheckboxGroup formId, scope, element>
<@createBadge scope=scope element=element>
<el-checkbox-group v-model="${scope}.${element.id}" <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
    <el-checkbox v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label">
    </el-checkbox>
</el-checkbox-group>
</@createBadge>
</#macro>