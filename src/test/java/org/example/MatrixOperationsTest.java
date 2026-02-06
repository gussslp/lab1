package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrixOperationsTest {
    @Test
    void testAdd() {
        double[][] m1 = {{1, 2}, {3, 4}};
        double[][] m2 = {{1, 1}, {1, 1}};

        // Очікуємо: {{2, 3}, {4, 5}}
        double[][] result = MatrixOperations.add(m1, m2);

        assertEquals(2.0, result[0][0], 0.0001); // 1+1 = 2
        assertEquals(5.0, result[1][1], 0.0001); // 4+1 = 5
    }

    @Test
    void testAverage() {
        double[][] m = {
                {2, 4}, // Середнє 3
                {10, 20} // Середнє 15
        };

        double[] result = MatrixOperations.findAverage(m);

        assertEquals(3.0, result[0], 0.0001);
        assertEquals(15.0, result[1], 0.0001);
    }

    @Test
    void testError() {
        // Перевіряємо, чи програма "свариться" на різні розміри
        double[][] m1 = {{1}};
        double[][] m2 = {{1, 2}}; // інший розмір

        assertThrows(IllegalArgumentException.class, () -> MatrixOperations.add(m1, m2));
    }
}