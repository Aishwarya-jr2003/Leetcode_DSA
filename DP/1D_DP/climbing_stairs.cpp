class Solution {
    public int climbStairs(int n) {

             if(n == 0){
            return 0;

        }
        int prev2 = 1;
        int prev = 1;

        for(int i=2;i<=n;i++){
            int cur = prev+prev2;
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
        
    }
