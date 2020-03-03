package com.aodingkun.Socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ClassName PostTest
 * @Description TODO demonstrates how to use the URLConnection class for Post Request
 * @Author jonas.ao
 * @Date 2019/12/27
 * Project JavaTest
 * @Version 1.0
 **/
public class PostTest {
    public static void main(String[] args)throws IOException {
        String propsFilename=args.length>0?args[0]: "src\\com.aodingkun.Socket\\post.properties";
        Properties props = new Properties();
        try (InputStream in= Files.newInputStream(Paths.get(propsFilename))){
            props.load(in);

        }

        String urlString = props.remove("url").toString();
        Object userAgent = props.remove("User-Agent");
        Object redirects = props.remove("redirects");
        CookieHandler.setDefault(new CookieManager(null,CookiePolicy.ACCEPT_ALL));
        //创建UrlConnection 对象
        String result=doPost(new URL(urlString),props,userAgent==null?null:userAgent.toString(),redirects==null?-1:Integer.parseInt(redirects.toString()));
        System.out.println(result);


    }
    /**
     * @Description: do post
     * @Param:
     * @return:
     * @Date: 2019/12/27
     **/
    public static  String doPost(URL url, Map<Object,Object> nameValueParis,String userAgent,int redirects) throws IOException {
        //从 urlConnnection 获得输出流 并将名/值 写入到输出流中
        URLConnection connection =(HttpURLConnection) url.openConnection();
        if(userAgent!=null)
            connection.setRequestProperty("User-Agent",userAgent);
        if (redirects>=0)
            //自动重定向关闭
            ((HttpURLConnection) connection).setInstanceFollowRedirects(false);
        //建立一个输出连接
        connection.setDoOutput(true);
        //调用 getOutputSream 获得流 同庚这个流向服务器发送数据 如果要向服务器发送文本信息 纳闷可以非常方便的将流包装在PrinWriter 对象
        try( PrintWriter out = new PrintWriter(connection.getOutputStream())){
            boolean first=true;
            for (Map.Entry<Object,Object> pair:nameValueParis.entrySet())
            {
                if (first) first=false;
                else out.print('&');
                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                //向服务器发送数据
                out.print(name);
                out.print('=');
                out.print(URLEncoder.encode(value,"UTF-8"));
            }
        }
        String encoding = connection.getContentEncoding();
        if (encoding==null)encoding="UTF-8";
        if (redirects>0){
           //int responseCode= connection.getResponseCode();
            int responseCode = ((HttpURLConnection) connection).getResponseCode();

            if (responseCode==HttpURLConnection.HTTP_MOVED_PERM
                ||responseCode==HttpURLConnection.HTTP_MOVED_TEMP
                    ||responseCode==HttpURLConnection.HTTP_SEE_OTHER)
            {
                String location = connection.getHeaderField("Location");
                if (location!=null){
                    URL base = connection.getURL();
                    ((HttpURLConnection) connection).disconnect();;
                    return doPost(new URL(base,location),nameValueParis,userAgent,redirects -1);
                }
            }
        }else if (redirects==0){
            throw new IOException("Too many redirects");
        }
        StringBuilder response = new StringBuilder();
        try(Scanner in=new Scanner(connection.getInputStream(),encoding)){
            while (in.hasNextLine()){
                response.append(in.nextLine());
                response.append("\n");
            }
        }catch (IOException e){
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (err==null)throw e;
            try(Scanner in = new Scanner(err)){
                response.append(in.nextLine());
                response.append("\n");
            }
        }
        return response.toString();
    }
}
