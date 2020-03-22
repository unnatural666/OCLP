package com.oclp.dao;

import com.oclp.domain.course.ext.TeachplanNode;
import com.oclp.domain.system.SysDictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {

    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    SysDictionaryDao sysDictionaryDao;

    @Test
    public void testFindTeachplan(){
        TeachplanNode teachplanNode=teachplanMapper.selectList("4028e581617f945f01617f9dabc40000");
        System.out.println(teachplanNode);
    }


    @Test
    public void testFindbyType(){
        SysDictionary sysDictionary=sysDictionaryDao.findBydType("200");
        System.out.println(sysDictionary);
    }

}
