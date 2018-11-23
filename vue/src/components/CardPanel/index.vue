<template>
  <div class='card-panel'>
    <div class="card-panel-icon-wrapper icon-people">
      <svg-icon :icon-class="svg" class-name="card-panel-icon" />
    </div>
    <div class="card-panel-description">
      <div class="card-panel-text">{{title}}</div>
      <count-to class="card-panel-num" :startVal="startVal" :endVal="endVal" :duration="duration"></count-to>
    </div>
  </div>
</template>

<script>
import CountTo from 'vue-count-to'

export default {
  components: {
    CountTo
  },
  props: {
    svg: {
      type: String,
      default: ''
    },
    title: {
      type: String,
      default: ''
    },
    startVal: {
      type: Number,
      default: 0
    },
    endVal: {
      type: Number,
      default: 0
    },
    duration: {
      type: Number,
      default: 3000
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .card-panel {
    height: 108px;
    float: left;
    margin-right: 30px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);
    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }
      .icon-people {
         background: #40c9c6;
         float: left;
         font-size: 48px;
      }
    }
    .icon-people {
      color: #40c9c6;
      float: left;
      font-size: 48px;
    }
    .card-panel-icon-wrapper {
      float: left;
      margin: 14px 0 0 14px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }

    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;
      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }
      .card-panel-num {
        font-size: 20px;
      }
    }
  }
</style>
