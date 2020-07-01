<template>
  <div style="width: 100%;height: 700px;" class="beijing">
  <div id="caiji">

    <div id="Register">   <el-form :model="userForm" ref="userForm" :rules="rules">
      <el-form-item prop="name">
        <el-input v-model="userForm.name" class="form-control" placeholder="请输入昵称"></el-input>
      </el-form-item>
      <el-form-item prop="username">
        <el-input v-model="userForm.username" class="form-control" placeholder="请输入电话号码"></el-input>
      </el-form-item>

      <el-form-item prop="code">
        <el-input v-model="userForm.code" class="form-control" placeholder="请输入验证码" style="width: 55%;"></el-input>
<!--        <el-button type="primary" style="width: 120px;margin-left: 7px;" @click="getting" >获取验证码</el-button>-->
        <el-button type="primary" style="width: 120px;margin-left: 7px;"  >获取验证码</el-button>
      </el-form-item>

      <el-form-item prop="password">
        <el-input type="password" v-model="userForm.password" class="form-control" placeholder="请输入密码字母加数字"></el-input>
      </el-form-item>

      <el-form-item prop="checked">
        <el-checkbox v-model="checked" @change="dialogFormVisible = true;checked=false" ><span style="color: #f2f2f2">我已经遵守协议</span></el-checkbox>
      </el-form-item>

      <el-form-item>
        <el-button type="primary"  @click="myregister" style="width: 100%">注册</el-button>

      </el-form-item>
    </el-form></div>




  </div>

    <!--弹框-->
    <div class="repair">
      <el-dialog title="注册须知" :visible.sync="dialogFormVisible">
        <el-form :model="form" style="height: 400px;overflow: auto;text-align: center " >

          <h2>在线课程学习平台</h2>
          <br>
          <p>

          </p>


        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="checked = false;dialogFormVisible = false">取消</el-button>
    <el-button type="primary"  @click="dialogFormVisible = false;checked=true">确认</el-button>
  </span>
      </el-dialog>
    </div>

  </div>
</template>

<script>
  import * as loginApi from '../../base/api/login';
  export default {
    name: "Register",
    data() {
      return {
        checked: false,
        rules: {
          username: [{required: true, message: '请输入电话号码', trigger: 'blur'}],
          name: [{required: true, message: '请输入昵称', trigger: 'blur'}],
          code: [{required: true, message: '请输入验证码', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码字母加数字', trigger: 'blur'}],
        },
        dialogTableVisible: false,
        dialogFormVisible: false,
        formLabelWidth: '120px',
        form:{
          // eename:'',
        },
        userForm: {
          username:'itcast',
          password:'',
          name:'',
          code:'',
        }
      }
    },
    methods: {
      // getting() {
      //   let that=this
      //  // event.preventDefault();
      //   if(that.userForm.username==''){
      //     return this.$message({message: '请填写手机号码 ',type: 'error',showClose: true})
      //   }
      //
      //   // this.axios.post('http://localhost:8081/gettel',
      //   //   this.userForm
      //   // )
      //     .then(res => {
      //       if (res.data == '002') {
      //         this.$message({message: '该用户已被注册', type: 'warn'});
      //       }
      //       if (res.data == '000') {
      //         this.$message({message: '验证码已发送，请注意查收', type: 'success'});
      //       }
      //     })
      //     .catch(error => {
      //       console.log(error);
      //     });
      // },
      // register(formName) {
      //   let that = this
      //
      //   var re = /^1\d{10}$/
      //   //账号必须1开头11位
      //   //字母、数字、下划线组成，字母开头，4-16位
      //   // 8-16位字符；数字、字母、特殊字符（除空格），起码其中两种组合 这个密码验证的正则表达式
      //   var ps =  /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{8,16}$/;
      //
      //   if(that.checked===false){
      //     return  this.$message({message: '请遵守协议', type: 'error'})
      //   }else if(re.test(that.userForm.username)&&ps.test(that.userForm.password)){
      //
      //     this.$refs[formName].validate((valid) => {
      //       if (valid) {
      //         that.$store.dispatch('register', that.userForm).then(() => {
      //           that.$message({message: '注册成功 快去完善信息吧',type: 'success',showClose: true});
      //           that.$router.push({ path: '/basic' })
      //         }).catch((error) => {
      //           if(error !== 'error'){
      //             that.$message({message: error,type: 'error',showClose: true});
      //           }
      //         })
      //
      //       } else {
      //         return false;
      //       }
      //     });
      //
      //
      //   }else{
      //     this.$message({message: '请填写正确的手机号码和密码 ',type: 'error',showClose: true})
      //   }
      //
      //
      // }
      myregister(){
        this.$refs.userForm.validate((valid) => {
          if(valid){

            loginApi.register(this.userForm).then(res=>{
              if(res.success){
                this.$message({message: '注册成功，赶快登录吧！ ',type: 'success',showClose: true});
                this.$router.push('/login')
              }

              console.log(res)
            })
          }
        })

      }
    }

  }
</script>

<style scoped>
  .beijing{
   background: url("../../assets/img/timg.jpg");
  }
#Register{
  width: 300px;
  height: 250px;
  margin: 50px auto ;
  /*padding-top: 150px;*/
  /*opacity: 0.5;*/

}
  #caiji{
    position: absolute;
    width: 380px;
    height:420px;
    /*border: 1px solid #ffffff;*/
    margin-left: 500px;
    margin-top: 100px;
    /*background-color: white;*/
    /*opacity: 0.5;*/
    background: rgba(0, 0, 0, 0.35);
    border-radius: 25px;
  }
</style>
