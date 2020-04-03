<template>
  <div>
    <template>
      <div>
        <el-dialog title="课程预览" :visible.sync="dialogFormVisible" fullscreen>
          <el-form :model="form"  label-width="140px" style="width:1200px;height: 600px">
         <div class="preview">
<!--           头部-->
<!--           <div class="phead">-->

<!--           </div>-->
<!--           中间-->
           <div class="pmiddle">

             <div class="mleft">
             <div class="mll" >
               <h1>{{courseBase.name}}</h1><br>
               <p class="pic"><span class="new-pic">特惠价格￥{{courseMarket.price}}</span> <span class="old-pic">原价￥{{courseMarket.price_old}}</span></p><br>
<!--               <span><em>难度等级</em>-->
<!--                中等-->
<!--                </span>-->
<!--               <span><em>课程时长</em>-->
<!--                </span>-->
<!--               <span><em>评分</em></span>-->
<!--               <span><em>授课模式</em>-->
<!--                 任务式学习-->
<!--                </span>-->
               <div class="hello">
                 <el-breadcrumb separator="|">
                   <el-breadcrumb-item :to="{ path: '/' }">难度等级{{courseBase.grade}}</el-breadcrumb-item>
                   <el-breadcrumb-item>课程时长{{teachplanNode.timelength}}</el-breadcrumb-item>
                   <el-breadcrumb-item>评分</el-breadcrumb-item>
                   <el-breadcrumb-item>授课模式</el-breadcrumb-item>
                 </el-breadcrumb>
               </div>



             </div>


             </div>
             <div class="mright">
               <div class="mrr1" >

               </div>
               <div class="mrr2" >
                 <el-tag type="info"  style="margin-left: 80px ;width: 50px">收藏</el-tag>
                 <el-tag type="info" style="margin-left: 60px ;width: 50px">分享</el-tag>

               </div>
             </div>

           </div>
<!-- 下半部分-->
           <div class="pbottom">
             <div class="lbottom">
               <div class="lcard">
                 <el-card class="box-card">
                   <div slot="header" class="clearfix">
                     <span>课程介绍 </span>
<!--                     <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
                   </div>

                   <div  class="wc">
                     {{'适应人群： ' + courseBase.users }}
                   </div>
                   <br>

                   <div  class="text item">
                     {{'适应人群： ' + courseBase.users }}
                   </div>
                 </el-card>
               </div>

             </div>
             <div class="rbottom">
               <el-card class="box-card">
                 <div slot="header" class="clearfix">
                   <span>课程目录</span>
                   <!--                     <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
                 </div>
<!--                 课程计划渲染-->
                 <div  class="text item">
                   <el-tree
                     :data="teachplanList"
                     :props="defaultProps"
                     node-key="id"
                     default-expand-all
                     :expand-on-click-node="false"
                     :render-content="renderContent">
                   </el-tree>
                 </div>
               </el-card>
             </div>

           </div>

         </div>
          </el-form>
<!--          <div slot="footer" class="dialog-footer">-->
<!--&lt;!&ndash;            <el-button type="primary" @click="dialogFormVisible = false">关闭预览</el-button>&ndash;&gt;-->
<!--          </div>-->
        </el-dialog>
        <el-card class="box-card1">
          <div slot="header" class="clearfix">
            <span>课程预览</span>
          </div>
          <div class="text item">
            <el-button type="primary"  @click.native="preview" >课程预览</el-button>
            <br/><br/>
<!--            <span v-if="previewurl && previewurl!=''"><a :href="previewurl" target="_blank">点我查看课程预览页面 </a> </span>-->
          </div>
        </el-card>
        <el-card class="box-card1">
          <div slot="header" class="clearfix">
            <span>课程发布</span>
          </div>
          <div class="text item">
            <div v-if="course.status == '202001'">
              状态：制作中<br/>
              <el-button type="primary"  @click.native="publish" >新课程发布</el-button>
            </div>
            <div v-else-if="course.status == '202003'">
              状态：已下线
              <br/><br/>
              <span><a :href="'http://www.xuecheng.com/course/detail/'+this.courseid+'.html'" target="_blank">点我查看课程详情页面 </a> </span>
            </div>
            <div v-else-if="course.status == '202002'">
              状态：已发布<br/>
              <el-button type="primary"  @click.native="publish" >修改发布</el-button>
              <br/><br/>
              <span><a :href="'http://www.xuecheng.com/course/detail/'+this.courseid+'.html'" target="_blank">点我查看课程详情页面 </a> </span>
            </div>
          </div>
        </el-card>
      </div>
    </template>
  </div>
</template>
<script>
  import * as sysConfig from '@/../config/sysConfig';
  import * as courseApi from '../../api/course';
  import utilApi from '../../../../common/utils';
  import * as systemApi from '../../../../base/api/system';
export default{

  data() {
    return {
      //课程计划渲染
      courseBase:{
        name:'',

      },
      coursePic:{

      },
      courseMarket:{

      },
      teachplanNode:{

      },


      teachplanList : [{
        id: 1,
        pname: '一级 1',
        children: [{
          id: 4,
          pname: '二级 1-1',
          children: [{
            id: 9,
            pname: '三级 1-1-1'
          }, {
            id: 10,
            pname: '三级 1-1-2'
          }]
        }]
      }],
      defaultProps:{
        children: 'children',
        label: 'pname'
      },
      //弹出对话框
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px',
      dotype: '',
      courseid: '',
      course: {"id": "", "name": "", "status": ""},
      previewurl: ''
    }
  },
  methods:{

    //课程预览
    preview(){
      this.dialogFormVisible=true
        courseApi.preview(this.courseid).then((res) => {
          console.log('sssssssssssssssssssssssssssssssssssssssssssssssssss')
          console.log(res)
          console.log(res.courseBase)
          console.log(res.teachplanNode.children)
          this.teachplanList=res.teachplanNode.children
          this.teachplanNode=res.teachplanNode
          this.courseBase=res.courseBase
          this.courseMarket=res.courseMarket

          if(res.success){
            console.log('--------------------------------------')
            console.log(res)
            // this.$message.error('预览页面生成成功，请点击下方预览链接');
            // if(res.success){
            //   //预览url
            //  console.log(res)
            // }
          }else{
            this.$message.error(res.message);
          }
        });

    },
    //课程计划查询
    findTeachplan(){
      this.teachplanList = []
      //查询课程计划
      courseApi.findTeachplanList(this.courseid).then(res=>{
        if(res && res.children){
          this.teachplanList = res.children;
        }


      })
    },
    //预览
    // preview(){
    //     //调用课程管理服务的预览接口，得到课程预览url
    //   courseApi.preview(this.courseid).then((res) => {
    //     if(res.success){
    //       this.$message.error('预览页面生成成功，请点击下方预览链接');
    //       if(res.previewUrl){
    //         //预览url
    //         this.previewurl = res.previewUrl
    //       }
    //     }else{
    //       this.$message.error(res.message);
    //     }
    //   });
    // },
    publish(){
      //课程发布
      courseApi.publish(this.courseid).then(res=>{
          if(res.success){
              this.$message.success("发布成功，请点击下边的链接查询课程详情页面")

          }else{
            this.$message.error(res.message)
          }

      })
    },
    getCourseView(){
      courseApi.findCourseView(this.courseid).then(res=>{
        if(res && res.courseBase){
            //获取课程状态
            this.course.status = res.courseBase.status;
        }

      })
    }

  },
  mounted(){
    //课程id
    this.courseid = this.$route.params.courseid;
    //查询课程信息
    this.getCourseView();
  }

  }
</script>
<style scoped>
  .preview{
    margin-top: -25px;
    width: 1200px;
    height: 650px;
    box-shadow: 0 1px 12px 0 rgba(0, 0, 0, 0.1);
  }
  /*.phead{*/
  /*  height: 60px;*/
  /*  width: 100%;*/
  /*  background: url("../../../../statics/images/preview/phead.png");*/
  /*  background-size:100% 100%;*/
  /*  background-repeat:no-repeat;*/
  /*}*/
  .pmiddle{
    height: 210px;
    width: 100%;
    background: url("../../../../statics/images/preview/pmiddle.jpg");
    background-size:100% 100%;
  }
  .mll{
    margin:20px 180px;
    width: 300px;
    height: 200px;
    color: white;
  }
  .pic .new-pic {
    color: #ca50f8;
    font-size: 18px;
  }
  .pic .old-pic {
    color: #999;
    font-size: 18px;
    text-decoration: line-through;
  }

  .hello{
    font-size:20px;
    color: white;
  }
  .mrr1{
    margin-left: 100px;
    width: 300px;
    height: 175px;
    background: url("../../../../statics/images/preview/mrrr.png");
    background-size:100% 100%;
    background-repeat:no-repeat;
  }
  .mrr2{
    font-size: 18px;
    margin-left: 100px;
    width: 300px;
    height: 120px;
  }

  .mleft{

    height: 200px;
    width: 50%;
    float: left;
  }
  .mright{

    height: 200px;
    width: 50%;
    float: left;
  }
  .pbottom{
    background-color: yellow;
    width: 100%;
    height: 360px;
  }
  .lbottom{
    width: 50%;
    height: 360px;
    float: left;
    background-color: blue;
  }
  /*课程介绍*/
  .lcard{

  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 20px;

  }
  .wc{
    height:80px;
    box-shadow: 0 1px 12px 0 rgba(0, 0, 0, 0.1);
}
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    border: none;
    height: 360px;
    width: 100%;
    box-shadow: 0 1px 12px 0 rgba(0, 0, 0, 0.1);
  }


  .rbottom{
    width: 50%;
    height: 360px;
    float: left;
    background-color: palegreen;
  }

</style>
