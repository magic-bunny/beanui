

<template>
<div class="Helloworld-container">
<div class="Helloworld-inner-container">
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
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {
    this.created_Helloworld_Helloworld();
    },
    components: {
    },
    data() {
      return {
            Helloworld_loading: false,
            Helloworld: {}
      }
    },
    methods: {
    
    created_Helloworld_Helloworld() {
        var data = this.Helloworld;
        function submitRequest(self) {
            self.Helloworld_loading = true;
            request({
                url: "/test",
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
    placeholder_Helloworld_input() {
      }
    




        
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .Helloworld-container {

    }
    .Helloworld-inner-container {
        margin: 20px;
    }
</style>