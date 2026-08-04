package cf_1114_div3;

import java.util.*;

public class third {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //HashMap<String, String> map = new HashMap<>();
        //map.put("")
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String b1 = sc.next(), b2 = sc.next();
            if(b1.equals(b2)){
                System.out.println("YES");
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
                System.out.println("NO");
                continue;
            }
            boolean odd = true, even = true;
            for(int j=0;j<n;j=j+2){
                if(a1[j]!=a2[j]){ even = false; }
            }for(int j=1;j<n;j=j+2){
                if(a1[j]!=a2[j]){ odd = false; }
            }
            for(int j=2;j<n;j=j+2){
                if(a1[j]!=a1[j-2]){ even = true; }
            }for(int j=3;j<n;j=j+2){
                if(a1[j]!=a1[j-2]){ odd = true; }
            }
            if(odd && even){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
