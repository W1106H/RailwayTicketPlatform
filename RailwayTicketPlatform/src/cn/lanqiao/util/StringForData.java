package cn.lanqiao.util;

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
}
