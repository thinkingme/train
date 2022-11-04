package cn.thinkingme.train.test;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println(Integer.toString(100, 7));

        System.out.println(Arrays.toString("林鹏".getBytes(StandardCharsets.UTF_8)));
        String aaa = new String("11");
        String bbb = new String("11");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(aaa,"11");
        aaa = "2";
        System.out.println(stringStringHashMap.get("11"));
        System.out.println(stringStringHashMap.get("1"));
        boolean b1 = aaa == bbb;
        System.out.println(b1);


        method("1");

        Instant now = Instant.now();
        String s = encodeBase64File("E:\\图片\\【P站画师】来收壁纸吧！韩国画师reinforced的风景插画作品\\收藏[524]图id[70561800_p7]_标题[무제]画师[reinforced]uid[12355624]_acg17.com.jpg");
        Instant after = Instant.now();
        System.out.println(Duration.between(now,after));

        Instant now2 = Instant.now();
        String s2 = encodeBase64FileOle("E:\\图片\\【P站画师】来收壁纸吧！韩国画师reinforced的风景插画作品\\收藏[524]图id[70561800_p7]_标题[무제]画师[reinforced]uid[12355624]_acg17.com.jpg");
        Instant after2 = Instant.now();
        System.out.println(Duration.between(now2,after2));

        Object circle1 = new Circle();
        Object circle2 = new Circle();
        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<String, Integer>();
        System.out.println(circle1.equals(circle2));
        List<String> list = new ArrayList();
        list.add("7");
        list.add("9");
        list.add("11");
        list.add("6");
        list.add("0");
        Collections.shuffle(list);
        Collections.sort(list,new Comparator<String>(){
        	@Override
            public int compare(String o1, String o2) {
        		
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
		});
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        List <Integer>a = new ArrayList<>(32);
        a.add(1);
        a.add(2);
        a.add(3);
        List <Integer>b = new ArrayList<>(32);
        b.add(2);
        b.add(3);
        b.add(3);
        a.removeAll(b);
        List <Integer>newList = b.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
        System.out.println(a);
    }

    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.getEncoder().encodeToString(buffer);
    }
    public static String encodeBase64FileOle(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    public static void method(String beanName){
        Object singleton = getSingleton(beanName, () -> {
            return 10;
        });
        System.out.println((int)singleton);
    }
    public static Object getSingleton(String beanName, ObjectFactory<?> singletonFactory) {
        return singletonFactory.getObject();
    }
}

class Circle {
    double radius;
    @Override
    public boolean equals(Object circle) {
        return this.radius == ((Circle)circle).radius;
    }
}