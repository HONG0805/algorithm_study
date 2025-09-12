package graph_advanced;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int vertex, weight;

	Node(int v, int w) {
		vertex = v;
		weight = w;
	}

	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class BOJ_1504 {
	static int N, E;
	static ArrayList<Node>[] graph;
	static int INF = 200_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		int ans = Math.min(path1, path2);
		if (ans >= INF)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static int dijkstra(int start, int end) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.weight > dist[cur.vertex])
				continue;

			for (Node next : graph[cur.vertex]) {
				if (dist[next.vertex] > dist[cur.vertex] + next.weight) {
					dist[next.vertex] = dist[cur.vertex] + next.weight;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
		return dist[end];
	}
}
