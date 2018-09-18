

<template>
<div class="DynamicTableComponent-container">
<div class="DynamicTableComponent-inner-container">
<el-form v-loading="DynamicTableComponent_loading" ref="DynamicTableComponent" :model="DynamicTableComponent"
>
<el-form-item prop="label1" 
 
 label=""
>
<el-alert v-model="DynamicTableComponent.label1" title="Fixed header, sorted by header order" 
 
>
</@createI18N element=element attr=''>
</el-alert>
</el-form-item>
<el-form-item prop="checkbox1" 
 
 label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox1" :data="DynamicTableComponent.checkboxData1" 
 
>
    <el-checkbox v-for="item in DynamicTableComponent.checkboxData1" :key="item.key" :label="item.label">
    </el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item prop="table1" 
 
 label=""
>
<el-table :data="DynamicTableComponent.tableData1" 
 
>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.fruitName')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.fruitName" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.apple')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.apple" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.banana')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.banana" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.orange')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.orange" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
</el-table>
</el-form-item>
<el-form-item prop="label2" 
 
 label=""
>
<el-alert v-model="DynamicTableComponent.label2" title="Not fixed header, sorted by click order" 
 
>
</@createI18N element=element attr=''>
</el-alert>
</el-form-item>
<el-form-item prop="checkbox2" 
 
 label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox2" :data="DynamicTableComponent.checkboxData2" 
 
>
    <el-checkbox v-for="item in DynamicTableComponent.checkboxData2" :key="item.key" :label="item.label">
    </el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item prop="table2" 
 
 label=""
>
<el-table :data="DynamicTableComponent.tableData2" 
 
>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.fruitName')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.fruitName" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.apple')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.apple" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.banana')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.banana" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
 <el-table-column 
 :label="$t('demo.view.table.DynamicRow.orange')"
>
    <template slot-scope="scope">
<span v-model="DynamicTableComponent.orange" 
 
>
</@createI18N element=element attr=''>
</span>
     </template>
    </el-table-column>
</el-table>
</el-form-item>
</el-form>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
    this.created_DynamicTableComponent_DynamicTableComponent();
        },
    data() {
      return {
            DynamicTableComponent_loading: false,
            DynamicTableComponent: {}
      }
    },
    methods: {
    
    created_DynamicTableComponent_DynamicTableComponent() {
        this.DynamicTableComponent_loading = true;
        request({
            url: "/dynamic-table/init",
            method: "get"
        }).then(res => {
            this.DynamicTableComponent = res.data;
            this.DynamicTableComponent_loading = false;
        }).catch(err => {
            this.DynamicTableComponent_loading = false;
        })
      }
    


























































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