package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wine[i] = Integer.parseInt(st.nextToken());
		}

		if (n == 1) {
			System.out.println(wine[0]);
		} else if (n == 2) {
			System.out.println(wine[0] + wine[1]);
		} else {
			dp[0] = wine[0];
			dp[1] = dp[0] + wine[1];
			dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));

			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(dp[i - 3] + wine[i] + wine[i - 1], dp[i - 2] + wine[i]);
				dp[i] = Math.max(dp[i - 1], dp[i]);
			}
			System.out.println(dp[n - 1]);
		}

}
}