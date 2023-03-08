package com.thinkingme.train.shua.并查集;

import java.util.Scanner;

/**
 * @ProjectName: 题目代码
 * @Package: 并查集
 * @ClassName: 亲戚问题
 * @Author: huige
 * @Description:
 * 并查集加速有路径压缩和按秩合并的操作
 * 路径压缩：在查找时把节点的父节点都设置一下
 * 合并（路径压缩）
 * int find(int x)
 * {
 *     if(x == fa[x])
 *         return x;
 *     else{
 *         fa[x] = find(fa[x]);  //父节点设为根节点
 *         return fa[x];         //返回父节点
 *     }
 * }
 * 按秩合并：合并时记录合并次数，小者合并入大者
 * 初始化（按秩合并）
 * inline void init(int n)
 * {
 *     for (int i = 1; i <= n; ++i)
 *     {
 *         fa[i] = i;
 *         rank[i] = 1;
 *     }
 * }
 * 合并（按秩合并）
 * inline void merge(int i, int j)
 * {
 *     int x = find(i), y = find(j);    //先找到两个根节点
 *     if (rank[x] <= rank[y])
 *         fa[x] = y;
 *     else
 *         fa[y] = x;
 *     if (rank[x] == rank[y] && x != y)
 *         rank[y]++;                   //如果深度相同且根节点不同，则新的根节点的深度+1
 * }
 * @Date: 2021/10/9 9:27
 * @Version: 1.0
 */
public class 亲戚问题 {
    static int fa[] = new int[Integer.MAX_VALUE], rank[] = new int[Integer.MAX_VALUE];
    static void init(int n)
    {
        for (int i = 1; i <= n; ++i)
        {
            fa[i] = i;
            rank[i] = 1;
        }
    }
    //初始化（按秩合并）
    static int find(int x)
    {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));
    }
    //合并（按秩合并）
    static void merge(int i, int j)
    {
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y])
            fa[x] = y;
        else
            fa[y] = x;
        if (rank[x] == rank[y] && x != y)
            rank[y]++;
    }

    public static void main(String[] args) {
        int n, m, p, x, y;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
        init(n);
        for (int i = 0; i < m; ++i)
        {
            x= scanner.nextInt();y=scanner.nextInt();
            merge(x, y);
        }
        for (int i = 0; i < p; ++i)
        {
            x= scanner.nextInt();y=scanner.nextInt();
            System.out.println(find(x) == find(y) ? "Yes" : "No");
        }
    }
}
