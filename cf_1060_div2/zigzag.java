package cf_1060_div2;
import java.util.*;
/*
 3
5
1 4 2 5 3
4
3 3 2 1
5
6 6 6 6 6

 */
public class zigzag {
    static void zig(int n, int arr[]){
        int max = arr[0],prevmax = arr[0];
        int ret = 0;
        for(int i=0;i<n-1;i++){
            max = Math.max(max, arr[i+1]);
            if(i>0){
                prevmax = Math.max(prevmax, arr[i-1]);
            }
            if(i%2==0){
                int temp = Math.max(0, arr[i]-max+1);
                ret += Math.max(0, arr[i]-max+1);
                if(i>0){
                    ret += Math.max(0, arr[i]-prevmax+1-temp);
                }
            }
        }
        if((n-1)%2==0){
            ret += Math.max(0, arr[n-1]-Math.max(prevmax, arr[n-2])+1);
        }
        System.out.println(ret);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            zig(n, arr);
        }
    }
}
