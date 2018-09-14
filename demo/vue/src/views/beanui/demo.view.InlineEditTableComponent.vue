

<template>
<div class="InlineEditTableComponent-container">
<div class="InlineEditTableComponent-inner-container">
    <el-form ref="InlineEditTableComponent" :model="InlineEditTableComponent" >
<el-form-item prop="table" 
label=""
>
<el-form-item>
    <el-table :data="InlineEditTableComponent.tableData" highlight-current-row="true" 
    >
        <el-table-column
        label="ID" width="60" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Date" width="150" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.date}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Author" width="100" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.author}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Importance" width="150" 
>
        <template slot-scope="scope">
<el-rate v-model="scope.row.importance" 
>
</el-rate>
         </template>
        </el-table-column>
        <el-table-column
        label="Readings" width="100" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.readings}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        prop="title" label="Title" width="400" 
>
        <template slot-scope="scope">
<el-input v-model="scope.row.title" size="mini" style="padding-right: 100px;" 
>
</el-input>
<el-button
    icon="el-icon-refresh"
    type="warning"
    size="mini"
    style="position: absolute;right: 15px;top: 10px;"
    text="cancel"
    >
    cancel
</el-button>
         </template>
        </el-table-column>
        <el-table-column
        label="Status" width="100" 
>
        <template slot-scope="scope">
<el-tag 
>
{{scope.row.status}}
</el-tag>
         </template>
        </el-table-column>
        <el-table-column
        label="actions" width="150" 
>
        <template slot-scope="scope">
<el-button
    icon="el-icon-edit"
    type="primary"
    size="mini"
    text="Edit"
    >
    Edit
</el-button>
         </template>
        </el-table-column>
    </el-table>
</el-form-item>
</el-form-item>
    </el-form>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
    this.created_InlineEditTableComponent_InlineEditTableComponent();








































        },
    data() {
      return {
            InlineEditTableComponent: {}
      }
    },
    methods: {

    
    created_InlineEditTableComponent_InlineEditTableComponent() {
        request({
            url: "/inline-edit-table/init",
            method: "get"
        }).then(res => {
            this.InlineEditTableComponent = res.data;
        }).catch(err => {

        })
      }
    



























































    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .InlineEditTableComponent-container {
    }
    .InlineEditTableComponent-inner-container {
        margin: 20px;
    }
</style>