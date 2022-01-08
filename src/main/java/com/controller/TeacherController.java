package com.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.pojo.Teacher;
import com.service.TeacherService;
import com.utils.TeacherUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王志恒
 * @create 2021/12/7 16:32
 */
@RestController
@RequestMapping("/TeacherController")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @RequestMapping("/TeacherSelect")
    public PageInfo<Teacher> teacherPageInfo(@RequestParam Integer pageSize,@RequestParam Integer pageNum, @RequestBody Teacher teacherSibe){
        System.out.println("分页"+teacherService.teacherList(pageNum,pageSize,teacherSibe));
        System.out.println("JSON:**"+ JSON.toJSONString(teacherSibe));
        System.out.println("JSON:**"+ JSON.toJSONString(teacherSibe.getTname()));

        return teacherService.teacherList(pageNum,pageSize,teacherSibe);
    }

    @RequestMapping("/TeacherDelete")
    public TeacherUtil TeacherDelete(Integer tid){
        try{
            teacherService.deleteTeacherTry(tid);
            return new TeacherUtil(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();

            return new TeacherUtil(false,"删除失败");
        }

    }
    @RequestMapping("/TeacherById")
    public Teacher TeacherById(Integer tid){
        System.out.println("tid::***"+tid);
        System.out.println(JSON.toJSONString(teacherService.saveById(tid)));
        return  teacherService.saveById(tid);

    }
    @RequestMapping("/TeacherAddUpdate")
    public TeacherUtil TeacherAddUpdate(@RequestBody Teacher teacher){
        System.out.println(JSON.toJSONString(teacher));
        try{
            teacherService.saveByTeacher(teacher);
            return new TeacherUtil(true,"编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new TeacherUtil(true,"编辑失败");

        }

    }



}
