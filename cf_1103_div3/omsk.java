package cf_1103_div3;
import java.util.*;
public class omsk {/*
    static int x1;
    static HashMap<Integer, HashMap<Integer, Integer>> dp;

    
    static int rec(int a, int b){
        if(a==b){
            return 0;
        }if(dp.containsKey(a) && dp.get(a).containsKey(b)){
            return dp.get(a).get(b);
        }
        if(!dp.containsKey(a)){
            dp.put(a, new HashMap<>());
        }
        int ans1 = 1000000, ans2 = 1000000;
        int diff = Math.abs(a-b);
        if(a != 0){ ans1 = rec(a/x1, b); }
        if(b != 0){ ans2 = rec(a, b/x1); }
        dp.get(a).put(b,Math.min(diff, 1+Math.min(ans1, ans2)));
        return dp.get(a).get(b);
    }*/
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt(), b = sc.nextInt(), x = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            arr.add(a); brr.add(b);
            while(a != 0){
                arr.add(a/x);
                a/=x;
            }while(b != 0){
                brr.add(b/x);
                b /= x;
            }
            int ans = Integer.MAX_VALUE;
            int k=0;
            for(int l1: arr){
                int h=0;
                for(int l2: brr){
                    ans = Math.min(ans, Math.abs(l1-l2)+k+h);
                    h++;
                }
                k++;
            }
            System.out.println(ans);
        }
    }
}
