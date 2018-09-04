<#macro createUpload formId,id,element>
<el-upload <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
  <i class="${element.content.icon}"></i>
  <div class="el-upload__text">${element.content.text}</div>
</el-upload>
</#macro>