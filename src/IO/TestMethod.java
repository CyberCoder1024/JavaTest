package IO;

/**
 * @ClassName TestMethod
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/17 20:19
 * Project JavaTest
 * @Version 1.0
 **/
public class TestMethod {
    public static void main(String[] args) {
        //加载类的过程
        TestMethod tm = new TestMethod();
        tm.testOne();
        //test 3-2-1
    }

    private void testOne() {
        this.testTwo();
        System.out.println("我是testOne");
    }

    private void testTwo() {
        this.testThree();
        System.out.println("我是testTwo");
    }

    private void testThree() {
        System.out.println("我是testThree");
    }
}
