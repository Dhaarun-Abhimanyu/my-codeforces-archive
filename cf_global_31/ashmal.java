import java.util.*;
public class ashmal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.next();
            }
            //Arrays.sort(arr);
            StringBuilder str = new StringBuilder(arr[0]);
            for(int j=1;j<arr.length;j++){
                String s1 = str + arr[j];
                String s2 = arr[j] + str;
                if(s1.compareTo(s2) <= 0){
                    str = new StringBuilder(s1);
                }else{
                    str = new StringBuilder(s2);
                }
            }
            System.out.println(str);
        }
    }
}