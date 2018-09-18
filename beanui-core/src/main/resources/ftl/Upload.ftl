<#macro createUpload formId, scope, element>
<@createBadge element=element>
<el-upload <@createAttrs content=element.content/> <@createEvents formId=formId element=element/>>
  <i class="${element.content.icon}"></i>
  <div class="el-upload__text">${element.content.text}</div>
</el-upload>
</@createBadge>
</#macro>