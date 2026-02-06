package org.example;

public class MatrixOperations {

    public static void main(String[] args) {
        double[][] A = {{1.5, 2.0, 4.7}, {4.2, 5.1, 8.1}, {3.2, 1.8, 0.4}};
        double[][] B = {{0.5, 3.0, 1.3}, {2.8, 1.9, 2.6}, {1.5, 2.1, 0.1}};

        try {
            double[][] C = add(A, B);

            System.out.println("Матриця C:");
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    System.out.printf("%8.2f", C[i][j]);
                }
                System.out.println();
            }

            double[] averages = findAverage(C);

            System.out.println("\nСередні значення:");
            for (int i = 0; i < averages.length; i++) {
                System.out.printf("\nРядок %d: %.2f",i+1, averages[i]);
            }

        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Різні розміри матриць!");
        }
        int rows = a.length;
        int cols = a[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    static double[] findAverage(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[] avg = new double[rows];

        for (int i = 0; i < rows; i++) {
            double sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
            avg[i] = sum / cols;
        }
        return avg;
    }
}