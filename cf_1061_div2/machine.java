package cf_1061_div2;
import java.util.*;
public class machine {
    static void calc(int n, String s, int q, int[] query){
        if(s.indexOf('B') == -1){
            for(int i: query){
                System.out.println(i);
            }
        }else{
            for(int i: query){
                int time = 0,ind=0;
                while(i > 0){
                    if(s.charAt(ind)=='A'){
                        i--;
                    }else{
                        i/=2;
                    }
                    time++;
                    ind = (ind+1)%n;
                }
                System.out.println(time);
            }
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), q = sc.nextInt();
            int query[] = new int[q];
            String mac = sc.next();
            for(int j=0;j<q;j++){
                query[j] = sc.nextInt();
            }
            calc(n, mac, q, query);
        }
    }
}
