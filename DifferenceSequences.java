
public class DifferenceSequences {

	public static void main(String[] argv) {
		int[] firstrow = new int[] {1,2,4,8,16,31};
		int[][] triangle = new int[firstrow.length][firstrow.length];
		triangle[0] = firstrow;
		for (int level = 1; level < firstrow.length; level++) {
			for (int i = 0; i < (firstrow.length - level); i++) {
				triangle[level][i] = triangle[level - 1][i + 1] - triangle[level-1][i];
			}
		}
		for (int j = 0; j < firstrow.length; j++) {
			for (int r = 0; r < j; r++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (firstrow.length - j); k++) {
				System.out.print(triangle[j][k] + " ");
			}
			System.out.print("\n");
		}
	}
	
}