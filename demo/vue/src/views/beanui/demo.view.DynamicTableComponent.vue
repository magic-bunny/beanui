

<template>
<div class="DynamicTableComponent-container">
<div class="DynamicTableComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="DynamicTableComponent_loading" ref="DynamicTableComponent" :model="DynamicTableComponent"
>
<el-form-item prop="label1"
  label=""
>
<el-alert v-model="DynamicTableComponent.label1" title="Fixed header, sorted by header order"
 >
{{DynamicTableComponent.label1}}
</el-alert>
</el-form-item>
<el-form-item prop="checkbox1"
  label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox1" :data="DynamicTableComponent.checkboxData1"
 >
    <el-checkbox v-for="item in checkboxData1" :key="item.key" :label="item.label" :disabled="item.disabled">
    </el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item prop="table1"
  label=""
>
<el-table :data="DynamicTableComponent.tableData1"
  current-change="current_change_DynamicTableComponent_table1" @selection-change="selection_change__DynamicTableComponent_table1">
 <el-table-column  :label="$t('demo.view.table.DynamicRow.fruitName')"
>
    <template slot-scope="scope">
<span v-model="scope.row.fruitName"  >
{{scope.row.fruitName}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.apple')"
>
    <template slot-scope="scope">
<span v-model="scope.row.apple"  >
{{scope.row.apple}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.banana')"
>
    <template slot-scope="scope">
<span v-model="scope.row.banana"  >
{{scope.row.banana}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.orange')"
>
    <template slot-scope="scope">
<span v-model="scope.row.orange"  >
{{scope.row.orange}}
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
{{DynamicTableComponent.label2}}
</el-alert>
</el-form-item>
<el-form-item prop="checkbox2"
  label=""
>
<el-checkbox-group v-model="DynamicTableComponent.checkbox2" :data="DynamicTableComponent.checkboxData2"
 >
    <el-checkbox v-for="item in checkboxData2" :key="item.key" :label="item.label" :disabled="item.disabled">
    </el-checkbox>
</el-checkbox-group>
</el-form-item>
<el-form-item prop="table2"
  label=""
>
<el-table :data="DynamicTableComponent.tableData2"
  current-change="current_change_DynamicTableComponent_table2" @selection-change="selection_change__DynamicTableComponent_table2">
 <el-table-column  :label="$t('demo.view.table.DynamicRow.fruitName')"
>
    <template slot-scope="scope">
<span v-model="scope.row.fruitName"  >
{{scope.row.fruitName}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.apple')"
>
    <template slot-scope="scope">
<span v-model="scope.row.apple"  >
{{scope.row.apple}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.banana')"
>
    <template slot-scope="scope">
<span v-model="scope.row.banana"  >
{{scope.row.banana}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.table.DynamicRow.orange')"
>
    <template slot-scope="scope">
<span v-model="scope.row.orange"  >
{{scope.row.orange}}
</span>
    </template>
    </el-table-column>
</el-table>
</el-form-item>
</el-form>
</el-col>
</el-row>
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
        var data = this.DynamicTableComponent;
        function submitRequest(self) {
            self.DynamicTableComponent_loading = true;
            request({
                url: "/dynamic-table/init",
                method: "get"
            }).then(res => {
                self.DynamicTableComponent = res.data;
                self.DynamicTableComponent_loading = false;
            }).catch(err => {
                self.DynamicTableComponent_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_DynamicTableComponent_label1() {
      }
    




    ,
    placeholder_DynamicTableComponent_checkbox1() {
      }
    




    ,
    current_change_DynamicTableComponent_table1(val) {
        this.DynamicTableComponent.table1 = [val];
    },
    selection_change__DynamicTableComponent_table1(val) {
        this.DynamicTableComponent.table1 = val;
    },
    placeholder_DynamicTableComponent_table1() {
      }
    


    ,
    placeholder_DynamicTableComponent_fruitName() {
      }
    




    ,
    placeholder_DynamicTableComponent_apple() {
      }
    




    ,
    placeholder_DynamicTableComponent_banana() {
      }
    




    ,
    placeholder_DynamicTableComponent_orange() {
      }
    






    ,
    placeholder_DynamicTableComponent_label2() {
      }
    




    ,
    placeholder_DynamicTableComponent_checkbox2() {
      }
    




    ,
    current_change_DynamicTableComponent_table2(val) {
        this.DynamicTableComponent.table2 = [val];
    },
    selection_change__DynamicTableComponent_table2(val) {
        this.DynamicTableComponent.table2 = val;
    },
    placeholder_DynamicTableComponent_table2() {
      }
    


    ,
    placeholder_DynamicTableComponent_fruitName() {
      }
    




    ,
    placeholder_DynamicTableComponent_apple() {
      }
    




    ,
    placeholder_DynamicTableComponent_banana() {
      }
    




    ,
    placeholder_DynamicTableComponent_orange() {
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