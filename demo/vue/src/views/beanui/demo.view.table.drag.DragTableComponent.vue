

<template>
<div class="DragTableComponent-container">
<div class="DragTableComponent-inner-container">
<el-row>
<el-col :span="24/1" style="padding: 10px;">
<el-form v-loading="DragTableComponent_loading" ref="DragTableComponent" :model="DragTableComponent"
>
<el-form-item prop="table"
  label=""
>
<el-table :data="DragTableComponent.tableData"
fit="true"
border="true"
highlight-current-row="true"
  current-change="current_change_DragTableComponent_table" @selection-change="selection_change__DragTableComponent_table">
 <el-table-column width="70"
 label="ID"
>
    <template slot-scope="scope">
<span v-model="scope.row.id"  >
{{scope.row.id}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="200"
 label="Date"
>
    <template slot-scope="scope">
<span v-model="scope.row.date"  >
{{scope.row.date}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="400"
 label="Title"
>
    <template slot-scope="scope">
<span v-model="scope.row.title"  >
{{scope.row.title}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Author"
>
    <template slot-scope="scope">
<span v-model="scope.row.author"  >
{{scope.row.author}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="200"
 label="Importance"
>
    <template slot-scope="scope">
<el-rate v-model="scope.row.importance"  >
{{scope.row.importance}}
</el-rate>
    </template>
    </el-table-column>
 <el-table-column width="100"
 label="Readings"
>
    <template slot-scope="scope">
<span v-model="scope.row.readings"  >
{{scope.row.readings}}
</span>
    </template>
    </el-table-column>
 <el-table-column width="110"
 label="Status"
>
    <template slot-scope="scope">
<el-tag  >
{{scope.row.status}}
</el-tag>
    </template>
    </el-table-column>
</el-table>
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
    this.created_DragTableComponent_DragTableComponent();
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
DragTableComponent_loading: false,
DragTableComponent: {}
            
      }
    },
    methods: {
    
    created_DragTableComponent_DragTableComponent() {
        var data = this.DragTableComponent;
        var params = this.$router.params;
        var requestParams = "?"
        for(var key in params) {
            var value = params[key];
            requestParams += ("&" + key + "=" + value);
        }
        function submitRequest(self) {
            self.DragTableComponent_loading = true;
            request({
                url: "/drag-table/init" + (requestParams=="?"?"":requestParams),
                method: "get"
            }).then(res => {
                self.DragTableComponent = res.data;
                self.DragTableComponent_loading = false;
            }).catch(err => {
                self.DragTableComponent_loading = false;
            });
        }
        submitRequest(this);
      }
    


    ,
    current_change_DragTableComponent_table(val) {
        this.DragTableComponent.table = [val];
    },
    selection_change__DragTableComponent_table(val) {
        this.DragTableComponent.table = val;
    },
    placeholder_DragTableComponent_table() {
      }
    


    ,
    placeholder_DragTableComponent_id() {
      }
    




    ,
    placeholder_DragTableComponent_date() {
      }
    




    ,
    placeholder_DragTableComponent_title() {
      }
    




    ,
    placeholder_DragTableComponent_author() {
      }
    




    ,
    placeholder_DragTableComponent_importance() {
      }
    




    ,
    placeholder_DragTableComponent_readings() {
      }
    




    ,
    placeholder_DragTableComponent_status() {
      }
    






        
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
    .DragTableComponent-container {

    }
    .DragTableComponent-inner-container {
        margin: 20px;
    }
</style>