class Solution {

  /*  public int minutil(int i, int j, List<List<Integer>> triangle, int n, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == n - 1) return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + minutil(i + 1, j, triangle, n, dp);
        int diagonal = triangle.get(i).get(j) + minutil(i + 1, j + 1, triangle, n, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }*/

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);

        }

        for(int i= n-2;i>= 0;i--){
            for(int j=i;j>= 0;j--){
                int down = triangle.get(i).get(j)+dp[i+1][j];
                int diagonal = triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j] = Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
}
