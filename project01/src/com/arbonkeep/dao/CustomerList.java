package com.arbonkeep.dao;

import com.arbonkeep.bean.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/12 - 19:58
 *本类使用数组模拟数据库存储数据
 */
public class CustomerList {
    private List<Customer> customers;//声明一个集合用于存储数据
    private int total;

    /**
     * 声明构造方法，初始化集合
     */
    public CustomerList() {
        customers = new ArrayList<>();
    }

    /**
     * 增加用户
     * @param customer
     * @return
     */
    public List<Customer> addCustomer(Customer customer) {
        customers.add(customer);
        return customers;
    }

    /**
     * 删除用户
     * @param index
     * @return
     */
    public List<Customer> deleteCustomer(int index ) {
        customers.remove(index);

        return customers;
    }

    /**
     * 修改用户
     * @param customer
     * @return
     */
    public List<Customer> modifyCustomer(int index, Customer customer) {
        customers.set(index, customer);
        return customers;
    }

    /**
     * 获取所有用户
     */
    public List<Customer> getAllCustomer() {
        return customers;
    }

    /**
     * 获取用户个数
     * @return
     */
    public int getTotal() {
        return customers.size();
    }

    /**
     * 获取一个用户
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

}
