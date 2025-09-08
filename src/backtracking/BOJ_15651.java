package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651 {
	static int N, M;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];

		dfs(0);

		br.close();
	}

	static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++)
				sb.append(result[i]).append(' ');
			System.out.println(sb.toString());
			return;
		}

		for (int i = 1; i <= N; i++) {
			result[depth] = i;
			dfs(depth + 1);
		}
	}
}
