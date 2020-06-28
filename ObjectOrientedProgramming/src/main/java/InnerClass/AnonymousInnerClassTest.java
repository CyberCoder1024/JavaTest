package InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @ClassName AnonymousInnerClassTest
 * @Description 匿名内部类
 * @Author jonas.ao
 * @Date 2020/6/21
 * Project JavaTest
 * @Version 1.0
 **/
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock1 talkingClock1 = new TalkingClock1();
        talkingClock1.start(1000,true );

        JOptionPane.showMessageDialog(null,"Quit program?" );
        System.exit(0);
    }
}
/**
 *@ClassName: TalkingClock
 *@Description: 抽象出TalingClock 类
 *@Author: AoDingKun
 *@Date :2020/6/21 15:38
 *Project : InnerrClassTest.java
 */
class TalkingClock1 {

    public void start(int interval, final boolean beep){
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tine,the times is"+new Date());
                if (beep)//beep引用了创建TimPrinter的TalkingClock对象的域
                    Toolkit.getDefaultToolkit().beep();
            }

        };
       Timer timer = new Timer(interval,actionListener);
        timer.start();

    }
}
