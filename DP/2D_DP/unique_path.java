//memoization :


class Solution {

    static int countWaysUtil(int i ,int j,int[][]dp){
        // if we reach the starting cell(0,0) there one to reach it .
        if(i==0 && j == 0){
            return 1;
        }
        //If we go out of bounds ,thers no way to reach the cell
        if(i<0 || j<0){
            return 0;
        }
        // if the value for this cell is already computed return t 
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = countWaysUtil(i-1,j,dp);
        int left = countWaysUtil(i,j-1,dp);
        // Store the result in the dp array and return it 
        return dp[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {
        // CREATE a 2 d rray to store the results 
        int dp[][] = new int[m][n];

        //initialize the dp array with -1 to indicate the uncoputed value s
        for(int[] row:dp)
        Arrays.fill(row,-1);

        //start the recursive calculation from bottom right cell(m-1,n-1)
        return countWaysUtil(m-1,n-1,dp);
        
    }
}

// tabulation : 
class Solution {

    static int countWaysUtil(int m, int n, int[][] dp) {

        // loop through each cell in the grid 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                // calculate the number of ways by moving
                // up(if possible) and left (if possible)

                if(i>0)
                up = dp[i-1][j];
                if(j >0)
                left = dp[i][j-1];
                // store the total number of ways to reach 
                //the current cell in dp array 
                dp[i][j] = up+left;
            }
        }
      
        return dp[m-1][n-1] ;
    }

    public int uniquePaths(int m, int n) {
        // CREATE a 2 d rray to store the results 
        int dp[][] = new int[m][n];

        //initialize the dp array with -1 to indicate the uncoputed value s
        for (int[] row : dp)
            Arrays.fill(row, -1);

        //start the recursive calculation from bottom right cell(m-1,n-1)
        return countWaysUtil(m, n, dp);

    }
}


