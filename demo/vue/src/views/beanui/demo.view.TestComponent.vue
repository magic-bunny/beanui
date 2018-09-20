

<template>
<div class="TestComponent-container">
<div class="TestComponent-inner-container">
<el-card
tag="el-card"
title="test"
>
    <div slot="header">
        <span>test</span>
    </div>
<el-form v-loading="testForm_loading" ref="testForm" :model="testForm"
:rules="testForm_rules"
label-width="120px"
>
<el-form-item prop="username"
 
 :label="$t('demo.view.form.TestForm.username')"
>
<el-input v-model="testForm.username"  
>
{{testForm.username}}
</el-input>
</el-form-item>
<el-form-item prop="password"
 
 :label="$t('demo.view.form.TestForm.password')"
>
<el-input v-model="testForm.password"  
>
{{testForm.password}}
</el-input>
</el-form-item>
<el-form-item prop="isAdmin"
 
 label=""
>
<el-badge value="20"
>
<el-switch v-model="testForm.isAdmin"  
>
{{testForm.isAdmin}}
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate"
 
 label=""
>
<el-date-picker v-model="testForm.lastDate"  
>
{{testForm.lastDate}}
</el-date-picker>
</el-form-item>
<el-form-item prop="users"
 
 label=""
>
<el-table  
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
<el-form-item prop="level"
 
 label=""
>
<el-rate v-model="testForm.level"  
>
{{testForm.level}}
</el-rate>
</el-form-item>
<el-form-item prop="detail"
 
 label=""
>
<el-select v-model="testForm.detail" :data="testForm.options"
placeholder="请选择"
 
>
    <el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</el-select>
</el-form-item>
<el-form-item prop="address"
 
 label=""
>
<el-transfer v-model="testForm.address" :data="testForm.addressData"
:titles="['1','2']"
 
>
{{testForm.address}}
</el-transfer>
</el-form-item>
<el-form-item prop="test"
 
 label=""
>
<el-button icon="el-icon-upload"
type="primary"
 @click="click_testForm_button" 
>
    upload
</el-button>
<el-button  
>
    clear
</el-button>
</el-form-item>
</el-form>
</el-card>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
    this.created_testForm_testForm();
        },
    data() {
      return {
            testForm_loading: false,
            testForm: {}
      }
    },
    methods: {

    
    created_testForm_testForm() {
        this.testForm_loading = true;
        request({
            url: "/demo3",
            method: "get"
        }).then(res => {
            this.testForm = res.data;
            this.testForm_loading = false;
        }).catch(err => {
            this.testForm_loading = false;
        })
      }
    






























































    ,
    click_testForm_button() {
        this.testForm_loading = true;
        request({
            url: "/demo3",
            method: "get"
        }).then(res => {
            this.testForm = res.data;
            this.testForm_loading = false;
        }).catch(err => {
            this.testForm_loading = false;
        })
      }
    







    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .TestComponent-container {
    }
    .TestComponent-inner-container {
        margin: 20px;
    }
</style>