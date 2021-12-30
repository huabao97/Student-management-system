package com.tjcu.service.impl;

import com.tjcu.dao.EmpDao;
import com.tjcu.entity.Emp;
import com.tjcu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 花豹
 * @date 2021/12/17 14:53
 * @Description:
 */
//抑制所有警告
@SuppressWarnings("all")
//服务层
@Service
//除了查询事务
@Transactional(propagation = Propagation.REQUIRED)//隔离级别为required
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public void insertEmp(Emp emp) {
        empDao.insertEmp(emp);
    }

    @Override
    public void deleteById(Integer id) {
        empDao.deleteById(id);
    }

    @Override
    //查询事务为supports
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> showEmp() {
        return empDao.showEmp();
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    //查询事务为supports
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp selectEmpById(Integer id) {
        return empDao.selectEmpById(id);
    }
}
