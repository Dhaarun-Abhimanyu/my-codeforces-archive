package spectral_cup_cf_1100_1_2;
import java.util.*;
public class maxbutmin {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            long sum = 0L;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            int maxind = -1;
            long max = sum;
            long pos = 0L;
            long curr = 0L;
            //System.out.println(sum);
            for(int j=0;j<n;j++){
                if(arr[j] >= 0){
                    long temp = pos-arr[j]+(sum-curr-arr[j]);
                    if(temp > max){
                        max = temp;
                        maxind = j;
                    }
                    
                }
                pos += Math.abs(arr[j]);
                    curr += arr[j];
            }
            if(maxind == -1){
                System.out.println(0);
                System.out.println();
                continue;
            }
            //System.out.println(arr[maxind]);
            int lastneg = -1;
            if(arr[0] < 0){ lastneg = 0; }
            List<Integer> res = new ArrayList<>();
            for(int j=1;j<maxind;j++){
                if(arr[j] < 0 && arr[j-1] >= 0){
                    
                    res.add(j);
                    if(lastneg != -1){ res.add(lastneg+1); }
                    lastneg = j;
                }else if(arr[j] < 0){
                    lastneg = j;
                }
            }
            if(arr[maxind-1] > 0){
                
                res.add(maxind);
                if(lastneg != -1){ res.add(lastneg+1); }
            }
            res.add(maxind+1);
            System.out.println(res.size());
            for(int j=0;j<res.size();j++){
                System.out.print(res.get(j)+" ");
            }
            System.out.println();
        }
    }
}


/*
long sum = 0L;
            for(int j=1;j<n;j++){
                if(arr[j] <= 0){
                    sum += arr[j];
                }else{
                    System.out.println(sum+" "+arr[j]);
                    if(-arr[j] > sum){
                        if(lastpos != -1){ res.add(lastpos+1); }
                        res.add(j+1);
                        sum = -arr[j];
                        lastpos = j-1;
                    }else{
                        lastpos=j;
                        sum = 0L;
                    }
                }
            }*/
