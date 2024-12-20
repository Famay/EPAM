package A;

import org.A.PolynomialMultiplication;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialMultiplicationTest {

    @Test
    void testMultiplyPolynomialsSimple() {
        // Arrange
        List<Integer> poly1 = List.of(1, 2, 3); // 3x^2 + 2x + 1
        List<Integer> poly2 = List.of(1, 1);    // x + 1

        // Act
        List<Integer> result = PolynomialMultiplication.multiplyPolynomials(poly1, poly2);

        // Assert
        assertEquals(List.of(1, 3, 5, 3), result); // Ожидается: 3x^3 + 5x^2 + 3x + 1
    }

    @Test
    void testMultiplyPolynomialsWithZero() {
        // Arrange
        List<Integer> poly1 = List.of(0, 0, 0); // 0
        List<Integer> poly2 = List.of(1, 1);    // x + 1

        // Act
        List<Integer> result = PolynomialMultiplication.multiplyPolynomials(poly1, poly2);

        // Assert
        assertEquals(List.of(0, 0, 0, 0), result); // Ожидается: 0
    }

    @Test
    void testMultiplyPolynomialsWithSingleCoefficient() {
        // Arrange
        List<Integer> poly1 = List.of(3);       // 3
        List<Integer> poly2 = List.of(4);       // 4

        // Act
        List<Integer> result = PolynomialMultiplication.multiplyPolynomials(poly1, poly2);

        // Assert
        assertEquals(List.of(12), result); // Ожидается: 12
    }

    @Test
    void testMultiplyPolynomialsNegativeCoefficients() {
        // Arrange
        List<Integer> poly1 = List.of(-1, 2);   // 2x - 1
        List<Integer> poly2 = List.of(1, -3);   // -3x + 1

        // Act
        List<Integer> result = PolynomialMultiplication.multiplyPolynomials(poly1, poly2);

        // Assert
        assertEquals(List.of(-1, 5, -6), result); // Ожидается: -6x^2 + 5x - 1
    }
}

