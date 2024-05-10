package datastructure;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws HeapFullException, HeapEmptyException {

		MaxHeap<Integer> maxHeap = new MaxHeap<>(Integer.class);

		maxHeap.insert(9);

		maxHeap.insert(4);

		maxHeap.insert(17);

		maxHeap.insert(6);

		maxHeap.insert(100);

		maxHeap.insert(144);

		maxHeap.insert(47);

		maxHeap.insert(247);

		System.out.println("___________________________________________");

		System.out.println("Element prioritaire: " + maxHeap.getHigestPriority());

		System.out.println();
		System.out.println(maxHeap);
		maxHeap.removeHighestPriority();

		System.out.println("\n*****************************************\n");

		MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

		minHeap.insert(9);
		minHeap.insert(4);
		minHeap.insert(17);
		minHeap.insert(6);
		minHeap.insert(100);
		minHeap.insert(3);
		minHeap.insert(13);
		minHeap.insert(23);

		System.out.println(minHeap);
		System.out.println("------------------------------------");

		System.out.println();
		System.out.println(minHeap);
		System.out.println("Element prioritaire: " + minHeap.getHigestPriority());

		System.out.println();
		minHeap.removeHighestPriority();
		System.out.println(minHeap);

		System.out.println("\n********************\n");
		System.out.println("\nHEAPIFY\n");
		int[] array = { 4, 6, 9, 2, 10, 56, 12, 5, 1, 17, 14 };

		System.out.println(Arrays.toString(array));

		// Heapify.heapify(array, array.length - 1);
		// System.out.println(Arrays.toString(array));

		System.out.println("***********************************");
		System.out.println("HEAP SORT:");
		System.out.println("***********************************");

		Sort.heapSort(array);
		System.out.println(Arrays.toString(array));

	}

}
