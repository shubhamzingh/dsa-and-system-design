package dsa.leetcode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean[][] visited = new Boolean[m][n];
        Integer[][] memo = new Integer[m][n];
        return dfs(0,0,m,n,grid, visited, memo, 0);
    }

    int dfs(int i, int j, int m, int n, int[][] grid, Boolean[][] visited, Integer[][] memo, int pathSum){

        // out of bound
        if(i>= m || j>=n) {
            return Integer.MAX_VALUE;
        }

//        if(memo[i][j]!=null){
//            return memo[i][j];
//        }

        // if(visited[i][j]!=null && visited[i][j]==true){
        //     //visited[i][j]=false;
        //     return memo[i][j];
        //  }


        //last element
        if(i==m-1 && j== n-1){
            //visited[i][j]=false;
            return pathSum+grid[i][j];
        }

        //general calc
        visited[i][j]=true;
        int rc= dfs(i+1,j,m,n,grid,visited,memo,pathSum+grid[i][j]);
        int dc = dfs(i,j+1,m,n,grid,visited,memo,pathSum+grid[i][j]);
        visited[i][j]=false;

        return  Math.min(rc,dc);
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] arr = { {1,3,1},
                        {1,5,1},
                        {4,2,1} };
        System.out.println(mps.minPathSum(arr));
    }
}
