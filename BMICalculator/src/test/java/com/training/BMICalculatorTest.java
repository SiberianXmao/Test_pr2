package com.training;

import com.training.bmi.BMICalculator;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    private final BMICalculator calculator = new BMICalculator();

    // ---------------- Основные тесты ----------------

    @Test
    public void testBMICalculation() {
        double bmi = calculator.calculateBMI(70, 1.75);
        // В JUnit 4: assertEquals(expected, actual, delta)
        assertEquals(22.86, bmi, 0.1);
    }


    @Test
    public void testBMICategoryNormal() {
        assertEquals("Норма", calculator.getBMICategory(22.0));
    }

    @Test
    public void testBMICategoryUnderweight() {
        assertEquals("Недостаточный вес", calculator.getBMICategory(17.0));
    }

    @Test
    public void testBMICategoryObesity() {
        assertEquals("Ожирение", calculator.getBMICategory(35.0));
    }

    @Test
    public void testRecommendedMinWeight() {
        double minWeight = calculator.recommendedMinWeight(1.75);
        assertEquals(56.6, minWeight, 0.1);
    }

    @Test
    public void testRecommendedMaxWeight() {
        double maxWeight = calculator.recommendedMaxWeight(1.75);
        assertEquals(76.2, maxWeight, 0.1);
    }

    @Test
    public void testIsWeightNormalTrue() {
        assertTrue(calculator.isWeightNormal(70, 1.75));
    }

    @Test
    public void testIsWeightNormalFalse() {
        assertFalse(calculator.isWeightNormal(100, 1.75));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(-70, 1.75));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(70, 0));
    }

    // ---------------- Дополнительные тесты для мутаций ----------------

    // 1️⃣ Тесты на граничные значения BMI для getBMICategory()
    @Test
    public void testBMICategoryBoundaryValues() {
        // Нижняя граница нормального BMI
        assertEquals("Норма", calculator.getBMICategory(18.5));
        // Верхняя граница нормального BMI
        assertEquals("Норма", calculator.getBMICategory(24.9));
        // Граница избыточного веса
        assertEquals("Избыточный вес", calculator.getBMICategory(29.9));
    }

    // 2️⃣ Тесты на границы веса для isWeightNormal()
    @Test
    public void testIsWeightNormalBoundaries() {
        double height = 1.75;
        double minWeight = 18.5 * height * height;  // нижняя граница
        double maxWeight = 24.9 * height * height;  // верхняя граница

        assertTrue(calculator.isWeightNormal(minWeight, height));
        assertTrue(calculator.isWeightNormal(maxWeight, height));
    }

    // 3️⃣ Тесты на граничные значения для calculateBMI()
    @Test
    public void testBMICalculationBoundaries() {
        double bmiLow = calculator.calculateBMI(18.5 * 1.75 * 1.75, 1.75);
        assertEquals(18.5, bmiLow, 0.01);

        double bmiHigh = calculator.calculateBMI(24.9 * 1.75 * 1.75, 1.75);
        assertEquals(24.9, bmiHigh, 0.01);
    }

    // ---------------- Существующие тесты для покрытия остальных мутаций ----------------

    @Test
    public void testCalculateBMI() {
        double bmi = calculator.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    public void testCalculateBMIInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(-70, 1.75));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(70, 0));
    }

    @Test
    public void testGetBMICategory() {
        assertEquals("Недостаточный вес", calculator.getBMICategory(17.0));
        assertEquals("Норма", calculator.getBMICategory(22.0));
        assertEquals("Избыточный вес", calculator.getBMICategory(27.0));
        assertEquals("Ожирение", calculator.getBMICategory(32.0));
    }

    @Test
    public void testIsWeightNormal() {
        assertTrue(calculator.isWeightNormal(70, 1.75));
        assertFalse(calculator.isWeightNormal(50, 1.75));
        assertFalse(calculator.isWeightNormal(90, 1.75));
    }
    @Test
    public void testCalculateBMIZeroInput() {
        // Проверяем, что при нуле выбрасывается исключение
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(0, 1.75));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(70, 0));
    }

}
