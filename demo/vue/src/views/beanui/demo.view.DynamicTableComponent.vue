

<template>
<div class="DynamicTableComponent-container">
<div class="DynamicTableComponent-inner-container">
    <el-form ref="DynamicTableComponent" :model="DynamicTableComponent" >
<el-form-item
label=""
>
<el-alert v-model="DynamicTableComponent.label1" title="Fixed header, sorted by header order" show-icon>
</el-alert>
</el-form-item>
<el-form-item
label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox1" :data="DynamicTableComponent.checkboxData1">
    <el-checkbox v-for="item in DynamicTableComponent.checkboxData1" :key="item.key" :label="item.label"></el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item
label=""
>
<el-form-item>
    <el-table :data="DynamicTableComponent.tableData1" >
        <el-table-column
        label="fruit name" 
        :label="$t('demo.view.table.DynamicRow.fruitName')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.fruitName}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="apple" 
        :label="$t('demo.view.table.DynamicRow.apple')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.apple}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="banana" 
        :label="$t('demo.view.table.DynamicRow.banana')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.banana}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="orange" 
        :label="$t('demo.view.table.DynamicRow.orange')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.orange}}
</span>
         </template>
        </el-table-column>
    </el-table>
</el-form-item>
</el-form-item>
<el-form-item
label=""
>
<el-alert v-model="DynamicTableComponent.label2" title="Not fixed header, sorted by click order" show-icon>
</el-alert>
</el-form-item>
<el-form-item
label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox2" :data="DynamicTableComponent.checkboxData2">
    <el-checkbox v-for="item in DynamicTableComponent.checkboxData2" :key="item.key" :label="item.label"></el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item
label=""
>
<el-form-item>
    <el-table :data="DynamicTableComponent.tableData2" >
        <el-table-column
        label="fruit name" 
        :label="$t('demo.view.table.DynamicRow.fruitName')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.fruitName}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="apple" 
        :label="$t('demo.view.table.DynamicRow.apple')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.apple}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="banana" 
        :label="$t('demo.view.table.DynamicRow.banana')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.banana}}
</span>
         </template>
        </el-table-column>
        <el-table-column
        label="orange" 
        :label="$t('demo.view.table.DynamicRow.orange')"
        >
        <template slot-scope="scope">
<span >
{{scope.row.orange}}
</span>
         </template>
        </el-table-column>
    </el-table>
</el-form-item>
</el-form-item>
    </el-form>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
        var data = this.DynamicTableComponent;
        request({
            url: "/dynamic-table/init",
            method: "get"
            
        }).then(res => {
            this.DynamicTableComponent = res.data;
        }).catch(err => {

        })
      },
    data() {
      return {
                DynamicTableComponent: {}
      }
    },
    methods: {
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .DynamicTableComponent-container {
    }
    .DynamicTableComponent-inner-container {
        margin: 20px;
    }
</style>