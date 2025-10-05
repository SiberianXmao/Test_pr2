package com.training.arrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {


    // поиск максимального элемента
    public static int findMax(int[] arr){
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив пустой или null");
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // поиск минимального элемента
    public static int findMin(int[] arr){
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Массив пустой или null");
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    // сортировка по возрастанию
    public static int[] sortAscending(int[] arr){
        if (arr == null) return new int[0];

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    };

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
        for (int num : arr) {
            sum += num;
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
