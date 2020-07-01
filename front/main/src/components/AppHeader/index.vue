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

            <!-- <el-menu-item index="/faceteach">面授高薪班</el-menu-item> -->

            <el-menu-item >	<div class="input1"> <el-input placeholder="搜索课程" prefix-icon="el-icon-search" @keyup.enter.native="search" v-model="keyword" ></el-input></div></el-menu-item>

<!--            <el-menu-item @click="my"  index="/usercenter">我的学习</el-menu-item>-->
            <el-menu-item   @click="my" v-show="this.myself">我的学习</el-menu-item>
            <el-menu-item    v-show="!this.myself" index="/usercenter">我的学习</el-menu-item>

<!--            <el-menu-item index="/course" @click="tiao">系统后台</el-menu-item>-->
            <el-menu-item  @click="tiao"  target="_blank" v-if="!this.myrole==false">系统后台</el-menu-item>
<!--            <el-menu-item  index="/coursedetail/courseid" >课程详情</el-menu-item>-->
            <el-menu-item  >
              <el-col :span="12">
                <el-dropdown>
                  <span class="el-dropdown-link">
                    学习路线图
                    <i class="el-icon-arrow-down el-icon--right"></i>
                  </span>
                  <el-dropdown-menu slot="dropdown" disabled>
                    <el-menu-item  index="/bigdata" style="height: 35px"><el-dropdown-item icon="el-icon-star-on" >大数据</el-dropdown-item></el-menu-item>
                    <el-menu-item  index="/java" style="height: 35px"><el-dropdown-item icon="el-icon-star-off" >Java开发</el-dropdown-item></el-menu-item>
                      <el-menu-item  index="/web" style="height: 35px"><el-dropdown-item icon="el-icon-check">前端开发</el-dropdown-item></el-menu-item>
                    <el-menu-item  index="/python" style="height: 35px"><el-dropdown-item icon="el-icon-circle-plus-outline">Python学习</el-dropdown-item></el-menu-item>
                    <el-menu-item  index="/android" style="height: 35px"><el-dropdown-item icon="el-icon-circle-check">Android开发</el-dropdown-item></el-menu-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </el-col>
            </el-menu-item>
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

            <template v-if="this.logined==false">
              <el-menu-item index="/login">
                <el-button type="text">登录</el-button>
              </el-menu-item>
              <el-menu-item index="/register">
                <el-button type="text">注册</el-button>
              </el-menu-item>
            </template>

            <template v-else>
              <span v-if="logined" style="position:absolute;margin: 20px -100px">欢迎您:{{this.user.name}}</span>
              <el-submenu index>
                <template slot="title">
                  <!--<img class="me-header-picture" :src="user.avatar" />						    	-->
                  <img class="me-header-picture" src="../../../static/images/head.jpeg" />
                </template>
                <el-menu-item >
                  <span @click="exit"><i class="el-icon-back" ></i>退出</span>
                </el-menu-item>
              </el-submenu>

            </template>



          </el-menu>
        </el-col>
      </el-row>
    </el-header>
  </div>
</template>

<script>
  import PubSub from 'pubsub-js'
  import utilApi from '../../common/utils';
  import * as loginApi from '../../base/api/login';


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
      myself:true,
      myrole:false,
      user:{
        name:'',
        utype:'',
        userid:'',
        username: '',
        userpic: ''
      },
      logined:false,
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
    my(){
      if(!this.user.name){
        this.$message({message: '请先登录哦！ ',type: 'warning',showClose: true});

      }else{
        this.myself=false
        this.$router.push('/usercenter')
        // window.open(' http://localhost:13000')
      }

    },
    tiao(){
      // window.location.href = " http://localhost:12000"
      window.open(' http://localhost:12000')

    },
    refresh_user(){
      //从sessionStorage中取出当前用户
      let activeUser= utilApi.getActiveUser();

      //取出cookie中的令牌
      let uid = utilApi.getCookie("uid")

      if(activeUser && uid && uid == activeUser.uid){
        this.logined = true
        this.user = activeUser;
        console.log(this.user.username)
      }else{
        if(!uid){
          return ;
        }
        //请求查询jwt
        loginApi.getjwt().then((res) => {
          if(res.success){
            let jwt = res.jwt;
            let activeUser = utilApi.getUserInfoFromJwt(jwt)
            if(activeUser){
              this.logined = true
              this.user = activeUser;
              utilApi.setUserSession("activeUser",JSON.stringify(activeUser))
            }
          }
        })
      }
    },
      exit(){
        this.$confirm('退出后将不能继续学习，确认退出吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          loginApi.logout({}).then((res) => {
              if(res.success){
                sessionStorage.removeItem('activeUser');
                this.$message({message: '欢迎您下次再来！ ',showClose: true});
                this.user.username=''
                this.logined = false
                this.myrole=false
                this.myself=true
                this.$router.push('/')
              }else{
                this.logined = true
              }
            },
            (res) => {
              // this.logoutsuccess = false
            });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出！',
            showClose:true
          });
        });

      },
     roles(){
      if(this.user.utype=='101002'||this.user.utype=='101003'){
        this.myrole=true
      }else {
        this.myrole=false
      }
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
  },
  activated(){


  },
  created(){

    PubSub.subscribe('utype',(event,utype)=>{
      console.log(utype)
      this.user.utype=utype
   this.roles()
    })

  },

  mounted(){

    //刷新当前用户
    // this.refresh_user()
    this.refresh_user()
    this.roles()
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
