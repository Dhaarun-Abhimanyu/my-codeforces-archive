package cf_1090_div4;
import java.util.*;
public class tree {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int x = sc.nextInt(), y = sc.nextInt();
            int total = x+y;
            boolean odd_root = false;
            odd_root = total%2 != 0;
            double check = 0.0;
            if(odd_root){
                check = (3*x - (y-1)) / 2.0;
            }else{
                check = (3*x - y) / 2.0;
            }
            boolean pow_2 = ((y+1) & y) == 0;
            if(x>y || check != (double)((int)check) || (x==0 && !pow_2)){
                System.out.println("NO");
                continue;
            }
            if(x==0){
                System.out.println("YES");
                for(int j=1;j<=y/2;j++){
                    System.out.println(j+" "+2*j);
                    System.out.println(j+" "+(2*j+1));
                }
                continue;
            }
            int my_x = (int)check;
            int curr = 1;
            int next = 2;
            int my_y = x-my_x; 
            List<int[]> list = new ArrayList<>();
            for(int j=0;j<my_y+1;j++){
                list.add(new int[]{curr, next++});
            }
            int y_end = next-1;
            int single_line = 2;
            if(odd_root){
                my_x = 2*my_x - 1;
            }else{
                my_x = 2*(my_x-1);
            }
            for(int j=0;j<my_x;j++){
                list.add(new int[]{single_line, next});
                single_line = next;
                next++;
            }
            for(int j=3;j<=y_end;j++){
                int next_1 = next+1;
                int next_2 = next+2;
                list.add(new int[]{j, next});
                list.add(new int[]{next, next_1});
                list.add(new int[]{next, next_2});
                next = next_2+1;
            }
            System.out.println("YES");
            for(int j[]: list){
                System.out.println(j[0]+" "+j[1]);
            }
        }
    }
}
