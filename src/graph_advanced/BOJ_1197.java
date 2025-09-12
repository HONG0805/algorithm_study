package graph_advanced;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int from, to, weight;

	Edge(int f, int t, int w) {
		from = f;
		to = t;
		weight = w;
	}

	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}

public class BOJ_1197 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, w);
		}

		Arrays.sort(edges);

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;

		int sum = 0;
		for (Edge e : edges) {
			if (find(e.from) != find(e.to)) {
				union(e.from, e.to);
				sum += e.weight;
			}
		}

		System.out.println(sum);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}