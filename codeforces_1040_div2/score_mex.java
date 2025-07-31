package codeforces_1040_div2;

import java.util.*;

public class score_mex {
    static Scanner sc = new Scanner(System.in);
    static void maxscore(){
        int zer = 0,one=0,sum=0;
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++){ 
            arr[i] = sc.nextInt();
            sum += arr[i];
            if(arr[i]==0){ sum += 1; }
        }
        System.out.println(sum);
    }
    public static void main(String args[]){
        
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            maxscore();
        }
    }
}
