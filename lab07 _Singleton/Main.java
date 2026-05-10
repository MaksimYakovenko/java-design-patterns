import java.io.IOException;
import java.util.List;

/**
 * Демонстрація використання шаблону Singleton для читання та обробки текстових файлів
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація шаблону Singleton ===\n");
        
        // Демонстрація 1: Створення єдиного екземпляра
        demonstrateSingleInstance();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Демонстрація 2: Читання та обробка файлів
        demonstrateFileReading();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Демонстрація 3: Робота з кешем
        demonstrateCaching();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Демонстрація 4: Статистика
        demonstrateStatistics();
    }
    
    /**
     * Демонструє, що створюється тільки один екземпляр
     */
    private static void demonstrateSingleInstance() {
        System.out.println("1. Демонстрація єдиного екземпляра:");
        System.out.println("-".repeat(50));
        
        FileReaderSingleton reader1 = FileReaderSingleton.getInstance();
        FileReaderSingleton reader2 = FileReaderSingleton.getInstance();
        FileReaderSingleton reader3 = FileReaderSingleton.getInstance();
        
        System.out.println("reader1 == reader2: " + (reader1 == reader2));
        System.out.println("reader2 == reader3: " + (reader2 == reader3));
        System.out.println("reader1 == reader3: " + (reader1 == reader3));
        System.out.println("HashCode reader1: " + reader1.hashCode());
        System.out.println("HashCode reader2: " + reader2.hashCode());
        System.out.println("HashCode reader3: " + reader3.hashCode());
        
        System.out.println("\nВисновок: Всі посилання вказують на один і той самий об'єкт!");
    }
    
    /**
     * Демонструє читання та обробку файлів
     */
    private static void demonstrateFileReading() {
        System.out.println("2. Читання та обробка файлів:");
        System.out.println("-".repeat(50));
        
        FileReaderSingleton reader = FileReaderSingleton.getInstance();
        
        try {
            // Читання файлу 1
            String file1 = "lab07 _Singleton/sample1.txt";
            System.out.println("\n📄 Читання файлу: " + file1);
            List<String> lines1 = reader.readFile(file1);
            System.out.println("Вміст файлу:");
            for (int i = 0; i < lines1.size(); i++) {
                System.out.println("  " + (i + 1) + ": " + lines1.get(i));
            }
            
            // Підрахунок статистики
            System.out.println("\nСтатистика файлу:");
            System.out.println("  Кількість рядків: " + reader.countLines(file1));
            System.out.println("  Кількість слів: " + reader.countWords(file1));
            
            // Читання файлу 2
            String file2 = "lab07 _Singleton/sample2.txt";
            System.out.println("\n📄 Читання файлу: " + file2);
            String content = reader.readFileAsString(file2);
            System.out.println("Вміст файлу як рядок:");
            System.out.println("  " + content);
            
            // Пошук у файлі
            System.out.println("\n🔍 Пошук слова 'шаблон' у файлі:");
            List<String> searchResults = reader.searchInFile(file2, "шаблон");
            if (searchResults.isEmpty()) {
                System.out.println("  Нічого не знайдено");
            } else {
                for (String line : searchResults) {
                    System.out.println("  - " + line);
                }
            }
            
            // Фільтрація
            System.out.println("\n🔍 Фільтрація: рядки довші за 20 символів:");
            List<String> filtered = reader.readAndFilter(file1, line -> line.length() > 20);
            for (String line : filtered) {
                System.out.println("  - " + line);
            }
            
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            System.out.println("\n⚠️ Створіть тестові файли sample1.txt та sample2.txt у папці lab07 _Singleton");
        }
    }
    
    /**
     * Демонструє роботу кешу
     */
    private static void demonstrateCaching() {
        System.out.println("3. Демонстрація кешування:");
        System.out.println("-".repeat(50));
        
        FileReaderSingleton reader = FileReaderSingleton.getInstance();
        String filePath = "lab07 _Singleton/sample1.txt";
        
        try {
            System.out.println("\n📖 Перше читання файлу (з диска):");
            reader.readFile(filePath);
            
            System.out.println("\n📖 Друге читання того ж файлу (з кешу):");
            reader.readFile(filePath);
            
            System.out.println("\n📖 Третє читання того ж файлу (з кешу):");
            reader.readFile(filePath);
            
            System.out.println("\n🗑️ Очищення кешу...");
            reader.clearCache();
            
            System.out.println("\n📖 Читання після очищення кешу (знову з диска):");
            reader.readFile(filePath);
            
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
    
    /**
     * Демонструє статистику використання
     */
    private static void demonstrateStatistics() {
        System.out.println("4. Статистика використання:");
        System.out.println("-".repeat(50));
        
        FileReaderSingleton reader = FileReaderSingleton.getInstance();
        
        System.out.println("\n" + reader.getStatistics());
        
        System.out.println("\n🔄 Скидання статистики...");
        reader.resetStatistics();
        reader.clearCache();
        
        System.out.println("\n" + reader.getStatistics());
    }
}

