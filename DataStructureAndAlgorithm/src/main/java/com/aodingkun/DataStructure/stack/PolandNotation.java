package com.aodingkun.DataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {


        String expression = "1+((2+3)*4)-5";//先定义表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("��׺���ʽ��Ӧ��List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("��׺���ʽ��Ӧ��List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,�C]

        System.out.printf("expression=%d", calculate(suffixExpreesionList)); // ?


    }


    //
    public static List<String> parseSuffixExpreesionList(List<String> ls) {

        Stack<String> s1 = new Stack<String>(); //

        //Stack<String> s2 = new Stack<String>(); //
        List<String> s2 = new ArrayList<String>(); //

        //
        for (String item : ls) {
            //
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//!!!
            } else {
                //
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //
                s1.push(item);
            }
        }

        //
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;

    }


    // 将一个逆波兰表达式 一次将数据和元素安抚放入到ArrayList中
    public static List<String> toInfixExpressionList(String s) {
        //
        List<String> ls = new ArrayList<String>();
        int i = 0; //
        String str; //
        char c; //
        do {
            //
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //
            } else { //
                str = ""; //
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;//
    }

    //
    public static List<String> getListString(String suffixExpression) {
        //
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;

    }

    /**
     * 完成对逆波兰表达式的运算
     * 1.从左到右扫描 将3 4 压入堆栈
     * 2.运到+ 操作符，因此弹出4和3 （4为栈顶元素，3为次顶元素）计算3+4的值 将计算结果压入堆栈
     * 3. 将5 入栈
     * 4. 接下来  x 运算符 因此弹出5 和7 计算结果压入栈
     * 6. 将6 入栈
     * 6.最好- 运算符 计算出35-6 的值
     * @param ls
     * @return
     */

    public static int calculate(List<String> ls) {
        //创建一个栈
        Stack<String> stack = new Stack<String>();
        //遍历list
        for (String item : ls) {
            //使用正则表达式 取出数
            if (item.matches("\\d+")) { //匹配多位数
                // 入栈
                stack.push(item);
            } else {
                // pop 两个数并运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有错误");
                }
                //把res入栈
                stack.push("" + res);
            }

        }
        //最好留在stack的数据为结果
        return Integer.parseInt(stack.pop());
    }

}

//
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("" + operation);
                break;
        }
        return result;
    }

}
