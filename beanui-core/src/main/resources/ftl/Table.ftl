<#macro createTable formId,id,element>
<el-form-item>
    <el-table :data="${formId}.${id}" <#list element.content?keys as key><#if element.content[key]!=''>${key}="${element.content[key]}" </#if></#list>>
      <#list element.children as object>
        <el-table-column <#list object.content?keys as key><#if object.content[key]!=''>${key}="${object.content[key]}" </#if></#list>>
            <#list object.children as o>
            <template slot-scope="scope">
            <#if o.type="Input">
              <@createInput formId=formId id=o.id element=o/>
            <#elseif o.type="Select">
              <@createSelect formId=formId id=o.id element=o/>
            <#elseif o.type="Button">
              <@createButton element=o/>
            <#elseif o.type="Switch">
              <@createSwitch formId=formId id=o.id element=o/>
            <#elseif o.type="DatePicker">
              <@createDatePicker formId=formId id=o.id element=o/>
            <#elseif o.type="Table">
              <@createTable formId=formId id=o.id element=o/>
            <#elseif o.type="DatePicker">
              <@createRate formId=formId id=o.id element=o/>
            </#if>
            </template>
            </#list>
        </el-table-column>
      </#list>
    </el-table>
</el-form-item>
</#macro>