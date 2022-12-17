package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;

public class Main {
    public static void main(String[] args) {
        int[] arr = {123, 1, 44, 22, 3, 4343, 2, 148, 171, 234, 7, 76};
        int lngthArr = arr.length;

//        mergeSort(arr, lngthArr);
//        System.out.println(Arrays.toString(arr));

//        removeEvenNumber(arr);

        minMaxMid();
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

    /**
     * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */
    private static void minMaxMid() {
        int min = 0;
        int max = 100;

        int lenght =  8 + (int)(Math.random() * ((20 - 8) + 1));
        ArrayList<Integer> list = new ArrayList<>(lenght);

        for (int i =0; i < lenght; i++) {
            int randomNumber = min + (int)(Math.random() * ((max - min) + 1));
            list.add(randomNumber);
        }

        int maxNumber = list.get(0);
        int minNumber = list.get(0);
        int mean = 0;

        for (int i =0; i < list.size(); i++) {
            if (list.get(i) > maxNumber) {
                maxNumber = list.get(i);
            }
            if (list.get(i) < minNumber) {
                minNumber = list.get(i);
            }
            mean += list.get(i);
        }

        mean = mean/lenght;

        System.out.println("Array: " + Arrays.toString(list.toArray()));
        System.out.println("Max number: " + maxNumber);
        System.out.println("Min number: " + minNumber);
        System.out.println("Mean: " + mean);

    }

}