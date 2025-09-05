package stack_queue_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static final int MAX = 100000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[MAX + 1];
		boolean[] visited = new boolean[MAX + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == K) {
				System.out.println(dist[cur]);
				return;
			}
			int[] next = { cur - 1, cur + 1, cur * 2 };

			for (int nx : next) {
				if (nx >= 0 && nx <= MAX && !visited[nx]) {
					visited[nx] = true;
					dist[nx] = dist[cur] + 1;
					q.add(nx);
				}
			}
		}
	}
}
