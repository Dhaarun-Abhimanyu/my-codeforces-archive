package cf_1114_div3;
import java.util.*;
public class silhoutte {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long b[] = new long[n];
            List<long[]> freq = new ArrayList<>();
            int ind = 0;
            long max = 0;
            HashMap<Long, Integer> index = new HashMap<>();
            for(int j=0;j<n;j++){
                b[j] = sc.nextLong();
                if(index.containsKey(b[j])){
                    int idk = index.get(b[j]);
                    freq.get(idk)[1]++;
                }else{
                    freq.add(new long[]{b[j], 1});
                    index.put(b[j], ind);
                    ind++;
                }
            }
            Collections.sort(freq, (a,bitch) -> Long.compare(a[0], bitch[0]));
            if(freq.get(0)[0] != 0){
                System.out.println("-1");
                continue;
            }
            long sum = 0L;
            HashMap<Long, Long> answer = new HashMap<>();
            for(int j=1;j<freq.size();j++){
                long currnum = freq.get(j)[0] - sum;
                long prevfreq = freq.get(j-1)[1];
                long prevnum = freq.get(j-1)[0];
                if(currnum%prevfreq != 0){
                    System.out.println("-1");
                    continue outer;
                }
                long num = currnum / prevfreq;
                if(num <= max){
                    System.out.println("-1");
                    continue outer;
                }
                max = num;
                sum += prevfreq * num;
                answer.put(prevnum, num);
            }
            answer.put(freq.get(freq.size()-1)[0], max+1);
            //long res[] = new long[n];
            for(int j=0;j<n;j++){
                System.out.print(answer.get(b[j])+" ");
            }
            System.out.println();
        }
    }
}
