package cf_1084_div3;
import java.util.*;
public class portal {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt(), x=sc.nextInt(), y = sc.nextInt();
            int min=Integer.MAX_VALUE,min_index=-1;
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j>=x && j < y){
                    if(arr[j] < min){
                        min = arr[j];
                        min_index = j;
                    }
                }
            }
            LinkedList<Integer> res = new LinkedList<>();
            int ind = min_index;
            for(int j=x;j<y;j++){
                res.add(arr[ind]);
                ind++;
                if(ind==y){ind=x;}
            }
            int great_min=-1;
            for(int j=0;j<n;j++){
                if(j>=x && j < y){continue; }
                if(arr[j] < min){
                    great_min = j;
                }else{
                    break;
                }
            }
                LinkedList<Integer> temp = new LinkedList<>();
                for(int j=great_min;j>=0;j--){
                    if(j>=x && j < y){continue; }
                    res.addFirst(arr[j]);
                }
                for(int j=great_min+1;j<n;j++){
                    if(j>=x && j < y){continue; }
                    res.add(arr[j]);
                }
            for(int j: res){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

/*
if(arr[0] < arr[min_index]){
                LinkedList<Integer> temp = new LinkedList<>();
                for(int j=0;j<x;j++){
                    temp.addFirst(arr[j]);
                }
                int index = y;
                while(index < n && arr[index] < arr[min_index]){
                    temp.addFirst(arr[index++]);
                }
                for(int val: temp){
                    res.addFirst(val);
                }
                for(index=index;index<n;index++){
                    res.add(arr[index]);
                }
            }else{

            }
 */
