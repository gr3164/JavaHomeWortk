package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;

public class Main {
    public static void main(String[] args) {
        int[] arr = {123, 1, 44, 22, 3, 4343, 2, 148, 171, 234, 7, 76};
        int lngthArr = arr.length;

//        mergeSort(arr, lngthArr);
//        System.out.println(Arrays.toString(arr));

        removeEvenNumber(arr);
    }
    /**
     * Реализовать алгоритм сортировки слиянием
     */
    public static void mergeSort(int[] src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }
    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) src[k++] = left[i++];
            else src[k++] = right[j++];
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }

    /**
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    private static void removeEvenNumber(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);

        for (int i =0; i < arr.length; i++) {
           if (arr[i] % 2 != 0) {
               list.add(arr[i]);
           }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}