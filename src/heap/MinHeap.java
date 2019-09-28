package heap;

import array.ArrayHelper;

public class MinHeap {

	private int[] heapArr;
	private int size;

	public MinHeap(int capacity) {
		heapArr = new int[capacity];
		size = 0;
	}

	public void insertKey(int key) throws Exception {

		if (size >= heapArr.length) {
			throw new Exception("Heap is full");
		}

		int index = size++;
		heapArr[index] = key;

		int parentIndex = parent(index);
		while (index != 0 && heapArr[parentIndex] > heapArr[index]) {
			ArrayHelper.swap(heapArr, index, parentIndex);
			index = parentIndex;
		}
	}

	public int parent(int i) {
		return i / 2;
	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

	public void minHeapify(int i) {
		int left = left(i);
		int right = right(i);
		int smallest = i;
		if (left < size && heapArr[smallest] > heapArr[left]) {
			smallest = left;
		}

		if (right < size && heapArr[smallest] > heapArr[right]) {
			smallest = right;
		}

		if (smallest != i) {
			ArrayHelper.swap(heapArr, smallest, i);
			minHeapify(smallest);
		}
	}

	public void heapSort() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			minHeapify(i);
		}

		for (int i = size - 1; i >= 0; i--) {
			ArrayHelper.swap(heapArr, 0, i);

			// Heapify root element to get highest element at root again
			minHeapify(i);
		}
	}

}
