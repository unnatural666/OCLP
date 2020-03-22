package com.oclp.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oclp.common.exception.ExceptionCast;
import com.oclp.common.model.response.CommonCode;
import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.common.model.response.QueryResult;
import com.oclp.common.model.response.ResponseResult;
import com.oclp.dao.CourseBaseRepository;
import com.oclp.dao.CourseMapper;
import com.oclp.dao.TeachplanMapper;
import com.oclp.dao.TeachplanRepository;
import com.oclp.domain.course.CourseBase;
import com.oclp.domain.course.Teachplan;
import com.oclp.domain.course.ext.CourseInfo;
import com.oclp.domain.course.ext.TeachplanNode;
import com.oclp.domain.course.request.CourseListRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanRepository teachplanRepository;

    @Autowired
    CourseBaseRepository courseBaseRepository;

    @Autowired
    CourseMapper courseMapper;
    //查询课程计划
    public TeachplanNode findTeachplanList(String courseId){
        return teachplanMapper.selectList(courseId);
    }

    //添加课程计划
    @Transactional
    public ResponseResult addTeachplan(Teachplan teachplan) {

        if(teachplan == null ||
                StringUtils.isEmpty(teachplan.getPname()) ||
                StringUtils.isEmpty(teachplan.getCourseid())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        //课程id
        String courseid = teachplan.getCourseid();
        //父结点的id
        String parentid = teachplan.getParentid();
        if(StringUtils.isEmpty(parentid)){
            //获取课程的根结点
            parentid = getTeachplanRoot(courseid);
        }
        //查询根结点信息
        Optional<Teachplan> optional = teachplanRepository.findById(parentid);
        Teachplan teachplan1 = optional.get();
        //父结点的级别
        String parent_grade = teachplan1.getGrade();
        //创建一个新结点准备添加
        Teachplan teachplanNew = new Teachplan();
        //将teachplan的属性拷贝到teachplanNew中
        BeanUtils.copyProperties(teachplan,teachplanNew);
        //要设置必要的属性
        teachplanNew.setParentid(parentid);
        teachplanNew.setCourseid(courseid);
        if(parent_grade.equals("1")){
            teachplanNew.setGrade("2");
        }else{
            teachplanNew.setGrade("3");
        }
        teachplanNew.setStatus("0");//未发布
        teachplanRepository.save(teachplanNew);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    //获取课程的根结点,查询不到自动添加根节点
    private String getTeachplanRoot(String courseId){
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if(!optional.isPresent()){
            return null;
        }
        CourseBase courseBase = optional.get();
        //调用dao查询teachplan表得到该课程的根结点（一级结点）
        List<Teachplan> teachplanList = teachplanRepository.findByCourseidAndParentid(courseId, "0");
        if(teachplanList == null || teachplanList.size()<=0){
            //查询不到，新添加一个课程的根结点
            Teachplan teachplan = new Teachplan();
            teachplan.setCourseid(courseId);
            teachplan.setParentid("0");
            teachplan.setGrade("1");//一级结点
            teachplan.setStatus("0");
            teachplan.setPname(courseBase.getName());
            teachplanRepository.save(teachplan);
            return teachplan.getId();
        }
        //返回根结点的id
        return teachplanList.get(0).getId();

    }

    //课程列表分页查询
    public QueryResponseResult<CourseInfo> findCourseList(int page, int size, CourseListRequest courseListRequest){
        if (courseListRequest==null){
            courseListRequest=new CourseListRequest();
        }
        if (page<=0){
            page=0;
        }
        if (size<=0){
            size=20;
        }
        //设置分页参数
        PageHelper.startPage(page,size);
        //分页查询
        Page<CourseInfo> courseListPage=courseMapper.findCourseListPage(courseListRequest);
        //查询列表
        List<CourseInfo> list=courseListPage.getResult();
        //总记录数
        long total=courseListPage.getTotal();
        //查询结果集
        QueryResult<CourseInfo> courseInfoQueryResult=new QueryResult<CourseInfo>();
        courseInfoQueryResult.setList(list);
        courseInfoQueryResult.setTotal(total);
        return new QueryResponseResult<CourseInfo>(CommonCode.SUCCESS,courseInfoQueryResult);
    }
}
