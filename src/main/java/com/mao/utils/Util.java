package com.mao.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author renshilin
 * @date 2021-11-01
 */
public class Util {
    public static void main(String[] args) {
        // 读取文件内容
        readFile();
    }

    /**
     * 读取文件内容
     * @return s
     */
    public static String readFile(){
        List<String> keys = Arrays.asList("configId", "version", "resourceCode", "submitUserName", "submitDate", "brokerCode", "batchNo", "engineeringFeatureCodes");
        String path = "C:\\Users\\admin\\Desktop\\order.json";
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if (s.contains(":")) {
                    String[] strArr = s.split(":");
                    String key = strArr[0].trim().replace("\"", "");
                    if (keys.contains(key)) {
                        boolean b = keys.size() - 1 == keys.indexOf(key);
                        String value = strArr[1].trim().replace("\"", "");
                        String substring = value.substring(0, value.length() - 1);
                        String ss = "<" + key + ">";
                        String ss1 = "</" + key + ">";
                        System.out.println("    " + ss + substring + ss1);
                        if (b) {
                            System.out.println("</ITEM>");
                            System.out.println("<ITEM>");
                        }
                    }
                }
                // result.append( System.lineSeparator() + s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
