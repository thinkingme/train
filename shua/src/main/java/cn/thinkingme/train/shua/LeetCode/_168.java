package cn.thinkingme.train.shua.LeetCode;
import java.util.*;
public class _168 {
	public static void main(String[] args) {
		System.out.println(convertToTitle(52));
	}
    public static String convertToTitle(int columnNumber) {
    	StringBuffer stringBuffer=new StringBuffer();
    	while(columnNumber>0) {
    		columnNumber --;
    		int temp = columnNumber%26;
    		char c = (char)('A'+temp);
    		if(temp == 0) c = 'A';
    		String string = c+"";
    		stringBuffer =stringBuffer.append(string);
    		columnNumber/=26;
    	}
		System.out.println("我的");
    	return stringBuffer.reverse().toString();
    }
    

}
