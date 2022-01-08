package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.TeacherMapper;
import com.pojo.Teacher;
import com.pojo.TeacherExample;
import com.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王志恒
 * @create 2021/12/7 16:34
 */
@Service
public class TeacherServiceimpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    public PageInfo<Teacher> teacherList(Integer pageNum, Integer pageSize, Teacher teacher) {
        PageHelper.startPage(pageNum,pageSize);
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria=teacherExample.createCriteria();
        if(teacher!=null){
            if(!StringUtils.isEmpty(teacher.getTname())){
                criteria.andTnameLike("%"+teacher.getTname()+"%");
            }
            if(teacher.getTmoney()!=null){
                criteria.andTmoneyGreaterThanOrEqualTo(teacher.getTmoney());
            }
            if(teacher.getMoney()!=null){
                criteria.andTmoneyLessThanOrEqualTo(teacher.getMoney());
            }
        }
        List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
        PageInfo<Teacher> teacherPageInfo=new PageInfo<Teacher>(teacherList);
        return teacherPageInfo;
    }

    public void deleteTeacherTry(Integer tid) {
        teacherMapper.deleteByPrimaryKey(tid);
    }

    public Teacher saveById(Integer tid) {
        return teacherMapper.selectByPrimaryKey(tid);
    }

    public void saveByTeacher(Teacher teacher) {
        if(teacher!=null){
            if(teacher.getTid()!=null){
                teacherMapper.updateByPrimaryKeySelective(teacher);
            }else{
                teacherMapper.insertSelective(teacher);
            }
        }
    }


}
