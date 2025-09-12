package graph_advanced;

import java.io.*;
import java.util.*;

public class BOJ_13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int MAX = 100_001;
		int[] dist = new int[MAX];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Deque<Integer> dq = new ArrayDeque<>();
		dist[N] = 0;
		dq.addFirst(N);

		while (!dq.isEmpty()) {
			int cur = dq.pollFirst();

			int next = cur * 2;
			if (next < MAX && dist[next] > dist[cur]) {
				dist[next] = dist[cur];
				dq.addFirst(next);
			}

			next = cur + 1;
			if (next < MAX && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				dq.addLast(next);
			}

			next = cur - 1;
			if (next >= 0 && dist[next] > dist[cur] + 1) {
				dist[next] = dist[cur] + 1;
				dq.addLast(next);
			}
		}

		System.out.println(dist[K]);
	}
}
