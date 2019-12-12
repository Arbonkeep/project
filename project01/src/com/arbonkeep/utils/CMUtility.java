package com.arbonkeep.utils;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.Scanner;

/**
 * @author arbonkeep
 * @date 2019/12/12 - 19:08
 * 将相关方法声明成方法，可以直接调用方法实现功能
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 本方法用于选择执行增删改查中的哪个方法，如果用户键入’1’-’5’中的任意字符，则方法返回。
     * 返回值为用户键入字符
     * @return
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("输入出错，请重新输入:");
            }else {
                break;
            }
        }

        return c;
    }

    /**
     * 从键盘获取一个字符并返回
     * @return
     */
    public static char readChar() {
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。上述方法的重写
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     * @param defaultValue
     * @return
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return str.length() == 0 ? defaultValue :str.charAt(0);
    }

    /**
     * 从键盘读取一个长度不为2的整数，并返回
     * @return
     */
    public static int readInt() {
        int n;

        while (true) {
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (RuntimeException e) {
                System.out.println("数字输入有误，请重新输入");
            }
        }
        return n;
    }

    /**
     * 上述方法的重写
     * 如果用户直接输入回车，那么就将defaultValue返回
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int num;
        while (true) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                num = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e) {
                System.out.println("数字输入出错，请重新输入");
            }
        }
        return num;
    }

    /**
     * 从键盘读取一个长度为limit的字符串
     * @param limit
     * @return
     */
    public static String readString(int limit) {
        String str = readKeyBoard(limit,false);
        return str;
    }

    /**
     * 上述方法的重写，如果输入了回车键，就返回defaultValue
     * @param limit
     * @param defaultValue
     * @return
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 用于确认是否输入该内容的方法，取值为y或n
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            }else {
                System.out.println("选择出错，请重新选择：");
            }
        }
        return c;
    }

    /**
     * 此方法用于读取键盘录入的数据
     * @param limit
     * @param blankReturn
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String str = "";

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            if (str.length() == 0) {
                if (blankReturn) {
                    return str;
                }else {
                 continue;
                }
            }
            if (str.length()< 1 || str.length() >limit) {
                System.out.println("输出大小（不大于" + limit + "）请重新输入：");
                continue;
            }
            break;
        }
        return str;
    }


}
