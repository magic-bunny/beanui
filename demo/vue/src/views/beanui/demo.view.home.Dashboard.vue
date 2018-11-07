

<template>
<div class="Dashboard-container">
<div class="Dashboard-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="chartForm1_loading" ref="chartForm1" :model="chartForm1"
>
<el-form-item prop="chart1"
  label=""
>
    <demo_view_home_chart1 :chart-data="chartForm1.chart1"></demo_view_home_chart1>
</el-form-item>
</el-form>
</el-card>
</el-col>
</el-row>
<el-col :span="24/3" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="chartForm2_loading" ref="chartForm2" :model="chartForm2"
>
<el-form-item prop="chart2"
  label=""
>
    <demo_view_home_chart2 :chart-data="chartForm2.chart2"></demo_view_home_chart2>
</el-form-item>
</el-form>
</el-card>
</el-col>
<el-col :span="24/3" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="chartForm3_loading" ref="chartForm3" :model="chartForm3"
>
<el-form-item prop="chart3"
  label=""
>
    <demo_view_home_chart3 :chart-data="chartForm3.chart3"></demo_view_home_chart3>
</el-form-item>
</el-form>
</el-card>
</el-col>
</el-row>
<el-row>
<el-col :span="24/3" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="chartForm4_loading" ref="chartForm4" :model="chartForm4"
>
<el-form-item prop="chart4"
  label=""
>
    <demo_view_home_chart4 :chart-data="chartForm4.chart4"></demo_view_home_chart4>
</el-form-item>
</el-form>
</el-card>
</el-col>
<el-row>
<el-col :span="24/2" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="tableForm_loading" ref="tableForm" :model="tableForm"
>
<el-form-item prop="tableRow"
  label=""
>
<el-table :data="tableForm.tabelRowData"
  current-change="current_change_tableForm_tableRow" @selection-change="selection_change__tableForm_tableRow">
 <el-table-column width="300"
 label="Order_No"
>
    <template slot-scope="scope">
<span v-model="scope.row.orderNumber"  >
{{scope.row.orderNumber}}
</span>
    </template>
    </el-table-column>
 <el-table-column prop="price"
width="150"
 label="Price"
>
    <template slot-scope="scope">
<el-tag size="mini"
type="info"
 >
{{scope.row.currency}}
</el-tag>
<span v-model="scope.row.price"  >
{{scope.row.price}}
</span>
    </template>
    </el-table-column>
 <el-table-column  label="Status"
>
    <template slot-scope="scope">
<el-tag :type="scope.row.success"
 >
{{scope.row.status}}
</el-tag>
    </template>
    </el-table-column>
</el-table>
</el-form-item>
</el-form>
</el-card>
</el-col>
<el-col :span="24/2" style="padding: 10px;">
<el-card
tag="el-card"
>
<el-form v-loading="top5Form_loading" ref="top5Form" :model="top5Form"
>
<el-form-item prop="image"
  label=""
>
<img v-model="top5Form.image" src="https://article-fd.zol-img.com.cn/t_s640x2000/g5/M00/0F/09/ChMkJlvD-sWIB2v2AAXSpmRRBDUAAsfUAO0r_cABdK-697.jpg"
 >
{{top5Form.image}}
</img>
</el-form-item>
<el-form-item prop="vue"
  label="Vue"
>
<el-progress v-model="top5Form.vue" percentage="70"
stroke-width="18"
text-inside="true"
 >
{{top5Form.vue}}
</el-progress>
</el-form-item>
<el-form-item prop="javascript"
  label="Javascript"
>
<el-progress v-model="top5Form.javascript" percentage="18"
stroke-width="18"
text-inside="true"
 >
{{top5Form.javascript}}
</el-progress>
</el-form-item>
<el-form-item prop="css"
  label="Css"
>
<el-progress v-model="top5Form.css" percentage="12"
stroke-width="18"
text-inside="true"
 >
{{top5Form.css}}
</el-progress>
</el-form-item>
<el-form-item prop="eslint"
  label="Eslint"
>
<router-link to="dynamic-table"
>
<el-progress v-model="top5Form.eslint" percentage="100"
stroke-width="18"
text-inside="true"
status="success"
 >
{{top5Form.eslint}}
</el-progress>
</router-link>
</el-form-item>
</el-form>
</el-card>
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
import demo_view_home_chart1 from './demo.view.home.Chart1'
import demo_view_home_chart2 from './demo.view.home.Chart2'
import demo_view_home_chart3 from './demo.view.home.Chart3'
import demo_view_home_chart4 from './demo.view.home.Chart4'

  export default {
    created: function() {
    this.created_chartForm1_chartForm1();
    this.created_chartForm2_chartForm2();
    this.created_chartForm3_chartForm3();
    this.created_chartForm4_chartForm4();
    this.created_tableForm_tableForm();
    },
    components: {
        JsonEditor,
        MarkdownEditor,
        BackToTop,
        Tinymce,
        demo_view_home_chart1,
        demo_view_home_chart2,
        demo_view_home_chart3,
        demo_view_home_chart4
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
chartForm1_loading: false,
chartForm1: {}
,
chartForm2_loading: false,
chartForm2: {}
,
chartForm3_loading: false,
chartForm3: {}
,
chartForm4_loading: false,
chartForm4: {}
,
tableForm_loading: false,
tableForm: {}
,
top5Form_loading: false,
top5Form: {"vue":0,"javascript":0,"css":0,"eslint":0}

      }
    },
    methods: {
    
    created_chartForm1_chartForm1() {
        var data = this.chartForm1;
        function submitRequest(self) {
            self.chartForm1_loading = true;
            request({
                url: "dashboard/init_form1",
                method: "get"
            }).then(res => {
                self.chartForm1 = res.data;
                self.chartForm1_loading = false;
            }).catch(err => {
                self.chartForm1_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_chartForm1_chart1() {
      }
    




,
    
    created_chartForm2_chartForm2() {
        var data = this.chartForm2;
        function submitRequest(self) {
            self.chartForm2_loading = true;
            request({
                url: "dashboard/init_form2",
                method: "get"
            }).then(res => {
                self.chartForm2 = res.data;
                self.chartForm2_loading = false;
            }).catch(err => {
                self.chartForm2_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_chartForm2_chart2() {
      }
    




,
    
    created_chartForm3_chartForm3() {
        var data = this.chartForm3;
        function submitRequest(self) {
            self.chartForm3_loading = true;
            request({
                url: "dashboard/init_form3",
                method: "get"
            }).then(res => {
                self.chartForm3 = res.data;
                self.chartForm3_loading = false;
            }).catch(err => {
                self.chartForm3_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_chartForm3_chart3() {
      }
    




,
    
    created_chartForm4_chartForm4() {
        var data = this.chartForm4;
        function submitRequest(self) {
            self.chartForm4_loading = true;
            request({
                url: "dashboard/init_form4",
                method: "get"
            }).then(res => {
                self.chartForm4 = res.data;
                self.chartForm4_loading = false;
            }).catch(err => {
                self.chartForm4_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    placeholder_chartForm4_chart4() {
      }
    




,
    
    created_tableForm_tableForm() {
        var data = this.tableForm;
        function submitRequest(self) {
            self.tableForm_loading = true;
            request({
                url: "dashboard/init_form5",
                method: "get"
            }).then(res => {
                self.tableForm = res.data;
                self.tableForm_loading = false;
            }).catch(err => {
                self.tableForm_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    current_change_tableForm_tableRow(val) {
        this.tableForm.tableRow = [val];
    },
    selection_change__tableForm_tableRow(val) {
        this.tableForm.tableRow = val;
    },
    placeholder_tableForm_tableRow() {
      }
    


    ,
    placeholder_tableForm_orderNumber() {
      }
    




    ,
    placeholder_tableForm_currency() {
      }
    


    ,
    placeholder_tableForm_price() {
      }
    




    ,
    placeholder_tableForm_status() {
      }
    






,
    
    placeholder_top5Form_top5Form() {
      }
    


    ,
    placeholder_top5Form_image() {
      }
    




    ,
    placeholder_top5Form_vue() {
      }
    




    ,
    placeholder_top5Form_javascript() {
      }
    




    ,
    placeholder_top5Form_css() {
      }
    




    ,
    placeholder_top5Form_eslint() {
      }
    





    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .Dashboard-container {

    }
    .Dashboard-inner-container {
        margin: 20px;
    }
</style>