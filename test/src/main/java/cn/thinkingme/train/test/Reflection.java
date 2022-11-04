package cn.thinkingme.train.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("username", "zhangsan");
		map.put("age", "12");
		Teacher teacher = param2bean(map, new Teacher());
		System.out.println(teacher.getClass().getClassLoader());
		System.out.println(teacher);
		User user = param2bean(map, new User());
		System.out.println(user);
		Foo<String> foo = new Foo<String>(){};

        Type type = ((ParameterizedType)foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);

        System.out.println(foo.getTClass());
	}
	public static<T> T param2bean(HashMap<String, String> map,T t) {
		Field[] declaredFields = t.getClass().getDeclaredFields();
		for(Field field:declaredFields) {
			try {
				field.set(t, map.get(field.getName()));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return t;
	}
}
class Teacher{
	public String username;
	public String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "teacher [username=" + username + ", age=" + age + "]";
	}
	
}
class Foo<T>{
    public Class<T> getTClass()
    {
        @SuppressWarnings("unchecked")
		Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}
