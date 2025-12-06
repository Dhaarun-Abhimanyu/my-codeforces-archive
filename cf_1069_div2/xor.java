package cf_1069_div2;
import java.util.*;
public class xor {
    static void calc(int n, int l, int r){
        int prefix[] = new int[n+1];
        prefix[0] = 0;
        int check = 0,count=1;
        //HashSet<Integer> map = new HashMap<>();
        for(int i=0;i<=n;i++){
            if(i==l-1){ check = count; }
            if(i==r){
                prefix[i] = check;
                //System.out.print(prefix[i]+" ");
                continue;
            }
            prefix[i] = count++;
            //System.out.print(prefix[i]+" ");
        }
        //System.out.println();
        int a[] = new int[n];
        for(int i=1;i<=n;i++){
            a[i-1] = prefix[i] ^ prefix[i-1];
            System.out.print(a[i-1]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
            calc(n,l,r);
        }
    }
}
