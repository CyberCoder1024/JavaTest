package InnerClass;

/**
 * @ClassName StaticInnerClassTest
 * @Description 静态内部类
 * @Author jonas.ao
 * @Date 2020/6/21
 * Project JavaTest
 * @Version 1.0
 **/
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[]  d= new double[20];
        for (int i = 0; i <d.length ; i++) {
            d[i]=100*Math.random();
            ArrayAlg.Pair p = (ArrayAlg.Pair) ArrayAlg.minmax(d);
            System.out.println("min="+p.getFirst());
            System.out.println("max="+p.getSecond());

        }
    }
}

/**
 *
 */
class ArrayAlg{
    /**
     * 静态内部类
     * 计算数组中的最小值和最大值
     */
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public void setFirst(double first) {
            this.first = first;
        }

        public double getSecond() {
            return second;
        }

        public void setSecond(double second) {
            this.second = second;
        }

    }
    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v:values){
            if (min>v){
                min=v;
            }
            if (max<=v){
                max=v;
            }
        }
        return new Pair(min, max);
    }
}