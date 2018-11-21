package org.december.beanui.element.annotation;

import java.util.List;

public @interface Tree {
    String data() default ""; //	展示数据	array	—	—
    String empty_text() default ""; //	内容为空的时候展示的文本	String	—	—
    String node_key() default ""; //	每个树节点用来作为唯一标识的属性，整棵树应该是唯一的	String	—	—
    String props() default ""; //	配置选项，具体看下表	object	—	—
    String render_after() default ""; //_expand	是否在第一次展开某个树节点后才渲染其子节点	boolean	—	true
    String load() default ""; //	加载子树数据的方法，仅当 lazy 属性为true 时生效	function(node, resolve)	—	—
    String render_content() default ""; //	树节点的内容区的渲染 Function	Function(h, { node, data, store }	—	—
    String highlight_current() default ""; //	是否高亮当前选中节点，默认值是 false。	boolean	—	false
    String default_expand() default ""; //_all	是否默认展开所有节点	boolean	—	false
    String expand_on() default ""; //_click_node	是否在点击节点的时候展开或者收缩节点， 默认值为 true，如果为 false，则只有点箭头图标的时候才会展开或者收缩节点。	boolean	—	true
    String check_on() default ""; //_click_node	是否在点击节点的时候选中节点，默认值为 false，即只有在点击复选框时才会选中节点。	boolean	—	false
    String auto_expand() default ""; //_parent	展开子节点的时候是否自动展开父节点	boolean	—	true
    String default_expanded() default ""; //_keys	默认展开的节点的 key 的数组	array	—	—
    String show_checkbox() default ""; //	节点是否可被选择	boolean	—	false
    String check_strictly() default ""; //	在显示复选框的情况下，是否严格的遵循父子不互相关联的做法，默认为 false	boolean	—	false
    String default_checked() default ""; //_keys	默认勾选的节点的 key 的数组	array	—	—
    String filter_node() default ""; //_method	对树节点进行筛选时执行的方法，返回 true 表示这个节点可以显示，返回 false 则表示这个节点会被隐藏	Function(value, data, node)	—	—
    String accordion() default ""; //	是否每次只打开一个同级树节点展开	boolean	—	false
    String indent() default ""; //	相邻级节点间的水平缩进，单位为像素	number	—	16
    String lazy() default ""; //	是否懒加载子节点，需与 load 方法结合使用	boolean	—	false
    String draggable() default ""; //	是否开启拖拽节点功能	boolean	—	false
    String allow_drag() default ""; //	判断节点能否被拖拽	Function(node)	—	—
    String allow_drop() default ""; //	拖拽时判定目标节点能否被放置。type 参数有三种情况：'prev'、'inner' 和 'next'，分别表示放置在目标节点前、插入至目标节点和放置在目标节点后	Function(draggingNode, dropNode, type)	—	—
    String tag() default "el-tree";
    String label() default "";
    String v_model() default "";

    class Node {
        public Node(String label, List<Node> children) {
            this.label = label;
            this.children = children;
        }

        public Node(String label, List<Node> children, boolean isLeaf) {
            this.label = label;
            this.children = children;
            this.isLeaf = isLeaf;
        }

        public Node(String label, List<Node> children, boolean disabled, boolean isLeaf) {
            this.label = label;
            this.children = children;
            this.disabled = disabled;
            this.isLeaf = isLeaf;
        }

        private String label;//	指定节点标签为节点对象的某个属性值	string, function(data, node)	—	—
        private List<Node> children;//	指定子树为节点对象的某个属性值	string	—	—
        private boolean disabled;//	指定节点选择框是否禁用为节点对象的某个属性值	boolean, function(data, node)	—	—
        private boolean isLeaf;//	指定节点是否为叶子节点，仅在指定了 lazy 属性的情况下生效	boolean, function(data, node)	—	—

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }
}
