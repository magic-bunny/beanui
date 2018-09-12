

<template>
<div class="DragTableComponent-container">
<div class="DragTableComponent-inner-container">
    <el-form ref="DragTableComponent" :model="DragTableComponent" >
<el-form-item
label=""
>
<el-form-item>
    <el-table :data="DragTableComponent.tableData" fit="true" border="true" highlight-current-row="true" >
        <el-table-column
        label="ID" width="70" 
>
        <template slot-scope="scope">
<span >
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Date" width="200" 
>
        <template slot-scope="scope">
<span >
{{scope.row.date}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Title" width="400" 
>
        <template slot-scope="scope">
<span >
{{scope.row.title}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Author" width="100" 
>
        <template slot-scope="scope">
<span >
{{scope.row.author}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Importance" width="200" 
>
        <template slot-scope="scope">
<el-rate v-model="scope.row.importance" >
</el-rate>
         </template>
        </el-table-column>
        <el-table-column
        label="Readings" width="100" 
>
        <template slot-scope="scope">
<span >
{{scope.row.readings}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Status" width="110" 
>
        <template slot-scope="scope">
<el-tag >
{{scope.row.status}}
</el-tag>
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
        var data = this.DragTableComponent;
        request({
            url: "/drag-table/init",
            method: "get"
            
        }).then(res => {
            this.DragTableComponent = res.data;
        }).catch(err => {

        })
      },
    data() {
      return {
                DragTableComponent: {}
      }
    },
    methods: {
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