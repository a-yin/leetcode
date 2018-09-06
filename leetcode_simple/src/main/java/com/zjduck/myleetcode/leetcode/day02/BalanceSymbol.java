package com.zjduck.myleetcode.leetcode.day02;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈的应用01：平衡符号
 *
 * Created by lingb on 2018/9/5
 */
public class BalanceSymbol {

    public static void main(String[] args) {

        if (isBalanceSymbol()) {
            System.out.println("Balance!");
            return;
        }

        System.out.println("Imbalance!");
    }


    /**
     * 算法描述如下：
     * 1、new 一个空栈，读入字符直到文件结尾。
     * 2、循环扫描每个字符：
     *      1）若字符是一个开放符号（即类似于 '[' '{' '(' ...），则将其压栈。
     *      2）若字符是一个封闭符号（即类似于 ']' '}' ')' ...），此时判断栈是否为空，若栈为空则报错。否则，将栈顶字符出栈。判断出栈的字符是否为一对符号，若不是对应的开放字符，则报错。
     * 3、扫描结束后（即最后当字符文件结尾），判断栈是否为空，若栈非空（即栈还存储开放符号）则报错。
     *
     */
    public static boolean isBalanceSymbol() {
        Stack<Character> stack = new Stack<>();

        // 这里用控制台输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch;

        // 扫描字符串中每个字符
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (isOpenSymbol(ch)) {
                stack.push(ch);

            } else if (isCloseSymbol(ch)) {
                if (stack.empty()) {
                    sc.close();
                    return false;

                } else {
                    if (!isTwinSymbol(stack.peek(), ch)) {
                        sc.close();
                        return false;
                    }

                    stack.pop();
                }

            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;

    }


    /**
     * 判断是否为开放符号
     *
     * @param ch
     * @return
     */
    public static boolean isOpenSymbol(char ch) {
//        String symbolList = "[{(";
//        if (symbolList.contains(String.valueOf(ch))) {
//            return true;
//
//        }

        // 等价于上面
        if (ch == '[' || ch == '{' || ch == '(') {
            return true;
        }

        return false;
    }

    /**
     * 判断是否为封闭符号
     *
     * @param ch
     * @return
     */
    public static boolean isCloseSymbol(char ch) {
//        String symbolList = "]})";
//        if (symbolList.contains(String.valueOf(ch))) {
//            return true;
//
//        }

        // 等价于上面
        if (ch == ']' || ch == '}' || ch == ')') {
            return true;
        }

        return false;
    }

    /**
     * 判断是否为一对符号
     *
     * @param openSymbol
     * @param closeSymbol
     * @return
     */
    public static boolean isTwinSymbol(char openSymbol, char closeSymbol) {
        if (openSymbol == '[' && closeSymbol == ']') {
            return true;

        } else if (openSymbol == '{' && closeSymbol == '}') {
            return true;

        } else if (openSymbol == '(' && closeSymbol == ')') {

            return true;
        }

        return false;
    }

}
