<#macro createUpload formId, scope, element>
<@createBadge scope=scope element=element>
<@createTooltip scope=scope element=element>
<el-upload <@createAttrs scope=scope content=element.content/> <@createEvents formId=formId element=element/>>
  <i class="${element.content.icon}"></i>
  <div class="el-upload__text">${element.content.text}</div>
</el-upload>
</@createTooltip>
</@createBadge>
</#macro>