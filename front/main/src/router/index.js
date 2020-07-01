import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/components/Layout'
import AllCourse from '@/views/allcourse'
import Java from '@/views/studytrack/java'
import BigData from '@/views/studytrack/bigdata'
import Web from '@/views/studytrack/web'
import Python from '@/views/studytrack/python'
import Android from '@/views/studytrack/android'

import FaceTeach from '@/views/faceteach'
import CourseDetail from  '@/views/coursedetail'


import SafeSet from  '@/views/ucenter/safeset'
import StuSafeSet from  '@/views/ucenter/stusafeset'
import UserCenter from  '@/views/ucenter/usercenter'
import OverView from  '@/views/ucenter/overview'
import Bought from  '@/views/ucenter/bought'
import Dealing from  '@/views/ucenter/dealing'
import Income from  '@/views/ucenter/income'
import Rule from  '@/views/ucenter/rule'
import Help from  '@/views/ucenter/help'
import About from  '@/views/ucenter/about'
import Basic from  '@/views/ucenter/basic'
import CurrentStudy from  '@/views/ucenter/currentstudy'
import Teacher from  '@/views/ucenter/teacher'



// import Add from '@/views/managecourse/page/course_add'
// import course_baseinfo from '@/views/managecourse/page/course_manage/course_baseinfo'
// import course_plan from '@/views/managecourse/page/course_manage/course_plan'
// import course_picture from '@/views/managecourse/page/course_manage/course_picture'
// import course_marketinfo from '@/views/managecourse/page/course_manage/course_marketinfo'
// import course_teacher from '@/views/managecourse/page/course_manage/course_teacher'
// import course_pub from '@/views/managecourse/page/course_manage/course_pub'
// import course_summary from '@/views/managecourse/page/course_manage/course_summary'
//
//
// import CourseManage from '@/views/managecourse/page/course_manage'
// import MyCourse from '@/views/managecourse/mycourse'
// import UpLoad from '@/views/managecourse/upload'
// import MeiZi from '@/views/managecourse/meizi'
// import ManageCourse from '@/views/managecourse'
import Home from '@/views/home'
import Login from '@/views/login'
import Register from '@/views/register'




Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '',
      name: 'Layout',
      component: Layout,
      children: [
        {
          path: '/',
          component: Home
        },
	    	{
	    	 path: '/allcourse',
        //  component: r => require.ensure([], () => r(require('@/views/AllCourse')), 'allcourse'),
         component:AllCourse
         //加上此标签则需要验证登录状态
          // meta: {
          //   requireLogin: true
          // }
	    	},

        {
          path:'/java',
          component:Java
        },
        {
          path:'/bigdata',
          component:BigData
        },
        {
          path:'/android',
          component:Android
        },
        {
          path:'/python',
          component:Python
        },
        {
          path:'/web',
          component:Web
        },
        {
          path: '/faceteach',
          component: FaceTeach

          // meta: {
          //   requireLogin: true
          // },
        },
          {
              path: '/coursedetail/:courseid',
              component: CourseDetail
              // meta: {
              //   requireLogin: true
              // },
          },
        {
          path: '/usercenter',
          component: UserCenter,
          children:[
            {
              path:'/',
              component:SafeSet,
            },
            {
              path:'/safeset',
              component:SafeSet,
            },
            {
              path:'/stusafeset',
              component:StuSafeSet,
            },
            {
              path:'/currentstudy',
              component:CurrentStudy,
            },
            {
              path:'/about',
              component:About,
            },
            {
              path:'/basic',
              component:Basic,
            },
            {
              path:'/teacher',
              component:Teacher,
            },
            {
              path:'/bought',
              component:Bought,
            },
            {
              path:'/dealing',
              component:Dealing,
            },
            {
              path:'/overview',
              component:OverView,
            },
            {
              path:'/income',
              component:Income,
            },
            {
              path:'/rule',
              component:Rule,
            },
            {
              path:'/help',
              component:Help,
            },
          ]

        },




          // {
          //     path: '/managecourse',
          //     component: ManageCourse,
          //     children:[
          //         {
          //             path: '/',
          //             component: MyCourse
          //         },
          //
          //         {
          //             path:'/mycourse',
          //             component:MyCourse,
          //             children:[
          //
          //             ]
          //         },
          //         {
          //             path: '/mycourse/add',
          //             component: Add,
          //         },
          //         {
          //             path: '/course/manage/:courseid',
          //             component: CourseManage,
          //             child:[
          //                 { path: '/course/manage/plan/:courseid', name: '课程计划',component: course_plan,hidden: false },
          //                 { path: '/course/manage/baseinfo/:courseid', name: '基本信息',component: course_baseinfo,hidden: false },
          //                 { path: '/course/manage/picture/:courseid', name: '课程图片',component: course_picture,hidden: false },
          //                 { path: '/course/manage/marketinfo/:courseid', name: '营销信息',component: course_marketinfo,hidden: false },
          //                 { path: '/course/manage/teacher/:courseid', name: '教师信息',component: course_teacher,hidden: false},
          //                 { path: '/course/manage/pub/:courseid', name: '发布课程',component: course_pub,hidden: false},
          //                 { path: '/course/manage/summary/:courseid', name: '课程首页',component: course_summary,hidden: false }
          //             ]
          //
          //
          //         },
          //         {
          //             path:'/upload',
          //             component:UpLoad
          //         },
          //         {
          //             path:'/meizi',
          //             component:MeiZi
          //         },
          //
          //
          //     ]
          //     // meta: {
          //     //   requireLogin: true
          //     // },
          // },

      ]
    },

    {
    	 path: '/login',
    	 component: Login
    },
    {
    	 path: '/register',
    	 component: Register
    },
  ],
  scrollBehavior (to, from, savedPosition) {
	  return { x: 0, y: 0 }
	}
})



export default router
