

<template>
<div class="InlineEditTableComponent-container">
<div class="InlineEditTableComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="InlineEditTableComponent_loading" ref="InlineEditTableComponent" :model="InlineEditTableComponent"
>
<el-form-item prop="table"
  label=""
>
<el-table :data="InlineEditTableComponent.tableData"
highlight-current-row="true"
  highlight-current-row current-change="current_change_InlineEditTableComponent_table" @selection-change="selection_change__InlineEditTableComponent_table">
 <el-table-column width="60"
 label="ID"
>
    <template slot-scope="scope">
<span v-model="scope.row.id"  >
{{scope.row.id}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="150"
 label="Date"
>
    <template slot-scope="scope">
<span v-model="scope.row.date"  >
{{scope.row.date}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Author"
>
    <template slot-scope="scope">
<span v-model="scope.row.author"  >
{{scope.row.author}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="150"
 label="Importance"
>
    <template slot-scope="scope">
<el-rate v-model="scope.row.importance"  >
{{scope.row.importance}}
</el-rate>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Readings"
>
    <template slot-scope="scope">
<span v-model="scope.row.readings"  >
{{scope.row.readings}}
</span>
    </template>
    </el-table-column>
 <el-table-column prop="title"
width="400"
 label="Title"
>
    <template slot-scope="scope">
<el-input v-model="scope.row.title" size="mini"
style="padding-right: 100px;"
 >
{{scope.row.title}}
</el-input>
<el-button icon="el-icon-refresh"
type="warning"
size="mini"
style="position: absolute;right: 15px;top: 10px;"
 >
    cancel
</el-button>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Status"
>
    <template slot-scope="scope">
<el-tag  >
{{scope.row.status}}
</el-tag>
    </template>
    </el-table-column>
 <el-table-column width="150"
 label="actions"
>
    <template slot-scope="scope">
<el-button icon="el-icon-edit"
type="primary"
size="mini"
 >
    Edit
</el-button>
    </template>
    </el-table-column>
</el-table>
</el-form-item>
</el-form>
</el-col>
</el-row>
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
        var data = this.InlineEditTableComponent;
        function submitRequest(self) {
            self.InlineEditTableComponent_loading = true;
            request({
                url: "/inline-edit-table/init",
                method: "get"
            }).then(res => {
                self.InlineEditTableComponent = res.data;
                self.InlineEditTableComponent_loading = false;
            }).catch(err => {
                self.InlineEditTableComponent_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    current_change_InlineEditTableComponent_table(val) {
        this.InlineEditTableComponent.table = [val];
    },
    selection_change__InlineEditTableComponent_table(val) {
        this.InlineEditTableComponent.table = val;
    },
    placeholder_InlineEditTableComponent_table() {
      }
    


    ,
    placeholder_InlineEditTableComponent_id() {
      }
    




    ,
    placeholder_InlineEditTableComponent_date() {
      }
    




    ,
    placeholder_InlineEditTableComponent_author() {
      }
    




    ,
    placeholder_InlineEditTableComponent_importance() {
      }
    




    ,
    placeholder_InlineEditTableComponent_readings() {
      }
    




    ,
    placeholder_InlineEditTableComponent_title() {
      }
    


    ,
    placeholder_InlineEditTableComponent_cancel() {
      }
    




    ,
    placeholder_InlineEditTableComponent_status() {
      }
    




    ,
    placeholder_InlineEditTableComponent_action() {
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