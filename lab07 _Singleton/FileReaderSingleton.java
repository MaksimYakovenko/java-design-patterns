import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * Singleton клас для читання та обробки текстових файлів.
 * Забезпечує єдину точку доступу до операцій читання файлів у програмі.
 */
public class FileReaderSingleton {
    // Єдиний екземпляр класу (Thread-Safe)
    private static volatile FileReaderSingleton instance;

    // Кеш прочитаних файлів для оптимізації
    private final Map<String, List<String>> fileCache;

    // Статистика використання
    private int filesRead;
    private int cacheHits;

    /**
     * Приватний конструктор для запобігання створення екземплярів ззовні
     */
    private FileReaderSingleton() {
        this.fileCache = new HashMap<>();
        this.filesRead = 0;
        this.cacheHits = 0;
        System.out.println("FileReaderSingleton: Екземпляр створено");
    }

    /**
     * Отримання єдиного екземпляра класу (Double-Checked Locking)
     * @return єдиний екземпляр FileReaderSingleton
     */
    public static FileReaderSingleton getInstance() {
        if (instance == null) {
            synchronized (FileReaderSingleton.class) {
                if (instance == null) {
                    instance = new FileReaderSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Читає весь вміст файлу як список рядків
     * @param filePath шлях до файлу
     * @return список рядків файлу
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public List<String> readFile(String filePath) throws IOException {
        // Перевіряємо кеш
        if (fileCache.containsKey(filePath)) {
            cacheHits++;
            System.out.println("FileReaderSingleton: Файл взято з кешу: " + filePath);
            return new ArrayList<>(fileCache.get(filePath));
        }

        // Читаємо файл
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        // Зберігаємо в кеш
        fileCache.put(filePath, new ArrayList<>(lines));
        filesRead++;

        System.out.println("FileReaderSingleton: Файл прочитано: " + filePath);
        return lines;
    }

    /**
     * Читає файл та повертає його вміст як один рядок
     * @param filePath шлях до файлу
     * @return вміст файлу як рядок
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public String readFileAsString(String filePath) throws IOException {
        List<String> lines = readFile(filePath);
        return String.join(System.lineSeparator(), lines);
    }

    /**
     * Фільтрує рядки файлу за умовою
     * @param filePath шлях до файлу
     * @param filter умова фільтрації
     * @return відфільтровані рядки
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public List<String> readAndFilter(String filePath, java.util.function.Predicate<String> filter) throws IOException {
        List<String> lines = readFile(filePath);
        List<String> filtered = new ArrayList<>();
        for (String line : lines) {
            if (filter.test(line)) {
                filtered.add(line);
            }
        }
        return filtered;
    }

    /**
     * Підраховує кількість рядків у файлі
     * @param filePath шлях до файлу
     * @return кількість рядків
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public int countLines(String filePath) throws IOException {
        return readFile(filePath).size();
    }

    /**
     * Підраховує кількість слів у файлі
     * @param filePath шлях до файлу
     * @return кількість слів
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public int countWords(String filePath) throws IOException {
        List<String> lines = readFile(filePath);
        int wordCount = 0;
        for (String line : lines) {
            String[] words = line.trim().split("\\s+");
            if (words.length > 0 && !words[0].isEmpty()) {
                wordCount += words.length;
            }
        }
        return wordCount;
    }

    /**
     * Шукає рядки, що містять певний текст
     * @param filePath шлях до файлу
     * @param searchText текст для пошуку
     * @return список рядків, що містять текст
     * @throws IOException якщо файл не знайдено або виникла помилка читання
     */
    public List<String> searchInFile(String filePath, String searchText) throws IOException {
        return readAndFilter(filePath, line -> line.contains(searchText));
    }

    /**
     * Очищає кеш файлів
     */
    public void clearCache() {
        fileCache.clear();
        System.out.println("FileReaderSingleton: Кеш очищено");
    }

    /**
     * Видаляє конкретний файл з кешу
     * @param filePath шлях до файлу
     */
    public void removeFromCache(String filePath) {
        fileCache.remove(filePath);
        System.out.println("FileReaderSingleton: Файл видалено з кешу: " + filePath);
    }

    /**
     * Повертає статистику використання
     * @return рядок зі статистикою
     */
    public String getStatistics() {
        return String.format("Статистика FileReaderSingleton:%n" +
                "  Файлів прочитано: %d%n" +
                "  Звернень до кешу: %d%n" +
                "  Файлів у кеші: %d",
                filesRead, cacheHits, fileCache.size());
    }

    /**
     * Скидає статистику
     */
    public void resetStatistics() {
        filesRead = 0;
        cacheHits = 0;
        System.out.println("FileReaderSingleton: Статистику скинуто");
    }

    // Захист від клонування
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Клонування Singleton не дозволено");
    }

    // Захист від десеріалізації
    protected Object readResolve() {
        return getInstance();
    }
}

