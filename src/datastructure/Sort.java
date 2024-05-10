package datastructure;

import java.util.Arrays;

public class Sort {

	public static void heapSort(int[] array) {
		Heapify.heapify(array, array.length - 1);

		System.out.println("--------------------------------------------------------------");

		int endIndex = array.length - 1;

		//Recupère l'élément prioritaire
		while (endIndex > 0) {
			
			System.out.println("\n Fin du tas: " + array[endIndex] + " Tableau= " + Arrays.toString(array));

			System.out.println("\n Déplace " + array[0] + " à la fin");

			Heapify.swap(array, 0, endIndex);

			System.out.println("\nAprès le swap: " + Arrays.toString(array));

			endIndex--;

			Heapify.percolateDown(array, 0, endIndex);

		}

	}

}
