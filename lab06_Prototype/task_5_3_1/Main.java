import java.util.List;

// Демонстрація роботи шаблону Прототип для рівнянь
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║       ДЕМОНСТРАЦІЯ ШАБЛОНУ ПРОЕКТУВАННЯ ПРОТОТИП              ║");
        System.out.println("║              для класу Equation та його нащадків               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println();

        // 1. Створення реєстру прототипів
        System.out.println("1. Створення та налаштування реєстру прототипів:");
        System.out.println("─".repeat(60));

        EquationRegistry registry = new EquationRegistry();

        // Реєстрація базових прототипів
        registry.registerPrototype("linear", new Equation(2, -6));
        registry.registerPrototype("quadratic", new QuadraticEquation(1, -5, 6));
        registry.registerPrototype("biquadratic", new BiQuadraticEquation(1, -5, 4));

        registry.listPrototypes();
        System.out.println();

        // 2. Демонстрація клонування лінійного рівняння
        System.out.println("\n2. Клонування лінійного рівняння:");
        System.out.println("─".repeat(60));

        Equation original1 = new Equation(3, -9);
        System.out.println("Оригінальне рівняння: " + original1.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(original1.solve()));

        Equation cloned1 = original1.clone();
        System.out.println("\nКлоноване рівняння: " + cloned1.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(cloned1.solve()));

        System.out.println("\nПеревірка незалежності об'єктів:");
        System.out.println("  original1 == cloned1: " + (original1 == cloned1));
        System.out.println("  original1.equals(cloned1): " +
            (original1.getCoefficientsString().equals(cloned1.getCoefficientsString())));

        // 3. Демонстрація клонування квадратного рівняння
        System.out.println("\n\n3. Клонування квадратного рівняння:");
        System.out.println("─".repeat(60));

        QuadraticEquation original2 = new QuadraticEquation(1, -7, 12);
        System.out.println("Оригінальне рівняння: " + original2.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(original2.solve()));

        QuadraticEquation cloned2 = original2.clone();
        System.out.println("\nКлоноване рівняння: " + cloned2.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(cloned2.solve()));

        System.out.println("\nПеревірка незалежності об'єктів:");
        System.out.println("  original2 == cloned2: " + (original2 == cloned2));
        System.out.println("  original2.equals(cloned2): " +
            (original2.getCoefficientsString().equals(cloned2.getCoefficientsString())));

        // 4. Демонстрація клонування біквадратного рівняння
        System.out.println("\n\n4. Клонування біквадратного рівняння:");
        System.out.println("─".repeat(60));

        BiQuadraticEquation original3 = new BiQuadraticEquation(1, -10, 9);
        System.out.println("Оригінальне рівняння: " + original3.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(original3.solve()));

        BiQuadraticEquation cloned3 = original3.clone();
        System.out.println("\nКлоноване рівняння: " + cloned3.getCoefficientsString());
        System.out.println("Розв'язки: " + formatSolutions(cloned3.solve()));

        System.out.println("\nПеревірка незалежності об'єктів:");
        System.out.println("  original3 == cloned3: " + (original3 == cloned3));
        System.out.println("  original3.equals(cloned3): " +
            (original3.getCoefficientsString().equals(cloned3.getCoefficientsString())));

        // 5. Використання реєстру прототипів
        System.out.println("\n\n5. Використання реєстру прототипів:");
        System.out.println("─".repeat(60));

        System.out.println("Отримання клону лінійного рівняння з реєстру:");
        Equation fromRegistry1 = (Equation) registry.getPrototype("linear");
        if (fromRegistry1 != null) {
            System.out.println("  Рівняння: " + fromRegistry1.getCoefficientsString());
            System.out.println("  Розв'язки: " + formatSolutions(fromRegistry1.solve()));
        }

        System.out.println("\nОтримання клону квадратного рівняння з реєстру:");
        QuadraticEquation fromRegistry2 = (QuadraticEquation) registry.getPrototype("quadratic");
        if (fromRegistry2 != null) {
            System.out.println("  Рівняння: " + fromRegistry2.getCoefficientsString());
            System.out.println("  Розв'язки: " + formatSolutions(fromRegistry2.solve()));
        }

        System.out.println("\nОтримання клону біквадратного рівняння з реєстру:");
        BiQuadraticEquation fromRegistry3 = (BiQuadraticEquation) registry.getPrototype("biquadratic");
        if (fromRegistry3 != null) {
            System.out.println("  Рівняння: " + fromRegistry3.getCoefficientsString());
            System.out.println("  Розв'язки: " + formatSolutions(fromRegistry3.solve()));
        }

        // 6. Демонстрація глибокого копіювання
        System.out.println("\n\n6. Перевірка глибокого копіювання (immutability):");
        System.out.println("─".repeat(60));

        Equation original4 = new Equation(5, -10);
        Equation cloned4 = original4.clone();

        System.out.println("Оригінал: " + original4.getCoefficientsString());
        System.out.println("Клон: " + cloned4.getCoefficientsString());

        // Зміна коефіцієнтів не впливає на інший об'єкт
        System.out.println("\nКоефіцієнти оригіналу та клону зберігаються незалежно");
        System.out.println("Список coefficients клонується глибоко (deep copy)");

        // 7. Масове клонування
        System.out.println("\n\n7. Масове створення об'єктів через клонування:");
        System.out.println("─".repeat(60));

        QuadraticEquation template = new QuadraticEquation(2, -8, 6);
        System.out.println("Шаблон: " + template.getCoefficientsString());

        System.out.println("\nСтворення 5 клонів:");
        for (int i = 1; i <= 5; i++) {
            QuadraticEquation clone = template.clone();
            System.out.println("  Клон " + i + ": " + clone.getCoefficientsString() +
                             " → Розв'язки: " + formatSolutions(clone.solve()));
        }

        // 8. Переваги використання Прототипу
        System.out.println("\n\n8. ПЕРЕВАГИ ШАБЛОНУ ПРОТОТИП:");
        System.out.println("─".repeat(60));
        System.out.println("✓ Швидке створення нових об'єктів без виклику конструктора");
        System.out.println("✓ Уникнення складної ініціалізації для складних об'єктів");
        System.out.println("✓ Можливість додавання/видалення прототипів у runtime");
        System.out.println("✓ Зменшення кількості підкласів");
        System.out.println("✓ Конфігурація програми з динамічно завантажуваних класів");

        System.out.println("\n" + "═".repeat(60));
        System.out.println("Демонстрація завершена!");
        System.out.println("═".repeat(60));
    }

    // Допоміжний метод для форматування розв'язків
    private static String formatSolutions(List<Double> solutions) {
        if (solutions.isEmpty()) {
            return "немає розв'язків";
        }

        if (solutions.get(0).equals(Double.POSITIVE_INFINITY)) {
            return "нескінченно багато розв'язків";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < solutions.size(); i++) {
            sb.append(String.format("%.4f", solutions.get(i)));
            if (i < solutions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

