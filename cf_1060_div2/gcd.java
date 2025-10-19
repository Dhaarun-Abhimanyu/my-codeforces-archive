package cf_1060_div2;
import java.util.*;

public class gcd {
    static boolean sieve[] = new boolean[2*100000+1];
    static void build_sieve(){
        for(int i=2;i<2*100000+1;i++){
            if(!sieve[i]){
                for(int j=i*i;j<2*100000+1;j++){
                    sieve[j] = true;
                }
            }
        }
    }
    static void too_great(int n, int arr[]){
        int odd = 0, even=0;
        int[] map = new int[4*100000 + 5];
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
                int yes=0, close=0;
                if(!sieve[i]){
                    for(int j=i; j<=max+i;j+=i){
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
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        build_sieve();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            for(int j=0;j<n;j++){
                sc.nextInt();
            }
            too_great(n, arr);
        }
    }
}
