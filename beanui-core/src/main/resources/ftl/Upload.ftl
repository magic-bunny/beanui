<#macro createUpload formId, scope, element>
<el-upload <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>
<#if element.events??>
<#list element.events as event>
@${event.type}="${event.type}_${formId}_${element.id}"
</#list>
</#if>>
  <i class="${element.content.icon}"></i>
  <div class="el-upload__text">${element.content.text}</div>
</el-upload>
</#macro>