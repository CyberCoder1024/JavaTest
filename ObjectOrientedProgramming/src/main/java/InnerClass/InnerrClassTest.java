package InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @ClassName InnerrClassTest
 * @Description 使用内部类访问对象的状态
 * @Author jonas.ao
 * @Date 2020/6/21
 * Project JavaTest
 * @Version 1.0
 **/
public class InnerrClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();

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
class TalkingClock {
    //发布通告的间隔
    private int interval;
    //开关铃声的标志
    private boolean beep;

                        /**
                         * 构造函数 构造语音闹钟需要的两个参数
                         * @param interval
                         * @param beep
                         */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }
    public void start(){
//        /**
//         *@ClassName: TalkingClock
//         *@Description:
//         *@Author: AoDingKun
//         *@Date :2020/6/21 15:51
//         *Project : InnerrClassTest.java
//         */
//        class TimPrinrer implements ActionListener{
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("At the tine,the times is"+new Date());
//                if (beep)//beep引用了创建TimPrinter的TalkingClock对象的域
//                    Toolkit.getDefaultToolkit().beep();
//            }
//        }
//
        ActionListener timPrinrer = new TimPrinrer();
        Timer timer = new Timer(interval,timPrinrer);
        timer.start();

    }
    /**
     *@ClassName: TalkingClock
     *@Description: TimPrinrer 位于语音闹钟类内部
     *@Author: AoDingKun
     *@Date :2020/6/21 15:38
     *Project : InnerrClassTest.java
     */
    public class TimPrinrer implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tine,the times is"+new Date());
            if (beep)//beep引用了创建TimPrinter的TalkingClock对象的域
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
