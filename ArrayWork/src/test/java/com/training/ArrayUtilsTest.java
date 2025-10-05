package com.training;

import com.training.arrayUtils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void testFindMax() {
        assertEquals(9, ArrayUtils.findMax(new int[]{1, 5, 9, 3}));
        assertEquals(-1, ArrayUtils.findMax(new int[]{-5, -1, -9}));
    }

    @Test
    public void testFindMin() {
        assertEquals(1, ArrayUtils.findMin(new int[]{1, 5, 9, 3}));
        assertEquals(-9, ArrayUtils.findMin(new int[]{-5, -1, -9}));
    }

    @Test
    public void testSortAscending() {
        int[] input = {5, 1, 3};
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, ArrayUtils.sortAscending(input));
    }

    @Test
    public void testSortDescending() {
        int[] input = {5, 1, 3};
        int[] expected = {5, 3, 1};
        assertArrayEquals(expected, ArrayUtils.sortDescending(input));
    }

    @Test
    public void testAverage() {
        assertEquals(3, ArrayUtils.average(new int[]{1, 2, 3, 6}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageEmptyArrayThrows() {
        ArrayUtils.average(new int[]{});
    }


    @Test
    public void testSingleElementArray() {
        int[] arr = {42};
        assertEquals(42, ArrayUtils.findMax(arr));
        assertEquals(42, ArrayUtils.findMin(arr));
        assertArrayEquals(new int[]{42}, ArrayUtils.sortAscending(arr));
        assertArrayEquals(new int[]{42}, ArrayUtils.sortDescending(arr));
        assertEquals(42, ArrayUtils.average(arr));
    }

    // Тесты для 2-элементного массива
    @Test
    public void testTwoElementArray() {
        int[] arr = {5, 10};
        assertEquals(10, ArrayUtils.findMax(arr));
        assertEquals(5, ArrayUtils.findMin(arr));
        assertArrayEquals(new int[]{5, 10}, ArrayUtils.sortAscending(arr));
        assertArrayEquals(new int[]{10, 5}, ArrayUtils.sortDescending(arr));
        assertEquals(7, ArrayUtils.average(arr));
    }

    // Тест с повторяющимися элементами
    @Test
    public void testRepeatedElements() {
        int[] arr = {7, 7, 7, 7};
        assertEquals(7, ArrayUtils.findMax(arr));
        assertEquals(7, ArrayUtils.findMin(arr));
        assertArrayEquals(new int[]{7, 7, 7, 7}, ArrayUtils.sortAscending(arr));
        assertArrayEquals(new int[]{7, 7, 7, 7}, ArrayUtils.sortDescending(arr));
        assertEquals(7, ArrayUtils.average(arr));
    }

    @Test
    public void testMaxMinBoundaryCases() {
        // максимум в конце
        int[] arr1 = {1, 2, 3, 9};
        assertEquals(9, ArrayUtils.findMax(arr1));
        assertEquals(1, ArrayUtils.findMin(arr1));

        // максимум в середине
        int[] arr2 = {1, 9, 2, 3};
        assertEquals(9, ArrayUtils.findMax(arr2));
        assertEquals(1, ArrayUtils.findMin(arr2));

        // минимум в конце
        int[] arr3 = {9, 5, 3, -1};
        assertEquals(9, ArrayUtils.findMax(arr3));
        assertEquals(-1, ArrayUtils.findMin(arr3));

        // минимум в середине
        int[] arr4 = {5, -2, 7, 8};
        assertEquals(8, ArrayUtils.findMax(arr4));
        assertEquals(-2, ArrayUtils.findMin(arr4));
    }

    @Test
    public void testSingleAndTwoElementArrays() {
        // Одноэлементный массив
        int[] single = {42};
        assertEquals(42, ArrayUtils.findMax(single));
        assertEquals(42, ArrayUtils.findMin(single));

        // Двухэлементный массив
        int[] two1 = {5, 10};
        assertEquals(10, ArrayUtils.findMax(two1));
        assertEquals(5, ArrayUtils.findMin(two1));

        int[] two2 = {10, 5};
        assertEquals(10, ArrayUtils.findMax(two2));
        assertEquals(5, ArrayUtils.findMin(two2));
    }



}
