package cf_1098_div2;
import java.util.*;
public class cirno {
    static boolean contains(int d, int d1, int d2){
        return d==d1 || d==d2;
    }

    static long rev(long a){
        long ret = 0L;
        while(a != 0){
            ret = ret*10L + a%10;
            a /= 10;
        }
        return ret;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            long a = sc.nextLong();
            int n = sc.nextInt(), d1 = sc.nextInt(), d2 = sc.nextInt();
            int max = Math.max(d1, d2);
            int min = Math.min(d1, d2);
            int len = Long.toString(a).length();
            long ans1 = 0L;
            for(int j=0;j<len-1;j++){
                ans1 = ans1*10L + (long)max;
            }
            ans1 = rev(ans1);
            long ans = Math.min(Math.abs(a-ans1), Math.abs(a-(ans1*10+max)));
            //System.out.println(ans1);
            ans1 = 0;
            for(int j=0;j<=len;j++){
                ans1 = ans1*10L + (long)min;
            }
            ans1 = rev(ans1);
            ans = Math.min(ans, Math.abs(a-ans1));
            //System.out.println(ans1);
            ans1=0;
            String num = Long.toString(a);
            int start = 0;
            for(int j=0;j<len;j++){
                int idk = num.charAt(j)-48;
                if(!contains(idk, d1, d2)){
                    start=j;
                    break;
                }
            }
            //System.out.println("start: "+start);
            int first = (int)Long.toString(a).charAt(start)-48;
            if(d1>=first){
                ans1 = 0;
                for(int j=start+1;j<len;j++){
                    ans1 = ans1*10+(long)min;
                }
            }else{
                ans1 = 0;
                for(int j=start+1;j<len;j++){
                    ans1 = ans1*10+(long)max;
                }
            }
            long ano1 = ans1*10 + max;
            long ano2 = ans1*10 + min;
            ans1 = ans1*10 + (long)d1;
            ano1 = ano1*10 + (long)d1;
            ano2 = ano2*10 + (long)d1;
            for(int j=start-1;j>=0;j--){
                ans1 = ans1*10 + (long)(num.charAt(j)-48);
                if(j>0){
                    ano1 = ano1*10 + (long)(num.charAt(j-1)-48);
                    ano2 = ano2*10 + (long)(num.charAt(j-1)-48);
                }
            }
            ans1 = rev(ans1);
            ano1 = rev(ano1);
            ano2 = rev(ano2);
            //System.out.println(ans1);
            ans = Math.min(ans, Math.abs(a-ans1));
            ans = Math.min(ans, Math.abs(a-ano1));
            ans = Math.min(ans, Math.abs(a-ano2));
            if(d2>=first){
                ans1 = 0;
                for(int j=start+1;j<len;j++){
                    //System.out.println("AAA");
                    ans1 = ans1*10+(long)min;
                }
            }else{
                ans1 = 0;
                for(int j=start+1;j<len;j++){
                    ans1 = ans1*10+(long)max;
                }
            }
            ano1 = ans1*10 + max;
            ano2 = ans1*10 + min;
            ans1 = ans1*10 + (long)d2;
            ano1 = ano1*10 + (long)d2;
            ano2 = ano2*10 + (long)d2;
            for(int j=start-1;j>=0;j--){
                ans1 = ans1*10 + (long)(num.charAt(j)-48);
                if(j>0){
                    ano1 = ano1*10 + (long)(num.charAt(j-1)-48);
                    ano2 = ano2*10 + (long)(num.charAt(j-1)-48);
                }
            }
            
            ans1 = rev(ans1);
            ano1 = rev(ano1);
            ano2 = rev(ano2);
            //System.out.println(ans1);
            ans = Math.min(ans, Math.abs(a-ans1));
            ans = Math.min(ans, Math.abs(a-ano1));
            ans = Math.min(ans, Math.abs(a-ano2));
            System.out.println(ans);
        }
    }
}
