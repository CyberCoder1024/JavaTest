package com.aodingkun;

/**
 * @ClassName Test
 * @Description
 * @Author jonas.ao
 * @Date 2020/4/24
 * Project JavaTest
 * @Version 1.0
 **/
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(new B().getValue());
//    }
//    static class A {
//        protected int value;
//        public A (int v) {
//            setValue(v);
//        }
//        public void setValue(int value) {
//            this.value= value;
//        }
//        public int getValue() {
//            try {
//                value ++;
//                return value;
//            } finally {
//                this.setValue(value);
//                System.out.println(value);
//            }
//        }
//    }
//    static class B extends A {
//        public B () {
//            super(5);
//            setValue(getValue()- 3);
//        }
//        public void setValue(int value) {
//            super.setValue(2 * value);
//        }
//    }
//}
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }
}

class Value {
    public int i = 15;
}