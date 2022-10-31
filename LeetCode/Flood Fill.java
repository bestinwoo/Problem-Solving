//LeetCode Invert Binary Tree
// Definition for a binary tree node.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//LeetCode Flood Fill
class Solution {
	int[] dx = {0,0,-1,1};
	int[] dy = {-1,1,0,0};
	int target;
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		target = image[sr][sc];
		if(target == color) return image;
		dfs(image, sr, sc, color);
		return image;
	}
	public void dfs(int[][] image, int y, int x, int color) {
		image[y][x] = color;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= image[y].length || ny < 0 || ny >= image.length) continue;
			if(image[ny][nx] == target) {
				dfs(image, ny, nx, color);
			}
		}
	}
}
