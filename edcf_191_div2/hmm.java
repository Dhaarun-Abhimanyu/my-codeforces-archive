package edcf_191_div2;
import java.util.*;
public class hmm {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            if(n==2){
                System.out.println("1 2 1 2 2 1 1 2");
                continue;
            }if(n==3){
                System.out.println("1 1 2 1 2 3 1 3 2 2 3 3");
                continue;
            }/*if(n==4){
                System.out.println("1 4 3 4 4 3 3 1 2 1 2 3 4 2 2 1");
                continue;
            }*/
            for(int j=1;j<=n;j++){
                for(int start=0;start<2;start++){
                    System.out.print(j+" ");
                }
            }
            for(int start=0;start<2;start++){
                for(int j=1;j<=n-2;j++){
                    if(start==0 && j >= n-1){ continue; }
                    System.out.print(j+" ");
                }
                System.out.print(n+" "+(n-1)+" ");
            }
            //System.out.print(n+" "+(n-1)+" "+(n-2));
            System.out.println();
        }
        
    }
}
