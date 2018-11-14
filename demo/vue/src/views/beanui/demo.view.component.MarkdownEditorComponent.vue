

<template>
<div class="MarkdownEditorComponent-container">
<div class="MarkdownEditorComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="MarkdownEditorComponent_loading" ref="MarkdownEditorComponent" :model="MarkdownEditorComponent"
>
<el-form-item prop="content"
  label=""
>
<markdown-editor v-model="MarkdownEditorComponent.content" ref="contentEditor"
id="contentEditor"
 >
{{MarkdownEditorComponent.content}}
</markdown-editor>
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
      MarkdownEditorComponent_loading: false,
      MarkdownEditorComponent: { 'content': '**this is test**\n\n* vue\n* element\n* webpack\n\n## Simplemde' }

    }
  },
  methods: {

    placeholder_MarkdownEditorComponent_MarkdownEditorComponent(param1, param2, param3, param4) {
    },
    placeholder_MarkdownEditorComponent_content(param1, param2, param3, param4) {
    }

  }
}
</script>
<style rel="stylesheet/scss" lang="scss">
    .MarkdownEditorComponent-container {

    }
    .MarkdownEditorComponent-inner-container {
        margin: 20px;
    }
</style>