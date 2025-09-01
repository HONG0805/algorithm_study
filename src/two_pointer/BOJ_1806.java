package two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int ans = Integer.MAX_VALUE;

		int left = 0;
		int sum = 0;
		for (int right = 0; right < N; right++) {
			sum += a[right];

			while (sum >= S) {
				ans = Math.min(ans, right - left + 1);
				sum -= a[left++];
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
