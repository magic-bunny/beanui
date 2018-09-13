


<template>
<div class="TestComponent-container">
<div class="TestComponent-inner-container">
    <el-form ref="testForm" :model="testForm" >
<el-form-item
:label="$t('demo.view.TestForm.username')"
>
<el-input v-model="testForm.username" >
</el-input>
</el-form-item>
<el-form-item
:label="$t('demo.view.TestForm.password')"
>
<el-input v-model="testForm.password" >
</el-input>
</el-form-item>
<el-form-item
label=""
>
<el-switch v-model="testForm.isAdmin" >
</el-switch>
</el-form-item>
<el-form-item
label=""
>
<el-date-picker v-model="testForm.lastDate" >
</el-date-picker>
</el-form-item>
<el-form-item
label=""
>
<el-form-item>
    <el-table >
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
<el-rate v-model="testForm.level" >
</el-rate>
</el-form-item>
<el-form-item
label=""
>
<el-select v-model="testForm.detail" placeholder="请选择" :options="testForm.options" >
<el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
</el-option>
</el-select>
</el-form-item>
<el-form-item
label=""
>
</el-form-item>
<el-form-item
label=""
>
<el-transfer v-model="testForm.address" :data="testForm.addressData" :titles="['1','2']" >
</el-transfer>
</el-form-item>
<el-form-item
label=""
>
<el-button
    icon="el-icon-upload"
    type="primary"
    text="upload"
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
    this.created_testForm();








































































        },
    data() {
      return {
                testForm: {}
      }
    },
    methods: {

    
    created_testForm() {
        request({
            url: "/demo3",
            method: "get"
        }).then(res => {
            this.testForm = res.data;
        }).catch(err => {

        })
      }
    




































































































    ,
    click_button() {
        request({
            url: "/demo3",
            method: "get"
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