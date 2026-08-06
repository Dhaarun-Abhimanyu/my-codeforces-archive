package cf_1114_div3;
import java.util.*;
public class chrono {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int b[] = new int[n];
            List<Integer> pos = new ArrayList<>();
            TreeMap<Long, Integer> neg = new TreeMap<>();
            for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
                if(b[j] > 0){
                    pos.add(b[j]);
                }else{
                    neg.put((long)b[j], neg.getOrDefault((long)b[j], 0)+1);
                }
            }
            int posSize = pos.size(), negSize = neg.size();
            if(posSize == 0){
                System.out.println("-1");
                continue outer;
            }
            Collections.sort(pos);
            //Collections.sort(neg);
            long res[] = new long[n];
            res[0] = pos.get(0);
            long curr = res[0];
            int posind = 1;
            //System.out.println(pos+"\n"+neg);
            for(int j=1;j<n;j++){
                //long hmmind = neg.higherKey(curr);
                long tobeadded = 0;
                if(neg.higherKey(-curr) != null){
                    tobeadded = neg.higherKey(-curr);
                    neg.put(tobeadded, neg.get(tobeadded)-1);
                    if(neg.get(tobeadded)==0){
                        neg.remove(tobeadded);
                    }
                }else{
                    if(posind >= posSize){
                        System.out.println("-1");
                        continue outer;
                    }
                    tobeadded = pos.get(posind++);
                }
                res[j] = curr + tobeadded;
                curr = res[j];
            }
            for(long j: res){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
