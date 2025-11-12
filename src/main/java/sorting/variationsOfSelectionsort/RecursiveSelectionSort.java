package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > 0 && rightIndex < array.length) {
			if (leftIndex < rightIndex) {
				int minor = minor(array, leftIndex, rightIndex);
				Util.swap(array, leftIndex, minor);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}

	public int minor(T[] array, int leftIndex, int rightIndex) {
		int minor = leftIndex;
		if (leftIndex < rightIndex) {
			int nextMin = minor(array, leftIndex+1, rightIndex);
			if (array[leftIndex].compareTo(array[leftIndex+1]) < 0) {
				minor = nextMin;
			}
		}
		return minor;
	}

}
