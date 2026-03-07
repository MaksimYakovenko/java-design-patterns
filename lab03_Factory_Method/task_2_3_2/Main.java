import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] inputFiles = {"input01.txt", "input02.txt", "input03.txt"};

        for (String filename : inputFiles) {
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("║  Аналіз рівнянь з файлу: " + String.format("%-30s", filename) + "║");
            System.out.println("╚════════════════════════════════════════════════════════════╝");
            System.out.println();

            try {
                processFile(filename);
            } catch (IOException e) {
                System.err.println("Помилка читання файлу " + filename + ": " + e.getMessage());
            }

            System.out.println("\n" + "═".repeat(60) + "\n");
        }
    }

    private static void processFile(String filename) throws IOException {
        List<Equation> equations = readEquationsFromFile(filename);

        if (equations.isEmpty()) {
            System.out.println("Файл порожній або не містить коректних рівнянь.");
            return;
        }

        System.out.println("Всього рівнянь прочитано: " + equations.size());
        System.out.println();

        classifyEquations(equations);
        findExtremeSolutions(equations);
    }

    private static List<Equation> readEquationsFromFile(String filename) throws IOException {
        List<Equation> equations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    String[] parts = line.split("\\s+");
                    double[] coefficients = new double[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        coefficients[i] = Double.parseDouble(parts[i]);
                    }

                    Equation equation = EquationFactory.createEquation(coefficients);
                    equations.add(equation);

                } catch (Exception e) {
                    System.err.println("Помилка в рядку " + lineNumber + ": " + e.getMessage());
                }
            }
        }

        return equations;
    }

    private static void classifyEquations(List<Equation> equations) {
        List<Equation> noSolutions = new ArrayList<>();
        List<Equation> oneSolution = new ArrayList<>();
        List<Equation> twoSolutions = new ArrayList<>();
        List<Equation> threeSolutions = new ArrayList<>();
        List<Equation> fourSolutions = new ArrayList<>();
        List<Equation> infiniteSolutions = new ArrayList<>();

        for (Equation eq : equations) {
            List<Double> solutions = eq.solve();

            if (!solutions.isEmpty() && solutions.get(0).equals(Double.POSITIVE_INFINITY)) {
                infiniteSolutions.add(eq);
            } else {
                switch (solutions.size()) {
                    case 0:
                        noSolutions.add(eq);
                        break;
                    case 1:
                        oneSolution.add(eq);
                        break;
                    case 2:
                        twoSolutions.add(eq);
                        break;
                    case 3:
                        threeSolutions.add(eq);
                        break;
                    case 4:
                        fourSolutions.add(eq);
                        break;
                }
            }
        }

        System.out.println("КЛАСИФІКАЦІЯ РІВНЯНЬ ЗА КІЛЬКІСТЮ РОЗВ'ЯЗКІВ:");
        System.out.println("─".repeat(60));

        printCategory("Рівняння без розв'язків", noSolutions, false);
        printCategory("Рівняння з одним розв'язком", oneSolution, true);
        printCategory("Рівняння з двома розв'язками", twoSolutions, true);
        printCategory("Рівняння з трьома розв'язками", threeSolutions, true);
        printCategory("Рівняння з чотирма розв'язками", fourSolutions, true);
        printCategory("Рівняння з нескінченною кількістю розв'язків", infiniteSolutions, false);
    }

    private static void printCategory(String categoryName, List<Equation> equations, boolean showSolutions) {
        System.out.println("\n" + categoryName + ": " + equations.size());

        if (!equations.isEmpty() && equations.size() <= 10) {
            for (Equation eq : equations) {
                System.out.print("  " + eq.getCoefficientsString());

                if (showSolutions) {
                    List<Double> solutions = eq.solve();
                    System.out.print(" → Розв'язки: ");
                    for (int i = 0; i < solutions.size(); i++) {
                        System.out.printf("%.6f", solutions.get(i));
                        if (i < solutions.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                }
                System.out.println();
            }
        } else if (equations.size() > 10) {
            System.out.println("  (показано перші 5 з " + equations.size() + ")");
            for (int i = 0; i < Math.min(5, equations.size()); i++) {
                Equation eq = equations.get(i);
                System.out.print("  " + eq.getCoefficientsString());

                if (showSolutions) {
                    List<Double> solutions = eq.solve();
                    System.out.print(" → Розв'язки: ");
                    for (int j = 0; j < solutions.size(); j++) {
                        System.out.printf("%.6f", solutions.get(j));
                        if (j < solutions.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    private static void findExtremeSolutions(List<Equation> equations) {
        double minSolution = Double.POSITIVE_INFINITY;
        double maxSolution = Double.NEGATIVE_INFINITY;
        Equation minEquation = null;
        Equation maxEquation = null;

        for (Equation eq : equations) {
            List<Double> solutions = eq.solve();

            if (solutions.size() == 1 && !solutions.get(0).equals(Double.POSITIVE_INFINITY)) {
                double solution = solutions.get(0);

                if (solution < minSolution) {
                    minSolution = solution;
                    minEquation = eq;
                }

                if (solution > maxSolution) {
                    maxSolution = solution;
                    maxEquation = eq;
                }
            }
        }

        System.out.println("\n" + "─".repeat(60));
        System.out.println("ЕКСТРЕМАЛЬНІ РОЗВ'ЯЗКИ (серед рівнянь з одним розв'язком):");
        System.out.println("─".repeat(60));

        if (minEquation != null) {
            System.out.println("\nНайменший розв'язок: " + String.format("%.6f", minSolution));
            System.out.println("  Рівняння: " + minEquation.getCoefficientsString());
        } else {
            System.out.println("\nНемає рівнянь з одним розв'язком");
        }

        if (maxEquation != null) {
            System.out.println("\nНайбільший розв'язок: " + String.format("%.6f", maxSolution));
            System.out.println("  Рівняння: " + maxEquation.getCoefficientsString());
        }
    }
}

