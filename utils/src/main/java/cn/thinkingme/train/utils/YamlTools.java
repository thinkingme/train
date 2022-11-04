package cn.thinkingme.train.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

/**
 * @ProjectName: 题目代码
 * @Package: PACKAGE_NAME
 * @ClassName: YamlTools
 * @Author: huige
 * @Description: yaml工具方法
 * @Date: 2021/12/13 9:13
 * @Version: 1.0
 */
public class YamlTools<T> {
    // 首先声明一个Map存解析之后的内容:
    T properties;

    // 空的构造函数
    public YamlTools() {
    }
    // 以文件路径为条件的构造函数
    public YamlTools(String filePath) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            Yaml yaml = new Yaml();
            properties = (T) yaml.loadAs(inputStream, Object.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null)inputStream.close();
        }

    }
    public YamlTools(String filePath,Class<T> type) throws IOException {
        InputStream inputStream = null;
        try {
            final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.readValue(filePath,type);
            inputStream = new FileInputStream(filePath);
            Yaml yaml = new Yaml();
            properties = yaml.loadAs(inputStream, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null)inputStream.close();
        }

    }
    public T toJavaObject(String filePath, Class<T> type) throws IOException {
        InputStream inputStream = null;
        try {
            final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

            inputStream = new FileInputStream(filePath);
            T t = mapper.readValue(inputStream, type);
            return t;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream!=null)inputStream.close();
        }
        return null;
    }

    public void write(String fileName,T t) throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File(fileName),t);
    }
    // 从String 中获取配置的方法
    public void initWithString(String content) {
        // 这里的yaml和上面那个应该可以抽取成一个全局变量,不过平常用的时候
        // 也不会两个同时用
        Yaml yaml = new Yaml();
        properties = (T) yaml.loadAs(content, Object.class);
    }


    /**
     * 从Map中获取配置的值
     * 传的key支持两种形式, 一种是单独的,如user.path.key
     * 一种是获取数组中的某一个,如 user.path.key[0]
     * @param key
     * @return
     */
//    public <T> T getValueByKey(String key, T defaultValue) {
//        String separator = ".";
//        String[] separatorKeys = null;
//        if (key.contains(separator)) {
//            // 取下面配置项的情况, user.path.keys 这种
//            separatorKeys = key.split("\\.");
//        } else {
//            // 直接取一个配置项的情况, user
//            Object res = properties.get(key);
//            return res == null ? defaultValue : (T) res;
//        }
//        // 下面肯定是取多个的情况
//        String finalValue = null;
//        Object tempObject = properties;
//        for (int i = 0; i < separatorKeys.length; i++) {
//            //如果是user[0].path这种情况,则按list处理
//            String innerKey = separatorKeys[i];
//            Integer index = null;
//            if (innerKey.contains("[")) {
//                // 如果是user[0]的形式,则index = 0 , innerKey=user
//                index = Integer.valueOf(innerKey.substring(innerKey.indexOf("[")+1, innerKey.indexOf("[")+2));
//                innerKey = innerKey.substring(0, innerKey.indexOf("["));
//            }
//            Map<String, Object> mapTempObj = (Map<String, Object>) tempObject;
//            Object object = mapTempObj.get(innerKey);
//            // 如果没有对应的配置项,则返回设置的默认值
//            if (object == null) {
//                return defaultValue;
//            }
//            Object targetObj = object;
//            if (index != null) {
//                // 如果是取的数组中的值,在这里取值
//                targetObj = ((ArrayList) object).get(index);
//            }
//            // 一次获取结束,继续获取后面的
//            tempObject = targetObj;
//            if (i == separatorKeys.length - 1) {
//                //循环结束
//                return (T) targetObj;
//            }
//
//        }
//        return null;
//    }
}
