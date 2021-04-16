package cn.lanqiao.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moqirun
 * @date 2021/4/14 20:16
 **/
public class EmailMatches {
    public static Boolean judgeLegal(String email) {
        if (email == null||email.equals("")) {
            return false;
        }
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(email);
        //进行正则匹配
        return m.matches();
    }
}
