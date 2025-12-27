
import java.util.*;
public class sus {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String s = sc.next();
            char[] str = s.toCharArray();
            int n = s.length(),count=0;
            outer:
            for(int j=0;j<n;j++){
                if(str[j]=='u'){
                    int left = j-1,right=j+1;
                    while(left >= 0 && right <n){
                        if(str[left]=='s' && str[right]=='s'){
                            continue outer;
                        }else if (str[left]=='s') {
                            str[right] = 's';
                            count++;
                            continue outer;
                        }else if (str[right]=='s') {
                            str[left] = 's';
                            count++;
                            continue outer;
                        }else{
                            left--;
                            right++;
                        }
                    }
                    str[j] = 's';
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
