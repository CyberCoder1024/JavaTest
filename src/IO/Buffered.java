package IO;

import java.io.*;

/**
 * @ClassName Buffered
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/19 22:58
 * Project JavaTest
 * @Version 1.0
 **/
public class Buffered {
    public static void main(String[] args) {
        Buffered bfd = new Buffered();
        String login = bfd.login("蔡徐坤", "ctrl");
        System.out.println(login);


    }
    /**
     * @Description:字节型缓冲流
     * @Param:
     * @return:
     * @Date: 2019/12/19
     **/
    public void byetBuffered(){
        try{
            File file = new File("D://test//test.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream("");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
           // bos.write(int);
            bos.write(1);
          //  bos.write(byte[]);
            bos.close();
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description:字符型缓冲流
     * @Param:
     * @return:
     * @Date: 2019/12/19
     **/
    public void charBuffered(){
        //字符流缓存流
        try {
            File file = new File("D://test//test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bfw = new BufferedWriter(new FileWriter("", true));
            bfw.newLine();
            bfw.write("java");
            bfw.flush();

            int code=br.read();
            //读取文件中一行的信息
            String s = br.readLine();
            while (s!=null){
                System.out.println(s);
                s= br.readLine();
            }
            System.out.println(code);
            while (code!=-1){
                System.out.println((char)code);
                code=br.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Description: //设计一个方法用来登录认证
     * @Param:
     * @return:
     * @Date: 2019/12/20
     **/

    public String login(String username, String password){
        //真实的名字和密码永久存在数据库--》数据持久化
        //文本我们采用txt形式的纯文本  文本中的内容 以韩为单位 每一行记录一个人的信息
        try {
            BufferedReader br=new BufferedReader(new FileReader(""));
            //表示一行记录 巨鹿账号和密码
           String user= br.readLine();
           while(user!=null){
               //将user的信息 按照-拆分 分别于方法的参数进行比较
               String[] value = user.split("-");//value[0] zhanghu;value[1] 密码
               if (value[0].equals(username)) {

                   if (value[1].equals(password)) {

                       return "登录成功";
                   }
               }
               user=br.readLine();
           }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return "账户密码不匹配";
    }

}
