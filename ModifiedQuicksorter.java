package cmsc351s19;

public class ModifiedQuicksorter {
	/* number of pivots that will be used */
	protected int m_k;
	/* number of comparisons performed */
	protected int m_comparisons = 0;
	/* number of moves performed */
	protected int m_moves = 0;

	/**
	* constructor
	* @param k The number of pivots, guaranteed to be at least 1
	*/
	public ModifiedQuicksorter(int k) {
		m_k = k;

		
	}

	/**
	* Perform an in-place insertion sort on array[1...n], both end-points inclusive
	* All the comparisons and moves COUNT in this function
	* You should implement an insertion sort WITH sentinel here
	* @param array array to sort
	* @param n number of elements in the array
	*/
	public void insertionSort(int[] array, int n) {
		for (int i = 2;i <= n;i++) {
			int pin = array[i];
			m_moves++;
			int j = i - 1;

			m_comparisons++;
			while (array[j] > pin) {
				array[j + 1] = array[j];
				m_moves++;
				j = j - 1;
				m_comparisons++;
			}
			array[j + 1] = pin;
			m_moves++;
		}
	}

	/**
	* Perform an in-place insertion sort on array[p...q], both end-points inclusive
	* This function extracts array[p...q] and maps it into an array [0, array[p], array[p+1], ..., array[q]],
	* then it calls the overloaded insertionSort on the extracted array
	* Moves happened in this function DOESN't count towards m_moves
	*
	* You should NOT modify this function
	* You should ALWAYS call this version of insertion sort in your other function
	* @param array array to sort
	* @param p starting point
	* @param q ending point
	*/
	public void insertionSort(int[] array, int p, int q) {
		// Sanity check
		if(p >= q) {
			return;
		}
		// Create a new array. Size is one more than the number of elements to accommodate sentinel
		int[] extractedArray = new int[q - p + 2];
		// Copy array[p...q] to extractedArray[1...(q-p+1)]
		System.arraycopy(array, p, extractedArray, 1, q - p + 1);
		// Make the call
		insertionSort(extractedArray, q - p + 1);
		// Copy back
		System.arraycopy(extractedArray, 1, array, p, q - p + 1);
	}

	/**
	* Partition array[p...q], both end-points inclusive
	* You should sort the last m_k elements in a[p...q], and then use them as pivots to partition the array in-place.
	* You should then return the indices of those pivots in an array, in increasing order, which SHOULD have size exactly m_k
	* @param array array to partition
	* @param p starting point
	* @param q ending point
	* @return the dices of partitioned pivots
	*/
	public int[] partition(int[] array, int p, int q) {
		int pindex = (q-m_k)+1;
		int[] pivindeces = new int[m_k];
		insertionSort(array,pindex,q);
		while (pindex <= q){		
			int i = p-1;
			for (int j=p; j<pindex; j++)
			{
				m_comparisons++;
				if (array[j] <= array[pindex])
				{
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					m_moves+=3;
				}

			}
			m_moves+=4;
			int temp = array[i+1];
			array[i+1] = array[pindex];
			array[pindex] = temp;
			pivindeces[pindex-((q-m_k)+1)]= i+1;
			pindex++;
		}

		return pivindeces;
	}

	/**
	* Sort array[p...q] in-place using modified quicksort, both end-points inclusive
	* @param array array to sort
	* @param p starting point
	* @param q ending point
	*/
	public void sort(int[] array, int p, int q) {
		if (q-p+1 <= 2*m_k){
			insertionSort(array,p,q);
		}
		else if (p < q-m_k)
		{
			int[] split = partition(array,p,q);
			int i = 0;
			if (split[0] != 0) {
				sort(array, p, split[0]-1);
			}
			while (i < split.length - 1){
				sort(array, split[i]+1, split[i+1]-1);
				i++;
			}
			if (split[split.length-1] != array.length-1) {
				sort(array, split[split.length-1]+1, q);
			}
		}
	}

	/**
	* Sort array in-place using modified quicksort
	* This function just calls overloaded version of sort
	* You should NOT modify this function
	* @param array array to sort
	*/
	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	/**
	* Get the number of comparisons up to now
	* You should not change this function
	* @return the number of comparisons
	*/
	final public int getComparisons() {
		return m_comparisons;
	}

	/**
	* Get the number of moves up to now
	* You should not change this function
	* @return the number of moves
	*/
	final public int getMoves() {
		return m_moves;
	}
}
