package cn.thinkingme.train.shua.刷题;
/**
 * 
 * 单调栈进阶
 * 
 * 给定一个可能含有重复值的数组 arr，
 * 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。
 * 返回所有位置相应的信息。
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
class Reader {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static String nextLine() throws IOException{// 读取下一行字符串
        return reader.readLine();
    }
    static String next() throws IOException {// 读取下一个字符串
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {// 读取下一个int型数值
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {// 读取下一个double型数值
        return Double.parseDouble(next());
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
    	int n = Reader.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
                a[i] =  Reader.nextInt();
        } 
        int right[] = new int[n];
        Arrays.fill(right, -1);
        int left[] = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        for(int i = 0 ; i < n ;i ++) {
        	while(!stack.isEmpty() && a[stack.peek()]>= a[i]) {
        		stack.pop();
        	}
        	if(!stack.isEmpty()) {
        		left[i] = stack.peek();
        	}
        	stack.push(i);
        }
        for(int i = 0 ; i < n ; i++) {
        	while(!stack2.isEmpty() && a[stack2.peek()]> a[i]) {
        		right[stack2.pop()] = i;
        	}

        	stack2.push(i);
        }
        
//        for(int i = n-1 ; i >= 0 ; i--) {
//        	while(!stack2.isEmpty() && a[stack2.peek()]>= a[i]) {
//        		stack2.pop();
//        	}
//        	if(!stack2.isEmpty()) {
//        		right[i] = stack2.peek();
//        	}
//        	stack2.push(i);
//        }
        
        for (int i = 0; i < n; i++) {
            System.out.println( left[i] +" " + right[i]);
        }
        
    }
}
//public class Main {
//	public static int getRes(int len){
//        if(len<4) return len;
//        int res = 3;
//        int pre = 2;
//        for(int i=4;i<=len;i++){
//            int tmp = res;
//            res = res+pre;
//            res %= (int)Math.pow(2,29);
//            pre = tmp;
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> arrayList = new ArrayList<String>();
//        int n = sc.nextInt();
//        System.out.println(getRes(n));
//    }
//}