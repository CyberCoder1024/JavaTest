package Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.SocketHandler;

/**
 * @ClassName TcpServer
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/11/8
 * Projiect JavaTest
 * @Version 1.0
 **/
public class TcpServer {
    public static void main(String[] args)throws Exception {
        try {
            // TODO: 2019/11/8 建立套接字
            ServerSocket server=new ServerSocket(4700);
            //TODO 监听 等待客户端连接
            Socket socket=server.accept();
            //TODO 建立连接
            InputStreamReader Sysin = new InputStreamReader(System.in);
            BufferedReader SysBuf = new BufferedReader(Sysin);

            InputStreamReader Socin = new InputStreamReader(socket.getInputStream());
            BufferedReader SocBuf = new BufferedReader(Socin);

            PrintWriter Socout = new PrintWriter(socket.getOutputStream());

            System.out.println("Client"+SocBuf.readLine());

            String readline=SysBuf.readLine();
            while (!readline.equals("bye")){
                Socout.println(readline);
                Socout.flush();
                System.out.println("Server:"+readline);

                String rl=SocBuf.readLine();
                if (!rl.equals("ok")){
                    System.out.println("Client:"+rl);
                }else{
                    break;
                }
                //TODO 从键盘读取
                readline=SysBuf.readLine();
            }
            //TODO关闭IO
            Socout.close();
            Socin.close();
            server.close();
        }catch (Exception e){
            System.out.println("Error:"+e);
        }
    }
    

}


     /* if (args.length>0){
          String host=args[0];
          InetAddress[] addresses=InetAddress.getAllByName(host);
          for (InetAddress a:addresses)
              System.out.println(a);

      }
      else {
          InetAddress localHostAddress=InetAddress.getLocalHost();
          System.out.println(localHostAddress);
      }*/
//        try(
//                Socket s=new Socket("time-a.nist.gov",13);
//            Scanner in = new Scanner(s.getInputStream(), "UTF-8")
//            )
//
//        {
//            while (in.hasNextLine())
//            {
//                String line=in.nextLine();
//                System.out.println(line);
//            }
