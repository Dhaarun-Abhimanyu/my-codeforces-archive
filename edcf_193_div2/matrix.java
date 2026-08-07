package edcf_193_div2;
import java.util.*;
public class matrix {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            int a[] = new int[x];
            int b[] = new int[y];
            for(int j=0;j<x;j++){
                a[j] = sc.nextInt();
            }for(int j=0;j<y;j++){
                b[j] = sc.nextInt();
            }
            int row = Math.min(n,x), col = Math.min(m,y);
            int ind1 = 0, ind2 = 0;
            long sum = 0L;
            int maxn = n, maxm = m;
            //HashSet<Integer> used = new HashSet<>();
            int total = n+m-1;
            while(total > 0 && ind1 < x && ind2 < y){
                if(a[x-1-ind1] > b[y-1-ind2]){
                    if(maxn > 0){
                        sum += a[x-1-ind1];
                        maxn--; total--;
                    }
                    ind1++;
                }else if(a[x-1-ind1] < b[y-1-ind2]){
                    if(maxm > 0){
                        sum += b[y-1-ind2];
                        maxm--; total--;
                    }
                    ind2++;
                }else{
                    sum += a[x-1-ind1];
                    ind1++;
                    ind2++;
                    total--;
                }
            }
            while(total > 0 && ind1 < x){
                if(maxn <= 0){ break; }
                sum += a[x-1-ind1];
                ind1++; total--; maxn--;
            }while(total > 0 && ind2 < y){
                if(maxm <= 0){ break; }
                sum += b[y-1-ind2];
                ind2++; total--; maxm--;
            }
            
            /*
            long last = 0L;
            if(!used.contains(a[x-1-ind1])){ last = a[x-1-ind1]; }
            if(!used.contains(b[y-1-ind2])){ last = Math.max(last, b[y-1-ind2]); }
            
            sum += last;*/
            System.out.println(sum);
        }
    }
}


/*
long sum1 = a[x-1], sum2 = b[y-1];
            int num1 = a[x-1], num2 = b[y-1];
            int ind1 = 0, ind2 = 0;
            while(ind1 < y && ind1 < col){
                if(b[y-ind1-1] != num1){
                    sum1 += b[y-ind1-1];
                }
                ind1++;
            }while(ind2 < x && ind2 < row){
                if(a[x-ind2-1] != num2){
                    sum2 += a[x-ind2-1];
                }
                ind2++;
            }
            long ans = Math.max(sum1, sum2);
            System.out.println(ans); */