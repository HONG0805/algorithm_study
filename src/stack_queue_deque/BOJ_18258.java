package stack_queue_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_18258 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			String cmd = st.nextToken();

			if (cmd.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				q.offer(x);
			} else if (cmd.equals("pop")) {
				sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
			} else if (cmd.equals("size")) {
				sb.append(q.size()).append('\n');
			} else if (cmd.equals("empty")) {
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
			} else if (cmd.equals("front")) {
				sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
			} else if (cmd.equals("back")) {
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
			}
		}
		System.out.print(sb.toString());
	}
}
