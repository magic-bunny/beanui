

<template>
<div style="padding:15px; background: #FCFCFC">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-tabs type="card" value="a" >
    <el-tab-pane name="a" label="title1" >
<el-form v-loading="testForm_loading" ref="testForm" :model="testForm"
:rules="testForm_rules"
>
<el-form-item prop="username"
  :label="$t('demo.view.layout.card.TestForm.username')"
>
<el-tooltip content="请输入6位以上用户名"
placement="right"
>
<el-input v-model="testForm.username"  >
{{testForm.username}}
</el-input>
</el-tooltip>
</el-form-item>
<el-form-item prop="password"
  :label="$t('demo.view.layout.card.TestForm.password')"
>
<el-input v-model="testForm.password" type="textarea"
 >
{{testForm.password}}
</el-input>
</el-form-item>
<el-form-item prop="isAdmin"
  label=""
>
<el-badge value="20"
>
<el-switch v-model="testForm.isAdmin"  >
{{testForm.isAdmin}}
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate"
  label=""
>
<el-date-picker v-model="testForm.lastDate"  >
{{testForm.lastDate}}
</el-date-picker>
</el-form-item>
<el-form-item prop="users"
  label=""
>
<el-table :data="testForm.userData"
  current-change="current_change_testForm_users" @selection-change="selection_change__testForm_users">
 <el-table-column type="selection"
width="50"
 label=""
>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.name')"
>
    <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini"
 >
{{scope.row.name}}
</el-input>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.age')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini"
 >
{{scope.row.age}}
</el-input-number>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.stature')"
>
    <template slot-scope="scope">
<span v-model="scope.row.stature"  >
{{scope.row.stature}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.weight')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini"
 >
{{scope.row.weight}}
</el-input-number>
    </template>
    </el-table-column>
 <el-table-column width="240"
 :label="$t('demo.view.layout.test2.UserRow.lastDate')"
>
    <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini"
 >
{{scope.row.lastDate}}
</el-date-picker>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.option')"
>
    <template slot-scope="scope">
<el-button size="mini"
 >
{{scope.row.option}}
</el-button>
    </template>
    </el-table-column>
</el-table>
</el-form-item>
<el-form-item prop="cascader"
  label=""
>
<el-cascader v-model="testForm.cascader" :options="testForm.cascaderOptions"
 >
</el-cascader>
</el-form-item>
<el-form-item prop="level"
  label=""
>
<el-rate v-model="testForm.level"  >
{{testForm.level}}
</el-rate>
</el-form-item>
<el-form-item prop="detail"
  label=""
>
<el-select v-model="testForm.detail" :data="testForm.options"
placeholder="请选择"
 >
    <el-option v-for="item in testForm.options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</el-select>
</el-form-item>
<el-form-item prop="address"
  label=""
>
<el-transfer v-model="testForm.address" :data="testForm.addressData"
:titles="['1','2']"
 >
{{testForm.address}}
</el-transfer>
</el-form-item>
<el-form-item prop="testChart"
  label=""
>
    <demo_view_layout_card_testchart :chart-data="testForm.testChart"></demo_view_layout_card_testchart>
</el-form-item>
<el-form-item prop="file"
  label=""
>
<el-upload icon="el-icon-upload"
drag="true"
 >
  <i class="el-icon-upload"></i>
  <div class="el-upload__text">将文件拖到此处</div>
</el-upload>
</el-form-item>
<el-form-item prop="layout"
  label=""
>
<el-button icon="el-icon-upload"
type="primary"
  @click="click_testForm_button">
{{testForm.button}}
</el-button>
<el-button  >
{{testForm.button2}}
</el-button>
</el-form-item>
</el-form>
    </el-tab-pane>
    <el-tab-pane name="b" label="title2" >
<el-form v-loading="testForm2_loading" ref="testForm2" :model="testForm2"
:rules="testForm2_rules"
>
<el-form-item prop="username"
  :label="$t('demo.view.layout.card.TestForm.username')"
>
<el-tooltip content="请输入6位以上用户名"
placement="right"
>
<el-input v-model="testForm2.username"  >
{{testForm2.username}}
</el-input>
</el-tooltip>
</el-form-item>
<el-form-item prop="password"
  :label="$t('demo.view.layout.card.TestForm.password')"
>
<el-input v-model="testForm2.password" type="textarea"
 >
{{testForm2.password}}
</el-input>
</el-form-item>
<el-form-item prop="isAdmin"
  label=""
>
<el-badge value="20"
>
<el-switch v-model="testForm2.isAdmin"  >
{{testForm2.isAdmin}}
</el-switch>
</el-badge>
</el-form-item>
<el-form-item prop="lastDate"
  label=""
>
<el-date-picker v-model="testForm2.lastDate"  >
{{testForm2.lastDate}}
</el-date-picker>
</el-form-item>
<el-form-item prop="users"
  label=""
>
<el-table :data="testForm2.userData"
  current-change="current_change_testForm2_users" @selection-change="selection_change__testForm2_users">
 <el-table-column type="selection"
width="50"
 label=""
>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.name')"
>
    <template slot-scope="scope">
<el-input v-model="scope.row.name" size="mini"
 >
{{scope.row.name}}
</el-input>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.age')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.age" size="mini"
 >
{{scope.row.age}}
</el-input-number>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.stature')"
>
    <template slot-scope="scope">
<span v-model="scope.row.stature"  >
{{scope.row.stature}}
</span>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.weight')"
>
    <template slot-scope="scope">
<el-input-number v-model="scope.row.weight" size="mini"
 >
{{scope.row.weight}}
</el-input-number>
    </template>
    </el-table-column>
 <el-table-column width="240"
 :label="$t('demo.view.layout.test2.UserRow.lastDate')"
>
    <template slot-scope="scope">
<el-date-picker v-model="scope.row.lastDate" size="mini"
 >
{{scope.row.lastDate}}
</el-date-picker>
    </template>
    </el-table-column>
 <el-table-column  :label="$t('demo.view.layout.test2.UserRow.option')"
>
    <template slot-scope="scope">
<el-button size="mini"
 >
{{scope.row.option}}
</el-button>
    </template>
    </el-table-column>
</el-table>
</el-form-item>
<el-form-item prop="cascader"
  label=""
>
<el-cascader v-model="testForm2.cascader" :options="testForm2.cascaderOptions"
 >
</el-cascader>
</el-form-item>
<el-form-item prop="level"
  label=""
>
<el-rate v-model="testForm2.level"  >
{{testForm2.level}}
</el-rate>
</el-form-item>
<el-form-item prop="detail"
  label=""
>
<el-select v-model="testForm2.detail" :data="testForm2.options"
placeholder="请选择"
 >
    <el-option v-for="item in testForm2.options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
</el-select>
</el-form-item>
<el-form-item prop="address"
  label=""
>
<el-transfer v-model="testForm2.address" :data="testForm2.addressData"
:titles="['1','2']"
 >
{{testForm2.address}}
</el-transfer>
</el-form-item>
<el-form-item prop="testChart"
  label=""
>
    <demo_view_layout_card_testchart :chart-data="testForm2.testChart"></demo_view_layout_card_testchart>
</el-form-item>
<el-form-item prop="file"
  label=""
>
<el-upload icon="el-icon-upload"
drag="true"
 >
  <i class="el-icon-upload"></i>
  <div class="el-upload__text">将文件拖到此处</div>
</el-upload>
</el-form-item>
<el-form-item prop="layout"
  label=""
>
<el-button icon="el-icon-upload"
type="primary"
  @click="click_testForm2_button">
{{testForm2.button}}
</el-button>
<el-button  >
{{testForm2.button2}}
</el-button>
</el-form-item>
</el-form>
    </el-tab-pane>
</el-tabs>
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
import demo_view_layout_card_testchart from './demo.view.layout.card.TestChart'

  export default {
    created: function() {
    this.created_testForm_testForm();
    this.created_testForm2_testForm2();
    },
    components: {
        JsonEditor,
        MarkdownEditor,
        BackToTop,
        Tinymce,
        demo_view_layout_card_testchart
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
                testForm_loading: false,
testForm: {"cascaderOptions":[],"level":0,"button":"Upload","button2":"Clear","admin":false}
,testForm_rules: {
    username: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
    password: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
    
    
    
    
    
    
    
    
    
    
}
,
                testForm2_loading: false,
testForm2: {"cascaderOptions":[],"level":0,"button":"Upload","button2":"Clear","admin":false}
,testForm2_rules: {
    username: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
    password: [{"min":"","len":"","max":"","pattern":"","trigger":"","type":"","message":"","required":"true"}],
    
    
    
    
    
    
    
    
    
    
}


      }
    },
    methods: {
                
    created_testForm_testForm(param1, param2, param3, param4) {
        var data = this.testForm;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.testForm_loading = true;
            request({
                url: "/demo3" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.testForm = res.data;
                self.testForm_loading = false;
            }).catch(err => {
                self.testForm_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm_username(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_password(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_isAdmin(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_lastDate(param1, param2, param3, param4) {
      }
    




    ,
    current_change_testForm_users(val) {
        this.testForm.users = [val];
    },
    selection_change__testForm_users(val) {
        this.testForm.users = val;
    },
    placeholder_testForm_users(param1, param2, param3, param4) {
      }
    


    ,
    placeholder_testForm_id(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_name(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_age(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_stature(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_weight(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_lastDate(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_option(param1, param2, param3, param4) {
      }
    






    ,
    placeholder_testForm_cascader(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_level(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_detail(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_address(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_testChart(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm_file(param1, param2, param3, param4) {
      }
    




    ,
    click_testForm_button(param1, param2, param3, param4) {
        var data = this.testForm;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.testForm_loading = true;
            request({
                url: "/demo3" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.testForm = res.data;
                self.testForm_loading = false;
            }).catch(err => {
                self.testForm_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm_button2(param1, param2, param3, param4) {
      }
    




,
                
    created_testForm2_testForm2(param1, param2, param3, param4) {
        var data = this.testForm2;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.testForm2_loading = true;
            request({
                url: "/demo3" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.testForm2 = res.data;
                self.testForm2_loading = false;
            }).catch(err => {
                self.testForm2_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm2_username(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_password(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_isAdmin(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_lastDate(param1, param2, param3, param4) {
      }
    




    ,
    current_change_testForm2_users(val) {
        this.testForm2.users = [val];
    },
    selection_change__testForm2_users(val) {
        this.testForm2.users = val;
    },
    placeholder_testForm2_users(param1, param2, param3, param4) {
      }
    


    ,
    placeholder_testForm2_id(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_name(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_age(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_stature(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_weight(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_lastDate(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_option(param1, param2, param3, param4) {
      }
    






    ,
    placeholder_testForm2_cascader(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_level(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_detail(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_address(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_testChart(param1, param2, param3, param4) {
      }
    




    ,
    placeholder_testForm2_file(param1, param2, param3, param4) {
      }
    




    ,
    click_testForm2_button(param1, param2, param3, param4) {
        var data = this.testForm2;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.testForm2_loading = true;
            request({
                url: "/demo3" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.testForm2 = res.data;
                self.testForm2_loading = false;
            }).catch(err => {
                self.testForm2_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_testForm2_button2(param1, param2, param3, param4) {
      }
    






    }
  }
</script>