package graph_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int M, N, K;
	static int[][] field;
	static boolean[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			field = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { y, x });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int dir = 0; dir < 4; dir++) {

				int ny = cy + dy[dir];
				int nx = cx + dx[dir];

				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (field[ny][nx] == 1 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new int[] { ny, nx });
					}
				}
			}
		}
	}
}
