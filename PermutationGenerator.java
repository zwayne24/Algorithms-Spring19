package cmsc351s19;

import java.util.Random;

public class PermutationGenerator {
	final private Random m_random;

	/**
	 * constructor. You should not modify this constructor
	 * @param random The randomness source
	 */
	public PermutationGenerator(Random random) {
		m_random = random;
	}

	/**
	 * Generate a new random permutation of {1, 2, 3, ... , n}
	 * @param n The size of the permutation
	 * @return The new random permutation
	 */
	public int[] nextPermutation(int n) {
		int [] A = new int[n];
		for (int i = 1; i <= n; i++){
			A[i-1] = i;
		}
		for (int i = 0; i < n; i++){
			int k = m_random.nextInt(n);
			int temp = A[i];
			A[i] = A[k];
			A[k] = temp;
		}
		return A;
	}
}
