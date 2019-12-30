package com.arbonkeep.domain;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:33
 */
public class NoteBook implements Equipment {
    private String model;//笔记本型号
    private String price;//笔记本价格

    public NoteBook() {
    }

    public NoteBook(String model, String price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //描述笔记本的方法
    @Override
    public String getDescription() {
        return model + "(" + price + ")" ;
    }
}
