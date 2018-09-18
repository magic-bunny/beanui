

<template>
<div class="DragTableComponent-container">
<div class="DragTableComponent-inner-container">
<el-form v-loading="DragTableComponent_loading" ref="DragTableComponent" :model="DragTableComponent"
>
<el-form-item prop="table" 
 
 label=""
>
<el-table :data="DragTableComponent.tableData" fit="true" border="true" highlight-current-row="true" 
 
>
 <el-table-column width="70" 
 label="ID"
>
    <template slot-scope="scope">
<span v-model="DragTableComponent.id" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="200" 
 label="Date"
>
    <template slot-scope="scope">
<span v-model="DragTableComponent.date" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="400" 
 label="Title"
>
    <template slot-scope="scope">
<span v-model="DragTableComponent.title" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="100" 
 label="Author"
>
    <template slot-scope="scope">
<span v-model="DragTableComponent.author" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="200" 
 label="Importance"
>
    <template slot-scope="scope">
<el-rate v-model="DragTableComponent.importance" 
 
>
</@createI18N element=element attr=''>
</el-rate>
     </template>
    </el-table-column>
 <el-table-column width="100" 
 label="Readings"
>
    <template slot-scope="scope">
<span v-model="DragTableComponent.readings" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column width="110" 
 label="Status"
>
    <template slot-scope="scope">
<el-tag 
 
>
{{scope.row.status}}
</el-tag>
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