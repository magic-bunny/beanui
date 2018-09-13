


<template>
<div class="LoginComponent-container">
<div class="LoginComponent-inner-container">
    <el-form ref="LoginComponent" :model="LoginComponent" >
<el-form-item
label=" "
>
<el-input v-model="LoginComponent.username" label=" " auto-complete="on" prefix-icon="el-icon-message" >
</el-input>
</el-form-item>
<el-form-item
label=" "
>
<el-input v-model="LoginComponent.password" label=" " type="password" auto-complete="on" prefix-icon="el-icon-goods" suffix-icon="el-icon-more" >
</el-input>
</el-form-item>
<el-form-item
label=""
>
<el-button
    type="primary"
    style="width:100%;margin-bottom:30px;"
    text="login"
>
    login

</el-button>
</el-form-item>
    </el-form>
</div>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    created: function() {














        },
    data() {
      return {
                LoginComponent: {}
      }
    },
    methods: {





















    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .LoginComponent-container {
        background-color: #2d3a4b;
        position: fixed;
        height: 100%;
        width: 100%;
    }
    .LoginComponent-inner-container {
        margin: 20px;
        width: 600px;
        margin: 120px auto;
        position: absolute;
        left: 0;
        right: 0;
    }
</style>