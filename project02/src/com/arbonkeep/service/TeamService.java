package com.arbonkeep.service;

import com.arbonkeep.domain.Employee;
import com.arbonkeep.domain.Programmer;

/**
 * @author arbonkeep
 * @date 2020/1/8 - 10:51
 * 团队信息类
 */
public class TeamService {
    private static final int counter = 1;//生成团队成员的id
    private final int MAX_MEMBER = 5;//团队的上限人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存当前团队成员
    private int total = 0;//团队的实际人数

    public TeamService() {

    }

    //所有程序员构成的数组
    public Programmer[] getTeam() {
        Programmer[] programmer = new Programmer[total];

        for (int i = 0; i < total; i ++) {
            programmer[i] = this.team[i];
        }
        return team;
    }

    //检验是否存在该员工的方法
    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
           if (team[i].getId() == p.getId()) return true;
        }

        return false;
    }

    //增加员工
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法继续增加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("成员不是程序员们，无法添加");
        }

        Programmer p = (Programmer) e;//将传入的员工转换为程序员

        if (isExist(p)) {
            throw new TeamException("该成员已经存在，无法再次添加");
        }
        if (p.getStatus().getNAME().equals("BUSY")) {
            throw new TeamException("该成员已经是其他团队的成员，无法添加")
        }else if (p.getStatus().getNAME().equals("VOCATION")) {
            throw new TeamException("该员工在休假，添加失败");
        }

        int numOfArch = 0;//架构师
        int numOfPro = 0;//程序员
        int numOfDes = 0;//设计师


    }

}
