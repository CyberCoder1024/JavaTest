package Array;

/**
 * @ClassName SaveOddNumber
 * @Description TODO 1-100之间的偶数存入数据
 * @Author jonas.ao
 * @Date 2019/12/16 17：00
 * Project JavaTest
 * @Version 1.0
 **/
public class SaveOddNumber {
    public static void main(String[] args) {
        //1、创建需要的数组
        int[] odd=new int[50];
        //2、需要将1-100之间的偶数存入数组内
        for (int i=0;i<odd.length;i++){
            odd[i]=2*i+2;
        }
        //3、输出验证看一看
        for (int element:odd) {
            System.out.println(element);
            
        }
    }
}
