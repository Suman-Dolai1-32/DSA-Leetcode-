class Solution {
    public static boolean valid(int row,int col,int n,int m)
    {
        if (row < 0 || row >= n || col < 0 || col >= m)
            return false;
        return true;
    }
    public static void DFS(char[][] board,int i,int j,int n,int m,int x[],int y[])
    {
        board[i][j] = 'B';
        for(int k = 0;k<4;k++)
        {
            int row = i + x[k];
            int col = j + y[k];
            if(valid(row,col,n,m) && board[row][col] == 'O')
                DFS(board,row,col,n,m,x,y);
        }
    }
    public void solve(char[][] board) {
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1)
                {
                    if(board[i][j] == 'O')
                        DFS(board,i,j,n,m,x,y);
                }
            }
        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'B')
                    board[i][j] = 'O';
            }
        }
    }
}