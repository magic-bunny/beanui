
<template>
  <div class="login-container">

    <el-form class="login-form" autoComplete="on" :model="LoginComponent" :rules="loginRules" ref="LoginComponent" label-position="left">

      <div class="title-container">
        <h3 class="title">{{$t('demo.view.LoginComponent.title')}}
</h3>
        <lang-select class="set-language"></lang-select>
        <img class="user-avatar" :src="LoginComponent.userImage">
      </div>

      <el-form-item prop="username">
        <span class="svg-container svg-container_login">
          <svg-icon icon-class="user" />
        </span>
        <el-input name="username" type="text" v-model="LoginComponent.username" autoComplete="on" :placeholder="$t('demo.view.LoginComponent.username')"
/>
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input name="password" :type="passwordType" @keyup.enter.native="handleLogin" v-model="LoginComponent.password" autoComplete="on" :placeholder="$t('demo.view.LoginComponent.password')"
/>
        <span class="show-pwd" @click="showPwd">
          <svg-icon icon-class="eye" />
        </span>
      </el-form-item>

      <el-button type="primary" style="width:70%;" :loading="loading" @click.native.prevent="handleLogin">{{$t('demo.view.LoginComponent.loginButton')}}
</el-button>

      <el-button class="thirdparty-button" type="success" @click="showDialog=true">{{$t('demo.view.LoginComponent.signupButton')}}
</el-button>

      <el-checkbox class="remember" v-model="LoginComponent.remember">{{$t('demo.view.LoginComponent.remember')}}
</el-checkbox>
    </el-form>

    <el-dialog :title="$t('demo.view.LoginComponent.signupTitle')"
 :visible.sync="showDialog" append-to-body>
      <br/>
      <br/>
      <br/>
      <br/>
      Comming Soon......
      <br/>
      <br/>
      <br/>
      <br/>
    </el-dialog>

  </div>
</template>

<script>
import { isvalidUsername } from '@/utils/validate'
import LangSelect from '@/components/LangSelect'
import Cookies from 'js-cookie'

export default {
  components: { LangSelect },
  name: 'login',
  data() {
    return {
      LoginComponent: {
        username: Cookies.get('login-name'),
        password: Cookies.get('password'),
        remember: true,
        userImage: Cookies.get('user-image')
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur'}],
        password: [{ required: true, trigger: 'blur'}]
      },
      passwordType: 'password',
      loading: false,
      showDialog: false
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
    },
    handleLogin() {
      this.$refs.LoginComponent.validate(valid => {
        if (valid) {
          this.loading = true
          var data = {
            username: this.LoginComponent.username,
            password: this.LoginComponent.password,
            remember: this.LoginComponent.remember
          }
          this.$store.dispatch('LoginByUsername', data).then(() => {
            this.loading = false
            this.$router.push({ path: '/' })
          }).catch((error) => {
            this.loading = false
            this.$message({
                message: error,
                type: 'warning'
            });
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
  /* 修复input 背景不协调 和光标变色 */
  /* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

  $bg:#283443;
  $light_gray:#eee;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login-container .el-input input{
      color: $cursor;
      &::first-line {
        color: $light_gray;
      }
    }
  }

  /* reset element-ui css */
  .login-container {
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $light_gray;
        height: 47px;
        caret-color: $cursor;
        &:-webkit-autofill {
          -webkit-box-shadow: 0 0 0px 1000px $bg inset !important;
          -webkit-text-fill-color: $cursor !important;
        }
      }
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>

<style rel="stylesheet/scss" lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  position: fixed;
  height: 100%;
  width: 100%;
  background-color: $bg;
  .login-form {
    position: absolute;
    left: 0;
    right: 0;
    width: 520px;
    padding: 35px 35px 35px 35px;
    margin: 50px auto;
  }
  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;
    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }
  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
    &_login {
      font-size: 20px;
    }
  }
  .title-container {
    position: relative;
    text-align: center;
    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .set-language {
      color: #fff;
      position: absolute;
      top: 5px;
      right: 0px;
    }
    img {
       width: 150px;
       height: 150px;
       margin-bottom: 40px;
    }
  }
  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
  .thirdparty-button {
    position: absolute;
    width: 22%;
    right: 35px;
  }

  .remember {
    margin-top: 30px
  }
}
</style>
