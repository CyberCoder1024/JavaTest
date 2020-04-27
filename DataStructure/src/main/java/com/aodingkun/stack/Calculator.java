package com.aodingkun.stack;

public class Calculator {

	public static void main(String[] args) {
		//表达式
		String expression = "7*2*2-5+1-5+3-4"; // 15// 多位数处理？
		//创建两个栈
		ArrayStack2 numStack = new ArrayStack2(10);//数栈
		ArrayStack2 operStack = new ArrayStack2(10);//符号栈
		//定义相关的遍历
		int index = 0;//用于扫描
		int num1 = 0; 
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' '; //将每次扫描得到的char保存至ch
		String keepNum = ""; //
		//用while循环扫描表达式expression
		while(true) {
			//一次得到expression的每个字符
			ch = expression.substring(index, index+1).charAt(0);
			//判断ch
			if(operStack.isOper(ch)) {//
				//不为空
				if(!operStack.isEmpty()) {
					//如果当前优先级小于或等于栈中的操作符 就需要从数栈中pop出两个数
					//再从符号栈中pop出一个符号 进行运算 得到结果 入数栈 然后将当前操作符入符号栈
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//把运算结果入数栈
						numStack.push(res);
						//把当前操作符入符号栈
						operStack.push(ch);
					} else {
						//直接入符号栈
						operStack.push(ch);
					}
				}else {
					//如果为空直接入符号栈
					operStack.push(ch); // 1 + 3
				}
			} else { //如果为数 直接入数栈
				
				//numStack.push(ch - 48); //? "1+3" '1' => 1
				//1.当处理多位数时，不能发现是一个数就立即入栈 因为可能为多位数
				//2.在处理数的适合 需要向expression 的表达式的index 后再看衣卫 如果是数继续扫描 如果为符号才入栈
				//3.定义一个字符串变量 用于拼接
				//多位数处理
				keepNum += ch;

				//index+1 判断是否扫描到表达式的最后
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				}else{
				
					////判断下一个字符是不是数字 如果是数字 就继续扫描 如果是运算符 则入栈
					//注意看后一位 不是index++
					if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//如果后一位是运算符 则入栈 keepNum
						numStack.push(Integer.parseInt(keepNum));
						//清空KeepNum
						keepNum = "";
					}
				}
			}
			//
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		//当表达式扫描完毕 就顺序从 数栈 和符号栈 pop 出相应的符号 并运行
		while(true) {
			//
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			//入栈
			numStack.push(res);
		}
		//将数栈中最后的结果出栈
		int res2 = numStack.pop();
		System.out.printf("表达式 %s = %d", expression, res2);
	}

}

//
class ArrayStack2 {
	private int maxSize; // 栈大小
	private int[] stack; // 数组 模拟栈
	private int top = -1;// 栈顶 -1为出书化
	
	/**
	 * @Description : 功能说明
	 * @MethodName ArrayStack2
	 * @Description:
	 * @param maxSize
	 * @Return :
	 * @Author : AoDingKun
	 * @Date : 2020/4/16 15:37
	*/

	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//
	public int peek() {
		return stack[top];
	}
	
	//
	public boolean isFull() {
		return top == maxSize - 1;
	}
	//
	public boolean isEmpty() {
		return top == -1;
	}
	//
	public void push(int value) {
		//
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	//
	public int pop() {
		//
		if(isEmpty()) {
			//
			throw new RuntimeException("ջ�գ�û������~");
		}
		int value = stack[top];
		top--;
		return value;
	}
	/**
	 * @Description : 功能说明 显示栈的情况
	 * @MethodName list
	 * @Description: 遍历时 需要从栈顶开始显示数据
	 * @Return : void
	 * @Author : AoDingKun
	 * @Date : 2020/4/16 15:33
	*/
	public void list() {
		if(isEmpty()) {
			System.out.println("~~");
			return;
		}
		//从栈顶开始显示数据
		for(int i = top; i >= 0 ; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	/**
	 * @Description : 功能说明 返回优先级
	 * @MethodName priority
	 * @Description:优先级由程序来确定 优先级使用数字表示 数字越大 优先级越高
	 * @param oper
	 * @Return : int
	 * @Author : AoDingKun
	 * @Date : 2020/4/16 15:33
	*/

	public int priority(int oper) {
		if(oper == '*' || oper == '/'){
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 目前的表达式只有 +-*/
		}
	}
	/**
	 * @Description : 功能说明 判断是不是一个运算符
	 * @MethodName isOper
	 * @Description:
	 * @param val
	 * @Return : boolean
	 * @Author : AoDingKun
	 * @Date : 2020/4/16 15:33
	*/

	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	/**
	 * @Description : 功能说明 计算方法
	 * @MethodName cal
	 * @Description:
	 * @param num1
	 * @param num2
	 * @param oper
	 * @Return : int
	 * @Author : AoDingKun
	 * @Date : 2020/4/16 15:34
	*/

	public int cal(int num1, int num2, int oper) {
		int res = 0; // res result存放计算的结果
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;//
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}
