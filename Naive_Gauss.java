
public class Naive_Gauss {

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
	public static void main (String [] args) {
		/*
		 * 6x(1) - 2x(2) + 3x(3) + 4x(4) = 16
		 *       - 4x(2) + 2x(3) + 2x(4) = -6
		 *                 2x(3) - 5x(4) = -9
		 *                 4x(3) - 13x(4)= -21
		 */	
		float [][] a = {
				{6, -2, 3, 4},
				{0, -4, 2, 2},
				{0, 0, 2, -5},
				{0, 0, 4, -13}
				};
		float [] b = {16, -6, -9, -21};
		float [] x = {0, 0, 0, 0};
		int n = 4;
		
		naiveGauss (n, a, b, x);
		for (float i : x) {
			System.out.println(i + "\t");
		}
		
		
	}
}
