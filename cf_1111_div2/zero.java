package cf_1111_div2;
import java.util.*;
public class zero {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int first[] = new int[n];
            int second[] = new int[n];
            boolean cor1 = true, cor0 = true, zeroto0 = false, zeroto1 = false, oneto1 = false;
            int onecount = 0,total1=0;
            for(int j=0;j<n;j++){
                first[j] = sc.nextInt();
                if(first[j]==1){total1++;}
            }for(int j=0;j<n;j++){
                second[j] = sc.nextInt();
                if(first[j] == 1 && second[j] == 1){
                    oneto1 = true;
                }
                if(first[j] == 1 && second[j] == 0){
                    cor1 = false;
                    onecount++;
                }else if(first[j] == 0 && second[j] == 0){
                    zeroto0 = true;
                }else if(first[j] == 0 && second[j] == 1){
                    cor0 = false;
                    zeroto1 = true;
                }
            }
            if(cor1 && cor0){
                System.out.println("0");
            }else if(cor0){
                if(onecount % 2 != 0){
                    System.out.println("1");
                }else{
                    System.out.println("2");
                }
            }else{
                if(total1==0){
                    System.out.println("-1");
                }
                else if(!zeroto0 && cor1 && zeroto1){
                    System.out.println("-1");
                }else{
                    if(!cor1){
                        if(onecount % 2 != 0){
                            System.out.println("1");
                        }else{
                            System.out.println("2");
                        }
                    }
                    else{
                        System.out.println("2");
                    }
                }
            }
        }
    }
}
