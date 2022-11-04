package cn.thinkingme.train.mian.vivo笔试;
/**
 * 一个完整的软件项目往往会包含很多由代码和文档组成的源文件。
 * 编译器在编译整个项目的时候，可能需要按照依赖关系来依次编译每个源文件。
 * 比如，A.cpp 依赖 B.cpp，那么在编译的时候，编译器需要先编译 B.cpp，
 * 才能再编译 A.cpp。 假设现有 0，1，2，3 四个文件，0号文件依赖1号文件，
 * 1号文件依赖2号文件，3号文件依赖1号文件，则源文件的编译顺序为 2,1,0,3 或 2,1,3,0。
 * 现给出文件依赖关系，如 1,2,-1,1，表示0号文件依赖1号文件，1号文件依赖2号文件，2号文件没有依赖，
 * 3号文件依赖1号文件。请补充完整程序，返回正确的编译顺序。注意如有同时可以编译多个文件的情况，
 * 按数字升序返回一种情况即可，比如前述案例输出为：2,1,0,3
输入例子1:
"1,2,-1,1"
输出例子1:
"2,1,0,3"
 * @author Administrator
 *
 */
import java.util.*;


public class 编程依赖问题 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序
     * @param input string字符串 
     * @return string字符串
     */
	
    public static String compileSeq (String input) {
        // write code here
    	if(input.length()<=1) {
    		return input;
    	}
    	String string[] = input.split(",");
    	StringBuffer stringBuffer = new StringBuffer();
    	int size = string.length;
    	Stack<Integer> stack = new Stack<>();
    	int a[][]= new int[size][2];
    	for(int i = 0;i<size;i++) {
    		a[i][0] = Integer.parseInt(string[i]);
    		a[i][1] = 0;
    	}
    	for(int i = 0;i<size;i++) {
    		if(a[i][1] == 1)continue;
    		int j = i;
    		while(a[j][0] != -1&&a[j][1] !=1) {
    			stack.push(j);
    			a[j][1] = 1;
    			j  = a[j][0];
    		}
    		if(a[j][0] == -1&&a[j][1] !=1) {
    			stack.push(j);
    			a[j][1] = 1;
    		}
    		while(!stack.isEmpty()) {
    			stringBuffer.append(",");
    			stringBuffer.append(stack.pop().toString());
    		}
    	}
    	return stringBuffer.toString().substring(1);
    }
    public static void main(String[] args) {
		System.out.println(compileSeq("1,2,-1,1"));
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		int a[][] = {{2,6,9,4},{1,2,4},{1, 2, 3}, {2, 3, 4}, {12, 4, 6}, {6, 7, 9}, {1, 3, 6}};
		for(int i =0;i<a.length;i++) {
			ArrayList<Integer> aList = new ArrayList<>();
			for(int j = 0;j<a[i].length;j++) {
				aList.add(a[i][j]);
			}
			arrayList.add(aList);
		}
		Collections.sort(arrayList, new Comparator<ArrayList<Integer>>(){
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				int len = Math.min(o1.size(), o2.size());
	            for (int i = 0; i < len; i++) {
	                if (o1.get(i) != o2.get(i)) {
	                    return o1.get(i) - o2.get(i);
	                }
	            }
	            return o1.size() - o2.size();
			}
		});
		System.out.println(arrayList);
	}
}

