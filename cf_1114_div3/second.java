package cf_1114_div3;

import java.util.*;

public class second {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String s = sc.next();
            int count = 1;
            boolean check1 = false, check2 = false;
            int temp = 1;
            for(int j=1;j<n;j++){
                char c = s.charAt(j);
                char prev = s.charAt(j-1);
                if(c != prev){
                    count++;
                    if(temp==1){
                        if(j != 1){
                            check1 = true;
                        }
                        if(j > 1 && s.charAt(j-2)==c){
                            check2 = true;
                            //System.out.print("aa");
                        }
                    }
                    temp=1;
                }else{
                    temp++;
                }
            }
            if(check1){
                count--;
            }if(check2){
                count--;
            }
            System.out.println(count);
        }
    }
}
