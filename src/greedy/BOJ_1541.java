package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();

		String[] minusSplit = expression.split("-");

		int result = 0;

		result += sumOfGroup(minusSplit[0]);

		for (int i = 1; i < minusSplit.length; i++) {
			result -= sumOfGroup(minusSplit[i]);
		}

		System.out.println(result);
	}

	private static int sumOfGroup(String group) {
		String[] plusSplit = group.split("\\+");
		int sum = 0;
		for (String num : plusSplit) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}
}
