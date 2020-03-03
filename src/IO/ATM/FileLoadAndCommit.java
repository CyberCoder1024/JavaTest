package IO.ATM;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName FileLoadAndCommit
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/21 21:46
 * Project JavaTest
 * @Version 1.0
 **/
public class FileLoadAndCommit {

    //文件路径
    private String filePath=null;
    public FileLoadAndCommit(String filePath){
        this.filePath=filePath;
    }

    //TODO 程序块加载
    public HashMap<String,User>loadFile(){
        //键值对
        //键 用户账户 ；值 用户对象 三个属性 可读性好
        //集合除了可以充当缓存 增强执行性能之外 还能用来记录修改
     HashMap<String,User> userBox=new HashMap<String,User>();
        {
            BufferedReader bfr=null;
            FileReader fileReader=null;
            //TODO 程序库的目的是在对象创建之前 给集合进行赋值
            try {
                File file = new File(filePath);
                fileReader = new FileReader(file);
                bfr = new BufferedReader(fileReader);
                String value=bfr.readLine();
                while (value!=null){
                    //value的信息拆分成三段 构建一个User对象 三个属性刚好存储 对象存入集合
                    String[] userValue = value.split("-");
                    User userMap = new User(userValue[0], userValue[1], Float.parseFloat(userValue[2]));
                    //put(账户，User对象）
                    userBox.put(userMap.getaccount(),userMap);
                    value=bfr.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fileReader !=null){
                        fileReader.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }try {
                    if (bfr!=null){
                        bfr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userBox;

    }
    //TODO 设计一个方法 目的是为了将集合内的所有数据写入文件
    public void commit(HashMap<String,User> userBox) {//数据库----commmit提交-----事务
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //创建一个字符型文件输出流
            File file = new File(filePath);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            Iterator<String> accounts = userBox.keySet().iterator();
            while (accounts.hasNext()) {
                //集合内获取的某一个人名
                String account = accounts.next();
                //记录一个人的真实数据
                User user = userBox.get(account);
                //String value= user.getaccount()+"-"+user.getPassword()+"-"+user.getbalances();
                //将user对象的真实数据凭借成一行字符串
                StringBuilder builder = new StringBuilder(user.getaccount());
                builder.append("-");
                builder.append(user.getPassword());
                builder.append("-");
                builder.append(user.getbalances());
                //字符型文件输出流将凭借好的builder写入文件
                bufferedWriter.write(builder.toString());
                //换行
                bufferedWriter.newLine();
                bufferedWriter.flush();


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}