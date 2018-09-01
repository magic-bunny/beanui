

<template>
<div class="app-container">
    <el-form ref="userQuery" :model="userQuery" label-width="80px">
<el-form-item
>
<el-form-item>
    <el-table :data="userQuery.users" >
        <el-table-column prop="id" label="id" >
        </el-table-column>
        <el-table-column prop="name" label="name" >
        </el-table-column>
        <el-table-column prop="age" label="age" >
        </el-table-column>
        <el-table-column prop="stature" label="stature" >
        </el-table-column>
        <el-table-column prop="weight" label="weight" >
        </el-table-column>
        <el-table-column prop="lastDate" label="lastDate" >
        </el-table-column>
        <el-table-column prop="option" label="edit" >
            <template slot-scope="scope">
<el-button
    size="medium"
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
<el-button
    size="medium"
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
</template>
<script>
import request from '@/utils/request'

  export default {
    data() {
      return {
                userQuery: {"button":"","users":[]}
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