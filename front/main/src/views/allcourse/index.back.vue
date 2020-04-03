<template>
  <div class="course">
    <div style="margin:20px 10px" >课程列表</div>
    <!-- 头部 -->
    <div class="hcard">
      <div class="lef">
        <span>所有分类：</span>
        <span>分类：</span>
      </div>
      <div class="righ">
        <el-tabs
          :tab-position="tabPosition"
          v-model="activeName"
          type="card"
          @tab-click="handleClick"
        >
          <el-tab-pane label="全部" name="first">全部</el-tab-pane>
          <el-tab-pane label="大数据" name="second">大数据</el-tab-pane>
          <el-tab-pane label="Java" name="third">Java</el-tab-pane>
          <el-tab-pane label="Python" name="fourth">Python</el-tab-pane>
          <el-tab-pane label="Android" name="fifth">Android</el-tab-pane>
          <el-tab-pane label="C++" name="sixth">C++</el-tab-pane>
          <el-tab-pane label="数据库" name="seventh">数据库</el-tab-pane>
        </el-tabs>
      </div>
    </div>
    <!-- 筛选 -->
    <div class="tuijian">
      <div class="t">
        <a href>最新</a>
        <a href>最热</a>
        <a href>推荐</a>
      </div>
      <div class="j">
        <a href >免费课程</a>
        <a href>直播课程</a>
        <a href >SVIP</a>
      </div>
    </div>
    <!-- 课程渲染 -->
    <div class="first">
      <div class="card">
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/Redis.jpg" alt="Redis" width="230" height="160" />
              </a>
            </div>
            <div class="desc">Redis</div>
          </div>
        </div>

        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/java.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/hc.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/js.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/mybatis.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/mysql.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/mysqlc.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/Spring4.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/mysqlc.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/Spring4.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/mysqlc.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
        </div>
        <div class="little">
          <div class="responsive">
            <div class="img">
              <a target="_blank" href="http://static.runoob.com/images/demo/demo1.jpg">
                <img src="@/assets/img/vimage/Spring4.jpg" alt="图片文本描述" width="230" height="160" />
              </a>
            </div>
            <div class="desc">这里添加图片文本描述</div>
          </div>
          <div class="page" >
      <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
    </div>
        </div>
        
      </div>
    </div>
    <!-- 分页 -->
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeName: "first",
      tabPosition: "bottom"
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>


<style scoped>
.course {
  padding: 10px 0px;
  margin: 0 auto;
  width: 1200px;
  height: 1000px;
  border-radius: 4px;
  /* 投影 */
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.hcard {
  margin-top: 40px;
  height: 80px;

  border-radius: 4px;
  /* 投影 */
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.lef {
  width: 130px;
  height: 80px;
  float: left;
}
.righ {
  width: 765px;
  height: 80px;
  margin-top: 2px;
  float: left;
}
.lef span {
  width: 148px;
  height: 40px;
  float: left;
  margin: 2px 10px;
}
/* 推荐 */
.tuijian {
  width: 1150px;
  height: 40px;
  border: 1px solid rgba(245, 222, 179, 0.377);
  margin-top: 40px;
}
.t {
  width: 300px;
  height: 40px;
  float: left;
}
.t a {
  display: block;
  height: 30px;
  text-align: center;
  width: 80px;
  float: left;
  padding-top: 10px;
  color: gray;
}
.j {
  width: 500px;
  height: 40px;
  float: right;
}
.j a {
  display: block;
  height: 30px;
  text-align: center;
  width: 80px;
  float: right;
  padding-top: 10px;
  margin-right: 10px;
  color: gray;
}

/* 课程渲染 */
.first {
  padding: 30px 80px 0px 80px;
}
.card {
  margin-left: 5px;
  padding: 20px 30px;
  height: 710px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.page{
  margin: 40px -450px;
}
</style>