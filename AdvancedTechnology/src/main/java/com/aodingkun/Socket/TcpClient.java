package com.aodingkun.Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName TcpClient
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/11/8
 * Projiect JavaTest
 * @Version 1.0
 **/
public class TcpClient {
    public static void main(String[] args) throws Exception{
        try{
            Socket socket = new Socket("10.12.11.184", 4700);
            // TODO: 2019/11/8 建立连接

            InputStreamReader Sysin = new InputStreamReader(System.in);
            BufferedReader SysBuf = new BufferedReader(Sysin);

            InputStreamReader Socin = new InputStreamReader(socket.getInputStream());
            BufferedReader SocBuf = new BufferedReader(Socin);

            PrintWriter Socout = new PrintWriter(socket.getOutputStream());

            //TODO  进行通信
            String readline=SysBuf.readLine();
            while (!readline.equals("bye")){
                Socout.println(readline);
                Socout.flush();
                System.out.println("Client:"+readline);

                System.out.println("Server"+SocBuf.readLine());
                readline=SysBuf.readLine();

            }
            //关闭IO
            Socout.close();
            Socin.close();
            socket.close();

        }catch (Exception e){
            System.out.println("Error:"+e);
        }

    }
}
