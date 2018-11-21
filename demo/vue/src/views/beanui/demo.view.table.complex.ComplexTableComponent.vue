

<template>
<div style="padding:15px; background: #FCFCFC">
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
<el-tooltip placement="top" content="Back to top">
  <back-to-top transitionName="fade" :customStyle="myBackToTopStyle" :visibilityHeight="300" :backPosition="50"></back-to-top>
</el-tooltip>
</div>
</template>
<script>
import request from '@/utils/request'
import JsonEditor from '@/components/JsonEditor'
import MarkdownEditor from '@/components/MarkdownEditor'
import BackToTop from '@/components/BackToTop'
import Tinymce from '@/components/Tinymce'

  export default {
    created: function() {
    },
    components: {
        JsonEditor,
        MarkdownEditor,
        BackToTop,
        Tinymce
    },
    data() {
      return {
        myBackToTopStyle: {
            right: '50px',
            bottom: '50px',
            width: '40px',
            height: '40px',
            'border-radius': '4px',
            'line-height': '45px',
            background: '#e7eaf1'
        },
complexTableEditForm_loading: false,
complexTableEditForm: {"imp":0,"show":false}

      }
    },
    methods: {
    
    placeholder_complexTableEditForm_complexTableEditForm(param1, param2, param3, param4) {
      }
    


    ,
    placeholder_complexTableEditForm_type(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_complexTableEditForm_date(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_complexTableEditForm_title(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_complexTableEditForm_status(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_complexTableEditForm_imp(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_complexTableEditForm_remark(param1, param2, param3, param4) {
      }
    





    }
  }
</script>