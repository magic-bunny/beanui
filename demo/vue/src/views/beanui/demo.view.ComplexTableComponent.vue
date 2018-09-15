

<template>
<div class="ComplexTableComponent-container">
<div class="ComplexTableComponent-inner-container">
    <el-form v-loading="complexTableDataForm_loading" ref="complexTableDataForm" :model="complexTableDataForm" >
<el-form-item 
prop="table" 


label=""
>
<el-form-item>
    <el-table :data="complexTableDataForm.tableData" 
    >
        <el-table-column width="60" 
        label="ID"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="150" 
        label="Date"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.date}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="100" 
        label="Author"
>
        <template slot-scope="scope">
<span 
>
{{scope.row.author}}
</span>
         </template>
        </el-table-column>
        <el-table-column width="150" 
        label="Importance"
>
        <template slot-scope="scope">
<el-rate v-model="scope.row.importance" 
>
</el-rate>
         </template>
        </el-table-column>
        <el-table-column width="100" 
        label="Readings"
>
        <template slot-scope="scope">
<span 
@click="click_complexTableDataForm_readings"
>
{{scope.row.readings}}
</span>
         </template>
        </el-table-column>
        <el-table-column prop="title" width="300" 
        label="Title"
>
        <template slot-scope="scope">
<el-input v-model="scope.row.title" size="mini" 
>
</el-input>
         </template>
        </el-table-column>
        <el-table-column width="100" 
        label="Status"
>
        <template slot-scope="scope">
<el-tag 
>
{{scope.row.status}}
</el-tag>
         </template>
        </el-table-column>
        <el-table-column prop="actions" width="240" 
        label="actions"
>
        <template slot-scope="scope">
<el-button
    type="primary"
    size="mini"
    style="position: absolute;left: 0px;top: 10px;"
    text="Edit"
    @click="click_complexTableDataForm_actionEdit"
    >
    Edit
</el-button>
<el-button
    type="success"
    size="mini"
    style="position: absolute;left: 60px;top: 10px;"
    text="Publish"
    >
    Publish
</el-button>
<el-button
    type="danger"
    size="mini"
    style="position: absolute;left: 150px;top: 10px;"
    text="Delete"
    >
    Delete
</el-button>
         </template>
        </el-table-column>
    </el-table>
</el-form-item>
</el-form-item>
    </el-form>
<el-dialog
    title="Edit"
:visible.sync="complexTableEditForm.show"
>
    <el-form v-loading="complexTableEditForm_loading" ref="complexTableEditForm" :model="complexTableEditForm" label-width="150px" >
<el-form-item 
prop="type" 


label="Type"
>
<el-input v-model="complexTableEditForm.type" label="Type" 
>
</el-input>
</el-form-item>
<el-form-item 
prop="date" 


label="Date"
>
<el-input v-model="complexTableEditForm.date" label="Date" 
>
</el-input>
</el-form-item>
<el-form-item 
prop="title" 


label="Title"
>
<el-input v-model="complexTableEditForm.title" label="Title" 
>
</el-input>
</el-form-item>
<el-form-item 
prop="status" 


label="Status"
>
<el-input v-model="complexTableEditForm.status" label="Status" 
>
</el-input>
</el-form-item>
<el-form-item 
prop="imp" 


label="Imp"
>
<el-rate v-model="complexTableEditForm.imp" label="Imp" 
>
</el-rate>
</el-form-item>
<el-form-item 
prop="remark" 


label="Remark"
>
<el-input v-model="complexTableEditForm.remark" label="Remark" 
>
</el-input>
</el-form-item>
    </el-form>
</el-dialog>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
    this.created_complexTableDataForm_complexTableDataForm();






































































        },
    data() {
      return {
            complexTableDataForm_loading: false,
            complexTableDataForm: {}
            ,
            complexTableEditForm_loading: false,
            complexTableEditForm: {}
      }
    },
    methods: {

    
    created_complexTableDataForm_complexTableDataForm() {
        this.complexTableDataForm_loading = true;
        request({
            url: "/complex-table/init-complex-table-data-form",
            method: "get"
        }).then(res => {
            this.complexTableDataForm = res.data;
            this.complexTableDataForm_loading = false;
        }).catch(err => {
            this.complexTableDataForm_loading = false;
        })
      }
    
































    ,
    click_complexTableDataForm_readings() {
        this.complexTableDataForm_loading = true;
        request({
            url: "/complex-table/init-complex-table-edit-form",
            method: "get"
        }).then(res => {
            this.complexTableEditForm = res.data;
            this.complexTableDataForm_loading = false;
        }).catch(err => {
            this.complexTableDataForm_loading = false;
        })
      }
    


















    ,
    click_complexTableDataForm_actionEdit() {
        this.complexTableDataForm_loading = true;
        request({
            url: "/complex-table/init-complex-table-edit-form",
            method: "get"
        }).then(res => {
            this.complexTableEditForm = res.data;
            this.complexTableDataForm_loading = false;
        }).catch(err => {
            this.complexTableDataForm_loading = false;
        })
      }
    






















































    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .ComplexTableComponent-container {
    }
    .ComplexTableComponent-inner-container {
        margin: 20px;
    }
</style>