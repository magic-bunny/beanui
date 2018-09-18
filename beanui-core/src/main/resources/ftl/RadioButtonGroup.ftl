<#macro createRadioButtonGroup formId, scope, element>
<@createBadge element=element>
<el-radio-group v-model="${scope}.${element.id}" <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
    <el-radio-button v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label">
    </el-radio-button>
</el-radio-group>
</@createBadge>
</#macro>