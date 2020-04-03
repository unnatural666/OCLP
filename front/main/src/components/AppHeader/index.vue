<template>
  <div class="head">

    <el-header class="me-area">
      <el-row class="me-header">
        <el-col :span="4" class="me-header-left">
          <router-link to="/" class="me-title">
            <!--  -->
            <img
              src="@/assets/img/logg.jpg"
              style="width: 160px;height: 190px;background-size:100% 100%;  "
            />
          </router-link>
        </el-col>
        <el-col v-if="!simple" :span="16">
          <el-menu
            :router="true"
            menu-trigger="click"
            active-text-color="#5FB878"
            :default-active="activeIndex"
            mode="horizontal"
          >
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/allcourse">课程</el-menu-item>
            <!-- 下拉菜单 -->
<!--            <el-menu-item index="/studytrack" disabled>-->
<!--              <el-col :span="12">-->
<!--                <el-dropdown>-->
<!--                  <span class="el-dropdown-link">-->
<!--                    学习路线图-->
<!--                    <i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
<!--                  </span>-->
<!--                  <el-dropdown-menu slot="dropdown">-->
<!--                    <el-dropdown-item icon="el-icon-star-off">Java开发</el-dropdown-item>-->
<!--                    <el-dropdown-item icon="el-icon-star-on">大数据</el-dropdown-item>-->
<!--                    <el-dropdown-item icon="el-icon-circle-plus-outline">Python</el-dropdown-item>-->
<!--                    <el-dropdown-item icon="el-icon-check">前端开发</el-dropdown-item>-->
<!--                    <el-dropdown-item icon="el-icon-circle-check">Android开发</el-dropdown-item>-->
<!--                  </el-dropdown-menu>-->
<!--                </el-dropdown>-->
<!--              </el-col>-->
<!--            </el-menu-item>-->
            <!-- <el-menu-item index="/faceteach">面授高薪班</el-menu-item> -->

            <el-menu-item >	<div class="input1"> <el-input placeholder="搜索课程" prefix-icon="el-icon-search" @keyup.enter.native="search" v-model="keyword" ></el-input></div></el-menu-item>

            <el-menu-item index="/allcourse">我的学习</el-menu-item>
            <el-menu-item index="/allcourse">教学提供方</el-menu-item>
<!--            <el-menu-item index="/course" @click="tiao">系统后台</el-menu-item>-->
            <el-menu-item  @click="tiao"  target="_blank" >系统后台</el-menu-item>
            <el-menu-item  index="/coursedetail" >课程详情</el-menu-item>
          </el-menu>

        </el-col>
        <template v-else>
          <slot></slot>
        </template>
        <el-col :span="4">
          <el-menu
            :router="true"
            menu-trigger="click"
            mode="horizontal"
            active-text-color="#5FB878"
          >
            <template >
              <el-menu-item index="/login">
                <el-button type="text">登录</el-button>
              </el-menu-item>
              <el-menu-item index="/register">
                <el-button type="text">注册</el-button>
              </el-menu-item>
            </template>

<!--            <template >-->
<!--              <el-submenu index>-->
<!--                <template slot="title">-->
<!--                  &lt;!&ndash;<img class="me-header-picture" :src="user.avatar" />						    	&ndash;&gt;-->
<!--                  <img class="me-header-picture" src="/src/static/user/head.jpeg" />-->
<!--                </template>-->
<!--                <el-menu-item >-->
<!--                  <i class="el-icon-back"></i>退出-->
<!--                </el-menu-item>-->
<!--              </el-submenu>-->
<!--            </template>-->
          </el-menu>
        </el-col>
      </el-row>
    </el-header>
  </div>
</template>

<script>
  import PubSub from 'pubsub-js'
export default {
  name: "AppHeader",
  props: {
    activeIndex: String,
    simple: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {

		input1:'',
		keyword:'',

	};
  },
  computed: {

  },
  methods: {
    //搜索框搜索
    search(){

      const keyword=this.keyword.trim()
      if(keyword){

        PubSub.publish('searchkey',keyword)
        console.log('hello')
        this.$router.push('/allcourse')

      }

    },
    tiao(){
      // window.location.href = " http://localhost:12000"
      window.open(' http://localhost:12000')

    },
    // logout() {
    //   let that = this;
    //   this.$store
    //     .dispatch("logout")
    //     .then(() => {
    //       this.$router.push({ path: "/" });
    //       that.$message({
    //         message: "已退出 ",
    //         type: "success",
    //         showClose: true
    //       });
    //     })
    //     .catch(error => {
    //       if (error !== "error") {
    //         that.$message({ message: error, type: "error", showClose: true });
    //       }
    //     });
    // }
  }
};
</script>

<style>
.head {
  width: 100%;
  height: 60px;
}
.el-header {
  position: fixed;
  z-index: 1024;
  min-width: 100%;
  box-shadow: 0 2px 3px hsla(0, 0%, 7%, 0.1), 0 0 0 1px hsla(0, 0%, 7%, 0.1);
}

.me-title {
  margin-top: 10px;
  font-size: 24px;
}

.me-header-left {
  /*margin-top: 10px;*/
}
.me-title img {
  /*max-height: 2.4rem;*/
  max-width: 100%;
  max-height: 60px;
}
.me-header-picture {
  width: 36px;
  height: 36px;
  border: 1px solid #ddd;
  border-radius: 50%;
  vertical-align: middle;
  background-color: #5fb878;
}
/* 下拉菜单 */
.el-dropdown-link {
  cursor: pointer;
  color: gray;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}
.input1{
	width: 200px;
	height: 30px;
}
</style>
