

<template>
<div class="ABCDComponent-container">
<div class="ABCDComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="userQuery_loading" ref="userQuery" :model="userQuery"
>
<el-form-item prop="user"
  label=""
>
<el-table :data="userQuery.users"
  highlight-current-row current-change="current_change_userQuery_user" @selection-change="selection_change__userQuery_user">
 <el-table-column type="selection"
width="50"
 label=""
>
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
<span v-model="scope.row.stature"  >
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
<el-form-item prop="a"
  label=""
>
<el-button icon="el-icon-search"
type="primary"
 @click="click_userQuery_button"
>
    Query
</el-button>
<el-button icon="el-icon-search"
type="danger"
 @click="click_userQuery_button2"
>
    Save
</el-button>
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
        },
    data() {
      return {
            userQuery_loading: false,
            userQuery: {}
      }
    },
    methods: {
    
    placeholder_userQuery_userQuery() {
      }
    


    ,
    current_change_userQuery_user(val) {
        this.userQuery.user = [val];
    },
    selection_change__userQuery_user(val) {
        this.userQuery.user = val;
    },
    placeholder_userQuery_user() {
      }
    


    ,
    placeholder_userQuery_id() {
      }
    




    ,
    placeholder_userQuery_name() {
      }
    




    ,
    placeholder_userQuery_age() {
      }
    




    ,
    placeholder_userQuery_stature() {
      }
    




    ,
    placeholder_userQuery_weight() {
      }
    




    ,
    placeholder_userQuery_lastDate() {
      }
    




    ,
    placeholder_userQuery_option() {
      }
    






    ,
    click_userQuery_button() {
        this.userQuery_loading = true;
        var data = this.userQuery;
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
    


    ,
    click_userQuery_button2() {
        this.userQuery_loading = true;
        var data = this.userQuery;
        request({
            url: "/demo4",
            method: "post"
            ,data
        }).then(res => {
            this.userQuery = res.data;
            this.userQuery_loading = false;
        }).catch(err => {
            this.userQuery_loading = false;
        })
      }
    




,
message_userQuery_message(text) {
    this.$message({
        message: text
    });
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