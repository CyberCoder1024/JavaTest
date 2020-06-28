package Generic;

/**
 * @ClassName GenericClassTest
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/22
 * Project JavaTest
 * @Version 1.0
 **/
public class GenericClassTest {
    public static void main(String[] args) {
        String[] words={"Mary","had","a","little","lamb"};
        Pair<String> mm=ArragAlg.minma(words);
        System.out.println("min="+mm.getFirst());
        System.out.println("max="+mm.getSecond());

    }
}

/**
 * 泛型类
 * @param <T>
 */
class Pair<T>{
    private T first;
    private T second;
    public Pair(){
        first=null;
        second=null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
class ArragAlg{
    public static Pair<String> minma(String[] a){
        if (a==null || a.length==0)
            return null;
        String min=a[0];
        String max=a[0];
        for (int i = 0; i <a.length ; i++) {
            if (min.compareTo(a[i])>0) min=a[i];
            if (max.compareTo(a[i])<0) max=a[i];

        }
        return new Pair<>(min,max);
    }

    /**
     * 泛型方法
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMid(T[] a){
        return a[a.length/2];
    }
}
