package IO;

/**
 * @ClassName digui
 * @Description TODO 递归的本质是方法的调用
 * @Author jonas.ao
 * @Date 2019/12/17 20：13
 * Project JavaTest
 * @Version 1.0
 **/
public class digui {
    public static void main(String[] args) {
        digui dg = new digui();
        dg.buildTower1(5);
    }
    //盖宝塔--循环
    public void buildTower(int floor){
        for (int i=1;i<=floor;i++){
            System.out.println("盖到第"+floor+"层宝塔");
        }
    }
    //递归的思想
        //想让我盖到第五层：我要求让别人把之前的事前做完
        //1、等待别人做事 2、我自己做事；调用顺序 和执行顺序相反
    public void buildTower1(int floor){
        //判断当前floor是否位1 若不是找一个别人先盖到之前层
        if (floor>1){
            this.buildTower1(floor-1);
        }
        System.out.println("盖到第"+floor+"层宝塔啦");

    }
}
