

<template>
<div class="ABCDComponent-container">
<div class="ABCDComponent-inner-container">
    <el-form ref="userQuery" :model="userQuery" >
<el-form-item
label=""
>
<el-form-item>
    <el-table :data="userQuery.users" >
        <el-table-column
        type="selection" width="50" 
>
        <template slot-scope="scope">
<span >
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        
>
        <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini" >
</el-input>
         </template>
        </el-table-column>
        <el-table-column
        
>
        <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini" >
</el-input-number>
         </template>
        </el-table-column>
        <el-table-column
        
>
        <template slot-scope="scope">
<span >
{{scope.row.stature}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        
>
        <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini" >
</el-input-number>
         </template>
        </el-table-column>
        <el-table-column
        width="240" 
>
        <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini" >
</el-date-picker>
         </template>
        </el-table-column>
        <el-table-column
        label="edit" 
>
        <template slot-scope="scope">
<el-button
    size="mini"
    text="edit"
>
    edit

</el-button>
         </template>
        </el-table-column>
    </el-table>
</el-form-item>
</el-form-item>
<el-form-item
label=""
>
<el-button
    icon="el-icon-search"
    type="primary"
    text="query"
    @click="click_button"
>
    query

</el-button>
</el-form-item>
    </el-form>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    data() {
      return {
                userQuery: {}
      }
    },
    methods: {
            click_button() {
                var data = this.userQuery;
                request({
                    url: "/demo2",
                    method: "get",
                    data
                }).then(res => {
                    this.userQuery = res.data;
                }).catch(err => {

                })
              }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .ABCDComponent-container {
    }
    .ABCDComponent-inner-container {
        margin: 20px;
    }
</style>