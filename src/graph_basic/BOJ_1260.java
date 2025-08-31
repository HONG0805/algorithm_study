package graph_basic;

import java.util.*;
import java.io.*;

public class BOJ_1260 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[n + 1];
		dfs(v);
		sb.append("\n");

		visited = new boolean[n + 1];
		bfs(v);

		System.out.print(sb);
	}

	static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");

			for (int next : graph[current]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
}
