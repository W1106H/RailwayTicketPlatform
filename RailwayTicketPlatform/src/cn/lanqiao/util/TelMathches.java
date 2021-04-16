package cn.lanqiao.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moqirun
 * @date 2021/4/15 9:58
 **/
public class TelMathches {
    public static Boolean judgeLegal(String tel) {
        boolean islegal = true;
        if (tel==null||tel.equals("")) {
            return false;
        }
        String regex = "^\\d{11}$";
        //正则表达式的模式
        Pattern p = Pattern.compile(regex);
        //正则表达式的匹配器
        Matcher m = p.matcher(tel);
        //进行正则匹配
        islegal = m.matches();
        return islegal;
    }
}
