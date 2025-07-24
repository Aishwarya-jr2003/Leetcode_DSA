class Solution {
    private long solve(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        long prev = arr[0];
        long prev2 = 0;

        for (int i = 1; i < n; i++) {
            long pick = arr[i];
            if (i > 1) pick += prev2;
            long nonPick = prev;

            long curr = Math.max(pick, nonPick);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Exclude first house
        int[] arr1 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr1[i - 1] = nums[i];
        }

        // Exclude last house
        int[] arr2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = nums[i];
        }

        long maxLoot = Math.max(solve(arr1), solve(arr2));
        return (int) maxLoot;
    }
}