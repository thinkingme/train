package cn.thinkingme.train.shua.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * 380. O(1) 时间插入、删除和获取随机元素
 * </p>
 *
 * @author: huige
 * @date: 2022/4/13 14:26
 */
public class _380O1时间插删除和获取随机元素 {

    class RandomizedSet {
        public int[] arr;
        Random random = new Random();
        Map <Integer,Integer>hs ;
        int idx = -1;
        public RandomizedSet() {
            arr= new int[200001];
            hs = new HashMap<Integer,Integer>(1024);
        }

        public boolean insert(int val) {
            if(hs.containsKey(val)){
                return false;
            }
            arr[++idx] = val;
            hs.put(val,idx);
            return true;
        }

        public boolean remove(int val) {
            if (!hs.containsKey(val)) {
                return false;
            }
            Integer remove = hs.remove(val);
            hs.put(arr[idx--],remove);
            arr[remove] = arr[idx--];
            return true;
        }

        public int getRandom() {
            return arr[random.nextInt(idx+1)];
        }
    }

}
