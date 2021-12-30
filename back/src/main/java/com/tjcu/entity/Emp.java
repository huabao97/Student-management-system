package com.tjcu.entity;

import java.io.Serializable;

/**
 * @author 花豹
 * @date 2021/12/17 14:42
 * @Description:
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;

    public Emp() {
    }

    public Emp(Integer id, String name, Double salary, Integer age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
