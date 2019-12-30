package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 17:11
 * 架构师类
 */
public class Architect extends Desinger {
    private int stock;

    public Architect() {}

    public Architect(int stock) {
        this.stock = stock;
    }

    public Architect(double bonus, int stock) {
        super(bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary,
                     Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }

    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t"
                + getStock() + "\t" + getEquipment().getDescription();
    }
}
