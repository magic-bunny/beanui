package org.december.beanui.element.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Upload {
    String label() default "";
    String text() default "";
    String icon() default "";
    String action() default "";//	必选参数，上传的地址	string	—	—
    String headers() default "";//	设置上传的请求头部	object	—	—
    String multiple() default "";//	是否支持多选文件	boolean	—	—
    String data() default "";//	上传时附带的额外参数	object	—	—
    String name() default "";//	上传的文件字段名	string	—	file
    String with_credentials() default "";//	支持发送 cookie 凭证信息	boolean	—	false
    String show_file_list() default "";//	是否显示已上传文件列表	boolean	—	true
    String drag() default "";//	是否启用拖拽上传	boolean	—	false
    String accept() default "";//	接受上传的文件类型（thumbnail_mode 模式下此参数无效）	string	—	—
    String on_preview() default "";//	点击文件列表中已上传的文件时的钩子	function(file)	—	—
    String on_remove() default "";//	文件列表移除文件时的钩子	function(file, fileList)	—	—
    String on_success() default "";//	文件上传成功时的钩子	function(response, file, fileList)	—	—
    String on_error() default "";//	文件上传失败时的钩子	function(err, file, fileList)	—	—
    String on_progress() default "";//	文件上传时的钩子	function(event, file, fileList)	—	—
    String on_change() default "";//	文件状态改变时的钩子，添加文件、上传成功和上传失败时都会被调用	function(file, fileList)	—	—
    String before_upload() default "";//	上传文件之前的钩子，参数为上传的文件，若返回 false 或者返回 Promise 且被 reject，则停止上传。	function(file)	—	—
    String before_remove() default "";//	删除文件之前的钩子，参数为上传的文件和文件列表，若返回 false 或者返回 Promise 且被 reject，则停止上传。	function(file, fileList)	—	—
    String list_type() default "";//	文件列表的类型	string	text/picture/picture_card	text
    String auto_upload() default "";//	是否在选取文件后立即进行上传	boolean	—	true
    String file_list() default "";//	上传的文件列表, 例如: [{name: 'food.jpg', url: 'https://xxx.cdn.com/xxx.jpg'}]	array	—	[]
    String http_request() default "";//	覆盖默认的上传行为，可以自定义上传的实现	function	—	—
    String disabled() default "";//	是否禁用	boolean	—	false
    String limit() default "";//	最大允许上传个数	number	—	—
    String on_exceed() default "";//	文件超出个数限制时的钩子	function(files, fileList)	—	_
}
