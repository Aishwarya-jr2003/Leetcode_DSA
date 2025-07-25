A frog wants to climb a staircase with n steps. Given an integer array heights,
 where heights[i] contains the height of the ith step, and an integer k.

To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j])
 energy, where abs() denotes the absolute difference. The frog can jump 
 from the ith step to any step in the range [i + 1, i + k], provided it exists. 
 Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.




public class Main {
    // This function recursively calculates the maximum possible sum
    // by considering or not considering the current element.
    static int solveUtil(int ind, int[] arr, int[] dp) {
        // If the index is negative, there are no elements left to consider.
        if (ind < 0) return 0;
        
        // If the index is 0, there is only one element to consider, so return its value.
        if (ind == 0) return arr[ind];
        
        // If we have already calculated the result for this index, return it.
        if (dp[ind] != -1) return dp[ind];
        
        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = arr[ind] + solveUtil(ind - 2, arr, dp);
        int nonPick = solveUtil(ind - 1, arr, dp);
        
        // Store the maximum of the two options in the dp array for future reference.
        return dp[ind] = Math.max(pick, nonPick);
    }

    // This function initializes the dp array and calls the recursive solver.
    static int solve(int n, int[] arr) {
        int dp[] = new int[n];
        
        // Initialize the dp array with -1 to indicate that values are not calculated yet.
        Arrays.fill(dp, -1);
        
        // Call the recursive solver for the last index (n-1).
        return solveUtil(n - 1, arr, dp);
    }

    public static void main(String args[]) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};
        
        // Get the length of the array.
        int n = arr.length;
        
        // Call the solve function to find the maximum possible sum.
        int result = solve(n, arr);
        
        // Print the result.
        System.out.println(result);
    }
}
