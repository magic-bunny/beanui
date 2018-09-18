

<template>
<div class="InlineEditTableComponent-container">
<div class="InlineEditTableComponent-inner-container">
<el-form v-loading="InlineEditTableComponent_loading" ref="InlineEditTableComponent" :model="InlineEditTableComponent"
>
<el-form-item prop="table" 
 
 label=""
>
<el-table :data="InlineEditTableComponent.tableData" highlight-current-row="true" 
 
>
 <el-table-column width="60" 
 label="ID"
>
    <template slot-scope="scope">
<span v-model="InlineEditTableComponent.id" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="150" 
 label="Date"
>
    <template slot-scope="scope">
<span v-model="InlineEditTableComponent.date" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="100" 
 label="Author"
>
    <template slot-scope="scope">
<span v-model="InlineEditTableComponent.author" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="150" 
 label="Importance"
>
    <template slot-scope="scope">
<el-rate v-model="InlineEditTableComponent.importance" 
 
>
</@createI18N element=element attr=''>
</el-rate>
     </template>
    </el-table-column>
 <el-table-column width="100" 
 label="Readings"
>
    <template slot-scope="scope">
<span v-model="InlineEditTableComponent.readings" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column prop="title" width="400" 
 label="Title"
>
    <template slot-scope="scope">
<el-input v-model="InlineEditTableComponent.title" size="mini" style="padding-right: 100px;" 
 
>
</@createI18N element=element attr=''>
</el-input>
<el-button icon="el-icon-refresh" type="warning" size="mini" style="position: absolute;right: 15px;top: 10px;" 
 
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
<el-button icon="el-icon-edit" type="primary" size="mini" 
 
>
    Edit
</el-button>
     </template>
    </el-table-column>
</el-table>
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