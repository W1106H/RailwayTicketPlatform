package cn.lanqiao.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientUtil {

    public static String getHostIp(){
        String hostAddress = null;
        try {
            hostAddress = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostAddress;
    }

    public static String generateRefundTicketString(String hostIp,String orderNo,String trainNum, String startStationNum, String endStationNum){
        return hostIp + "-" + "RefundTicket" + "-" + orderNo + "-" + trainNum + "-" + startStationNum + "-" + endStationNum;
    }

    public static String generateBuyTicketString(String hostIp,String trainNum, String startStationNum, String endStationNum){
        return hostIp + "-" + "BuyTicket" +  "-" + trainNum + "-" + startStationNum + "-" + endStationNum;
    }

    public static void sendInfo(String sendInfo) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
//            哪个服务器就改成哪个服务器的IP
            socket = new Socket("192.168.1.8",8081);
            outputStream = socket.getOutputStream();
            String s = sendInfo;
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean receiveInfo(){
        InputStream inputStream = null;
        Socket socket = null;
        ServerSocket serverSocket = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            serverSocket = new ServerSocket(8082);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while((len = inputStream.read(bytes)) != -1){
                stringBuffer.append(new String(bytes,0,len,"UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String str = stringBuffer.toString();
        if("true".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}
