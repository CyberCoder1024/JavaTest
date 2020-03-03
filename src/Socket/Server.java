package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/12/17 15:26
 * Project JavaTest
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args)throws IOException {
        File file = new File("C:\\Users\\logo.jpg");
        if (!file.exists())
            file.createNewFile();
        fileProtocl(file);
            System.out.println("开始打印文件内容");
        fileRead(file);
    }

    private static void fileRead(File file)throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader(file));
        String line=null;
        while ((line=bufr.readLine())!=null){
            System.out.println(line.toString());
        }
        System.out.println("文件打印完毕");

    }


    private static void fileProtocl(File file)throws IOException {
        ServerSocket server = new ServerSocket(8086);
        Socket socket = server.accept();
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip+"is connnected");
        //创建输入流 接收客户端信息
            //getinputStream接收从socket中传输的数据，接受格式为字节流
           //InputStreamReader将字节流转换成字符流，并缓存进BufferedReader中.
            //原因：要把接收的内容写入文件，优先选择使用字符流.
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //创建文件缓存流 并将读取到的内容写入到文件中，处理的是字符，优先选择字符缓存流
        BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
        String line=null;
        while ((line=bufIn.readLine())!=null){
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        //创建输出流 告知客户端传输结果
        PrintWriter prinout = new PrintWriter(socket.getOutputStream(), true);
        prinout.println("上传成功");
        System.out.println("文件接收完毕");
        bufw.close();
        socket.close();
        server.close();
    }

}
