package com.ssm.service.impl;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;
import com.ssm.mapper.StudentMapper;
import com.ssm.page.PageBean;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    /*Service层调用持久层的接口对象声明*/
    @Resource
    private StudentMapper studentMapper;

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public BaseResult<Student> pageSelect(int pageIndex, int pageSize,Student student) {

        BaseResult<Student> result = new BaseResult<Student>();

        PageBean<Student> pg = new PageBean<Student>(1,3,3);
        pg.setParameter(student);

        /*获得总条数*/
        int total = studentMapper.getTotalRecord(pg);

        /*构建分页对象*/
        PageBean<Student> pageBean = new PageBean<Student>(pageIndex+1,pageSize,total);

        //更新分页查询中的参数
        pageBean.setParameter(student);

        /*获取当前页数据*/
        List<Student> datas = studentMapper.pageSelect(pageBean);

        /*将记录总数与当前页data数据设置到BaseResult对象中*/
        result.setTotal(total);
        result.setData(datas);

        return result;
    }

//    public List<Student> pageSelect() {
//        return studentMapper.pageSelect();
//    }
}
