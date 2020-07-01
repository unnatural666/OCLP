<template>
  <div >
<!--    搜索部分-->
    <div >
      <h2>关键字：{{this.keyword}}</h2>
      <p>
        一级分类：
        <template v-for="(item,index) in se.subject">
          <!--        <span class="subjectItem" @click="subjectClick(item.tag)" :class="{bold:se.currentTag==item.tag}">{{item.name}}</span>-->
          <span class="subjectItem" @click="subjectClick(item.tag,item.id)" :class="{bold:se.currentTag==item.tag}">{{item.name}}</span>
        </template>
      </p>

      <p>
        二级分类：
        <template v-for="(item,index) in se.detail">
          <span class="subjectItem" v-show="se.currentTag==item.tag || se.currentTag=='all'" :class="{bold:se.currentName==item.name}" @click="detailClick(item.name,item.id)">{{item.name}}</span>
        </template>
      </p>
      <p>
        难度等级：
        <template v-for="(item,index) in se.Status">
          <span class="subjectItem"  :class="{bold:se.currentStatus==item.status}"  @click="statusClick(item.status,item.grade)">{{item.status}}</span>
        </template>
      </p>
    </div>
<!--    页面部分-->
    <div >
      <section>
      <el-row >
<!--        <el-col :span="8"  :offset=2 >-->
<!--          <el-card :body-style="{ padding: '10px' }">-->
<!--            <img src="/static/images/add.jpg" class="image" height="150px">-->
<!--            <div style="padding: 10px;">-->
<!--              <span>课程名称</span>-->
<!--              <div class="bottom clearfix">-->
<!--                <time class="time"></time>-->
<!--                <router-link class="mui-tab-item" :to="{path:'/course/add/base'}">-->
<!--                  <el-button type="text" class="button" >新增课程</el-button>-->
<!--                </router-link>-->
<!--              </div>-->
<!--            </div>-->
<!--          </el-card>-->
<!--        </el-col>-->

        <el-col :span="8" v-for="(course, index) in courses" :key="course.id" :offset="index > 0 ? 1 : 1">
          <el-card :body-style="{ padding: '15px' }">
            <router-link :to="{path:'/coursedetail/'+course.id}" @click="handleManage(course.id)" target="_blank"><img :src="course.pic!=null?imgUrl+course.pic:'/static/images/nonepic.jpg'" class="image" height="150px"> </router-link>
            <div style="padding: 10px;">
              <span>{{course.name}}</span>
              <div class="bottom clearfix">
                <time class="time"></time>
<!--                <el-button type="text" class="button" @click="handleManage(course.id)">管理课程</el-button>-->
              </div>
            </div>
          </el-card>
        </el-col>

        <!--分页-->
        <el-col :span="24" class="toolbar">
          <el-pagination background layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="size"
                         :total="total" :current-page="page"
                         style="float:right;">
          </el-pagination>
        </el-col>
      </el-row>
    </section>
    </div>


  </div>



</template>
<script>
  import PubSub from 'pubsub-js'
  //配置文件
   import * as courseApi from '../allcourse/api/course';
  import utilApi from '../../common/utils';
  let sysConfig = require('@/../config/sysConfig')
  // import {search_course} from "./api/course";

  export default {

    data(){
      return {
        page:1,
        size:7,
        total:0,
        keyword:'',
        courseid:'',

        courses: [
          {
            id:'402885816243d2dd016243f24c030002',
            name:'test01',
            pic:''
          },
          {
            id:'4028e581617f945f01617f9dabc40000',
            name:'test02',
            pic:''
          }
        ],
        sels: [],//列表选中列
        imgUrl:sysConfig.imgUrl,

        se:{
          subject:[
            {
              name:"全部",
              tag:"all",
              id:"1",
            },
            {
              name:"前端开发",
              tag:"front",
              id:"1-1",
            },
            {
              name:"移动开发",
              tag:"mobile",
              id:"1-2",
            },
            {
              name:"编程开发",
              tag:"program",
              id:"1-3",
            },
            {
              name:"数据库",
              tag:"database",
              id:"1-4",
            },
            {
              name:"人工智能",
              tag:"people",
              id:"1-5",
            },
            {
              name:"云计算/大数据",
              tag:"bigdata",
              id:"1-6",
            },
            {
              name:"UI设计",
              tag:"ui",
              id:"1-7",
            },
            {
              name:"游戏开发",
              tag:"game",
              id:"1-8",
            },
            {
              name:"智能硬件/物联网",
              tag:"hard",
              id:"1-9",
            },
            {
              name:"研发管理",
              tag:"explore",
              id:"1-10",
            },
            {
              name:"系统运维",
              tag:"sys",
              id:"1-11",
            },
            {
              name:"产品经理",
              tag:"product",
              id:"1-12",
            },
            {
              name:"企业/办公/职场",
              tag:"work",
              id:"1-13",
            },
            {
              name:"信息安全",
              tag:"safe",
              id:"1-14",
            },


          ],
          detail:[
            {
              name:"全部",
              tag:"all",
              id:"1",
            },

            {
              name:"HTML/CSS",
              tag:"front",
              id:"1-1-1"
            },
            {
              name:"JavaScript",
              tag:"front",
              id:"1-1-2"
            },
            {
              name:"jQuery",
              tag:"front",
              id:"1-1-3"
            },
            {
              name:"ExtJS",
              tag:"front",
              id:"1-1-4"
            },
            {
              name:"AngularJS",
              tag:"front",
              id:"1-1-5"
            },
            {
              name:"ReactJS",
              tag:"front",
              id:"1-1-6"
            },
            {
              name:"Bootstrap",
              tag:"front",
              id:"1-1-7"
            },
            {
              name:"Node.js",
              tag:"front",
              id:"1-1-8"
            },
            {
              name:"Vue",
              tag:"front",
              id:"1-1-9"
            },
            {
              name:"其它",
              tag:"front",
              id:"1-1-10"
            },

            {
              name:"微信开发",
              tag:"mobile",
              id:"1-2-1"
            },
            {
              name:"iOS",
              tag:"mobile",
              id:"1-2-2"
            },
            {
              name:"手游开发",
              tag:"mobile",
              id:"1-2-3"
            },
            {
              name:"Swift",
              tag:"mobile",
              id:"1-2-4"
            },
            {
              name:"Android",
              tag:"mobile",
              id:"1-2-5"
            },
            {
              name:"ReactNative",
              tag:"mobile",
              id:"1-2-6"
            },
            {
              name:"Cordova",
              tag:"mobile",
              id:"1-2-7"
            },
            {
              name:"其它",
              tag:"mobile",
              id:"1-2-8"
            },

            {
              name:"C/C++",
              tag:"program",
              id:"1-3-1"
            },
            {
              name:"Java",
              tag:"program",
              id:"1-3-2"
            },
            {
              name:".NET",
              tag:"program",
              id:"1-3-3"
            },
            {
              name:"Objective-C",
              tag:"program",
              id:"1-3-4"
            },
            {
              name:"Go语言",
              tag:"program",
              id:"1-3-5"
            },
            {
              name:"Python",
              tag:"program",
              id:"1-3-6"
            },
            {
              name:"Ruby/Rails",
              tag:"program",
              id:"1-3-7"
            },
            {
              name:"其它",
              tag:"program",
              id:"1-3-8"
            },

            {
              name:"Oracle",
              tag:"database",
              id:"1-4-1"
            },
            {
              name:"MySQL",
              tag:"database",
              id:"1-4-2"
            },
            {
              name:"SQL Server",
              tag:"database",
              id:"1-4-3"
            },
            {
              name:"DB2",
              tag:"database",
              id:"1-4-4"
            },
            {
              name:"NoSQL",
              tag:"database",
              id:"1-4-5"
            },
            {
              name:"Mongo DB",
              tag:"database",
              id:"1-4-6"
            },
            {
              name:"Hbase",
              tag:"database",
              id:"1-4-7"
            },
            {
              name:"数据仓库",
              tag:"database",
              id:"1-4-8"
            },
            {
              name:"其它",
              tag:"database",
              id:"1-4-9"
            },

            {
              name:"机器学习",
              tag:"people",
              id:"1-5-1"
            },
            {
              name:"深度学习",
              tag:"people",
              id:"1-5-2"
            },
            {
              name:"语音识别",
              tag:"people",
              id:"1-5-3"
            },
            {
              name:"计算机视觉",
              tag:"people",
              id:"1-5-4"
            },
            {
              name:"NLP",
              tag:"people",
              id:"1-5-5"
            },
            {
              name:"强化学习",
              tag:"people",
              id:"1-5-6"
            },
            {
              name:"其它",
              tag:"people",
              id:"1-5-7"
            },

            {
              name:"Hadoop",
              tag:"bigdata",
              id:"1-6-2"
            },
            {
              name:"OpenStack",
              tag:"bigdata",
              id:"1-6-3"
            },
            {
              name:"Docker/K8S",
              tag:"bigdata",
              id:"1-6-4"
            },
            {
              name:"云计算基础架构",
              tag:"bigdata",
              id:"1-6-5"
            },
            {
              name:"虚拟化技术",
              tag:"bigdata",
              id:"1-6-6"
            },
            {
              name:"云平台",
              tag:"bigdata",
              id:"1-6-7"
            },
            {
              name:"ELK",
              tag:"bigdata",
              id:"1-6-8"
            },
            {
              name:"其它",
              tag:"bigdata",
              id:"1-6-9"
            },

            {
              name:"Photoshop",
              tag:"ui",
              id:"1-7-1"
            },
            {
              name:"3Dmax",
              tag:"ui",
              id:"1-7-2"
            },
            {
              name:"Illustrator",
              tag:"ui",
              id:"1-7-3"
            },
            {
              name:"Flash",
              tag:"ui",
              id:"1-7-4"
            },
            {
              name:"Maya",
              tag:"ui",
              id:"1-7-5"
            },
            {
              name:"AUTOCAD",
              tag:"ui",
              id:"1-7-6"
            },
            {
              name:"UG",
              tag:"ui",
              id:"1-7-7"
            },
            {
              name:"SolidWorks",
              tag:"ui",
              id:"1-7-8"
            },
            {
              name:"CorelDraw",
              tag:"ui",
              id:"1-7-9"
            },
            {
              name:"InDesign",
              tag:"ui",
              id:"1-7-10"
            },
            {
              name:"Pro/Engineer",
              tag:"ui",
              id:"1-7-11"
            },
            {
              name:"Cinema 4D",
              tag:"ui",
              id:"1-7-12"
            },
            {
              name:"3D Studio",
              tag:"ui",
              id:"1-7-13"
            },
            {
              name:"After Effects（AE）",
              tag:"ui",
              id:"1-7-14"
            },
            {
              name:"原画设计",
              tag:"ui",
              id:"1-7-15"
            },
            {
              name:"动画制作",
              tag:"ui",
              id:"1-7-16"
            },
            {
              name:"Dreamweaver",
              tag:"ui",
              id:"1-7-17"
            },
            {
              name:"Axure",
              tag:"ui",
              id:"1-7-18"
            },
            {
              name:"其它",
              tag:"ui",
              id:"1-7-19"
            },

            {
              name:"Cocos",
              tag:'game',
              id:"1-8-1"
            },
            {
              name:"Unity3D",
              tag:'game',
              id:"1-8-2"
            },
            {
              name:"Flash",
              tag:'game',
              id:"1-8-3"
            },
            {
              name:"SpriteKit 2D",
              tag:'game',
              id:"1-8-4"
            },
            {
              name:"Unreal",
              tag:'game',
              id:"1-8-5"
            },
            {
              name:"其它",
              tag:'game',
              id:"1-8-6"
            },

            {
              name:"无线通信",
              tag:"hard",
              id:"1-9-1"
            },
            {
              name:"电子工程",
              tag:"hard",
              id:"1-9-2"
            },
            {
              name:"Arduino",
              tag:"hard",
              id:"1-9-3"
            },
            {
              name:"体感技术",
              tag:"hard",
              id:"1-9-4"
            },
            {
              name:"智能硬件",
              tag:"hard",
              id:"1-9-5"
            },
            {
              name:"驱动/内核开发",
              tag:"hard",
              id:"1-9-6"
            },
            {
              name:"单片机/工控",
              tag:"hard",
              id:"1-9-7"
            },
            {
              name:"WinCE",
              tag:"hard",
              id:"1-9-8"
            },
            {
              name:"嵌入式",
              tag:"hard",
              id:"1-9-9"
            },

            {
              name:"敏捷开发",
              tag:'explore',
              id:"1-10-1"
            },
            {
              name:"软件设计",
              tag:'explore',
              id:"1-10-2"
            },
            {
              name:"软件测试",
              tag:'explore',
              id:"1-10-3"
            },
            {
              name:"研发管理",
              tag:'explore',
              id:"1-10-4"
            },
            {
              name:"其它",
              tag:'explore',
              id:"1-10-5"
            },

            {
              name:"Linux",
              tag:"sys",
              id:"1-11-1"
            },
            {
              name:"Windows",
              tag:"sys",
              id:"1-11-2"
            },
            {
              name:"UNIX",
              tag:"sys",
              id:"1-11-3"
            },
            {
              name:"Mac OS",
              tag:"sys",
              id:"1-11-4"
            },
            {
              name:"网络技术",
              tag:"sys",
              id:"1-11-5"
            },
            {
              name:"路由协议",
              tag:"sys",
              id:"1-11-6"
            },
            {
              name:"无线网络",
              tag:"sys",
              id:"1-11-7"
            },
            {
              name:"Ngnix",
              tag:"sys",
              id:"1-11-8"
            },
            {
              name:"邮件服务器",
              tag:"sys",
              id:"1-11-9"
            },
            {
              name:"其它",
              tag:"sys",
              id:"1-11-10"
            },

            {
              name:"交互设计",
              tag:"product",
              id:"1-12-1"
            },
            {
              name:"产品设计",
              tag:"product",
              id:"1-12-2"
            },
            {
              name:"原型设计",
              tag:"product",
              id:"1-12-3"
            },
            {
              name:"用户体验",
              tag:"product",
              id:"1-12-4"
            },
            {
              name:"需求分析",
              tag:"product",
              id:"1-12-5"
            },
            {
              name:"其它",
              tag:"product",
              id:"1-12-6"
            },

            {
              name:"运营管理",
              tag:"work",
              id:"1-13-1"
            },
            {
              name:"企业信息化",
              tag:"work",
              id:"1-13-2"
            },
            {
              name:"网络营销",
              tag:"work",
              id:"1-13-3"
            },
            {
              name:"Office/WPS",
              tag:"work",
              id:"1-13-4"
            },
            {
              name:"招聘/面试",
              tag:"work",
              id:"1-13-5"
            },
            {
              name:"电子商务",
              tag:"work",
              id:"1-13-6"
            },
            {
              name:"CRM",
              tag:"work",
              id:"1-13-7"
            },
            {
              name:"ERP",
              tag:"work",
              id:"1-13-8"
            },
            {
              name:"其它",
              tag:"work",
              id:"1-13-9"
            },

            {
              name:"密码学/加密/破解",
              tag:"safe",
              id:"1-14-1"
            },
            {
              name:"渗透测试",
              tag:"safe",
              id:"1-14-2"
            },
            {
              name:"社会工程",
              tag:"safe",
              id:"1-14-3"
            },
            {
              name:"漏洞挖掘与利用",
              tag:"safe",
              id:"1-14-4"
            },
            {
              name:"云安全",
              tag:"safe",
              id:"1-14-5"
            },
            {
              name:"防护加固",
              tag:"safe",
              id:"1-14-6"
            },
            {
              name:"代码审计",
              tag:"safe",
              id:"1-14-7"
            },
            {
              name:"移动安全",
              tag:"safe",
              id:"1-14-8"
            },
            {
              name:"病毒木马",
              tag:"safe",
              id:"1-14-9"
            },
            {
              name:"其它",
              tag:"safe",
              id:"1-14-10"
            },
          ],
          Status:[
            {
              status:"全部",
              grade:"",
            },
            {
              status:"初级",
              grade:"200001",

            },
            {
              status:"中级",
              grade:"200002",

            },
            {
              status:"高级",
              grade:"200001",
            },

          ],
          currentTag:"program",
          currentName:"",
          currentStatus:""
        },
        se1:{
          subject:[
            {
              name:"",
              tag:""
            },
          ],
          detail:[{
            name:"",
            tag:""
          },],
          Status:[  {
            status:"",
          },],
          currentTag:"all",
          currentName:"",
          currentStatus:"",
          tag:'program',
          pid:'',
          cid:'',
          mt:'',
          st:'',
          grade:'',
          keyword:'',

        }

      }
    },
    methods:{
      //看视频
      handleManage(courseid){
        console.log(courseid)
      },
      //分页方法
      handleCurrentChange(val) {
        this.page = val;
        this.getCourse();
      },

      subjectClick:function(tag,id){
        this.se.currentTag=tag;
        this.se1.mt=id;
        console.log(this.se1.mt)
        console.log('--------------------')
        this.search()
      },
      detailClick:function(name,id){
        this.se.currentName=name;
        this.se1.st=id;
        console.log(this.se1.st)
        console.log(this.se1)
        this.search()
      },
      statusClick:function(status,grade){
        this.se.currentStatus=status;
        this.se1.grade=grade;
        console.log(this.se1.currentStatus)

        this.search()
      },

     search(){
        courseApi.search_course(this.page,this.size,this.se1).then((res)=>{
          console.log(res);
          if(res.success){
            this.total = res.queryResult.total;
            this.courses = res.queryResult.list;
          }
        })

     },

    },
    mounted(){
      PubSub.subscribe('searchkey',(event,keyword)=>{
        console.log(keyword)
        this.se1.keyword=keyword
        this.keyword=keyword
        this.search()

      })
    },
    created(){
      this.subjectClick()
    }

  }
</script>
<style scoped>
  .subjectItem{
    margin-right: 15px;
    margin-top: 10px;
  }
  .bold{
    font-weight: bold;
    color: white;
    background-color:blue;
  }


  .el-col-8{
    width:20%
  }
  .el-col-offset-2{
    margin-left:2%
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>

