<#macro createSubplot values>
<#if (values[2]-1)%values[1]=0>
<el-row>
</#if>
<el-col :span="24/${values[1]}" style="padding: 10px;">
<#nested>
</el-col>
<#if values[2]%values[1]=0>
</el-row>
</#if>
</#macro>