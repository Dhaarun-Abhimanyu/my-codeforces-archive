import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int neg = 0, pos = 0;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(arr[j] == -1){ neg++; }
                else{ pos++; }
            }
            if(n%2 != 0){
                System.out.println("NO");
            }else{
                if((n/2)%2 != 0 && neg%2 == 0){
                    System.out.println("NO");
                    continue;
                }
                if((n/2)%2 == 0 && neg%2 != 0){
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }

        }
    }
}