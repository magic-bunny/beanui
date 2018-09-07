export default {
<#list datas?keys as form>
  ${form}: {
  <#list datas[key]?keys as item>
    ${item}: '${datas[key][item]}'<#if item_has_next>,</#if>
  </#list>
  }<#if form_has_next>,</#if>
</#list>
}
