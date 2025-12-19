package cf_global_31;
import java.util.*;

public class xor {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), k=sc.nextInt();
            if(k%2!=0){
                for(int j=0; j<k;j++){
                    System.out.print(n+" ");
                }
            }else{
                for(int j=0; j<k-2;j++){
                    System.out.print(n+" ");
                }
                /*int temp = 1,count=0;
                while((n&temp) == 0){
                    temp = temp << 1;
                    count++;
                }
                int n1 = n - 1;
                int n2 = temp-1;
                if(n1+n2 > n){
                    System.out.print(n1+" "+n2);
                }else{
                    System.out.print(0+" "+n);
                }*/
                
                
                int bit32[] = new int[32];
                int temp = n,ind=0,first=0;
                while(temp != 0){
                    if(temp%2==1){ first = ind; }
                    bit32[ind] = temp%2;
                    temp/=2;
                    ind++;
                }
                int num1[] = new int[32];
                int num2[] = new int[32];
                int check=0,bit=1;
                boolean flag = false;
                for(int j=first;j>=0;j--){
                    if(check >= 2 || flag){ bit = 0;}
                    if(bit32[j]==1){
                        num1[j] = bit;
                        num2[j] = (bit+1)%2;
                        bit = (bit+1)%2;
                        check++;
                    }else{
                        if(check>=2){
                            num1[j] = 1;
                            num2[j] = 1;
                        }else{
                            flag = true;
                            num1[j] = 0;
                            num2[j] = 0;
                        }
                    }
                }
                int n1 = 0, n2=0;
                for(int j=31;j>=0;j--){
                    if(num1[j]==1){
                        n1 += Math.pow(2,j);
                    }
                    if(num2[j]==1){
                        n2 += Math.pow(2,j);
                    }
                }
                if(n1+n2 > n && n1 < n && n2 < n && n1 > 0 && n2 > 0){
                    System.out.print(n1+" "+n2);
                }else{
                    System.out.print(0+" "+n);
                }
                //System.out.print("\ncheck: "+n1+" "+n2);
            }
            System.out.println();
        }
    }
}
