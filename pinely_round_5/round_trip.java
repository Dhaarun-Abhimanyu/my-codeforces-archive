package pinely_round_5;
import java.util.Scanner;

public class round_trip{
    static int calc(int R, int x, int d, int n, String rounds){
        int count = 0;
        for(int i=0;i<rounds.length();i++){
            char c = rounds.charAt(i);
            if(c=='1'){
                count++;
                R = Math.max(0, R-d);
            }else{
                if(R < x){ count++; }
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int R0 = sc.nextInt(), X = sc.nextInt(), D = sc.nextInt(), n = sc.nextInt();
            String rounds = sc.next();
            System.out.println(calc(R0, X, D, n, rounds));
        }
    }
}