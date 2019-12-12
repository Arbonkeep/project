package com.arbonkeep.service;

import com.arbonkeep.bean.Customer;
import com.arbonkeep.dao.CustomerList;
import com.arbonkeep.utils.CMUtility;
import com.sun.org.apache.bcel.internal.generic.IFGE;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/12 - 21:01
 * 本类是实际的业务操作
 */
public class CustomerView {
    private CustomerList customers = new CustomerList();

    /**
     * 构造方法，初始化一个数据
     */
    public CustomerView() {
        Customer customer = new Customer("张三", '男', 25, "110",
                "110@qq.com");
        customers.addCustomer(customer);

    }

    /**
     * 此方法是初始化页面方法
     */
    public void enterMainMenu() {
        boolean flag = true;
        do {
            System.out.println("\n------------------信息管理软件-----------------\n");
            System.out.println("                    1 添加用户");
            System.out.println("                    2 修改用户");
            System.out.println("                    3 删除用户");
            System.out.println("                    4 用户列表");
            System.out.println("                    5 退出\n");
            System.out.println("                    请选择1-5：");

            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char c = CMUtility.readConfirmSelection();
                    if (c =='Y') {
                        flag = false;
                    }
                    break;
            }
        } while (flag);
    }

    //查询所有用户
    private void listAllCustomer() {
        System.out.println("------------------客户列表-----------------");
        List<Customer> customers = this.customers.getAllCustomer();
        if (customers.size() == 0) {
            System.out.println("没有客户记录");
        }else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

        System.out.println("------------------查询列表成功------------------");

    }

    //删除用户
    private void deleteCustomer() {
        System.out.println("-----------------删除用户------------------");

        int index = 0;
        Customer customer = null;
        while (true) {
            System.out.println("请选择需要删除用户的编号：");
            index = CMUtility.readInt();//从键盘读取一个编号

            if (index == -1) {
                return;
            }

            customer = customers.getCustomer(index -1);
            if (customer == null){
                System.out.println("无法找到指定用户");
            }else {
                break;
            }
        }

        System.out.println("确认是否删除(Y/N):");
        char c = CMUtility.readConfirmSelection();//调用工具类确认是否删除
        if (c == 'N') {
            return;
        }

        customers.deleteCustomer(index - 1);//减一是因为list索引从0开始

        boolean flag = true;
        if (flag) {
            System.out.println("-----------------删除完成---------------");
        }else {
            System.out.println("----------------删除失败，无法找到指定用户------------------");
        }

    }

    //修改用户
    private void modifyCustomer() {

        System.out.println("-----------------修改用户------------------");

        int index = 0;
        boolean flag = true;
        Customer customer = null;
        while (true) {
            System.out.println("请输入需要修改的用户编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }

            customer = customers.getCustomer(index -1);
            if (customer == null) {
                System.out.println("无法找到对应的用户");
            }else {
                break;
            }
        }

        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(4,customer.getName());
        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(15, customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(15,customer.getEmail());

        customer = new Customer(name, gender, age, phone, email);

        customers.modifyCustomer(index -1 , customer);

        if (flag) {
            System.out.println("----------------修改完成----------------");
        }else {
            System.out.println("-----------------删除失败,无法找到指定客户---------------");
        }


    }

    //添加用户
    private void addNewCustomer() {
        System.out.println("------------------添加用户-----------------");

        //分别从键盘商上获取到每一个属性
        System.out.println("姓名：");
        String name = CMUtility.readString(4);//姓名只需要读取一行中的4个
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String phone = CMUtility.readString(15);
        System.out.println("邮箱：");
        String email = CMUtility.readString(15);

        //构造出对应的对象
        Customer customer = new Customer(name, gender, age, phone, email);
        //将对象添加进集合中
        customers.addCustomer(customer);

        System.out.println("-----------------增加新用户成功------------------");
    }


}
