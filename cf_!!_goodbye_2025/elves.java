
import java.util.*;

public class elves {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt(), m=sc.nextInt();
            
            int arr[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                arr[j] = sc.nextInt();
                map.put(arr[j], j+1);
            }
            if(m>n/2){
                System.out.println("-1");
                continue;
            }
            Arrays.sort(arr);
            if(m==0){
                if(arr[0] < arr[n-1]-arr[n-2]){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(n-1);
                for(int j=1;j<n-1;j++){
                    System.out.println(map.get(arr[j+1])+" "+map.get(arr[j]));
                }
                System.out.println(map.get(arr[0])+" "+map.get(arr[n-1]));
            }else{
            System.out.println(n-m);
            for(int j=0;j<n-m;j++){
                System.out.println(map.get(arr[j+m])+" "+map.get(arr[j]));
            }}
            // 1 2 3 4
            /*
            HashMap<Integer, Integer> map = new HashMap<>();
            long arr[] = new long[n];
            PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> Long.compare(arr[a], arr[b]));
            PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Long.compare(arr[b], arr[a]));
            
            for(int j=0;j<n;j++){
                arr[j] = sc.nextLong();
                minheap.offer(j);
                maxheap.offer(j);
                map.put(j, 1);
            }
            int count=0;
            while(!maxheap.isEmpty() && !minheap.isEmpty()){
                int attacker = maxheap.poll();
                int rip = minheap.poll();
                if(arr[rip]==)
                arr[attacker] -= arr[rip];
                arr[rip] = Long.MAX_VALUE;
                count++;
            }
            Arrays.sort(arr);
            */
        }
    }
}
