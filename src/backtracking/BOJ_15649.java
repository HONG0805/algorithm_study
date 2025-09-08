package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int N, M;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[N];
		visited = new boolean[N + 1];

		dfs(0);

		br.close();
	}

	static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = 0; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
