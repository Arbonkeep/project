package com.arbonkeep.service;

import com.arbonkeep.domain.*;
import static com.arbonkeep.service.Data.*;

/**
 * @author arbonkeep
 * @date 2020/1/8 - 9:45
 */
public class NameListService {
    private Employee[] employees;

    //构造方法
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            //获取通用的属性
            int type =  Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment eq;//设备
            double bonus;//奖金
            int stock;//股票

            //使用switch进行判断
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case DESIGNER:
                    eq = createEquipment(i);
                    bonus =  Integer.parseInt(EMPLOYEES[i][5]);
                    employees[i] = new Desinger(id, name, age, salary, eq, bonus);
                    break;
                case ARCHGITECT:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    //创建设备的方法
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(EQIPMENTS[index][0]);
        switch (type) {
            case PC:
                return new PC(Data.EQIPMENTS[index][1], EQIPMENTS[index][2]);
            case NOTEBOOK:
                String price = EQIPMENTS[index][2];
                return new NoteBook(EQIPMENTS[index][1], price);
            case PRINTER:
                return new Printer(EQIPMENTS[index][1], EQIPMENTS[index][2]);
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
