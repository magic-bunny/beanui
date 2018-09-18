<#macro createCarousel formId, scope, element>
<@createBadge element=element>
<el-carousel <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
    <el-carousel-item v-for="item in ${element.content[':data']}" :key="item.key" :label="item.label" >
        <#if element.children[0].type="Form">
        <@createForm element=element.children[0]/>
        </#if>
    </el-carousel-item>
</el-carousel>
</@createBadge>
</#macro>