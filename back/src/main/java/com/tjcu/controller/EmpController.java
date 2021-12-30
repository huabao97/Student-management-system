package com.tjcu.controller;

import com.tjcu.entity.Emp;
import com.tjcu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 花豹
 * @date 2021/12/17 15:52
 * @Description:
 */
@RestController
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/emp/queryAll")
    public  List<Emp> queryall(){
        List<Emp> emps = empService.showEmp();
        return emps;
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("/emp/delete")
    public void delete(Integer id){
        empService.deleteById(id);
    }

    /**
     * 添加
     * @param emp
     */
    @RequestMapping("/emp/add")
    public void add(@RequestBody Emp emp){
        if(emp.getId()!=null){
            empService.updateEmp(emp);
        }else {
            emp.setId(null);
            empService.insertEmp(emp);
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping("/emp/queryOne")
    public Emp query(Integer id){
        Emp emp = empService.selectEmpById(id);
        return emp;
    }
}
