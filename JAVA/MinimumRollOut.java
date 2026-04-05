import java.util.PriorityQueue;

public class MinimumRollOut {
    public static void main(String[] args) {
        int[] arr={5,3,2,6};
        System.out.println(minCost(arr));
        
    }
    public static int minCost(int[] arr) {
        int tsum = 0; // total sum (total cost)
    
    // Step 1: Put all elements into a min-heap (priority queue)
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    for (int cost : arr) {
        pQueue.add(cost);
    }

    // Step 2: While more than one element remains in the heap
    while (pQueue.size() > 1) {
        // Remove the two smallest costs
        int first = pQueue.poll();
        int second = pQueue.poll();

        // Merge them → new cost
        int sum = first + second;

        // Add this merge cost to total
        tsum += sum;

        // Put the merged cost back into the heap
        pQueue.add(sum);
    }

    return tsum; // minimum total cost
    }
}
