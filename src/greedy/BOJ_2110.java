package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		int low = 1;
		int high = houses[N - 1] - houses[0];
		int answer = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (canInstall(houses, N, C, mid)) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(answer);
	}

	private static boolean canInstall(int[] houses, int N, int C, int dist) {
		int count = 1;
		int last = houses[0];

		for (int i = 1; i < N; i++) {
			if (houses[i] - last >= dist) {
				count++;
				last = houses[i];
			}
		}

		return count >= C;
	}
}
