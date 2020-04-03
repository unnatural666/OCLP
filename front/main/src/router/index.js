import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/components/Layout'
import AllCourse from '@/views/allcourse'
import StudyTrack from '@/views/studytrack'
import FaceTeach from '@/views/faceteach'
import CourseDetail from  '@/views/coursedetail'


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
          path: '/studytrack',
          component: StudyTrack
          // meta: {
          //   requireLogin: true
          // },
        },
        {
          path: '/faceteach',
          component: FaceTeach
          // meta: {
          //   requireLogin: true
          // },
        },
          {
              path: '/coursedetail',
              component: CourseDetail
              // meta: {
              //   requireLogin: true
              // },
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
