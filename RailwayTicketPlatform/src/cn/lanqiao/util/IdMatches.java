package cn.lanqiao.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moqirun
 * @date 2021/4/14 20:16
 **/
public class IdMatches {
    public static Boolean judgeLegal(String IDnum) {
        boolean islegal = true;
        if(IDnum==null||IDnum.equals("")) {
            return false;
        }
        String regex = "[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))([0-2][1-9]|30|31)\\d{3}[0-9Xx]";
        //正则表达式的模式
        Pattern p = Pattern.compile(regex);
        //正则表达式的匹配器
        Matcher m = p.matcher(IDnum);
        //进行正则匹配
        islegal=m.matches();
        return islegal;
    }
}
