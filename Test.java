牛牛在一个迷宫中，迷宫有 nn 个格子，有 mm 条通道，每条通道连接两个格子 uu, vv，编号为 uu 的格子与编号为 vv 的格子可互相到达，
每人每条通道只能走一次。

牛牛想知道，他是否能从 11 号格子出发回到 11 号格子。
import java.util.*;

/*
 * public class Point {
 *   int x;
 *   int y;
 * }
 */

public class Solution {
    /**
     * 能回到1号点返回 Yes，否则返回 No
     * @param param int整型一维数组 param[0] 为 n，param[1] 为 m
     * @param edge Point类一维数组 Point.x , Point.y 分别为一条边的两个点
     * @return string字符串
     */
    int[] arr;
    public String solve (int[] param, Point[] edge) {
        // write code here
        int n=param[0];
        int m=param[1];
        if(m==0) return "No";
        int num=0;
        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=i;
        }
        
        for(Point p:edge){
            if(p.x==1||p.y==1){
                num++;
            }else{
                union(p.x,p.y);
            }
        }
        
        for(int i=0;i<num-1;i++){
            for(int j=i+1;j<num;j++){
                if(union(i,j)){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    private int find(int x){
        while(arr[x]!=x){
            //x=arr[x];
            arr[x]=arr[arr[x]];
            x=arr[x];
        }
        return x;
    }
    
    private boolean union(int x,int y){
        int a=find(x);
        int b=find(y);
        if(a!=b){
            arr[a]=b;
            return false;
        }
        return true;
    }
}