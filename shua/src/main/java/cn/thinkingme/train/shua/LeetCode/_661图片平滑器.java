package cn.thinkingme.train.shua.LeetCode;

import java.util.Arrays;

/**
 * <p>
 * 661. 图片平滑器
 * </p>
 *
 * @author: huige
 * @date: 2022/3/24 16:03
 */
public class _661图片平滑器 {
    private static int[][]des  = new int[][]{{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}})));
    }

    public static int[][] imageSmoother(int[][] img) {
        int[][] newArr = new int[img.length][img[0].length];
        for (int y = 0; y < img.length; y++) {
            for (int x = 0; x < img[y].length; x++) {
                newArr[y][x] = countAvg(img,x,y);
            }
        }
        return newArr;
    }

    private static int countAvg(int[][] img, int x, int y) {
        int total = img[y][x],count = 1;
        for (int i = 0; i < des.length; i++) {
            int tmpX = x+des[i][0];
            int tmpY = y+des[i][1];
            if(tmpX>=0&& tmpX<img[0].length && tmpY>=0&& tmpY<img.length){
                total += img[tmpY][tmpX];
                count++;
            }
        }
        return Math.floorDiv(total,count);
    }
}
