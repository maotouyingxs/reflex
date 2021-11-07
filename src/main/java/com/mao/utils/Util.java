package com.mao.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author renshilin
 * @date 2021-11-01
 */
public class Util {
    public static void main(String[] args) throws ParseException, IOException {

        String str1 = "YS00,VPT000,PGF000,PRS000,BLW000,CTA001,MAW001,BEW000,CTK001,MBP001,PTL000,BDH001,CSF000,CTW001,VPO000,PRR004,MMI000,BDL001,BBR002,GML000,MAS000,MAL001,MBA000,MVB000,MBR000,CTL000,CZT003,MWA000,GMV000,MCA000,BDW000,PPM000,CTH001,VPR000,VFS000,PTR000,BDA001,VFW021,PFW000,CZW000,BOT001,PES000,CTP001,PTC000,PGR000,BMH000,PFP001,VFF003,MAN001,CZA001,PPP000,MMM000,PTM002,BDS001,MWV000,BDF001,CPK001,PTS001,BBW000,MAB001,VPP001,VPK000,BOS001,CST001,CTG006,VFH016,BEB001,MPO001,CFW000,BDU000,CFL004,PFB000,PAF000,CTN000,BDC000,PEO000,VPG002,PRM003,BDE001,PTW001,CTD001,BLH000,MPV001,CAM001,CTI000,BER001,PED000,PAR000,MBK000,CTX000,CTB000,BOF000,PTD001,CCT001,BDK000,CTT000,CGR000,MBF000,CCF006,MVC000,VFO000,PPS000,CTC000,CSU000,BMF000,PTB001,PPT000,BOU001,BDT000,BDN000,BDM001,MAF001,CTS006,CTO000,PTT015,CFU003,MAA001,MPR000,BSM000,CSR013,MKK000,PEE000,CGL000,VFG018,VMY001,MAR001,CTE000,MPW001,BSG001,VFD000,BOR003,CFR000,CTJ000,PRW000,BOW000,BDJ001,PEP007,CTZ006,MAC000,PEF001,MAO001,MIH002,PRP000,VPA000,CTF000,MAV001,CTR000,GMS000,BOC001,CSS001,BDB000,CCM001,MVU001,BEA000,GMR000,CAA000,VPW003,MAT000,CTM000,MAP000,BBL002,BEG000,BMO001,BUA001,MCP000,MAE003,VMS001,CFG000,BOA001,BDG000,BLD001,BOO000,PRA000,PTY001,BBF001,MHH001";
        String str2 = "YS00,VPT000,PGF000,BLW000,MAW001,BEW000,MBP001,PTL000,CTL000,VPO000,BDL001,PRR004,MMI000,CTW001,BBR002,GML000,MAS000,MBA000,CTK001,MVB000,PAF000,MBR000,CTN000,CZT003,MWA000,BMO001,GMV000,MCA000,BDE001,PPM000,VPR000,VPW003,VFW021,BDF001,PRS000,PFW000,CZW000,BOT001,PES000,BDG000,PTC000,BMH000,PGR000,PEF001,BEA001,PFP001,VFF003,MAN001,CTF000,CZA001,MMM000,CTP001,PTM002,MWV000,CPK001,BBW000,MAB001,VPP001,VPK000,PFB000,CTR000,BOS001,CST001,MPO001,VFH016,BEB001,CFW000,BDU000,CTS006,CTZ006,CTC000,CSF000,MAL001,BDC000,BDT000,PEO000,VPG002,CTH001,PRM003,PTW001,BDW000,BLH000,CTA001,MPV001,CAM001,CTI000,BER001,PED000,PAR000,MBK000,CTB000,CTX000,PTD001,BOF000,CCT001,CTO000,CTT000,CGR000,MBF000,CCF006,MVC000,VFO000,PPS000,CSU000,CTE000,PTB001,BOU001,BMF000,PPT000,BDM001,CFL004,MAF001,PTT015,VFG018,CFU003,MAA001,MPR000,CTG006,BSM000,MKK000,PEE000,CGL000,BDN000,VMY001,MAR001,MPW001,BSG001,VFD000,CTD001,BOR003,CFR000,PRW000,BOW000,PPP000,MAC000,MAO001,MIH002,PRP000,MAV001,VPA000,PTS001,GMS000,BOC001,PEP007,CSS001,BDB000,CTJ000,CCM001,BDS001,MVU001,GMR000,CAA000,PTR000,MAT000,CTM000,MAP000,BBL002,BUA001,CSR013,BEG000,BDJ001,MCP000,MAE003,VMS001,CFG000,BOA001,BLD001,BOO000,PRA000,BDA001,PTY001,BDK000,VFS000,BBF001,MHH001,BDH001";
        String[] strs1 = str1.split(",");
        String[] strs2 = str2.split(",");
        String s1 = doDiff(strs1, strs2);
        System.out.println(s1);

        // 读取文件内容
        // String s = readFile2();
        // StringBuilder sb = new StringBuilder();
        // JSONArray objects = JSONObject.parseArray(s);
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // Date parse = df.parse("2021-10-13");
        // for (Object object : objects) {
        //     JSONObject jsonObject = (JSONObject) object;
        //     JSONObject source = (JSONObject) jsonObject.get("_source");
        //     Object submitDate = source.get("submitDate");
        //     Date date = DateUtils.parseDate(submitDate.toString(), "yyyy-MM-dd HH:mm:ss");
        //     if (date.before(parse)) {
        //         continue;
        //     }
        //     Object optionalFeatureList1 = source.get("optionalFeatureList");
        //     if (optionalFeatureList1 == null) {
        //         continue;
        //     } else {
        //         JSONArray jsonArray1 = (JSONArray) optionalFeatureList1;
        //         boolean fla = false;
        //         for (Object json : jsonArray1) {
        //             JSONObject jsonOb = (JSONObject) json;
        //             Object featureCode = jsonOb.get("featureCode");
        //             if (featureCode != null) {
        //                 String ss = featureCode.toString();
        //                 if (ss.startsWith("Y")) {
        //                     fla = true;
        //                 }
        //             }
        //         }
        //         if (!fla) {
        //             continue;
        //         }
        //     }
        //     sb.append(object + ",");
        // }
        // File file =new File("C:\\Users\\admin\\Desktop\\orderResult.json");
        //
        // if(!file.exists()){
        //     file.createNewFile();
        // }
        // doCreateFile(sb.toString(), file);
    }

    /**
     * 获取错误的数据
     * @param keys
     * @param s
     * @throws ParseException
     * @throws IOException
     */
    private static void doGetError(List<String> keys, String s) throws ParseException, IOException {
        JSONArray objects = JSONObject.parseArray(s);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = df.parse("2021-10-13");
        StringBuilder sb = new StringBuilder();
        sb.append("<LIST>");
        sb.append("\r\n");
        for (Object object : objects) {
            JSONObject jsonObject = (JSONObject) object;
            JSONObject source = (JSONObject)jsonObject.get("_source");
            Object optionalFeatureList1 = source.get("optionalFeatureList");
            if (optionalFeatureList1 == null) {
                continue;
            } else {
                JSONArray jsonArray1 = (JSONArray) optionalFeatureList1;
                boolean fla = false;
                for (Object json : jsonArray1) {
                    JSONObject jsonOb = (JSONObject) json;
                    Object featureCode = jsonOb.get("featureCode");
                    if (featureCode != null) {
                        String ss = featureCode.toString();
                        if (ss.startsWith("Y")) {
                            fla = true;
                        }
                    }
                }
                if (!fla) {
                    continue;
                }
            }

            Object submitDate = source.get("submitDate");
            Date date = DateUtils.parseDate(submitDate.toString(), "yyyy-MM-dd HH:mm:ss");
            if (date.after(parse)) {
                sb.append("<ITEM>");
                sb.append("\r\n");
                for (String key : keys) {
                    if (source.containsKey(key)) {
                        sb.append("<" + key + ">");
                        String s1 = source.get(key).toString();
                        sb.append(s1);
                        sb.append("</" + key + ">");
                        sb.append("\r\n");
                    }
                }
                Object standardFeatureList = source.get("standardFeatureList");
                Object optionalFeatureList = source.get("optionalFeatureList");

                if (standardFeatureList != null) {

                    StringBuilder featureCodes = new StringBuilder();
                    StringBuilder familyCodes = new StringBuilder();
                    JSONArray jsonArray = (JSONArray) standardFeatureList;

                    doget(featureCodes, familyCodes, jsonArray,false);
                    StringBuilder featureCodes1 = new StringBuilder();
                    StringBuilder familyCodes1 = new StringBuilder();
                    if (optionalFeatureList != null) {
                        JSONArray jsonArray1 = (JSONArray) optionalFeatureList;
                        doget(featureCodes1, familyCodes1, jsonArray1,true);
                    }
                    sb.append("<" + "featureCodeCodes" + ">");
                    sb.append(featureCodes.toString());
                    sb.append("</" + "featureCodeCodes" + ">");
                    sb.append("\r\n");
                    sb.append("<" + "featureCodeDesc" + ">");
                    sb.append(familyCodes.toString());
                    sb.append("</" + "featureCodeDesc" + ">");
                    sb.append("\r\n");
                    sb.append("<" + "optionalFeatureCodeCodes" + ">");
                    sb.append(featureCodes1.toString());
                    sb.append("</" + "optionalFeatureCodeCodes" + ">");
                    sb.append("\r\n");
                    sb.append("<" + "optionalFeatureCodeDesc" + ">");
                    sb.append(familyCodes1.toString());
                    sb.append("</" + "optionalFeatureCodeDesc" + ">");
                    sb.append("\r\n");
                }
                sb.append("</ITEM>");
                sb.append("\r\n");
            }
        }
        sb.append("</LIST>");
        File file =new File("C:\\Users\\admin\\Desktop\\orderResult.txt");

        //if file doesnt exists, then create it
        if(!file.exists()){
            file.createNewFile();
        }

        //true = append file
        doCreateFile(sb.toString(), file);
    }

    /**
     * 创建文件
     * @param data
     * @param file
     * @throws IOException
     */
    private static void doCreateFile(String data, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();
        fileOutputStream.close();

        System.out.println("Done");
    }

    private static void doget(StringBuilder featureCodes, StringBuilder familyCodes, JSONArray jsonArray, Boolean flag) {
        for (Object json : jsonArray) {
            JSONObject jsonOb = (JSONObject) json;
            Object featureCode = jsonOb.get("featureCode");
            if (featureCode != null) {
                String s = featureCode.toString();
                featureCodes.append(s);
                featureCodes.append(",");
            }
            Object familyCode = jsonOb.get("familyCode");
            if (familyCode != null) {
                familyCodes.append(familyCode.toString() + "=" + featureCode);
                familyCodes.append(",");
            }
        }
    }

    public static String readFile2(){
        String path = "C:\\Users\\admin\\Desktop\\order.json";
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        StringBuilder result1 = new StringBuilder();
        result1.append("[");
        long count = 0L;
        long counts = 0L;
        long count3 = 0L;

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
                count++;
                if (counts != 0L && counts == count) {
                    String s1 = result.toString();
                    String substring = s1.substring(0, s1.length() - 1);
                    result1.append(s1);
                    result = new StringBuilder();
                    // count3++;
                    // System.out.println(count3);
                    // JSONObject jsonObject = JSONObject.parseObject(substring);
                    // if (count3 == 2L) {
                    //     return result1.append("]").toString();
                    // }
                }
                if (s.contains("interfaceStatus")) {
                    counts = count + 2;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        result1.append("]");
        return result1.toString();
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
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = df.parse("2021-10-12");
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if (s.contains(":")) {
                    String[] strArr = s.split(":");
                    String key = strArr[0].trim().replace("\"", "");
                    if (keys.contains(key)) {

                        boolean b = keys.size() - 1 == keys.indexOf(key);
                        String value = strArr[1].trim().replace("\"", "");
                        String substring = value.substring(0, value.length() - 1);
                        if ("submitDate".equals(key)) {
                            String data = substring.substring(0, substring.length() - 2);
                            Date date = DateUtils.parseDate(data, "yyyy-MM-dd");
                            if (date.before(parse)) {
                                continue;
                            }
                        }
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

    private static String doDiff(String[] engineeringFeatureCodeStrs, String[] newEngineeringFeatureCodeStrs) {
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> history = new LinkedList<>();
        String[] longerArr = engineeringFeatureCodeStrs;
        String[] shorterArr = newEngineeringFeatureCodeStrs;
        // 找出较长的数组来减较短的数组
        if (engineeringFeatureCodeStrs.length > newEngineeringFeatureCodeStrs.length) {
            longerArr = newEngineeringFeatureCodeStrs;
            shorterArr = engineeringFeatureCodeStrs;
        }
        for (String str : longerArr) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        for (String str : shorterArr) {
            if (list.contains(str)) {
                history.add(str);
                list.remove(str);
            } else {
                if (!history.contains(str)) {
                    list.add(str);
                }
            }
        }

        // String[] result = {};
        return list.toString();
    }
}
