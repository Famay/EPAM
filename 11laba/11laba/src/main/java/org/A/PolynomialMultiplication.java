package org.A;

import java.util.ArrayList;
import java.util.List;

public class PolynomialMultiplication {

    public static List<Integer> multiplyPolynomials(List<Integer> poly1, List<Integer> poly2) {
        // Определяем степень результирующего многочлена
        int degree1 = poly1.size() - 1;
        int degree2 = poly2.size() - 1;
        int resultDegree = degree1 + degree2;

        // Инициализируем результирующий список нулями
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= resultDegree; i++) {
            result.add(0);
        }

        // Умножаем коэффициенты многочленов
        for (int i = 0; i < poly1.size(); i++) {
            for (int j = 0; j < poly2.size(); j++) {
                int currentValue = result.get(i + j);
                result.set(i + j, currentValue + poly1.get(i) * poly2.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример многочленов: poly1 = 3x^2 + 2x + 1, poly2 = x + 1
        List<Integer> poly1 = List.of(1, 2, 3); // Коэффициенты: [1, 2, 3]
        List<Integer> poly2 = List.of(1, 1);    // Коэффициенты: [1, 1]

        List<Integer> result = multiplyPolynomials(poly1, poly2);

        System.out.println("Результат умножения многочленов: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == 0 ? "" : "x^" + i) + (i < result.size() - 1 ? " + " : "\n"));
        }
    }
}
