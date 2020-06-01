package Method;

/**
 * @ClassName diaoyong
 * @Description TODO 方法定义与调用格式
 * @Author jonas.ao
 * @Date 2020/2/7
 * Project JavaTest
 * @Version 1.0
 **/
/*
 * 定义格式
 * public static void 方法名称(){
 *       方法体
 *  }
 *
 *  调用格式
 *       方法名称();
 *
 * 方法定义注意：
 *   1、方法定义先后顺序无所谓
 *   2、方法定义必须紧挨着们不能再一个方法的内部定义另外一个方法
 *   3、方法定义之后，子集不会执行；如果希望执行，一定要进行方法的调用
 * */
public class diaoyong {
    public static void main(String[] args) {
        printMethod();
    }

    public static void printMethod() {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
