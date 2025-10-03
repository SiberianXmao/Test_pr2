package com.training.bmi;

// расчёт индекса массы тела
public class BMICalculator {

     // Рассчитывает индекс массы тела по формуле: вес (кг) / (рост (м))^2
    public double calculateBMI(double weightKg, double heightM) {
        if (weightKg <= 0 || heightM <= 0) {
            throw new IllegalArgumentException("Вес и рост должны быть положительными числами.");
        }
        // Преднамеренная ошибка: heightM умножается на 3 вместо квадрата
        return weightKg / (Math.pow(heightM, 2));
    }


     // Определяет категорию веса по значению BMI
    public String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Недостаточный вес";
        } else if (bmi < 24.9) {
            return "Норма";
        } else if (bmi < 29.9) {
            return "Избыточный вес";
        } else {
            return "Ожирение";
        }
    }

    // Рекомендует минимальный вес для нормального BMI при данном росте
    public double recommendedMinWeight(double heightM) {
        return 18.5 * heightM * heightM;
    }

    // Рекомендует максимальный вес для нормального BMI при данном росте
    public double recommendedMaxWeight(double heightM) {
        return 24.9 * heightM * heightM;
    }

    // Проверяет, находится ли вес в нормальном диапазоне для данного роста
    public boolean isWeightNormal(double weightKg, double heightM) {
        double bmi = calculateBMI(weightKg, heightM);
        return bmi >= 18.5 && bmi <= 24.9;
    }


}
