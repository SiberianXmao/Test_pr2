package com.training.arrayUtils;

import java.util.Arrays;

public class ArrayUtils {

    // поиск максимального элемента
    public static int findMax(int[] arr){
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив пустой или null");

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {  // используем индекс вместо for-each
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // поиск минимального элемента
    public static int findMin(int[] arr){
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив пустой или null");

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) { // используем индекс вместо for-each
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    // сортировка по возрастанию
    public static int[] sortAscending(int[] arr){
        if (arr == null) return new int[0];

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }

    // сортировка по убыванию
    public static int[] sortDescending(int[] arr){
        if (arr == null) return new int[0];

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        reverse(copy);
        return copy;
    }

    // среднее значение
    public static int average(int[] arr){
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив пустой или null");

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
