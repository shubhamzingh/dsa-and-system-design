package dsa.leetcode.backtracking;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        Boolean[][] visited = new Boolean[m][n];

        return dfs(0,0,m,n,visited);
    }

    int dfs(int i, int j, int m, int n, Boolean[][] visited){
        if(i>= m || j>=n) {
            // || (i<m && j< n && visited[i][j]==true)
            //visited[i][j]=false;
            return 0;
        }

        if(visited[i][j]!=null && visited[i][j]==true){
            visited[i][j]=false;
            return 0;
        }

        visited[i][j]=true;
        if(i==m-1 && j== n-1){
            visited[i][j]=false;
            return 1;
        }

        //move right
        int rc= dfs(i+1,j,m,n,visited);
        int dc = dfs(i,j+1,m,n,visited);

        //visited[i][j]=false;
        return  rc+dc;

    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        u.uniquePaths(19,13);
    }
}
