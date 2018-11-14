

<template>
<div class="JsonEditorComponent-container">
<div class="JsonEditorComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="JsonEditorComponent_loading" ref="JsonEditorComponent" :model="JsonEditorComponent"
>
<el-form-item prop="json"
  label=""
>
<json-editor v-model="JsonEditorComponent.json" ref="jsonEditor"
 >
{{JsonEditorComponent.json}}
</json-editor>
</el-form-item>
</el-form>
</el-col>
</el-row>
<el-tooltip placement="top" content="Back to top">
  <back-to-top transitionName="fade" :customStyle="myBackToTopStyle" :visibilityHeight="300" :backPosition="50"></back-to-top>
</el-tooltip>
</div>
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
JsonEditorComponent_loading: false,
JsonEditorComponent: {"json":{"cccccc":"111111","dddddd":"111111","aaaaaa":"111111","bbbbbb":"111111"}}
            
      }
    },
    methods: {
    
    placeholder_JsonEditorComponent_JsonEditorComponent(param1, param2, param3, param4) {
      }
    


    ,
    placeholder_JsonEditorComponent_json(param1, param2, param3, param4) {
      }
    




        
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .JsonEditorComponent-container {

    }
    .JsonEditorComponent-inner-container {
        margin: 20px;
    }
</style>