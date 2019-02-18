package com.cr.employee.controller;

import com.cr.employee.mapper.BossMapper;
import com.cr.employee.mapper.EmpMapper;
import com.cr.employee.pojo.Boss;
import com.cr.employee.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BossController {

    @Autowired
    BossMapper bossMapper;
    @Autowired
    EmpMapper empMapper;

    @ResponseBody
    @RequestMapping("/test/{id}")
    public Boss getById(@PathVariable("id") Integer id){
        Boss boss = bossMapper.getById(id);
        return boss;
    }


    @RequestMapping("/login")
    public String Login(String name, String pw,
                        HttpSession session, Map<String,String> map){
       int count = bossMapper.checked(name,pw);

        if (count != 0 ){
            session.setAttribute("name",name);
            return "redirect:/LoginSuccess.html";
        }else {
            map.put("msg","账号或者密码不对");
            return "index";
        }
    }


    //跳转到查询员工页面
    @RequestMapping("/emplist")
    public  String toListEmp(HttpSession session, Model model){

        String name = (String) session.getAttribute("name");

        int did = bossMapper.EmpDid(name);

        List<Emp> emps = empMapper.getEmps(did);
        model.addAttribute("emps",emps);

        //System.out.println(emps);
        return "boss/list";
    }

    //去添加员工的页面
    // /insert
    @RequestMapping("/insert")
    public String toAdd(){
        return "/boss/add";
    }


    //添加员工
    ///add
    @RequestMapping("/add")
    public  String  add(Emp emp){

        empMapper.insert(emp);
        return "redirect:/emplist";
    }

    // update
    //跳转到修改页面
    @RequestMapping("/update/{id}")
    public  String toUpdate(@PathVariable("id") Integer id,Model model){
        Emp emp = empMapper.getById(id);
        model.addAttribute("empUp",emp);
        //System.out.println(emp);
        return "/boss/update";
    }


    //  upEmp
    //修改并且返回主页、
    @RequestMapping("/upEmp")
    public String  UpEmp(Emp emp){
        System.out.println(emp);
        empMapper.update(emp);
        return "redirect:/emplist";
    }

    //删除并且返回查询的 首页：
    //delete/id
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        empMapper.delete(id);
        return "redirect:/emplist";
    }

}
