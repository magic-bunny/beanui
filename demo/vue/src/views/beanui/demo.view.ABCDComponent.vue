

<template>
<div class="ABCDComponent-container">
<div class="ABCDComponent-inner-container">
<el-form v-loading="userQuery_loading" ref="userQuery" :model="userQuery"
>
<el-form-item prop="user"
 
 label=""
>
<el-table :data="userQuery.users"
 
>
 <el-table-column type="selection"
width="50"
 :label="$t('demo.view.table.UserRow.id')"
>
    <template slot-scope="scope">
<span v-model="scope.row.id"  
>
{{scope.row.id}}
</span>
     </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.UserRow.name')"
>
    <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini"
 
>
{{scope.row.name}}
</el-input>
     </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.UserRow.age')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini"
 
>
{{scope.row.age}}
</el-input-number>
     </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.UserRow.stature')"
>
    <template slot-scope="scope">
<span v-model="scope.row.stature"  
>
{{scope.row.stature}}
</span>
     </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.UserRow.weight')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini"
 
>
{{scope.row.weight}}
</el-input-number>
     </template>
    </el-table-column>
 <el-table-column width="240"
 :label="$t('demo.view.table.UserRow.lastDate')"
>
    <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini"
 
>
{{scope.row.lastDate}}
</el-date-picker>
     </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.UserRow.option')"
>
    <template slot-scope="scope">
<el-button size="mini"
 
>
    edit
</el-button>
     </template>
    </el-table-column>
</el-table>
</el-form-item>
<el-form-item prop="button"
 
 label=""
>
<el-button icon="el-icon-search"
type="primary"
 @click="click_userQuery_button" 
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
    created: function() {
        },
    data() {
      return {
            userQuery_loading: false,
            userQuery: {}
      }
    },
    methods: {


































    
    click_userQuery_button() {
        this.userQuery_loading = true;
        request({
            url: "/demo2",
            method: "get"
        }).then(res => {
            this.userQuery = res.data;
            this.userQuery_loading = false;
        }).catch(err => {
            this.userQuery_loading = false;
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