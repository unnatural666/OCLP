<template>
  <div style="width: 100%;height:700px;" class="beijing">
    <div id="login">
      <div class="me-login-box me-login-box-radius">
        <h1>Welcome 登录</h1>

        <el-form ref="loginForm" :model="loginForm" :rules="loginRules">
          <el-form-item prop="account">
            <el-input placeholder="请输入正确的手机号" v-model="loginForm.username"></el-input>
          </el-form-item>

          <el-form-item prop="password">
            <el-input placeholder="请输入密码包含字母数字" v-model="loginForm.password" type="password"></el-input>
          </el-form-item>

          <el-form-item size="small" class="me-login-button">
            <el-button type="primary" @click.native="login">登录</el-button>
          </el-form-item>
        </el-form>

        <div class="me-login-design">
          <p>
            Click me go back
            <strong>
              <router-link to="/" class="me-login-design-color">Home</router-link>
            </strong>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import PubSub from 'pubsub-js'
  import utilApi from '../../common/utils';
  import * as loginApi from '../../base/api/login';


export default {
  name: "Login",

  data() {
    return {
      utype:'',
      loginForm: {
        username:'',
        password: ''
      },
      loginRules: {
        username: [
          {required: true, message: '请输入账号', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'}
        ]
      },
    };
  },
  methods: {
    login: function () {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          // this.editLoading = true;
          let para = Object.assign({}, this.loginForm);

          loginApi.login(para).then((res) => {
            console.log(res)

              // this.editLoading = false;
              if(res.success){
                this.utype=res.utype
                PubSub.publish('utype',this.utype)
                this.$message({message: '欢迎您登录成功！ ',type: 'success',showClose: true});
                this.$router.push('/')
                //刷新 当前页面
                // alert(this.returnUrl)
                // if(this.returnUrl!='undefined' && this.returnUrl!=''
                //   && !this.returnUrl.includes("/userlogout")
                //   && !this.returnUrl.includes("/userlogin")){
                //
                //   window.location.href = this.returnUrl;
                // }else{
                //   //跳转到首页
                //   window.location.href = 'http://www.xuecheng.com/'
                // }

              }else{
                this.$message({message: '账号或者密码错误！ ',type: 'error',showClose: true});
                // if(res.message){
                //   this.$message.error(res.message);
                // }else{
                //   this.$message.error('登陆失败');
                // }
              }
            },
            (res) => {
              // this.editLoading = false;
            });


        }
      });

    },

    //刷新用户



    // login(formName) {
    //   let that = this;
    //
    //   var re = /^1\d{10}$/;
    //   //账号必须1开头11位
    //   //字母、数字、下划线组成，字母开头，4-16位
    //   // 8-16位字符；数字、字母、特殊字符（除空格），起码其中两种组合 这个密码验证的正则表达式
    //   var ps = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,16}$/;
    //   if (re.test(that.userForm.account) && ps.test(that.userForm.password)) {
    //     // alert("正确");
    //     this.$refs[formName].validate(valid => {
    //       if (valid) {
    //         that.$store
    //           .dispatch("login", that.userForm)
    //           .then(response => {
    //             that.$router.go(-1);
    //
    //             that.$message({
    //               message: "登录成功 ",
    //               type: "success",
    //               showClose: true
    //             });
    //           })
    //           .catch(error => {
    //             if (error !== "error") {
    //               that.$message({
    //                 message: error,
    //                 type: "error",
    //                 showClose: true
    //               });
    //             }
    //           });
    //       } else {
    //         return false;
    //       }
    //     });
    //   } else {
    //     this.$message({
    //       message: "请填写正确的手机号码和密码 ",
    //       type: "error",
    //       showClose: true
    //     });
    //   }
    // }
  },
  mounted(){

  }
};
</script>

<style scoped>
.beijing {
      background: url("../../assets/img/timg.jpg");
}
#login {
  min-width: 100%;
  min-height: 100%;
}

.me-video-player {
  background-color: transparent;
  width: 100%;
  height: 100%;
  object-fit: fill;
  display: block;
  position: absolute;
  left: 0;
  z-index: 0;
  top: 0;
}
.me-login-box {
  position: absolute;
  width: 300px;
  height: 260px;
  background-color: white;
  margin-top: 150px;
  margin-left: -180px;
  left: 50%;
  padding: 30px;
}
.me-login-box-radius {
  border-radius: 10px;
  box-shadow: 0px 0px 1px 1px rgba(129, 241, 40, 0.1);
}

.me-login-box h1 {
  text-align: center;
  font-size: 24px;
  margin-bottom: 20px;
  vertical-align: middle;
}

.me-login-design {
  text-align: center;
  font-family: "Open Sans", sans-serif;
  font-size: 18px;
}
.me-login-design-color {
  color: #81f128 !important;
}
.me-login-button {
  text-align: center;
}
.me-login-button button {
  width: 100%;
}
</style>
