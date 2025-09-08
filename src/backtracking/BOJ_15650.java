package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15650 {
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];

		dfs(1, 0);

		br.close();
	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			System.out.println(sb.toString());
			return;
		}

		for (int i = start; i <= N; i++) {
			result[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
}