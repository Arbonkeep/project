package com.arbonkeep.service;

import com.arbonkeep.domain.*;


/**
 * @author arbonkeep
 * @date 2020/1/8 - 9:45
 */
public class NameListService {
    private Employee[] employees;

    //构造方法
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //获取通用的属性
            int type =  Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment eq;//设备
            double bonus;//奖金
            int stock;//股票

            //使用switch进行判断
            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case Data.DESIGNER:
                    eq = createEquipment(i);
                    bonus =  Integer.parseInt(Data.EQIPMENTS[i][5]);
                    employees[i] = new Desinger(id, name, age, salary, eq, bonus);
                    break;
                case Data.ARCGITECT:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    //创建设备的方法
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        switch (type) {
            case Data.PC:
                return new PC(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
            case Data.NOTEBOOK:
                String price = Data.EQIPMENTS[index][2];
                return new NoteBook(Data.EQIPMENTS[index][1], price);
            case Data.PRINTER:
                return new Printer(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
        }
        return null;
    }

    //获取所有员工的方法
    public Employee[] getAllEmployees() {
        return employees;
    }

    //获取某个指定id的员工信息
    public Employee getEmployee(int  id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw  new TeamException("需要查询的员工不存在");
    }
}
