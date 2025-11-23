package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new BubbleSort<>();
		this.implementation = new InsertionSort<>();
		this.implementation = new SelectionSort<>();
		this.implementation = new BidirectionalBubbleSort<>();
		this.implementation = new RecursiveBubbleSort<>();
		this.implementation = new RecursiveSelectionSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void testPartialSortMiddle() {
		Integer[] array = {9, 7, 3, 5, 8, 2, 1};
		Integer[] expected = {9, 3, 5, 7, 8, 2, 1};
		implementation.sort(array, 1, 3);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testPartialSortBeginning() {
		Integer[] array = {10, 3, 5, 8, 1};
		Integer[] expected = {3, 5, 10, 8, 1};
		implementation.sort(array, 0, 2);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testPartialSortEnd() {
		Integer[] array = {10, 20, 5, 3, 1};
		Integer[] expected = {10, 20, 1, 3, 5};
		implementation.sort(array, 2, 4);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testSortSingleElementInterval() {
		Integer[] array = {5, 4, 3, 2, 1};
		Integer[] expected = {5, 4, 3, 2, 1};
		implementation.sort(array, 2, 2);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testInvalidIntervalLeftGreaterThanRight() {
		Integer[] array = {4, 1, 2, 8};
		Integer[] expected = {4, 1, 2, 8};
		implementation.sort(array, 3, 1);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testInvalidIntervalRightOutOfBounds() {
		Integer[] array = {4, 1, 2, 8};
		Integer[] expected = {4, 1, 2, 8};
		implementation.sort(array, 0, 10);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testInvalidIntervalLeftNegative() {
		Integer[] array = {4, 1, 2, 8};
		Integer[] expected = {4, 1, 2, 8};
		implementation.sort(array, -1, 2);
		Assert.assertArrayEquals(expected, array);
	}

	@Test
	public void testAlreadySorted() {
		Integer[] array = {1, 2, 3, 4, 5};
		Integer[] expected = {1, 2, 3, 4, 5};
		genericTest(array);
	}

	@Test
	public void testReverseSorted() {
		Integer[] array = {5, 4, 3, 2, 1};
		genericTest(array);
	}

	@Test
	public void testWithNegativeNumbers() {
		Integer[] array = {3, -1, 5, -10, 2};
		genericTest(array);
	}

}