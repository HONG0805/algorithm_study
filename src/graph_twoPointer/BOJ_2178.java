package graph_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int n, m;
	static int[][] maze;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = line.charAt(j) - '0';
				dist[i][j] = -1;
			}
		}
		bfs(0, 0);

		System.out.print(dist[n - 1][m - 1] + 1);
	}

	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { startX, startY });

		dist[startX][startY] = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}

				if (maze[nextX][nextY] == 0) {
					continue;
				}

				if (dist[nextX][nextY] != -1) {
					continue;
				}

				dist[nextX][nextY] = dist[curX][curY] + 1;
				queue.offer(new int[] { nextX, nextY });
			}
		}
	}
}
