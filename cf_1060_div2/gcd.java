package cf_1060_div2;
import java.io.*;
import java.util.*;

public class gcd {
    static int cap = 2*100000+1;
    static boolean sieve[];
    static void build_sieve(){
        sieve = new boolean[cap];
        for(int i=2;i<cap;i++){
            if(!sieve[i]){
                for(int j=i*i;j<cap;j++){
                    sieve[j] = true;
                }
            }
        }
    }
    static void too_great(int n, int arr[]){
        int odd = 0, even=0;
        int[] map = new int[cap];
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(arr[i], max);
            map[arr[i]]++;
            if(arr[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }
        int ret = 2;
        if(even >= 2){
            System.out.println(0);
            return;
        }else if(odd >= 1 && even >= 1){
            ret = 1;
        }
            for(int i=3;i<=max;i+=2){
                int yes=0, close=0,j=i;
                if(!sieve[i]){
                    for(j=i; j<=max+i;j+=i){
                        yes+=map[j];
                        close+=map[j-1];
                    }
                }
                if(yes>=2){
                    System.out.println(0);
                    return;
                }else if(yes >= 1 && close >= 1){
                    ret = 1;
                }
            }
            System.out.println(ret);
    }
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        build_sieve();
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            br.readLine();
            too_great(n, arr);
        }
    }
}
