package com.cr.employee.mapper;

import com.cr.employee.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {

    //查询所有的emp
    public List<Emp> getEmps(Integer did);

    //插入员工
    public  void insert(Emp emp);

    //根据id 查员工
    public Emp getById(Integer id);

    //修改
    public void update(Emp emp);

    //删除
    public  void  delete(Integer id);
}
