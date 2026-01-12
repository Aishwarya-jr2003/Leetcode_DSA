A frog wants to climb a staircase with n steps.
Given an integer array heights, where heights[i]
contains the height of the ith step.
To jump from the ith step to the jth step,
the frog requires abs(heights[i] - heights[j]) energy, 
where abs() denotes the absolute difference. The frog can jump from any
step either one or two steps, provided it exists. Return the minimum 
amount of energy required by the frog to go from the 0th step to the (n-1)th step.


Examples:
Input: heights = [2, 1, 3, 5, 4]

Output: 2

Explanation: One possible route can be,

0th step -> 2nd Step = abs(2 - 3) = 1

2nd step -> 4th step = abs(3 - 4) = 1

Total = 1 + 1 = 2.




class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(stones[i] - stones[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(stones[i] - stones[i - 2]);
            }

            int curi = Math.min(fs, ss);
            prev2 = prev;
            prev = curi;
        }

        return prev;
    }
}
