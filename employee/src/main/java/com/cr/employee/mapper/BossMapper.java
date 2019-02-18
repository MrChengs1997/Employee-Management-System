package com.cr.employee.mapper;

import com.cr.employee.pojo.Boss;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BossMapper {

    public Boss getById(Integer id);

    //登陆测试
    public  int checked(@Param("name")String name,@Param("pw") String pw);

    //查询did
    public  int  EmpDid(String name);


}
