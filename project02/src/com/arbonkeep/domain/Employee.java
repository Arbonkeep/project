package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:36
 * 基本员工类
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //描述员工信息的方法
    protected  String getDetails() {
        return id + "\t" + name + "\t" + age +"\t" + salary;
    }

    //重写toString
    @Override
    public String toString() {
        return getDetails();//调用上述方法
    }
}
