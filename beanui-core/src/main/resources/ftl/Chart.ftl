<template>
  <div :class="className" :style="{height:height,width:width}"></div>
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import { debounce } from '@/utils'

export default {
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '350px'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object
    }
  },
  data() {
    return {
      chart: null
    }
  },
  mounted() {
    if (this.autoResize) {
      this.__resizeHanlder = debounce(() => {
        if (this.chart) {
          this.chart.resize()
        }
      }, 100)
      window.addEventListener('resize', this.__resizeHanlder)
    }

    const sidebarElm = document.getElementsByClassName('sidebar-container')[0]
    sidebarElm.addEventListener('transitionend', this.__resizeHanlder)
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    if (this.autoResize) {
      window.removeEventListener('resize', this.__resizeHanlder)
    }

    const sidebarElm = document.getElementsByClassName('sidebar-container')[0]
    sidebarElm.removeEventListener('transitionend', this.__resizeHanlder)

    this.chart.dispose()
    this.chart = null
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.initChart(val)
      }
    }
  },
  methods: {
    initChart(data) {
      this.chart = echarts.init(this.$el, 'macarons')
      this.chart.setOption({
        <#list options?keys as name>
        <#if name='series'>
            ${name}: [
              <#list options[name] as series>
              {
                <#list series?keys as key>
                  ${key}: ${series[key]}<#if key_has_next>,</#if>
                </#list>
              }<#if series_has_next>,</#if>
              </#list>
            ]
        <#elseif name='color'>
            ${name}: ${options[name]['value']}
        <#else>
            ${name}: {
              <#list options[name]?keys as key>
              ${key}: ${options[name][key]}<#if key_has_next>,</#if>
              </#list>
            }
        </#if>
        <#if name_has_next>,</#if>
        </#list>
      })
    }
  }
}
</script>
