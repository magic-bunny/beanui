<#macro createPagination element>
<el-pagination <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
  </el-pagination>
</#macro>