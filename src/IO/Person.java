package IO;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/20 14:28
 * Project JavaTest
 * @Version 1.0
 **/
//示意性接口
public class Person implements Serializable {
    //序列号
    private long serialVersionUID=-440948515215806088L;
    private String name;
    private int age;
    //构造方法
    public Person(){

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println(this.name+"的吃饭方法");
    }
}
