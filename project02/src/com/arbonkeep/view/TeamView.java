package com.arbonkeep.view;

import com.arbonkeep.domain.Employee;
import com.arbonkeep.domain.Programmer;
import com.arbonkeep.service.NameListService;
import com.arbonkeep.service.TeamException;
import com.arbonkeep.service.TeamService;
;

/**
 * @author arbonkeep
 * @date 2020/1/12 - 13:05
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //键盘录入方法
    public void enterMainMenu() {
        boolean loopFlag = true;
        char key = 0;
        do {
            if (key != '1' ) {
                listAllEmployees();
            }
            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("请问是否选择退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        } while (loopFlag);

    }

    //显示所有员工的方法
    private void listAllEmployees() {
        System.out.println("\n----------------------开发人员调度程序------------------------\n");
        Employee[] emps = listSvc.getAllEmployees();
        if (emps.length == 0) {
            System.out.println("没有成员记录");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        }

        for (Employee emp : emps) {
            System.out.println(" " + emp);
        }

        System.out.println("---------------------------------------------------");
    }

    //显示开发团队成员列表
    private void listTeam() {
        System.out.println("\n-----------------------团队成员列表---------------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("开发团队还没有成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        }

        for (Programmer programmer : team) {
            System.out.println(" " + programmer.getDetailsForTeam());
        }

        System.out.println("------------------------------------------------------");
    }

    //添加成员到团队的方法
    private void addMember() {
        System.out.println("-----------------------添加成员--------------------------");
        System.out.println("请输入成员ID：");
        int id = TSUtility.readInt();

        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        //调用按回车键继续
        TSUtility.readReturn();
    }

    //从团对中删除指定的id成员
    private void deleteMember() {
        System.out.println("------------------------删除成员---------------------------");
        System.out.println("请输入需要删除成员的id：");
        int id = TSUtility.readInt();
        System.out.println("请问是否删除(Y/N):");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N') {
            return;
        }

        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因是:" + e.getMessage());
        }
        //添加按回车键继续
        TSUtility.readReturn();
    }

    //程序的主方法
    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}
