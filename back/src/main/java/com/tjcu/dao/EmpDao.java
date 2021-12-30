package com.tjcu.dao;

import com.tjcu.entity.Emp;

import java.util.List;

/**
 * @author 花豹
 */
public interface EmpDao {
    /**
     *  增
     * @param emp
     */
     void insertEmp(Emp emp);

    /**
     * 删除
     *
     * @param id
     */
     void deleteById(Integer id);

    /**
     * 查所有
     * @return
     */
     List<Emp> showEmp();

    /**
     *更新
     * @param emp
     */
     void updateEmp(Emp emp);

    /**
     * 数据回显
     * @param id
     * @return
     */
     Emp selectEmpById(Integer id);
}
