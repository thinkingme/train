package cn.thinkingme.train.shua.LeetCode;
import java.util.*;
/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，
这个锁将会被永久锁定，无法再被旋转。
字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/open-the-lock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author huige
 *
 */
public class _752 {
	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"} ;
		String target = "0202";
		System.out.println(openLock(deadends, target));
		System.out.println(test());
	}
	public static int openLock(String[] deadends, String target) {
		if ("0000".equals(target)) {
            return 0;
        }
		int step = 0;
		Set<String> dead = new HashSet<>(Arrays.asList(deadends));
		if(dead.contains("0000")) {
			return -1;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer("0000");
		Set<String> seenSet = new HashSet<>();
		seenSet.add("0000");
		while(!queue.isEmpty()) {
			++step;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				List<String> list = getAllChange(cur);
				for(String str:list) {
					if(!seenSet.contains(str)&&!dead.contains(str)) {
						if(str.equals(target)) {
							return step;
						}
						queue.offer(str);
						seenSet.add(str);
					}
					
				}
			}
		}
		return -1;
    }
	static int test() {
		int x = 1;
		try {
			return x++;
		} catch(Exception e){
			
		}finally {
			System.out.println("finally:" + x);
			++x;
			System.out.println("++x:" + x);
			// finally代码中最好不要包含return，程序会提前退出，
			// 也就是说返回的值不是try或catch中的值
			return x;
		}
		
	}
	public static List<String> getAllChange(String str) {
		List<String> list = new ArrayList<String>();
		char[] c =str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			char temp = c[i];
			c[i] = (char)(c[i] == '0'?'9':(char)(c[i]-1));
			list.add(new String(c));
			c[i] = temp;
			c[i] = (char)(c[i] == '9'?'0':(char)(c[i]+1));
			list.add(new String(c));
			c[i] = temp;
		}
		return list;
	}
}