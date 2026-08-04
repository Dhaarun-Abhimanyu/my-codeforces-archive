package cf_1114_div3;

import java.util.*;

public class marenol {
    static int firstOne(char[] a, int start){
        for(int j=start;j<a.length;j++){
            if(a[j]=='1'){
                return j;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //HashMap<String, String> map = new HashMap<>();
        //map.put("")
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String b1 = sc.next(), b2 = sc.next();
            if(b1.equals(b2)){
                System.out.println("0");
                continue;
            }
            char a1[] = b1.toCharArray(), a2[] = b2.toCharArray();
            int oneodd = 0, oneeven = 0, twoodd = 0, twoeven = 0;
            for(int j=0;j<n;j++){
                if(j%2==0){
                    if(a1[j]=='1'){ oneeven++; }
                    if(a2[j]=='1'){ twoeven++; }
                }else{
                    if(a1[j]=='1'){ oneodd++; }
                    if(a2[j]=='1'){ twoodd++; }
                }
            }
            if(oneodd != twoodd || oneeven != twoeven){
                System.out.println("-1");
                continue;
            }
            int half1 = n/2, half2 = n/2;
            if(n%2 != 0){
                half1++;
            }
            char oneoddarr[] = new char[half2];
            char twooddarr[] = new char[half2];
            char oneevenarr[] = new char[half1];
            char twoevenarr[] = new char[half1];
            
            boolean odd = true, even = true;
            int ind = 0;
            for(int j=0;j<n;j=j+2){
                if(a1[j]!=a2[j]){ even = false; }
                oneevenarr[ind] = a1[j];
                twoevenarr[ind++] = a2[j];
            }
            ind=0;
            for(int j=1;j<n;j=j+2){
                if(a1[j]!=a2[j]){ odd = false; }
                oneoddarr[ind] = a1[j];
                twooddarr[ind++] = a2[j];
            }
            for(int j=2;j<n;j=j+2){
                if(a1[j]!=a1[j-2]){ even = true; }
            }for(int j=3;j<n;j=j+2){
                if(a1[j]!=a1[j-2]){ odd = true; }
            }
            if(odd && even){
                //System.out.println("YES");
                long ans = 0L;
                int k = firstOne(oneoddarr, 0), l = firstOne(twooddarr, 0);
                while(k != -1 && l != -1){
                    ans += Math.abs((long)k-l);
                    k = firstOne(oneoddarr, k+1);
                    l = firstOne(twooddarr, l+1);
                }
                k = firstOne(oneevenarr, 0); l = firstOne(twoevenarr, 0);
                while(k != -1 && l != -1){
                    ans += Math.abs((long)k-l);
                    k = firstOne(oneevenarr, k+1);
                    l = firstOne(twoevenarr, l+1);
                }
                System.out.println(ans);
            }else{
                System.out.println("-1");
            }
        }
    }
}
