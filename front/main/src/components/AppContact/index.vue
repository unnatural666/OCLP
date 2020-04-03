<template>
  <div class="contact">
 <div class="wrapper">
   <div class="wrapper1">
      <div class="bot">

      </div>
      
      <div class="chart">
        <table>
          <tr>
            <th>新手入门</th>
            <th>关于我们</th>
            <th>资源下载</th>
            <th>联系我们</th>
          </tr>
          <tr>
            <td>用户注册</td>
            <td>名师团队</td>
            <td>视频下载</td>
            <td>工作机会</td>
          </tr>
          <tr>
            <td>用户登录</td>
            <td>新闻动态</td>
            <td>资料下载</td>
            <td>招贤纳师</td>
          </tr>
          <tr>
            <td>用户指南</td>
            <td>合作企业</td>
            <td>工具下载</td>
            <td>联系方式</td>
          </tr>
        </table>
      </div>

    </div>
    <div class="wrapper2">
<!-- 二维码 -->

    </div> 
      </div>
     
  </div>
</template>

<style scoped>
.contact {
  width: 100%;
  height: 450px;
  background-color: rgba(0, 0, 0, 0.795);
}
.wrapper{
    margin: 0 auto;
    width:1000px ;
    height: 450;
}
.wrapper1 {
  width: 800px;
  height: 450px;
  float: left;

}
.wrapper2{
  width: 150px;
  height: 150px; 
  background: url("../../assets/img/wechat.png");
  background-size:100% 100%;
  background-repeat:no-repeat;
  margin-top:120px;
  margin-left: 20px;
  float: left;
}
.bot {
  width: 700px;
  height: 130px;
  margin-left:70px;
  background: url("../../assets/img/bot.png");
  background-size:100% 100%;
  background-repeat:no-repeat;
}
.chart {
  width: 800px;
  height: 270px;

}
table {
  width: 100%;

}

th {
  height: 25px;
  color: rgba(255, 255, 255, 0.733);
}
td {
  padding: 15px;
  text-align: center;
  color: rgba(255, 255, 255, 0.308);
}
</style>