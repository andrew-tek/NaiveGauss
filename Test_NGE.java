/* Andrew Tek
 * Computer Exercise 2.1.1
 * In this exercise we are trying to estimate p(t) = 1 + t + t^2 + t^3 + ... + t^(n - 1)
 * In order to do this we populate our matrix using a[i][j] = (1 + i)^(j - 1). Then
 * populate b using b [i] = [(i + 1)^n - 1] / i. From here we use the naiveGauss approach
 * to solve values of x. This computer does not have the proper accuracy so the 
 * values of x are marked as NaN. 
 */
public class Test_NGE {
	public static void naiveGauss(int n, float [][] a, float [] b, float [] x) {
		int i, j, k;
		float sum = 0, xmult;
		for (k = 0; k < n; k++) {
			for (i = k + 1; i < n; i++) {
				xmult = a[i][k] / a[k][k];
				a[i][k] = xmult;
				for (j = k + 1; j < n; j++) {
					a[i][j] -= (xmult * a[k][j]);
				}
				b[i] -= (xmult * b[k]);
			}
		}
		x[n - 1] = b[n - 1] / a[n - 1][n - 1];
		for (i = n - 1; i >= 0; i--) {
			sum = b[i];
			for (j = i + 1; j < n; j++) {
				sum -= (a[i][j] * x[j]);
			}
			x[i] = sum / a[i][i];
		}
	}
	public static void main(String[] args) {
		int m = 10;
		int i, j, n;
		float [][] a = new float [m][m];
		float [] b = new float [m];
		float [] x = new float [m];
		
		for (n = 4; n <= 10; n++) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					a[i][j] = (float) Math.pow(i + 1, j);
					System.out.print(a[i][j] + "\t");
				}
				System.out.println();
				b[i] = (float) ((Math.pow(i + 1, n) - 1) / i);
				
			}
			naiveGauss(n, a, b, x);
			System.out.println(n + "\t" + x[i - 1]);
		}
	}
}
