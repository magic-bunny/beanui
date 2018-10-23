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
                    yAxis: {
            }
        ,
            xAxis: {
              data: data.xAxisData
            }
        ,
            color: data.colors
        ,
            legend: {
              data: data.legendData
            }
        ,
            series: [
              {
                  data: data.data1,
                  name: 'Forest',
                  type: 'bar'
              },
              {
                  data: data.data2,
                  name: 'Steppe',
                  type: 'bar'
              },
              {
                  data: data.data3,
                  name: 'Desert',
                  type: 'bar'
              },
              {
                  data: data.data4,
                  name: 'Wetland',
                  type: 'bar'
              }
            ]
        ,
            tooltip: {
              trigger: 'axis'
            }
        
      })
    }
  }
}
</script>
