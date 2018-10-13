

<template>
<div class="ComplexTableComponent-container">
<div class="ComplexTableComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-dialog
title="Edit"
:visible.sync="complexTableEditForm.show"
tag="el-dialog"
>
<el-form v-loading="complexTableEditForm_loading" ref="complexTableEditForm" :model="complexTableEditForm"
label-width="150px"
>
<el-form-item prop="type"
  label="Config"
>
<el-input v-model="complexTableEditForm.type"  >
{{complexTableEditForm.type}}
</el-input>
</el-form-item>
<el-form-item prop="date"
  label="Date"
>
<el-input v-model="complexTableEditForm.date"  >
{{complexTableEditForm.date}}
</el-input>
</el-form-item>
<el-form-item prop="title"
  label="Title"
>
<el-input v-model="complexTableEditForm.title"  >
{{complexTableEditForm.title}}
</el-input>
</el-form-item>
<el-form-item prop="status"
  label="Status"
>
<el-input v-model="complexTableEditForm.status"  >
{{complexTableEditForm.status}}
</el-input>
</el-form-item>
<el-form-item prop="imp"
  label="Imp"
>
<el-rate v-model="complexTableEditForm.imp"  >
{{complexTableEditForm.imp}}
</el-rate>
</el-form-item>
<el-form-item prop="remark"
  label="Remark"
>
<el-input v-model="complexTableEditForm.remark"  >
{{complexTableEditForm.remark}}
</el-input>
</el-form-item>
</el-form>
</el-dialog>
</el-col>
</el-row>
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="complexTableDataForm_loading" ref="complexTableDataForm" :model="complexTableDataForm"
>
<el-form-item prop="table"
  label=""
>
<el-table :data="complexTableDataForm.tableData"
  current-change="current_change_complexTableDataForm_table" @selection-change="selection_change__complexTableDataForm_table">
 <el-table-column width="60"
 label="ID"
>
    <template slot-scope="scope">
<span v-model="scope.row.id"  >
{{scope.row.id}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="150"
 label="Date"
>
    <template slot-scope="scope">
<span v-model="scope.row.date"  >
{{scope.row.date}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Author"
>
    <template slot-scope="scope">
<span v-model="scope.row.author"  >
{{scope.row.author}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="150"
 label="Importance"
>
    <template slot-scope="scope">
<el-rate v-model="scope.row.importance"  >
{{scope.row.importance}}
</el-rate>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Readings"
>
    <template slot-scope="scope">
<span v-model="scope.row.readings"  @click="click_complexTableDataForm_readings"
>
{{scope.row.readings}}
</span>
    </template>
    </el-table-column>
 <el-table-column prop="title"
width="300"
 label="Title"
>
    <template slot-scope="scope">
<el-input v-model="scope.row.title" size="mini"
 >
{{scope.row.title}}
</el-input>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Status"
>
    <template slot-scope="scope">
<el-tag :type="scope.row.statusType"
 >
{{scope.row.status}}
</el-tag>
    </template>
    </el-table-column>
 <el-table-column prop="actions"
width="240"
 label="actions"
>
    <template slot-scope="scope">
<el-button type="primary"
size="mini"
style="position: absolute;left: 0px;top: 10px;"
 @click="click_complexTableDataForm_actionEdit"
>
    Edit
</el-button>
<el-button type="success"
size="mini"
style="position: absolute;left: 60px;top: 10px;"
 >
    Publish
</el-button>
<el-button type="danger"
size="mini"
style="position: absolute;left: 150px;top: 10px;"
 >
    Delete
</el-button>
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
    this.created_complexTableDataForm_complexTableDataForm()
  },
  components: {
  },
  data() {
    return {
      complexTableEditForm_loading: false,
      complexTableEditForm: {},
      complexTableDataForm_loading: false,
      complexTableDataForm: {}
    }
  },
  methods: {

    placeholder_complexTableEditForm_complexTableEditForm() {
    },
    placeholder_complexTableEditForm_type() {
    },
    placeholder_complexTableEditForm_date() {
    },
    placeholder_complexTableEditForm_title() {
    },
    placeholder_complexTableEditForm_status() {
    },
    placeholder_complexTableEditForm_imp() {
    },
    placeholder_complexTableEditForm_remark() {
    },
    created_complexTableDataForm_complexTableDataForm() {
      var data = this.complexTableDataForm
      function submitRequest(self) {
        self.complexTableDataForm_loading = true
        request({
          url: '/complex-table/init-complex-table-data-form',
          method: 'get'
        }).then(res => {
          self.complexTableDataForm = res.data
          self.complexTableDataForm_loading = false
        }).catch(err => {
          self.complexTableDataForm_loading = false
        })
      }
      submitRequest(this)
    },
    current_change_complexTableDataForm_table(val) {
      this.complexTableDataForm.table = [val]
    },
    selection_change__complexTableDataForm_table(val) {
      this.complexTableDataForm.table = val
    },
    placeholder_complexTableDataForm_table() {
    },
    placeholder_complexTableDataForm_id() {
    },
    placeholder_complexTableDataForm_date() {
    },
    placeholder_complexTableDataForm_author() {
    },
    placeholder_complexTableDataForm_importance() {
    },
    click_complexTableDataForm_readings() {
      var data = this.complexTableDataForm
      function submitRequest(self) {
        self.complexTableDataForm_loading = true
        request({
          url: '/complex-table/init-complex-table-edit-form',
          method: 'get'
        }).then(res => {
          self.complexTableEditForm = res.data
          self.complexTableDataForm_loading = false
        }).catch(err => {
          self.complexTableDataForm_loading = false
        })
      }
      submitRequest(this)
    },
    placeholder_complexTableDataForm_title() {
    },
    placeholder_complexTableDataForm_status() {
    },
    click_complexTableDataForm_actionEdit() {
      var data = this.complexTableDataForm
      function submitRequest(self) {
        self.complexTableDataForm_loading = true
        request({
          url: '/complex-table/init-complex-table-edit-form',
          method: 'get'
        }).then(res => {
          self.complexTableEditForm = res.data
          self.complexTableDataForm_loading = false
        }).catch(err => {
          self.complexTableDataForm_loading = false
        })
      }
      submitRequest(this)
    },
    placeholder_complexTableDataForm_actionPublish() {
    },
    placeholder_complexTableDataForm_actionDelete() {
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