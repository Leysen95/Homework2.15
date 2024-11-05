package me.skypro.Homework_2._5.model;

import me.skypro.Homework_2._5.exception.LengthExceededException;
import me.skypro.Homework_2._5.exception.NullIndexException;

import java.util.Arrays;

public class IntegerArrayList implements IntegerList{
    private Integer[] array;

    private int size;

    public IntegerArrayList(int length) {
        this.array = new Integer[length];
    }

    @Override
    public Integer add(Integer item) {
        checkLength();
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkLength();
        checkIndex(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkLength();
        checkIndex(index);

        array[index] = item;

        return item;
    }

    @Override
    public Integer remove(Integer item) {
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
        if (index == -1) {
            throw new NullIndexException();
        }
        Integer item = array[index];

        System.arraycopy(array, index + 1, array, index - 1, size - index);
        array[size - 1] = null;
        size--;

        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        sort();
        return binarySearch(item);
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);

        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == this) return true;
        if (otherList == null) return false;
        return Arrays.equals(otherList.toArray(), this.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Integer[array.length];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private int binarySearch(Integer item) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid].equals(item)){
                return mid;
            } else if (array[mid] < item) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    private void sort() {
        mergeSort(array);
    }

    public static void mergeSort(Integer[] table) {
        if (table.length < 2) {
            return;
        }
        int mid = table.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[table.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = table[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = table[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(table, left, right);
    }

    public static void merge(Integer[] table, Integer[] left, Integer[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                table[mainP++] = left[leftP++];
            } else {
                table[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            table[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            table[mainP++] = right[rightP++];
        }
    }

    private void checkLength() {
        if (size >= array.length) {
            throw new LengthExceededException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NullIndexException();
        }
    }
}
