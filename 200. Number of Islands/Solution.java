class Solution {
	private int m, n;
	public int numIslands(char[][] grid) {
		/*
		https://leetcode.com/problems/number-of-islands/description/
		copy this idea https://aaronice.gitbooks.io/lintcode/content/graph_search/number_of_islands.html
		Find the first '1' in the 2d array. use the first '1' represent its island, increase the number of islands. 
		And then use dps to wipe out all the '1's in this island. Then find the next '1'. 
		做法是复制的上面链接。主要思想就是先找到第一个‘1’。用这个‘1‘代表这个岛，然后增加一个岛的个数（ans）。之后用dps遍历属于这个岛
		的所有’1‘，把他们变成’0‘。之后，继续寻找下一个’1‘，直到遍历这个2d数列。
		*/
		m = grid.length;
		if (m <= 0){
			return 0;
		}
		n = grid[0].length;
		if (n <= 0){
			return 0;
		}
		int ans = 0;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(grid[i][j] == '1'){
					ans++;
					dps(grid, i, j);
				}
			}
		}
		return ans;
	}

	public void dps(char[][] grid, int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
		if (grid[i][j] == '1'){
			grid[i][j] = '0';
			dps(grid, i - 1, j);
			dps(grid, i + 1, j);
			dps(grid, i, j + 1);
			dps(grid, i, j - 1);
		}
	}
}