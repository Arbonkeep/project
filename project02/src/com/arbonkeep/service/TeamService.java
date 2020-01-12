package com.arbonkeep.service;

import com.arbonkeep.domain.Architect;
import com.arbonkeep.domain.Desinger;
import com.arbonkeep.domain.Employee;
import com.arbonkeep.domain.Programmer;

/**
 * @author arbonkeep
 * @date 2020/1/8 - 10:51
 * 团队信息类
 */
public class TeamService {
    private static int counter = 1;//生成团队成员的id
    private final int MAX_MEMBER = 5;//团队的上限人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存当前团队成员
    private int total = 0;//团队的实际人数

    public TeamService() {

    }

    //所有程序员构成的数组
    public Programmer[] getTeam() {
        Programmer[] team= new Programmer[total];

        for (int i = 0; i < total; i ++) {
            team[i] = this.team[i];
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
            throw new TeamException("该成员已经是其他团队的成员，无法添加");
        }else if (p.getStatus().getNAME().equals("VOCATION")) {
            throw new TeamException("该员工在休假，添加失败");
        }

        int numOfArch = 0;//架构师
        int numOfPro = 0;//程序员
        int numOfDes = 0;//设计师

        for (int i = 0; i < total; i ++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Desinger) numOfDes++;
            else if (team[i] instanceof Programmer) numOfPro++;
        }
        if (p instanceof  Architect) {
            if (numOfArch >= 1) throw new TeamException("团队中最多只能有一名构架师");
        } else if (p instanceof Desinger) {
            if (numOfDes >= 2) throw new TeamException("团队中最多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) throw new TeamException("团队中最多只能有3名程序员");
        }
        //添加到数组
        p.setStatus(Status.FREE);
        p.setMemberId(counter++);
        team[total++] = p;
    }

    //删除对应memberId的程序员
    public void removeMember(int memberId) throws TeamException {
        int n = 0;//for循环的n定义在外面，以供后面使用
        //找到指定的memberId的员工并删除
        for (; n < total; n++) {
            if (team[n].getMemberId() == memberId) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }
        //如果循环一次没找到，那么就报出有异常
        if (n == total) {
            throw new   TeamException("找不到该成员，无法删除");
        }

        //利用后面的元素覆盖前面的元素
        for (int i = n + 1; i < total; i ++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;

    }

}
