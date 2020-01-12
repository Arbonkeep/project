package com.arbonkeep.view;

import java.util.Scanner;

/**
 * @author arbonkeep
 * @date 2019/12/30 - 16:20
 * 用于键盘录入的工具类
 */
public class TSUtility {
    //声明键盘录入对象
    private static Scanner sc = new Scanner(System.in);

    //读取键盘输入的方法
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

    //读取菜单选项的方法
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    //读取返回的方法
    public static void  readReturn() {
        System.out.println("请按回车键继续。。。");
        readKeyBoard(100, true);
    }

    //读取int类型数的方法
    public static int readInt() {
        int n;
        while (true) {
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入有误，请重新输入:");
            }
        }
        return n;
    }

    //确认是与否的方法
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            }else {
                System.out.println("输入有误");
            }
        }

        return c;
    }

}
