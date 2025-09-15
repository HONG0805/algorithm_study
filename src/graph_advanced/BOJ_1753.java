package graph_advanced;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
	static class Node implements Comparable<Node> {
		int vertex, weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<Node>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}

		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.vertex;

			if (cur.weight > dist[now])
				continue;

			for (Node next : graph[now]) {
				if (dist[next.vertex] > dist[now] + next.weight) {
					dist[next.vertex] = dist[now] + next.weight;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}
