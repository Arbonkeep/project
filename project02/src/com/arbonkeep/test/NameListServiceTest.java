package com.arbonkeep.test;

import com.arbonkeep.domain.Employee;
import com.arbonkeep.service.NameListService;
import com.arbonkeep.service.TeamException;
import org.junit.Test;

/**
 * @author arbonkeep
 * @date 2020/1/8 - 10:43
 * 测试获取员工的类
 */
public class NameListServiceTest {
    //测试获取所有员工
    @Test
    public void test() {
        NameListService service = new NameListService();

        Employee[] employees = service.getAllEmployees();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    
    //测试查询一个员工
    @Test
    public void test2() {
        int id = 1;
        NameListService service = new NameListService();
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
