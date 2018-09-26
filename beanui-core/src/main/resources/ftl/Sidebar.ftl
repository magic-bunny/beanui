<template>
  <el-scrollbar wrapClass="scrollbar-wrapper">
    <div style="font-size: 20px; color: #fff;  text-align: center; margin: 0 0 10px 0">${r'{{'}title${r'}}'}</div>
    <el-menu
      mode="vertical"
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <sidebar-item v-for="route in permission_routers" :key="route.name" :item="route" :base-path="route.path"></sidebar-item>
    </el-menu>
  </el-scrollbar>
</template>

<script>
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'

export default {
  data() { return {
      title: "${projectName}"
    }
  },
  components: { SidebarItem },
  computed: {
    ...mapGetters([
      'permission_routers',
      'sidebar'
    ]),
    isCollapse() {
      if(this.sidebar.opened) {
        this.title = "${projectName}"
      } else {
        this.title = this.title.substring(0, 1)
      }
      return !this.sidebar.opened
    }
  }
}
</script>