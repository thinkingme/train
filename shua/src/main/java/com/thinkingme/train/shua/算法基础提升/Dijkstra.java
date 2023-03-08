package com.thinkingme.train.shua.算法基础提升;

import java.util.Scanner;

public class Dijkstra {
    //不能设置为Integer.MAX_VALUE，否则两个Integer.MAX_VALUE相加会溢出导致出现负权
    public static int MaxValue = 100000;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入顶点数和边数:");
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();
 
        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }
 
        //单源最短路径，源点
        int source = input.nextInt();
        //调用dijstra算法计算最短路径
        dijstra(matrix, source);
    }
 
    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];
 
        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }
 
        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;
 
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
 
            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
 
            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;
 
            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }
 
        }
 
        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != source) {
                if (shortest[i] == MaxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + "的最短路径为：" + path[i] + "，最短距离是：" + shortest[i]);
                }
            }
        }
    }
}