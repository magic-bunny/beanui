(window.webpackJsonp=window.webpackJsonp||[]).push([["rx35"],{rx35:function(e,t,l){"use strict";l.r(t);var a=l("t3Un"),s={created:function(){var e=this;this.testForm;Object(a.a)({url:"/demo3",method:"get"}).then(function(t){e.testForm=t.data}).catch(function(e){})},data:function(){return{testForm:{button:"",password:"",button2:"",address:"",level:"",options:[],isAdmin:"",detail:"",users:[],addressData:[],username:"",lastDate:""}}},methods:{click_button:function(){var e=this,t=this.testForm;Object(a.a)({url:"/demo3",method:"get",data:t}).then(function(t){e.testForm=t.data}).catch(function(e){})}}},o=l("KHd+"),r=Object(o.a)(s,function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-form",{ref:"testForm",attrs:{model:e.testForm,"label-width":"80px"}},[l("el-form-item",{attrs:{label:"username"}},[l("el-input",{model:{value:e.testForm.username,callback:function(t){e.$set(e.testForm,"username",t)},expression:"testForm.username"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"password"}},[l("el-input",{model:{value:e.testForm.password,callback:function(t){e.$set(e.testForm,"password",t)},expression:"testForm.password"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"isAdmin"}},[l("el-switch",{model:{value:e.testForm.isAdmin,callback:function(t){e.$set(e.testForm,"isAdmin",t)},expression:"testForm.isAdmin"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"lastDate"}},[l("el-date-picker",{model:{value:e.testForm.lastDate,callback:function(t){e.$set(e.testForm,"lastDate",t)},expression:"testForm.lastDate"}})],1),e._v(" "),l("el-form-item",[l("el-form-item",[l("el-table",{attrs:{data:e.testForm.users}},[l("el-table-column",{attrs:{type:"selection",prop:"id",label:"id",width:"50"}}),e._v(" "),l("el-table-column",{attrs:{prop:"name",label:"name"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input",{attrs:{size:"mini"},model:{value:t.row.name,callback:function(l){e.$set(t.row,"name",l)},expression:"scope.row.name"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"age",label:"age"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input-number",{attrs:{size:"mini"},model:{value:t.row.age,callback:function(l){e.$set(t.row,"age",l)},expression:"scope.row.age"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"stature",label:"stature"}}),e._v(" "),l("el-table-column",{attrs:{prop:"weight",label:"weight"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-input-number",{attrs:{size:"mini"},model:{value:t.row.weight,callback:function(l){e.$set(t.row,"weight",l)},expression:"scope.row.weight"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"lastDate",label:"lastDate",width:"240"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-date-picker",{attrs:{size:"mini"},model:{value:t.row.lastDate,callback:function(l){e.$set(t.row,"lastDate",l)},expression:"scope.row.lastDate"}})]}}])}),e._v(" "),l("el-table-column",{attrs:{prop:"option",label:"edit"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{attrs:{size:"mini",text:"edit"}},[e._v("\r\n    edit\r\n")])]}}])})],1)],1)],1),e._v(" "),l("el-form-item",{attrs:{label:"level"}},[l("el-rate",{model:{value:e.testForm.level,callback:function(t){e.$set(e.testForm,"level",t)},expression:"testForm.level"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"detail"}},[l("el-select",{attrs:{placeholder:"请选择",optionId:"options"},model:{value:e.testForm.detail,callback:function(t){e.$set(e.testForm,"detail",t)},expression:"testForm.detail"}},e._l(e.testForm.options,function(e){return l("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))],1),e._v(" "),l("el-form-item",{attrs:{label:"options"}}),e._v(" "),l("el-form-item",{attrs:{label:"address"}},[l("el-transfer",{attrs:{data:e.testForm.addressData,titles:["1","2"]},model:{value:e.testForm.address,callback:function(t){e.$set(e.testForm,"address",t)},expression:"testForm.address"}})],1),e._v(" "),l("el-form-item",{attrs:{label:"addressData"}}),e._v(" "),l("el-form-item",[l("el-button",{attrs:{size:"medium",icon:"el-icon-upload",text:"upload",type:"primary"},on:{click:e.click_button}},[e._v("\r\n    upload\r\n")]),e._v(" "),l("el-button",{attrs:{size:"medium",text:"clear"}},[e._v("\r\n    clear\r\n")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="demo.view.TestComponent.vue";t.default=r.exports}}]);