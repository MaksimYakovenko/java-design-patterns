public class Main {
    public static void main(String[] args) {
        System.out.println("=== Шаблон Builder для формування рядків ===\n");

        // Демонстрація базових можливостей Builder
        demonstrateBasicBuilder();

        // Демонстрація методу insert
        demonstrateInsertMethod();

        // Демонстрація Director
        demonstrateDirector();

        // Демонстрація додаткових можливостей
        demonstrateAdvancedFeatures();
    }

    private static void demonstrateBasicBuilder() {
        System.out.println("1. Базове використання Builder (метод append):");
        System.out.println("------------------------------------------------");

        CustomString result1 = new StringBuilderPattern()
                .append("Hello")
                .append(" ")
                .append("World")
                .append("!")
                .build();

        System.out.println("Результат: " + result1);
        System.out.println();

        // Додавання різних типів даних
        CustomString result2 = new StringBuilderPattern()
                .append("Число: ")
                .append(42)
                .append(", Дробове: ")
                .append(3.14)
                .append(", Символ: ")
                .append('A')
                .build();

        System.out.println("Різні типи: " + result2);
        System.out.println();
    }

    private static void demonstrateInsertMethod() {
        System.out.println("2. Використання методу insert:");
        System.out.println("------------------------------------------------");

        StringBuilderPattern builder = new StringBuilderPattern("Hello World!");
        System.out.println("Початковий рядок: " + builder);

        builder.insert(6, "Beautiful ");
        System.out.println("Після insert(6, \"Beautiful \"): " + builder);

        builder.insert(0, ">>> ");
        System.out.println("Після insert(0, \">>> \"): " + builder);

        builder.insert(builder.length(), " <<<");
        System.out.println("Після insert(кінець, \" <<<\"): " + builder);
        System.out.println();

        // Вставка чисел
        StringBuilderPattern builder2 = new StringBuilderPattern("Позиція: ");
        builder2.append("X").insert(9, 100);
        System.out.println("Вставка числа: " + builder2);
        System.out.println();
    }

    private static void demonstrateDirector() {
        System.out.println("3. Використання Director для типових сценаріїв:");
        System.out.println("------------------------------------------------");

        StringDirector director = new StringDirector();

        // HTML документ
        System.out.println("HTML документ:");
        CustomString html = director.buildHTMLDocument(
                "Моя сторінка",
                "<h1>Вітаємо!</h1>"
        );
        System.out.println(html);
        System.out.println();

        // JSON
        System.out.println("JSON об'єкт:");
        CustomString json = director.buildJSON(new String[][] {
                {"name", "Іван"},
                {"age", "25"},
                {"city", "Київ"}
        });
        System.out.println(json);
        System.out.println();

        // SQL запит
        System.out.println("SQL INSERT:");
        CustomString sql = director.buildSQLInsert(
                "users",
                new String[]{"name", "email", "age"},
                new String[]{"Марія", "maria@example.com", "30"}
        );
        System.out.println(sql);
        System.out.println();

        // Список
        System.out.println("Нумерований список:");
        CustomString list = director.buildList(
                new String[]{"Перший пункт", "Другий пункт", "Третій пункт"},
                true
        );
        System.out.println(list);

        // URL з параметрами
        System.out.println("URL з параметрами:");
        CustomString url = director.buildURL(
                "https://example.com/search",
                new String[][]{{"q", "java"}, {"page", "1"}, {"lang", "uk"}}
        );
        System.out.println(url);
        System.out.println();
    }

    private static void demonstrateAdvancedFeatures() {
        System.out.println("4. Додаткові можливості:");
        System.out.println("------------------------------------------------");

        // appendLine
        CustomString multiline = new StringBuilderPattern()
                .appendLine("Перший рядок")
                .appendLine("Другий рядок")
                .appendLine("Третій рядок")
                .build();
        System.out.println("Багаторядковий текст:");
        System.out.println(multiline);

        // Replace
        StringBuilderPattern builder = new StringBuilderPattern("Hello World");
        builder.replace(6, 11, "Java");
        System.out.println("Після replace(6, 11, \"Java\"): " + builder);

        // Delete
        builder.delete(0, 6);
        System.out.println("Після delete(0, 6): " + builder);

        // Reverse
        builder.reverse();
        System.out.println("Після reverse(): " + builder);

        // Clear
        builder.clear().append("Новий рядок після очищення");
        System.out.println("Після clear() та append: " + builder);
        System.out.println();

        // Складний приклад з комбінацією методів
        System.out.println("Складний приклад:");
        StringBuilderPattern complexBuilder = new StringBuilderPattern()
                .append("Результат обчислення: ")
                .append(10)
                .append(" + ")
                .append(20)
                .append(" = ");

        complexBuilder.insert(22, "<<");
        complexBuilder.append(30);
        complexBuilder.insert(complexBuilder.length(), ">>");

        CustomString complex = complexBuilder.build();
        System.out.println(complex);
    }
}