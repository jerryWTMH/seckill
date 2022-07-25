package com.example.seckill.utils;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLOutput;

@Component
public class md5 {
    private static final String salt = "1a2b3c4d";
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    public static String formPassToDBPass(String formPass, String salt){
        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass, String salt){
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] argc){
        System.out.println(inputPassToFromPass("jerry123"));
        System.out.println(formPassToDBPass("db1e6e6261c3a5ac3d3ef8d580ce13ff", "j89f0342hjks1"));
        System.out.println(inputPassToDBPass("jerry123", "j89f0342hjks1"));
    }


}
