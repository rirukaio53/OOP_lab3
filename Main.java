import java.util.Arrays;
import java.util.Comparator;


public class Main {

    /**
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {

        // ─── 1. Створення масиву об'єктів Clothing ────────────────────────────
        Clothing[] clothes = {
            new Clothing("Футболка",   "M",  "Біла",    450.00, "Бавовна",   "Zara"),
            new Clothing("Джинси",     "L",  "Синя",   1200.00, "Деним",     "Levi's"),
            new Clothing("Куртка",     "XL", "Чорна",  3500.00, "Поліестер", "Nike"),
            new Clothing("Светр",      "S",  "Сіра",    890.00, "Вовна",     "H&M"),
            new Clothing("Сорочка",    "M",  "Блакитна", 650.00, "Льон",     "Zara"),
            new Clothing("Спідниця",   "S",  "Червона",  780.00, "Шовк",     "Mango"),
            new Clothing("Пальто",     "L",  "Бежева", 4200.00, "Кашемір",   "Massimo Dutti"),
            new Clothing("Шорти",      "M",  "Зелена",  350.00, "Бавовна",   "Adidas"),
        };

        // ─── 2. Вивід початкового масиву ──────────────────────────────────────
        System.out.println("=== Початковий масив ===");
        printArray(clothes);

        // ─── 3. Сортування за ціною (зростання) — Comparable / Arrays.sort ───
        Arrays.sort(clothes);   // використовує compareTo() → сортує за price ASC
        System.out.println("\n=== Сортування за ціною (зростання) ===");
        printArray(clothes);

        // ─── 4. Сортування за брендом (спадання) — Comparator / Arrays.sort ──
        Arrays.sort(clothes, Comparator.comparing(Clothing::getBrand).reversed());
        System.out.println("\n=== Сортування за брендом (спадання) ===");
        printArray(clothes);

        // ─── 5. Пошук ідентичного об'єкта ────────────────────────────────────
        // Об'єкт-зразок, ідентичний одному з елементів масиву
        Clothing target =  new Clothing("Футболка",   "M",  "Біла",    450.00, "Бавовна",   "Zara");
        System.out.println("\n=== Пошук ідентичного об'єкта ===");
        System.out.println("Шукаємо: " + target);

        int foundIndex = findIdentical(clothes, target);
        if (foundIndex >= 0) {
            System.out.println("Знайдено на індексі " + foundIndex + ": " + clothes[foundIndex]);
        } else {
            System.out.println("Об'єкт не знайдено в масиві.");
        }
    }

    /**
     * Виводить усі елементи масиву одягу в консоль.
     *
     * @param clothes масив об'єктів {@link Clothing}
     */
    private static void printArray(Clothing[] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            System.out.printf("[%d] %s%n", i, clothes[i]);
        }
    }

    /**
     * Знаходить перший елемент масиву, ідентичний заданому об'єкту.
     *
     * <p>Ідентичність визначається через {@link Clothing#equals(Object)},
     * тобто всі поля повинні збігатися.
     *
     * @param clothes масив об'єктів для пошуку
     * @param target  об'єкт-зразок для порівняння
     * @return індекс знайденого елемента або {@code -1}, якщо не знайдено
     */
    private static int findIdentical(Clothing[] clothes, Clothing target) {
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
