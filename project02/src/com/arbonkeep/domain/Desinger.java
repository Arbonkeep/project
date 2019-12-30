package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 17:00
 * 设计师封装类(比程序员多了津贴)
 */
public class Desinger extends Programmer {
    private double bonus;

    public Desinger() {}

    public Desinger(double bonus) {
        this.bonus = bonus;
    }

    public Desinger(int id, String name, int age, double salary, Equipment equipment,
                    double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //此方法用于获取团队信息
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t设计师\t" + getBonus();
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + getBonus()
                + "\t\t" + getEquipment().getDescription();
    }
}
