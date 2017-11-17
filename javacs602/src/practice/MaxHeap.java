package practice;

import java.util.ArrayList;

public class MaxHeap {


    private ArrayList<Integer> list;

    public MaxHeap() {

        this.list = new ArrayList<Integer>();
    }

    public MaxHeap(ArrayList<Integer> items) {

        this.list = items;
        buildHeap();
    }

    public void insert(int item) {

        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);

        while (parent != i && list.get(i) > list.get(parent)) {

            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public void buildHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public int extractMax() {

        if (list.size() == 0) {

            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {

            int max = list.remove(0);
            return max;
        }

        // remove the last item ,and set it as new root
        int max = list.get(0);
        int lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        // bubble-down until heap property is maintained
        maxHeapify(0);

        // return max key
        return max;
    }

    public void decreaseKey(int i, int key) {

        if (list.get(i) < key) {

            throw new IllegalArgumentException("Key is larger than the original key");
        }

        list.set(i, key);
        int parent = parent(i);

        // bubble-up until heap property is maintained
        while (i > 0 && list.get(parent) > list.get(i)) {

            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }
    }

    private void maxHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int largest = -1;

        // find the largest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left) > list.get(i)) {
        	largest = left;
        } else {
        	largest = i;
        }

        if (right <= list.size() - 1 && list.get(right) > list.get(largest)) {
        	largest = right;
        }

        // if the largest key is not the current key then bubble-down it.
        if (largest != i) {

            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public int getMax() {

        return list.get(0);
    }

    public boolean isEmpty() {

        return list.size() == 0;
    }

    private int right(int i) {

        return 2 * i + 2;
    }

    private int left(int i) {

        return 2 * i + 1;
    }

    private int parent(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {

        int temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

}