package edcf_192_div2;
import java.util.*;
public class unstable {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            HashMap<Integer, Integer> freq = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                freq.put(arr[j], freq.getOrDefault(arr[j], 0)+1);
            }
            HashMap<Integer, Integer> freqfreq = new HashMap<>();
            for(int j: freq.keySet()){
                freqfreq.put(freq.get(j), freqfreq.getOrDefault(freq.get(j), 0)+1);
            }
            int total = freq.size();
            /*
            for(int j: freqfreq.keySet()){
                System.out.println(j+" "+freqfreq.get(j));
            }
            System.out.println("---");*/
            int tmp = n;
            int ans = 0;
            int fsize = freq.size();
            List<Integer> sortFreq = new ArrayList<>();
            for(int j: freq.keySet()){
                sortFreq.add(freq.get(j));
            }
            Collections.sort(sortFreq);
            long num[] = new long[n+1];
            for(int j=fsize-1;j>=0;j--){
                num[j] = num[j+1]+sortFreq.get(j);
            }
            //int ans=0;
            HashSet<Long> check = new HashSet<>();
            if(k >= n && (k-n)%freq.size()==0){ans++; check.add(0L+freq.size()); }
            for(int j=0;j<fsize;j++){
                if(j>0){
                    int one = sortFreq.get(j-1);
                    int two = sortFreq.get(j);
                    if(one==two){continue;}
                }
                int two = sortFreq.get(j);
                long count = fsize-j;
                long nm = num[j];
                if((k-nm)%count==0 && !check.contains(count) && two+ ((k-nm)/count) > 0){
                    check.add(count);
                    ans++;
                }
            }
            

            /*
            if(k >= n && (k-n)%freq.size()==0){ans++;check.add(freq.size());}
            while(!freq.isEmpty()){
                int count = 0;
                int num = 0;
                int fr = Integer.MAX_VALUE;
                int key = -1;
                for(int j: freq.keySet()){
                    if(freq.get(j) < fr){
                        fr = freq.get(j);
                        key = j;
                    }
                }
                int ch = freq.get(key);
                List<Integer> temp = new ArrayList<>(freq.keySet());
                for(int j: temp){
                    if(freq.get(j)==ch){
                        freq.remove(j);
                    }else{
                        freq.put(j, freq.get(j)-ch);
                        num += freq.get(j);
                        count += 1;
                    }
                }
                if(k >= num && count > 0 && (k-num)%count==0 && !check.contains(count)){
                    ans++;
                    check.add(count);
                }
            }*/
            System.out.println(ans);
        }
    }
}
