

<template>
<div class="TestComponent-container">
<div class="TestComponent-inner-container">
<el-row>
<el-col :span="24/2" style="padding: 10px;">
<el-card
tag="el-card"
title="test"
>
    <div slot="header">
        <span>test</span>
    </div>
<el-form v-loading="testForm_loading" ref="testForm" :model="testForm"
:rules="testForm_rules"
>
<el-form-item prop="username"
  :label="$t('demo.view.form.TestForm.username')"
>
<el-tooltip content="请输入6位以上用户名"
placement="right"
>
<el-input v-model="testForm.username"  >
{{testForm.username}}
</el-input>
</el-tooltip>
</el-form-item>
<el-form-item prop="password"
  :label="$t('demo.view.form.TestForm.password')"
>
<el-input v-model="testForm.password" type="textarea"
 >
{{testForm.password}}
</el-input>
</el-form-item>
<el-form-item prop="isAdmin"
  label=""
>
<el-badge value="20"
>
<el-switch v-model="testForm.isAdmin"  >
{{testForm.isAdmin}}
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate"
  label=""
>
<el-date-picker v-model="testForm.lastDate"  >
{{testForm.lastDate}}
</el-date-picker>
</el-form-item>
<el-form-item prop="users"
  label=""
>
<el-table   current-change="current_change_testForm_users" @selection-change="selection_change__testForm_users">
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
<el-form-item prop="level"
  label=""
>
<el-rate v-model="testForm.level"  >
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
<el-form-item prop="testChart"
  label=""
>
    <demo_view_chart_testchart :chart-data="testForm.testChart"></demo_view_chart_testchart>
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
<el-button  >
    clear
</el-button>
</el-form-item>
</el-form>
</el-card>
</el-col>
<el-col :span="24/2" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="testForm2_loading" ref="testForm2" :model="testForm2"
:rules="testForm2_rules"
>
<el-form-item prop="username"
  :label="$t('demo.view.form.TestForm.username')"
>
<el-tooltip content="请输入6位以上用户名"
placement="right"
>
<el-input v-model="testForm2.username"  >
{{testForm2.username}}
</el-input>
</el-tooltip>
</el-form-item>
<el-form-item prop="password"
  :label="$t('demo.view.form.TestForm.password')"
>
<el-input v-model="testForm2.password" type="textarea"
 >
{{testForm2.password}}
</el-input>
</el-form-item>
<el-form-item prop="isAdmin"
  label=""
>
<el-badge value="20"
>
<el-switch v-model="testForm2.isAdmin"  >
{{testForm2.isAdmin}}
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate"
  label=""
>
<el-date-picker v-model="testForm2.lastDate"  >
{{testForm2.lastDate}}
</el-date-picker>
</el-form-item>
<el-form-item prop="users"
  label=""
>
<el-table   current-change="current_change_testForm2_users" @selection-change="selection_change__testForm2_users">
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
<el-form-item prop="level"
  label=""
>
<el-rate v-model="testForm2.level"  >
{{testForm2.level}}
</el-rate>
</el-form-item>
<el-form-item prop="detail"
  label=""
>
<el-select v-model="testForm2.detail" :data="testForm2.options"
placeholder="请选择"
 >
    <el-option v-for="item in testForm2.options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</el-select>
</el-form-item>
<el-form-item prop="address"
  label=""
>
<el-transfer v-model="testForm2.address" :data="testForm2.addressData"
:titles="['1','2']"
 >
{{testForm2.address}}
</el-transfer>
</el-form-item>
<el-form-item prop="testChart"
  label=""
>
    <demo_view_chart_testchart :chart-data="testForm2.testChart"></demo_view_chart_testchart>
</el-form-item>
<el-form-item prop="test"
  label=""
>
<el-button icon="el-icon-upload"
type="primary"
 @click="click_testForm2_button"
>
    upload
</el-button>
<el-button  >
    clear
</el-button>
</el-form-item>
</el-form>
</el-card>
</el-col>
</el-row>
</div>
</div>
</template>
<script>
import request from '@/utils/request'
import demo_view_chart_testchart from './chart/demo.view.chart.TestChart'

  export default {
    created: function() {
    this.created_testForm_testForm();
    this.created_testForm2_testForm2();
    },
    components: {
        demo_view_chart_testchart
    },
    data() {
      return {
            testForm_loading: false,
            testForm: {}
            ,
            testForm2_loading: false,
            testForm2: {}
      }
    },
    methods: {

    
    created_testForm_testForm() {
        var data = this.testForm;
        function submitRequest(self) {
            self.testForm_loading = true;
            request({
                url: "/demo3",
                method: "get"
            }).then(res => {
                self.testForm = res.data;
                self.testForm_loading = false;
            }).catch(err => {
                self.testForm_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm_username() {
      }
    




    ,
    placeholder_testForm_password() {
      }
    




    ,
    placeholder_testForm_isAdmin() {
      }
    




    ,
    placeholder_testForm_lastDate() {
      }
    




    ,
    current_change_testForm_users(val) {
        this.testForm.users = [val];
    },
    selection_change__testForm_users(val) {
        this.testForm.users = val;
    },
    placeholder_testForm_users() {
      }
    


    ,
    placeholder_testForm_id() {
      }
    




    ,
    placeholder_testForm_name() {
      }
    




    ,
    placeholder_testForm_age() {
      }
    




    ,
    placeholder_testForm_stature() {
      }
    




    ,
    placeholder_testForm_weight() {
      }
    




    ,
    placeholder_testForm_lastDate() {
      }
    




    ,
    placeholder_testForm_option() {
      }
    






    ,
    placeholder_testForm_level() {
      }
    




    ,
    placeholder_testForm_detail() {
      }
    




    ,
    placeholder_testForm_address() {
      }
    




    ,
    placeholder_testForm_testChart() {
      }
    




    ,
    click_testForm_button() {
        var data = this.testForm;
        function submitRequest(self) {
            self.testForm_loading = true;
            request({
                url: "/demo3",
                method: "get"
            }).then(res => {
                self.testForm = res.data;
                self.testForm_loading = false;
            }).catch(err => {
                self.testForm_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm_button2() {
      }
    





        ,

    
    created_testForm2_testForm2() {
        var data = this.testForm2;
        function submitRequest(self) {
            self.testForm2_loading = true;
            request({
                url: "/demo3",
                method: "get"
            }).then(res => {
                self.testForm2 = res.data;
                self.testForm2_loading = false;
            }).catch(err => {
                self.testForm2_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm2_username() {
      }
    




    ,
    placeholder_testForm2_password() {
      }
    




    ,
    placeholder_testForm2_isAdmin() {
      }
    




    ,
    placeholder_testForm2_lastDate() {
      }
    




    ,
    current_change_testForm2_users(val) {
        this.testForm2.users = [val];
    },
    selection_change__testForm2_users(val) {
        this.testForm2.users = val;
    },
    placeholder_testForm2_users() {
      }
    


    ,
    placeholder_testForm2_id() {
      }
    




    ,
    placeholder_testForm2_name() {
      }
    




    ,
    placeholder_testForm2_age() {
      }
    




    ,
    placeholder_testForm2_stature() {
      }
    




    ,
    placeholder_testForm2_weight() {
      }
    




    ,
    placeholder_testForm2_lastDate() {
      }
    




    ,
    placeholder_testForm2_option() {
      }
    






    ,
    placeholder_testForm2_level() {
      }
    




    ,
    placeholder_testForm2_detail() {
      }
    




    ,
    placeholder_testForm2_address() {
      }
    




    ,
    placeholder_testForm2_testChart() {
      }
    




    ,
    click_testForm2_button() {
        var data = this.testForm2;
        function submitRequest(self) {
            self.testForm2_loading = true;
            request({
                url: "/demo3",
                method: "get"
            }).then(res => {
                self.testForm2 = res.data;
                self.testForm2_loading = false;
            }).catch(err => {
                self.testForm2_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm2_button2() {
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