package com.arbonkeep.domain;

import com.arbonkeep.service.Status;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:40
 * 程序员信息封装类
 */
public class Programmer extends Employee{
    private int memberId;//表示程序员的id(11)
    private Status status = Status.FREE;//表示程序员的状态
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary,
                       Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    //此方法获取代表程序员id以及父类employee详细描述
    public String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
    }
}
