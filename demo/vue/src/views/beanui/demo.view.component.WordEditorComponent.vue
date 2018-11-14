

<template>
<div class="WordEditorComponent-container">
<div class="WordEditorComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="WordEditorComponent_loading" ref="WordEditorComponent" :model="WordEditorComponent"
>
<el-form-item prop="text"
  label=""
>
<tinymce v-model="WordEditorComponent.text"  >
{{WordEditorComponent.text}}
</tinymce>
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
WordEditorComponent_loading: false,
WordEditorComponent: {}
            
      }
    },
    methods: {
    
    placeholder_WordEditorComponent_WordEditorComponent(param1, param2, param3, param4) {
      }
    


    ,
    placeholder_WordEditorComponent_text(param1, param2, param3, param4) {
      }
    




        
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .WordEditorComponent-container {

    }
    .WordEditorComponent-inner-container {
        margin: 20px;
    }
</style>