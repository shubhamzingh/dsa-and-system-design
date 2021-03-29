package amazon;

public class ServerCluster {

    public static int getNumberOfCluster(String[] grid, int rows){
        int res = 0;
        char[][] arr = new char[rows][];

        // converting string arr to 2d array for easier traversal
        for(int i=0; i< rows;i++){
            arr[i]=grid[i].toCharArray();
        }
         boolean[][] visited =  new boolean[rows][arr[0].length];

        for(int i=0;i<rows;i++){
            for(int j=0;j<arr[0].length;j++){
                if(visited[i][j]==false){
                    char clusterChar = arr[i][j];
                    dfs(arr, visited, i,j,rows,arr[0].length,clusterChar);
                    res++;
                }
            }
        }



        return res;
    }

    public static void dfs(char[][] arr, boolean[][] visited, int i, int j, int rows, int columns,char clusterChar){
        if(i<0 || j<0 || i>=rows || j>=columns || clusterChar!=arr[i][j] || visited[i][j]==true) return;
            visited[i][j]=true;
            dfs(arr, visited, i,j+1,rows,arr[0].length,clusterChar);
            dfs(arr, visited, i+1,j,rows,arr[0].length,clusterChar);
            dfs(arr, visited, i-1,j,rows,arr[0].length,clusterChar);
            dfs(arr, visited, i,j-1,rows,arr[0].length,clusterChar);
    }
    public static void main(String[] args) {
        String[] arr = {"aabba","aabba","aaacb"};
        System.out.println(getNumberOfCluster(arr,3));
    }
}
