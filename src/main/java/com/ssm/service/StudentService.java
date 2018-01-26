package com.ssm.service;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

//    List<Student> pageSelect();

    /**
     * 分页查询
     * @param pageIndex 页码，从0开始
     * @param pageSize 每页显示的条数
     *        student 包含条件查询的参数对象
     * @return 返回包含total和data的结果封装对象
     */
    BaseResult<Student> pageSelect(int pageIndex,int pageSize,Student student);

}
