package com.thinkingme.train.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ProjectName: 题目代码
 * @Package: test
 * @ClassName: 归并
 * @Author: huige
 * @Description: 111
 * @Date: 2021/11/18 15:24
 * @Version: 1.0
 */
class Gui implements Serializable{
    private static final long serialVersionUID = -6957361951748382519L;
    String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<FileApplicant> getFileApplicant() {
        return fileApplicant;
    }

    public void setFileApplicant(ArrayList<FileApplicant> fileApplicant) {
        this.fileApplicant = fileApplicant;
    }

    int age;
    ArrayList<FileApplicant> fileApplicant;
}
class FileApplicant implements Serializable {
    private static final long serialVersionUID = -7957361951748382519L;
    String fe07_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFe07_id() {
        return fe07_id;
    }

    public void setFe07_id(String fe07_id) {
        this.fe07_id = fe07_id;
    }

    public ArrayList<String> getFile_link() {
        return file_link;
    }

    public void setFile_link(ArrayList<String> file_link) {
        this.file_link = file_link;
    }

    ArrayList<String> file_link;
}

public class 归并JSON字符串 {
    public static void main(String[] args) {
        System.out.println(gui("{\n" +
                "   \"name\":\"Bill Gates\",\n" +
                "   \"age\":62,\n" +
                "   \"fileApplicant\": [\n" +
                "\t  { \"fe07_id\":\"01\",  \"file_link\":[ \"911\", \"Taycan\" ] },\n" +
                "\t  { \"fe07_id\":\"02\", \"file_link\":[ \"M5\", \"Taycan\" ] },\n" +
                "\t  { \"fe07_id\":\"03\", \"file_link\":[ \"XC60\", \"V60\" ] }\n" +
                "\t  { \"fe07_id\":\"01\",  \"file_link\":[ \"911\", \"Taycan\" ] },\n" +
                "\t  { \"fe07_id\":\"01\",  \"file_link\":[ \"911\", \"Taycan\" ] },\n" +
                "\t  { \"fe07_id\":\"03\", \"file_link\":[ \"XC60\", \"V60\" ] }\n" +
                "   ]\n" +
                "}"));
    }

    public static String gui(String json){
        Gui gui = JSON.parseObject(json, Gui.class);
        HashMap<String, ArrayList<String>> stringArrayListHashMap = new HashMap<>();
        for(FileApplicant fileApplicant:gui.getFileApplicant()){
            String id = fileApplicant.getFe07_id();
            if(!stringArrayListHashMap.containsKey(id)){
                stringArrayListHashMap.put(id,fileApplicant.getFile_link());
            }else{
                stringArrayListHashMap.get(id).addAll(fileApplicant.getFile_link());
            }
        }
        ArrayList<FileApplicant>  fileApplicant = JSON.parseObject(JSONObject.toJSONString(stringArrayListHashMap), ArrayList.class);
        gui.setFileApplicant(fileApplicant);
        return "map";
    }
}
