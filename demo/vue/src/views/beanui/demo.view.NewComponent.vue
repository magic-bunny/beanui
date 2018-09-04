

<template>
<div class="app-container">
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
    <el-table :data="testForm.users" >
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
label="level"
>
<el-rate v-model="testForm.level" >
</el-rate>
</el-form-item>
<el-form-item
label="detail"
>
<el-select v-model="testForm.detail" placeholder="请选择" optionId="options" >
<el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
</el-option>
</el-select>
</el-form-item>
<el-form-item
label="options"
>
</el-form-item>
<el-form-item
>
<el-button
    size="medium"
    icon="el-icon-upload"
    text="upload"
    type="primary"
    @click="click_button"
>
    upload
</el-button>
<el-button
    size="medium"
    text="clear"
>
    clear
</el-button>
</el-form-item>
    </el-form>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
        var data = this.testForm;
        request({
            url: "/demo3",
            method: "get",
            data
        }).then(res => {
            this.testForm = res.data;
        }).catch(err => {

        })
      },
    data() {
      return {
                testForm: {"button":"","password":"","button2":"","level":"","options":[],"isAdmin":"","detail":"","users":[],"username":"","lastDate":""}
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