package edcf_186_div2;
import java.util.*;
public class cakelayer {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int a = sc.nextInt(), b = sc.nextInt();
            int max = 0,num=1,j=0;
            int tempa = a, tempb = b;
            while(true){
                if(j%2==0){
                    a -= num;
                    if(a < 0){ break; }
                }else{
                    b -= num;
                    if(b < 0){ break; }
                }
                max++;
                num *= 2;
                j++;
            }
            int count = 0;
            num = 1; j=0;
            while(true){
                if(j%2==0){
                    tempb -= num;
                    if(tempb < 0){ break; }
                }else{
                    tempa -= num;
                    if(tempa < 0){ break; }
                }
                count++;
                num *= 2;
                j++;
            }
            System.out.println(Math.max(max, count));
        }
    }
}
