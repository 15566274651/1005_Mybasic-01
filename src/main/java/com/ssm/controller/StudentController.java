package com.ssm.controller;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class StudentController {

    /*声明Service层中的对外接口对象*/
    @Resource
    private StudentService studentService;

    /**
     * 配置起始页
     **/
    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }


    /*获取学生列表数据，用于前端页面表格显示
    * 返回数据以json格式数据进行返回*/
    @RequestMapping(value = "/searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent(){
        List<Student> students = studentService.selectAll();

        /*将查询到的结果集进行封装*/
        BaseResult<Student> result = new BaseResult<Student>();
        result.setTotal(100);//设置总记录数
        result.setData(students);//设置当页显示数据

        return result;
    }


//    @RequestMapping(value = "/pageSearch")
//    @ResponseBody
//    public BaseResult<Student> pageSearch(){
//        List<Student> students = studentService.pageSelect();
//
//        BaseResult<Student> result = new BaseResult<Student>();
//        result.setTotal(20);
//        result.setData(students);
//        return result;
//
//    }


    /**
     * 分页查询
     * 参数分别是miniUI前端传递过来的参数
     * student:接收前端页面传递过来的参数
     * @return
     */
    @RequestMapping(value = "/findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(int pageIndex,int pageSize,Student student){
        /*调用分页查询业务*/
        BaseResult<Student> result = studentService.pageSelect(pageIndex,pageSize,student);

        return result;
    }
}
