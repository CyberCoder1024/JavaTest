package Generic;

/**
 * @ClassName PairTest
 * @Description
 * @Author jonas.ao
 * @Date 2020/6/22
 * Project JavaTest
 * @Version 1.0
 **/
public class PairTest {
    public static void main(String[] args) {


    }
    public static void printBuddies(Pair<?extends Employee> pair){

    }
}
class PairAlg{
    public static boolean hasNull(Pair<?> pair){
        return pair.getFirst()==null || pair.getSecond()==null;
    }

    public static void swap(Pair<?> pair){
        swapHelper(pair);
    }
    public static <T> void swapHelper(Pair<T> pair){
        T first = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(first);
    }
}
class Employee{

}
