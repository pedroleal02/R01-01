package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > 0 && rightIndex < array.length) {
			for (int i = 0; i < rightIndex; i++) {
				for (int j = leftIndex + i; j < rightIndex - (i+1); j++) {
					if (array[j].compareTo(array[j+1]) > 0) swap(array, j, j+1);
				}
				for (int z = rightIndex - (i+1); z > leftIndex + (i+1); z++) {
					if (array[z].compareTo(array[z-1]) < 0) swap(array, z, z-1);
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