package study01;
import java.util.Scanner;

/*
 * Yoonnyung Choi, yoonnyung.choi@gmail.com, 04/19/2017
 * https://www.acmicpc.net/problem/1149
 *
 * 문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

예제 입력
3
26 40 83
49 60 57
13 89 99
예제 출력
96

Dynamic Programming, Bottom-up Approach

*/

public class RGB2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N=0;
		N= scanner.nextInt();
		scanner.nextLine();
		int[][] dp = new int[N][3];
		int[][]	colour = new int[N][3];

		for(int i=0; i<N; i++){
			colour[i][0] = scanner.nextInt();
			colour[i][1] = scanner.nextInt();
			colour[i][2] = scanner.nextInt();
			scanner.nextLine();
		}

		for(int i=0; i<3; i++){
			dp[0][i] = colour[0][i];
		}

		for(int j=1; j<N; j++){
			for(int k=0; k<3; k++){
				if(k==0){
					if(dp[j-1][1]<=dp[j-1][2]){
						dp[j][k]=colour[j][k]+dp[j-1][1];
					}else{
						dp[j][k]=colour[j][k]+dp[j-1][2];
					}
				}else if(k==1){
					if(dp[j-1][0]<=dp[j-1][2]){
						dp[j][k]=colour[j][k]+dp[j-1][0];
					}else{
						dp[j][k]=colour[j][k]+dp[j-1][2];
					}
				}else if(k==2){
					if(dp[j-1][0]<=dp[j-1][1]){
						dp[j][k]=colour[j][k]+dp[j-1][0];
					}else{
						dp[j][k]=colour[j][k]+dp[j-1][1];
					}
				}
			}
		}

		int minCost= dp[N-1][0];
		for(int i=1; i<3; i++){
			if(dp[N-1][i]<minCost){
				minCost=dp[N-1][i];
			}
		}
		System.out.println(minCost);
	}

}
