<template>
  <div id="app">
    <router-view  />
    <go-top></go-top>

    <div class="foot">
    </div>
  </div>
</template>

<script>
  import GoTop from "@/components/gotop/GoTop";
  export default {
    name: "App",
    components: { GoTop }
  };
</script>

<style>
  * {
    margin: 0;
    padding: 0;
  }

  body {
    background-color: #ffffff;
    font-weight: 400;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
    line-height: 1.5;
  }
  a {
    cursor: pointer;
    text-decoration: none;
    transition: none 86ms ease-out;
  }
  a:hover {
    color: #5fb878;
  }
  .me-area {
    background-color: #fff;
  }
  html {
    height: 100%;
  }
  body {
    min-height: 100%;
  }
  body {
    position: relative;
  }

  .me-pull-right {
    float: right;
  }
</style>
