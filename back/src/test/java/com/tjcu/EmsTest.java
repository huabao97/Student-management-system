package com.tjcu;

import com.tjcu.entity.Emp;
import com.tjcu.service.EmpService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 花豹
 * @date 2021/12/17 15:03
 * @Description:
 */

public class EmsTest extends ParentTest{
    @Autowired
    public EmpService empService;
@Test
  public void test(){
      List<Emp> emps = empService.showEmp();
      for (Emp emp : emps) {
          System.out.println(emp);
      }
  }
    @Test
    public void test2(){
        Emp emp = new Emp(null,"王小黑",80000d,21);
        empService.insertEmp(emp);
    }

    @Test
    public void test3(){
        Emp emp = empService.selectEmpById(2);
        System.out.println(emp);
    }
}
