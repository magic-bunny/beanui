

<template>
<div class="TestComponent-container">
<div class="TestComponent-inner-container">
    <el-form ref="testForm" :model="testForm" label-width="80px">
<el-form-item
label="username"
>
<el-input v-model="testForm.username" >
</el-input>
</el-form-item>
<el-form-item
label="password"
>
<el-input v-model="testForm.password" >
</el-input>
</el-form-item>
<el-form-item
label="isAdmin"
>
<el-switch v-model="testForm.isAdmin" >
</el-switch>
</el-form-item>
<el-form-item
label="lastDate"
>
<el-date-picker v-model="testForm.lastDate" >
</el-date-picker>
</el-form-item>
<el-form-item
>
<el-form-item>
    <el-table >
        <el-table-column type="selection" prop="id" label="id" width="50" >
        </el-table-column>
        <el-table-column prop="name" label="name" >
            <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini" >
</el-input>
            </template>
        </el-table-column>
        <el-table-column prop="age" label="age" >
            <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini" >
</el-input-number>
            </template>
        </el-table-column>
        <el-table-column prop="stature" label="stature" >
        </el-table-column>
        <el-table-column prop="weight" label="weight" >
            <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini" >
</el-input-number>
            </template>
        </el-table-column>
        <el-table-column prop="lastDate" label="lastDate" width="240" >
            <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini" >
</el-date-picker>
            </template>
        </el-table-column>
        <el-table-column prop="option" label="edit" >
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
label="level"
>
<el-rate v-model="testForm.level" >
</el-rate>
</el-form-item>
<el-form-item
label="detail"
>
<el-select v-model="testForm.detail" placeholder="请选择" :options="testForm.options" >
<el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
</el-option>
</el-select>
</el-form-item>
<el-form-item
label="address"
>
<el-transfer v-model="testForm.address" :data="testForm.addressData" :titles="['1','2']" >
</el-transfer>
</el-form-item>
<el-form-item
>
<el-button
    icon="el-icon-upload"
    text="upload"
    type="primary"
    @click="click_button"
>
    upload
</el-button>
<el-button
    text="clear"
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
        var data = this.testForm;
        request({
            url: "/demo3",
            method: "get"
            
        }).then(res => {
            this.testForm = res.data;
        }).catch(err => {

        })
      },
    data() {
      return {
                testForm: {}
      }
    },
    methods: {
            click_button() {
                var data = this.testForm;
                request({
                    url: "/demo3",
                    method: "get",
                    data
                }).then(res => {
                    this.testForm = res.data;
                }).catch(err => {

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