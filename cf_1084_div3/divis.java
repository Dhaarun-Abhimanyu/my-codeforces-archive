package cf_1084_div3;
import java.util.*;
public class divis {
    static int max = 1000000;
    static int sieve[] = new int[max+1];
    static ArrayList<Integer> prime = new ArrayList<>();
    static void calcSieve(){
        for(int j=1;j<=max;j++){ sieve[j] = j; }
        for(int j=2;j*j<=max;j++){
            if(sieve[j]!=j){continue; }
            prime.add(j);
            for(int k=j*j;k<=max;k+=j){
                sieve[k] = j;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        calcSieve();
        outer:
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            boolean check = true;
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                if(j > 0 && arr[j] < arr[j-1]){ check = false; }
            }
            if(check){
                System.out.println("Bob");
                continue;
            }
            for(int j=0;j<n;j++){
                if(sieve[arr[j]] != arr[j]){
                    int prime = sieve[arr[j]];
                    int temp = arr[j];
                    while(temp%prime == 0){
                        temp /= prime;
                    }
                    if(temp > 1){
                        //System.out.println(prime+" "+temp+" "+arr[j]);
                        System.out.println("Alice");
                        continue outer;
                    }
                    arr[j] = prime;
                }
            }
            for(int j=1;j<n;j++){
                if(arr[j] < arr[j-1]){
                    System.out.println("Alice");
                    continue outer;
                }
            }
            System.out.println("Bob");
            continue outer;
        }
    }
}


/*
for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                int temp = arr[j];
                if(sieve[arr[j]]){
                    for(int k=2;k*k<=arr[j];k++){
                        if(arr[j]%k==0){
                            int other = arr[j]/k;
                            if(!sieve[other]){
                                temp = other;
                            }
                        }
                    }
                }
                arr[j] = temp;s
            }
            for(int j=0;j<n;j++){
                    System.out.print(arr[j]+" ");
            }
            System.out.println();
            for(int j=1;j<n;j++){
                if(arr[j] < arr[j-1]){
                    System.out.println("Alice");
                    continue outer;
                }
            }
            System.out.println("Bob");
*/