package cf_idk_dv2;
import java.util.*;

public class angel_beats {
    /*static boolean sieve[];
    static void calc_sieve(int n){
        sieve = new boolean[n+1];
        for(int i=2;i<)
    }*/
    //static HashMap<Integer, Integer> map = new HashMap<>();
    static void calc(int n, int k, List<Integer> a, HashMap<Integer, Integer> map){
        Collections.sort(a);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        HashMap<Integer, Integer> vis = new HashMap<>();
        outer:
        for(int i=0;i<n;i++){
            int temp = 0;
            if(vis.containsKey(a.get(i))){ continue; }
            if(k/a.get(i) > n){ continue; }
            int curr = a.get(i);
            for(int j=a.get(i); j <= k; j+=a.get(i)){
                //System.out.print(j+" ");
                if(!map.containsKey(j)){ continue outer; }
                if(!vis.containsKey(j)){ temp++; }
            }
            for(int j=a.get(i); j <= k; j+=a.get(i)){
                vis.put(j, 0);
            }
            count += temp;
            res.add(a.get(i));
            if(count==n){ break; }
        }
        //System.out.println();
        if(count != n){ System.out.println("-1"); }
        else{
            System.out.println(res.size());
            for(int i: res){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                int temp = sc.nextInt();
                if(!map.containsKey(temp)){
                    a.add(temp);
                    map.put(temp, 0);
                }
            }
            //System.out.println(map);
            calc(a.size(), k, a, map);
        }
    }
}
