

<template>
<div class="TestComponent-container">
<div class="TestComponent-inner-container">
<el-form v-loading="testForm_loading" ref="testForm" :model="testForm"
:rules="testForm_rules"
label-width="120px"
>
<el-form-item prop="username" 
 
 :label="$t('demo.view.form.TestForm.username')"
>
<el-input v-model="testForm.username" 
 
>
</@createI18N element=element attr=''>
</el-input>
</el-form-item>
<el-form-item prop="password" 
 
 :label="$t('demo.view.form.TestForm.password')"
>
<el-input v-model="testForm.password" 
 
>
</@createI18N element=element attr=''>
</el-input>
</el-form-item>
<el-form-item prop="isAdmin" 
 
 label=""
>
<el-badge value="20" 
>
<el-switch v-model="testForm.isAdmin" 
 
>
</@createI18N element=element attr=''>
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate" 
 
 label=""
>
<el-date-picker v-model="testForm.lastDate" 
 
>
</@createI18N element=element attr=''>
</el-date-picker>
</el-form-item>
<el-form-item prop="users" 
 
 label=""
>
<el-table 
 
>
 <el-table-column type="selection" width="50" 
 :label="$t('demo.view.table.UserRow.id')"
>
    <template slot-scope="scope">
<span v-model="testForm.id" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.UserRow.name')"
>
    <template slot-scope="scope">
<el-input v-model="testForm.name" size="mini" 
 
>
</@createI18N element=element attr=''>
</el-input>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.UserRow.age')"
>
    <template slot-scope="scope">
<el-input-number v-model="testForm.age" size="mini" 
 
>
</@createI18N element=element attr=''>
</el-input-number>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.UserRow.stature')"
>
    <template slot-scope="scope">
<span v-model="testForm.stature" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.UserRow.weight')"
>
    <template slot-scope="scope">
<el-input-number v-model="testForm.weight" size="mini" 
 
>
</@createI18N element=element attr=''>
</el-input-number>
     </template>
    </el-table-column>
 <el-table-column width="240" 
 :label="$t('demo.view.table.UserRow.lastDate')"
>
    <template slot-scope="scope">
<el-date-picker v-model="testForm.lastDate" size="mini" 
 
>
</@createI18N element=element attr=''>
</el-date-picker>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.UserRow.option')"
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
</@createI18N element=element attr=''>
</el-rate>
</el-form-item>
<el-form-item prop="detail" 
 
 label=""
>
<el-select v-model="testForm.detail" placeholder="请选择" :options="testForm.options" 
 
>
    <el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</el-select>
</el-form-item>
<el-form-item prop="address" 
 
 label=""
>
<el-transfer v-model="testForm.address" :data="testForm.addressData" :titles="['1','2']" 
 
>
</@createI18N element=element attr=''>
</el-transfer>
</el-form-item>
<el-form-item prop="test" 
 
 label=""
>
<el-button icon="el-icon-upload" type="primary" 
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
            ,testForm_rules: {
                username: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
                password: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
                
                
                
                
                
                
                
            }
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