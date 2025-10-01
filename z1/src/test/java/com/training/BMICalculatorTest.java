package com.training;

import com.training.bmi.BMICalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {

    private final BMICalculator calculator = new BMICalculator();

    @Test
    void testBMICalculation() {
        double bmi = calculator.calculateBMI(70, 1.75);
        // Ожидаем ~22.86 (правильная формула), но из-за ошибки будет неверно
        assertEquals(22.86, bmi, 0.1, "BMI должен рассчитываться правильно");
    }

    @Test
    void testBMICategoryNormal() {
        assertEquals("Норма", calculator.getBMICategory(22.0));
    }

    @Test
    void testBMICategoryUnderweight() {
        assertEquals("Недостаточный вес", calculator.getBMICategory(17.0));
    }

    @Test
    void testBMICategoryObesity() {
        assertEquals("Ожирение", calculator.getBMICategory(35.0));
    }

    @Test
    void testRecommendedMinWeight() {
        double minWeight = calculator.recommendedMinWeight(1.75);
        assertEquals(56.6, minWeight, 0.1);
    }

    @Test
    void testRecommendedMaxWeight() {
        double maxWeight = calculator.recommendedMaxWeight(1.75);
        assertEquals(76.2, maxWeight, 0.1);
    }

    @Test
    void testIsWeightNormalTrue() {
        assertTrue(calculator.isWeightNormal(70, 1.75));
    }

    @Test
    void testIsWeightNormalFalse() {
        assertFalse(calculator.isWeightNormal(100, 1.75));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(-70, 1.75));
    }


}
