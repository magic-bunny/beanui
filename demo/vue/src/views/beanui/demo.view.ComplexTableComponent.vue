

<template>
<div class="ComplexTableComponent-container">
<div class="ComplexTableComponent-inner-container">
    <el-form ref="complexTableDataForm" :model="complexTableDataForm" >
<el-form-item prop="table" 
label=""
>
<el-form-item>
    <el-table :data="complexTableDataForm.tableData" 
    >
        <el-table-column
        label="ID" width="60" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.id}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Date" width="150" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.date}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Author" width="100" 
>
        <template slot-scope="scope">
<span 
>
{{scope.row.author}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="Importance" width="150" 
>
        <template slot-scope="scope">
<el-rate v-model="scope.row.importance" 
>
</el-rate>
         </template>
        </el-table-column>
        <el-table-column
        label="Readings" width="100" 
>
        <template slot-scope="scope">
<span 
@click="click_complexTableDataForm_readings"
>
{{scope.row.readings}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        prop="title" label="Title" width="300" 
>
        <template slot-scope="scope">
<el-input v-model="scope.row.title" size="mini" 
>
</el-input>
         </template>
        </el-table-column>
        <el-table-column
        label="Status" width="100" 
>
        <template slot-scope="scope">
<el-tag 
>
{{scope.row.status}}
</el-tag>
         </template>
        </el-table-column>
        <el-table-column
        prop="actions" label="actions" width="240" 
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
    <el-form ref="complexTableEditForm" :model="complexTableEditForm" label-width="150px" >
<el-form-item prop="type" 
label="Type"
>
<el-input v-model="complexTableEditForm.type" label="Type" 
>
</el-input>
</el-form-item>
<el-form-item prop="date" 
label="Date"
>
<el-input v-model="complexTableEditForm.date" label="Date" 
>
</el-input>
</el-form-item>
<el-form-item prop="title" 
label="Title"
>
<el-input v-model="complexTableEditForm.title" label="Title" 
>
</el-input>
</el-form-item>
<el-form-item prop="status" 
label="Status"
>
<el-input v-model="complexTableEditForm.status" label="Status" 
>
</el-input>
</el-form-item>
<el-form-item prop="imp" 
label="Imp"
>
<el-rate v-model="complexTableEditForm.imp" label="Imp" 
>
</el-rate>
</el-form-item>
<el-form-item prop="remark" 
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
            complexTableDataForm: {}
            ,
            complexTableEditForm: {}
      }
    },
    methods: {

    
    created_complexTableDataForm_complexTableDataForm() {
        request({
            url: "/complex-table/init-complex-table-data-form",
            method: "get"
        }).then(res => {
            this.complexTableDataForm = res.data;
        }).catch(err => {

        })
      }
    
































    ,
    click_complexTableDataForm_readings() {
        request({
            url: "/complex-table/init-complex-table-edit-form",
            method: "get"
        }).then(res => {
            this.complexTableEditForm = res.data;
        }).catch(err => {

        })
      }
    


















    ,
    click_complexTableDataForm_actionEdit() {
        request({
            url: "/complex-table/init-complex-table-edit-form",
            method: "get"
        }).then(res => {
            this.complexTableEditForm = res.data;
        }).catch(err => {

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