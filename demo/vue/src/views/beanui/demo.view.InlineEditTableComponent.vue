

<template>
<div class="InlineEditTableComponent-container">
<div class="InlineEditTableComponent-inner-container">
    <el-form v-loading="InlineEditTableComponent_loading" ref="InlineEditTableComponent" :model="InlineEditTableComponent" >
<el-form-item 
prop="table" 


label=""
>
<el-form-item>
    <el-table :data="InlineEditTableComponent.tableData" highlight-current-row="true" 
    >
        <el-table-column width="60" 
        label="ID"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="150" 
        label="Date"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.date}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="100" 
        label="Author"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.author}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="150" 
        label="Importance"
>
        <template slot-scope="scope">
<el-rate v-model="scope.row.importance" 
>
</el-rate>
         </template>
        </el-table-column>
        <el-table-column width="100" 
        label="Readings"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.readings}}
</span>
         </template>
        </el-table-column>
        <el-table-column prop="title" width="400" 
        label="Title"
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
        <el-table-column width="100" 
        label="Status"
>
        <template slot-scope="scope">
<el-tag 
>
{{scope.row.status}}
</el-tag>
         </template>
        </el-table-column>
        <el-table-column width="150" 
        label="actions"
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
            InlineEditTableComponent_loading: false,
            InlineEditTableComponent: {}
      }
    },
    methods: {

    
    created_InlineEditTableComponent_InlineEditTableComponent() {
        this.InlineEditTableComponent_loading = true;
        request({
            url: "/inline-edit-table/init",
            method: "get"
        }).then(res => {
            this.InlineEditTableComponent = res.data;
            this.InlineEditTableComponent_loading = false;
        }).catch(err => {
            this.InlineEditTableComponent_loading = false;
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