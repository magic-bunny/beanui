(window.webpackJsonp=window.webpackJsonp||[]).push([["Vmeo"],{Vmeo:function(e,t,l){"use strict";l.r(t);var n=l("t3Un"),a={data:function(){return{userQuery:{button:"",users:[]}}},methods:{click_button:function(){var e=this,t=this.userQuery;Object(n.a)({url:"/demo2",method:"get",data:t}).then(function(t){e.userQuery=t.data}).catch(function(e){})}}},o=l("KHd+"),r=Object(o.a)(a,function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-form",{ref:"userQuery",attrs:{model:e.userQuery,"label-width":"80px"}},[l("el-form-item",[l("el-form-item",[l("el-table",{attrs:{data:e.userQuery.users}},[l("el-table-column",{attrs:{type:"selection",prop:"id",label:"id",width:"50"}}),e._v(" "),l("el-table-column",{attrs:{prop:"name",label:"name"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input",{attrs:{size:"mini"},model:{value:t.row.name,callback:function(l){e.$set(t.row,"name",l)},expression:"scope.row.name"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"age",label:"age"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input-number",{attrs:{size:"mini"},model:{value:t.row.age,callback:function(l){e.$set(t.row,"age",l)},expression:"scope.row.age"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"stature",label:"stature"}}),e._v(" "),l("el-table-column",{attrs:{prop:"weight",label:"weight"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input-number",{attrs:{size:"mini"},model:{value:t.row.weight,callback:function(l){e.$set(t.row,"weight",l)},expression:"scope.row.weight"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"lastDate",label:"lastDate",width:"240"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-date-picker",{attrs:{size:"mini"},model:{value:t.row.lastDate,callback:function(l){e.$set(t.row,"lastDate",l)},expression:"scope.row.lastDate"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"option",label:"edit"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{size:"mini",text:"edit"}},[e._v("\r\n    edit\r\n")])]}}])})],1)],1)],1),e._v(" "),l("el-form-item",[l("el-button",{attrs:{size:"medium",icon:"el-icon-search",text:"query",type:"primary"},on:{click:e.click_button}},[e._v("\r\n    query\r\n")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="demo.view.ABCDComponent.vue";t.default=r.exports}}]);