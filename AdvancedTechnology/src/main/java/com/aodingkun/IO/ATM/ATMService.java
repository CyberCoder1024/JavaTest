package com.aodingkun.IO.ATM;

import java.util.Scanner;

/**
 * @ClassName ATMService
 * @Description TODO 业务操作
 * @Author jonas.ao
 * @Date 2019/12/20 16:02
 * Project JavaTest
 * @Version 1.0
 **/
public class ATMService {
    //需要底层数据的支撑
    private ATMDao Dao=new ATMDao();//将原来的Dao转换成atmDao
   // private User user;
    public static void main(String[] args) {
        ATMService service = new ATMService();
        Scanner scanin = new Scanner(System.in);
        System.out.println("欢迎使用银行自主服务ATM系统\n请输入账号:");
        //输入账户
        String accountInput = scanin.nextLine();
        System.out.println("请输入密码：");
        String passwordInput=scanin.nextLine();
        //返回登录的String 的结果。
        String loginResult = service.login(accountInput, passwordInput);
        //输出登录的结果
        System.out.println(loginResult);
        if (loginResult.equals("登录成功")){
            System.out.println("请你选择操作项目");
            System.out.println("Please Chose your Option\nQuery 1\nDeposit 2\nWithdrawal 3\nTransfer 4\nInsert 5\n");
            String option=scanin.nextLine();
            switch (option){
                case "1":

                    Float queryBalance = service.query(accountInput);
                    System.out.println("你的余额为"+queryBalance);
                    break;
                case "2":
                    System.out.println("请输入您的存款额");
                    String depositInput=scanin.nextLine();
                    service.deposit(accountInput,Float.parseFloat(depositInput));
                    System.out.println("存款后您的余额为"+service.query(accountInput));
                case "5":
                    System.out.println("请输入你的创建新账号");
                    String accountNew=scanin.nextLine();
                    service.insertAccount(accountNew,passwordInput);
                    System.out.println("您的账户已创建");
            }
        }else{
            System.out.println("sorry");
        }

    }



    /*******************************{业务方法}************************************/
    //业务操作 判断 计算 比较 看不见任何数据的操作 从哪来到哪去 存哪儿
    /**
     * @Description: 登录
     * @Param:
     * @return:
     * @Date: 2019/12/20
     **/
    public String login(String account,String password){
       /* try{
            //创建输入流 读取真实文件的记录
            BufferedReader bfr = new BufferedReader(new FileReader("src\\com.aodingkun.IO\\ATMService\\Bank.txt"));
            String tem=bfr.readLine();
            while (tem !=null){
                String [] value=tem.split("-");//value是数组存储了一个人的信息
                if (value[0].equals(account)){
                    if (value[1].equals(password)){
                        return "登录成功";
                    }
                }
                tem=bfr.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "账户密码不匹配 登录失败";*/
       //TODO 改进
       // User user = userBox.get(account);
        User user = Dao.selectOne(account);
        if (user !=null && user.getPassword().equals(password)){
            return "登录成功";
        }else{
            return "用户名或者密码错误";
        }

    }
    /**
     * @Description: 查询
     * @Param:
     * @return:
     * @Date: 2019/12/20
     **/
    public Float query(String account){
        User user = Dao.selectOne(account);
       // User user = userBox.get(account);
        return user.getbalances();
       /* while (Dao.user !=null){
            System.out.println("您的余额为"+ Dao.user.getbalances()+"元");
        }
        return "查询到这位用户"+ Dao.user +"的账户"+account+"下的账户余额为"+balances;*/

    }
    /**
     * @Description: 存款
     * @Param:
     * @return:
     * @Date: 2019/12/20
     */
    public Float deposit(String account, Float depositMoney){
       // User user = userBox.get(account);
        User user = Dao.selectOne(account);
        //先将集合内的数据做修改 找到某一个user对象 对象中的balances属性修改
        user.setbalances(user.getbalances()+depositMoney);

        Dao.updateOne(user);
        //Dao.commit();//提交 将临时的数据写入文件 事务
        return depositMoney;
    }
    /**
     * @Description: 取款
     * @Param:
     * @return:
     * @Date: 2019/12/20
     */
    public void withdrawal(String account,Float withDrawalMoney){
        User user = Dao.selectOne(account);
        //业务判断 取款额度判断 如果大于 进行提醒
        if (user.getbalances()>=withDrawalMoney){
            user.setbalances(user.getbalances()-withDrawalMoney);
            Dao.updateOne(user);
          //  Dao.commit();
        }else{
            System.out.println("您账户"+account+"余额"+user.getbalances()+"您的取款额度得小于您的余额");
        }
    }
    /**
     * @Description: 转账
     * @Param:转出账户 outAccount 转出额 ，自己的account
     * @return:
     * @Date: 2019/12/20
     */
    public void transfer(String outAccount,String inAccount,Float transferMoney){
        //转出 转入账户查询
        User outUser = Dao.selectOne(outAccount);
        User inUser = Dao.selectOne(inAccount);
        //转出额小于转出的账户余额才能进行转账
        if (outUser.getbalances()>=transferMoney){
            //对转出账户进行判断，如果不为空
            if (inUser!=null){
                outUser.setbalances(outUser.getbalances()-transferMoney);
                inUser.setbalances(inUser.getbalances()+transferMoney);
                Dao.updateOne(outUser);
                Dao.updateOne(inUser);
              //  Dao.commit();
            }else {
                System.out.println("对不起！对方账户不存在");
            }

        }else {
            System.out.println("对不起！"+outAccount+"账户余额不足");
        }

    }

    /**
     * @Description:开户
     * @Param:
     * @return:
     * @Date: 2019/12/21
     **/
    public void insertAccount(String account,String password){
        User user=Dao.selectOne(account);
        if (account==null){
            user.setaccount("account");
            user.setPassword(password);
            user.setbalances((float) 0.0);
            Dao.updateOne(user);
            System.out.println("账户设置成功"+account+"密码为"+password+"账户余额为");
        }else{
            System.out.println("对方账户已经存在，无法添加");
        }

    }

    /**
     * @Description:销户
     * @Param:
     * @return:
     * @Date: 2019/12/21
     **/

}
