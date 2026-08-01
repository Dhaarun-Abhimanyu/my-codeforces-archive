import java.util.*;
public class first {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String s = sc.next();
            char[] bin = s.toCharArray();
            int ind0 = -1, ind1 = -1;
            for(int j=0;j<bin.length;j++){
                if(bin[j]=='1'){ ind1 = j; break;}
            }for(int j=0;j<bin.length;j++){
                if(bin[j]=='0'){ ind0 = j; break;}
            }
            String res = "";
            for(int j=0;j<bin.length;j++){
                if(j==ind1 || j==ind0){ continue; }
                res += bin[j];
            }
            System.out.println(res);
        }
    }
}