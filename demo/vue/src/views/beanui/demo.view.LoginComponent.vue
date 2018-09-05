

<template>
<div class="app-container">
    <el-form ref="loginForm" :model="loginForm" label-width="80px">
<el-form-item
label="username"
>
<el-input v-model="loginForm.username" auto-complete="on" prefix-icon="el-icon-message" >
</el-input>
</el-form-item>
<el-form-item
label="password"
>
<el-input v-model="loginForm.password" type="password" auto-complete="on" prefix-icon="el-icon-goods" suffix-icon="el-icon-more" >
</el-input>
</el-form-item>
<el-form-item
>
<el-button
    size="medium"
    text="login"
>
    login
</el-button>
</el-form-item>
    </el-form>
</div>
</template>
<script>
import request from '@/utils/request'

  export default {
    data() {
      return {
                loginForm: {"password":"","loginButoon":"","username":""}
      }
    },
    methods: {
    }
  }
</script>