import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return max;
    }

    public int getMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public void delete(int key) {
        int index = heap.indexOf(key);
        if (index == -1) {
            throw new IllegalArgumentException("Key not found");
        }
        heap.set(index, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(index);
    }

    public void updateKey(int oldKey, int newKey) {
        int index = heap.indexOf(oldKey);
        if (index == -1) {
            throw new IllegalArgumentException("Key not found");
        }
        heap.set(index, newKey);
        if (newKey > oldKey) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    public void buildHeap(int[] array) {
        heap.clear();
        for (int value : array) {
            heap.add(value);
        }
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) > heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }
            if (largest == index) {
                break;
            }
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}