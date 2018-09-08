

<template>
<div class="ABCDComponent-container">
<div class="ABCDComponent-inner-container">
    <el-form ref="userQuery" :model="userQuery" label-width="120px">
<el-form-item
>
<el-form-item>
    <el-table :data="userQuery.users" >
        <el-table-column
        type="selection" prop="id" label="id" width="50" 
>
        </el-table-column>
        <el-table-column
        prop="name" label="name" 
>
            <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini" >
</el-input>
            </template>
        </el-table-column>
        <el-table-column
        prop="age" label="age" 
>
            <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini" >
</el-input-number>
            </template>
        </el-table-column>
        <el-table-column
        prop="stature" label="stature" 
>
        </el-table-column>
        <el-table-column
        prop="weight" label="weight" 
>
            <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini" >
</el-input-number>
            </template>
        </el-table-column>
        <el-table-column
        prop="lastDate" label="lastDate" width="240" 
>
            <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini" >
</el-date-picker>
            </template>
        </el-table-column>
        <el-table-column
        prop="option" label="edit" 
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
>
</el-form-item>
<el-form-item
>
<el-button
    icon="el-icon-search"
    text="query"
    type="primary"
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