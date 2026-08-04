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
            List<Integer> neg = new ArrayList<>();
            for(int j=0;j<n;j++){
                b[j] = sc.nextInt();
                if(b[j] > 0){
                    pos.add(b[j]);
                }else{
                    neg.add(b[j]);
                }
            }
            int posSize = pos.size(), negSize = neg.size();
            if(posSize == 0){
                System.out.println("-1");
                continue outer;
            }
            Collections.sort(pos);
            Collections.sort(neg);
            long res[] = new long[n];
            res[0] = pos.get(0);
            long curr = res[0];
            int posind = 1;
            //System.out.println(pos+"\n"+neg);
            for(int j=1;j<n;j++){
                int hmmind = -1;
                long tobeadded = 0;
                for(int k=0;k<neg.size();k++){
                    if(curr > -neg.get(k)){
                        hmmind = k;
                        break;
                    }
                }
                if(hmmind != -1){
                    tobeadded = neg.get(hmmind);
                    neg.remove(hmmind);
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
