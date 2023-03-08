package com.thinkingme.train.shua.动态规划;
/**
 * 考虑一个问题，如果有多个任务，每个任务有自己存在时间段（任务之间的时间段可能有重复），
 * 求如果选择任务可以使收益最大化，计算收益时，每个任务段之间不能有重合。
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TimeValue{
	int begain;
	int end;
	int val;
	int pre = -1;
	public TimeValue(int begain,int end,int val) {
		// TODO Auto-generated constructor stub
		this.begain = begain;
		this.end = end;
		this.val = val;
	}
}

public class 收益最大问题 {
	public static void main(String[] args) {
		ArrayList<TimeValue> arrayList = new ArrayList<>();
		arrayList.add(new TimeValue(1, 4, 5));
		arrayList.add(new TimeValue(3, 5, 1));
		arrayList.add(new TimeValue(0, 6, 8));
		arrayList.add(new TimeValue(4, 7, 4));
		arrayList.add(new TimeValue(3, 8, 6));
		arrayList.add(new TimeValue(5, 9, 3));
		arrayList.add(new TimeValue(6, 10, 2));
		arrayList.add(new TimeValue(8, 11, 4));
		int dp[]= new int[arrayList.size()];
 		Collections.sort(arrayList,new Comparator<TimeValue>() {
            @Override
            public int compare(TimeValue o1, TimeValue o2) {
                // 返回值为int类型，大于0表示正序，小于0表示逆序
                return o1.end - o2.end;
            }
        });
		for(int i = 0 ;i<arrayList.size();i++) {
			for(int j = i-1;j>=0;j--) {
				if(arrayList.get(i).begain>=arrayList.get(j).end) {
					arrayList.get(i).pre = j;
					break;
				}
			}
		}
		dp[0] = arrayList.get(0).val;
		int max = 0;
		for(int i = 1;i<dp.length;i++) {
			if(arrayList.get(i).pre == -1) {
				dp[i] = Math.max(arrayList.get(i).val,dp[i-1]);
				max = Math.max(dp[i], max);
			}else {
				dp[i] = Math.max(arrayList.get(i).val+dp[arrayList.get(i).pre],dp[i-1]);
				max = Math.max(dp[i], max);
			}
		}
		System.out.println(max);
	}
}
