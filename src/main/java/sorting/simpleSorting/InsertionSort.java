package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > 0 && rightIndex < array.length) {
			for (int i = 0; i < rightIndex; i++) {
				for (int j = i; j > leftIndex; j++) {
					if (array[j].compareTo(array[j - 1]) < 0) swap(array, j, j-1);
				}
			}
		}
	}

	public void swap(T[] array, int index1, int index2) { // modificar para puxar o swap do pacote util
		T aux = array[index1];
		array[index1] = array[index2];
		array[index2] = aux;
	}	
}
