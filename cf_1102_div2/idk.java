import java.util.*;
public class idk{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int j=n-3;j>=0;j--){
                if(arr[j+2]%arr[j+1] != arr[j]){
                    System.out.println("-1");
                    continue outer;
                }
            }
            System.out.println(arr[n-1]+" "+arr[n-2]);
        }
    }
}