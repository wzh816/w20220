package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Teacher;

import java.util.List;

/**
 * @author 王志恒
 * @create 2021/12/7 16:33
 */
public interface TeacherService {
    PageInfo<Teacher> teacherList(Integer pageNum,Integer pageSize,Teacher teacher);


    void deleteTeacherTry(Integer tid);

    Teacher saveById(Integer tid);

    void saveByTeacher(Teacher teacher);
}
