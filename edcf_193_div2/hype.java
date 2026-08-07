package edcf_193_div2;
import java.util.*;
public class hype {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            int count = 0;
            boolean swap = false;
            int prev = arr[0],prevind=0;
            int swapind = -1;
            int orig[] = arr.clone();
            for(int j=1;j<n;j++){
                if(arr[j] == prev){
                    count++;
                    //System.out.println(arr[j]+" "+prev);
                    if(!swap){
                    if((j <= n-3 && prev != arr[j+1] && arr[j] != arr[j+2])
                        || (j == n-2 && prev != arr[j+1]) ){
                    //System.out.println(arr[j]+" "+prev);
                        swap = true;
                        swapind = j;
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        prev = arr[j];
                        prevind = j;
                        
                    }else if((prevind >= 2 && arr[prevind-2] != arr[prevind] && arr[prevind-1] != arr[j])
                        || (prevind == 1 && arr[prevind-1] != arr[j]) ){
                            swap = true;
                            swapind = j;
                            int temp = arr[prevind];
                            arr[prevind] = arr[prevind-1];
                            arr[prevind-1] = temp;
                            prev = arr[j];
                            prevind = j;
                        }
                    }
                }else{
                    prev = arr[j];
                    prevind = j;
                }
            }
            
            if(swap){ count--; }
            for(int j=1;j<n-2;j++){
                if(orig[j]==orig[j-1] && orig[j+1]==orig[j+2] && orig[j] != orig[j+1]){
                    if(swapind != j){
                        count--;
                    }
                    break;
                }
            }
            System.out.println(n-count);
        }
    }
}
