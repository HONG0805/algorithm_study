package two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, trees[i]);
		}

		int low = 0;
		int high = maxHeight;
		int answer = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			long sum = 0;

			for (int h : trees) {
				if (h > mid) {
					sum += h - mid;
				}
			}
			if (sum >= M) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
