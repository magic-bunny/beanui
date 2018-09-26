

<template>
<div class="DragTableComponent-container">
<div class="DragTableComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="DragTableComponent_loading" ref="DragTableComponent" :model="DragTableComponent"
>
<el-form-item prop="table"
  label=""
>
<el-table :data="DragTableComponent.tableData"
fit="true"
border="true"
highlight-current-row="true"
  highlight-current-row current-change="current_change_DragTableComponent_table" @selection-change="selection_change__DragTableComponent_table">
 <el-table-column width="70"
 label="ID"
>
    <template slot-scope="scope">
<span v-model="scope.row.id"  >
{{scope.row.id}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="200"
 label="Date"
>
    <template slot-scope="scope">
<span v-model="scope.row.date"  >
{{scope.row.date}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="400"
 label="Title"
>
    <template slot-scope="scope">
<span v-model="scope.row.title"  >
{{scope.row.title}}
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
 <el-table-column width="200"
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
 <el-table-column width="110"
 label="Status"
>
    <template slot-scope="scope">
<el-tag  >
{{scope.row.status}}
</el-tag>
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
    this.created_DragTableComponent_DragTableComponent();
        },
    data() {
      return {
            DragTableComponent_loading: false,
            DragTableComponent: {}
      }
    },
    methods: {
    
    created_DragTableComponent_DragTableComponent() {
        this.DragTableComponent_loading = true;
        var data = this.DragTableComponent;
        request({
            url: "/drag-table/init",
            method: "get"
        }).then(res => {
            this.DragTableComponent = res.data;
            this.DragTableComponent_loading = false;
        }).catch(err => {
            this.DragTableComponent_loading = false;
        })
      }
    


    ,
    current_change_DragTableComponent_table(val) {
        this.DragTableComponent.table = [val];
    },
    selection_change__DragTableComponent_table(val) {
        this.DragTableComponent.table = val;
    },
    placeholder_DragTableComponent_table() {
      }
    


    ,
    placeholder_DragTableComponent_id() {
      }
    




    ,
    placeholder_DragTableComponent_date() {
      }
    




    ,
    placeholder_DragTableComponent_title() {
      }
    




    ,
    placeholder_DragTableComponent_author() {
      }
    




    ,
    placeholder_DragTableComponent_importance() {
      }
    




    ,
    placeholder_DragTableComponent_readings() {
      }
    




    ,
    placeholder_DragTableComponent_status() {
      }
    






        
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .DragTableComponent-container {

    }
    .DragTableComponent-inner-container {
        margin: 20px;
    }
</style>