import http from './../../../base/api/public'
import querystring from 'querystring'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;

//查询课程列表
//我的课程列表
export const findCourseList = (page,size,params) => {
//使用工具类将json对象转成key/value
  let queries = querystring.stringify(params)
  return http.requestQuickGet(apiUrl+"/course/coursebase/list/"+page+"/"+size+"?"+queries)
}

//查询课程分类
export const category_findlist= () => {
  return http.requestQuickGet(apiUrl+'/category/list')
}
/*添加课程基础信息*/
export const addCourseBase = params => {
  return http.requestPost(apiUrl+'/course/coursebase/add',params)
}
/*查询课程计划*/
export const findTeachplanList = courseid => {
  return http.requestQuickGet(apiUrl+'/course/teachplan/list/'+courseid)
}
/*添加课程计划*/
export const addTeachplan = teachplah => {
  return http.requestPost(apiUrl+'/course/teachplan/add',teachplah)
}

//保存课程图片地址到课程数据 库
export const addCoursePic= (courseId,pic) => {
  return http.requestPost(apiUrl+'/course/coursepic/add?courseId='+courseId+"&pic="+pic)
}
//查询课程图片
export const findCoursePicList = courseId => {
  return http.requestQuickGet(apiUrl+'/course/coursepic/list/'+courseId)
}

//删除课程图片
export const deleteCoursePic= courseId => {
  return http.requestDelete(apiUrl+'/course/coursepic/delete?courseId='+courseId)
}
// /*预览课程*/
// export const preview = id => {
//   return http.requestPost(apiUrl+'/course/preview/'+id);
// }
/*预览课程*/
export const preview = id => {
  return http.requestQuickGet(apiUrl+'/course/courseview/'+id);
}
/*发布课程*/
export const publish = id => {
  return http.requestPost(apiUrl+'/course/publish/'+id);
}
//查询课程信息
export const findCourseView = courseId => {
  return http.requestQuickGet(apiUrl+'/course/courseview/'+courseId)
}
//信息回显getCoursebaseById
export const getCoursebaseById = courseId => {
  return http.requestQuickGet(apiUrl+'/course/coursebase/get/'+courseId)
}

//更新课程基本信息
export const updateCoursebase= (id,course) => {
  return http.requestPut(apiUrl+'/course/coursebase/update/'+id,course)
}

/*保存媒资信息*/
export const savemedia = teachplanMedia => {
  return http.requestPost(apiUrl+'/course/savemedia',teachplanMedia);
}

/*课程营销*/
export const getCourseMarketById = courseId => {
  return http.requestQuickGet(apiUrl+'/course/coursemarket/get/'+courseId);
}

// 更新课程营销信息
export const updateCourseMarket =(id,courseMarket) => {
  return http.requestPost(apiUrl+'/course/coursemarket/update/'+id,courseMarket)
}
