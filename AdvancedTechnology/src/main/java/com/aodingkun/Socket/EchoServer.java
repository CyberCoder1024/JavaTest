package com.aodingkun.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName EchoServer
 * @Description TODO
 * @Author jonas.ao
 * @Date 2019/11/8
 * Projiect JavaTest
 * @Version 1.0
 **/
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8189);) {
            try (Socket incoming = serverSocket.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"),
                            true);
                    out.println("Hello!Enter BYE TO EXIT.");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE")) done = true;

                    }
                }


            }
        }

    }
}
