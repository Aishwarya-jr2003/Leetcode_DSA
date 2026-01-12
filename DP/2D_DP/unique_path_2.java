class Solution {

    static int f(int i,int j,int[][]obstacleGrid,int[][] dp){
        // if thers an obstacle at this cell or out of bounds,
        //return 0
        if(i>=0 && j>= 0 && obstacleGrid[i][j] == 1) return 0;
        // if weve reached the start cell theres one valid path 
        if(i==0 && j== 0) return 1;
        // if we r out of bounds return 0;
        if(i<0 || j<0) return 0;
        // if weve already calculated this cell return the stored result 
        if (dp[i][j] !=  -1) 
        return dp[i][j];

        int up = f(i-1,j,obstacleGrid,dp);
        int left = f(i,j-1,obstacleGrid,dp);

        return dp[i][j] = up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];
        // intialize the dp array with -1;
        for(int row[]:dp)
        Arrays.fill(row,-1);

        return f(n-1,m-1,obstacleGrid,dp);

        
    }
}

// Tabulation :
class Solution {

    static int f(int n,int m,int[][]maze,int[][] dp){
       for(int i=0;i<n;i++){
        for(int j = 0;j<m;j++){
            //base conditions 
            if(maze[i][j] == 1){
                dp[i][j] = 0;
                continue;
            }
            if(i== 0 && j == 0){
                dp[i][j] = 1;// there's one valid path to start cell
                continue;
            }
            int up = 0;
            int left = 0;
            // chck if moving up is possible 
            if(i>0) up = dp[i-1][j];
            //check if moving left is possible 
            if(j>0)
            left = dp[i][j-1];
            //calculate the number of paths by adding paths from above and from left
            dp[i][j] = up+left;
        }
       }
       return dp[n-1][m-1];
        
    }

   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];
        // intialize the dp array with -1;
        for(int row[]:dp)
        Arrays.fill(row,-1);

        return f(n,m,obstacleGrid,dp);

        
    }
}

// space optimization 
