package cn.lanqiao.util;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
// //通过字符串“HH：MM”得到目前DATA
public class StringForData {
    public static Date slip(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        List<String> list = new ArrayList<String>();
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        int hour=0,minute=0;
        hour = Integer.parseInt(list.get(0));
        minute=Integer.parseInt(list.get(1));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR,hour-12);
        cal.set(Calendar.MINUTE,minute);
        cal.set(Calendar.SECOND,0);
        Date date = cal.getTime();
        return date;
    }

    public static int getTimeSub(Time arrive_Time,Time start_Time){
        SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
        String at = sdf2.format(arrive_Time);
        String st = sdf2.format(start_Time);
        int arriveTime = Integer.parseInt(at);
        int startTime = Integer.parseInt(st);
        int tmp = startTime - arriveTime;
        if(tmp >= 0){
            return tmp;
        }else{
            return tmp + 60;
        }
    }
}
