

<template>
<div style="padding:15px; background: #FCFCFC">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="Helloworld_loading" ref="Helloworld" :model="Helloworld"
>
<el-form-item prop="input"
  label="hello world"
>
<el-input v-model="Helloworld.input"  >
{{Helloworld.input}}
</el-input>
</el-form-item>
</el-form>
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
    this.created_Helloworld_Helloworld();
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
Helloworld_loading: false,
Helloworld: {}
            
      }
    },
    methods: {
    
    created_Helloworld_Helloworld(param1, param2, param3, param4) {
        var data = this.Helloworld;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.Helloworld_loading = true;
            request({
                url: "/layout" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.Helloworld = res.data;
                self.Helloworld_loading = false;
            }).catch(err => {
                self.Helloworld_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_Helloworld_input(param1, param2, param3, param4) {
      }
    




        
    }
  }
</script>