package cf_1083_div2;
import java.util.Scanner;
public class simon {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int max = 0,max_ind=0,ugly=-1,ugly_ind=-1;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(max < arr[j]){
                    max = arr[j];
                    max_ind = j;
                }
                if(ugly==-1){
                    if(j+1==max){
                        ugly = 0;
                        ugly_ind = j;
                    }
                }
            }
            //System.out.println(max_ind+" "+ugly_ind);
            if(ugly != -1 && ugly_ind != n-1){
                int temp = arr[ugly_ind];
                arr[ugly_ind] = max;
                arr[max_ind] = temp;
            }
            for(int j=0;j<n;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }
}
