/**
 * Клас, що представляє одяг із мінімум 5 полями.
 * Реалізує інтерфейс Comparable для сортування за ціною.
 *
 * @author Student
 * @version 1.0
 */
public class Clothing implements Comparable<Clothing> {

    /** Назва одягу */
    private String name;

    /** Розмір одягу (наприклад, S, M, L, XL) */
    private String size;

    /** Колір одягу */
    private String color;

    /** Ціна одягу в гривнях */
    private double price;

    /** Матеріал одягу */
    private String material;

    /** Бренд одягу */
    private String brand;

    /**
     * Конструктор для створення об'єкта одягу.
     *
     * @param name     назва одягу
     * @param size     розмір одягу
     * @param color    колір одягу
     * @param price    ціна одягу
     * @param material матеріал одягу
     * @param brand    бренд одягу
     */
    public Clothing(String name, String size, String color,
                    double price, String material, String brand) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.material = material;
        this.brand = brand;
    }

    // ─── Гетери ───────────────────────────────────────────────────────────────

    /** @return назва одягу */
    public String getName() { return name; }

    /** @return розмір одягу */
    public String getSize() { return size; }

    /** @return колір одягу */
    public String getColor() { return color; }

    /** @return ціна одягу */
    public double getPrice() { return price; }

    /** @return матеріал одягу */
    public String getMaterial() { return material; }

    /** @return бренд одягу */
    public String getBrand() { return brand; }

    // ─── Сетери ───────────────────────────────────────────────────────────────

    /** @param name нова назва одягу */
    public void setName(String name) { this.name = name; }

    /** @param size новий розмір одягу */
    public void setSize(String size) { this.size = size; }

    /** @param color новий колір одягу */
    public void setColor(String color) { this.color = color; }

    /** @param price нова ціна одягу */
    public void setPrice(double price) { this.price = price; }

    /** @param material новий матеріал одягу */
    public void setMaterial(String material) { this.material = material; }

    /** @param brand новий бренд одягу */
    public void setBrand(String brand) { this.brand = brand; }

    // ─── Порівняння ───────────────────────────────────────────────────────────

    /**
     * Порівнює об'єкти за ціною (зростання) — використовується для сортування.
     *
     * @param other інший об'єкт одягу
     * @return негативне, 0 або позитивне число
     */
    @Override
    public int compareTo(Clothing other) {
        return Double.compare(this.price, other.price);
    }

    /**
     * Перевіряє повну ідентичність двох об'єктів одягу.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо всі поля збігаються
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothing other = (Clothing) obj;
        return Double.compare(other.price, price) == 0
                && name.equals(other.name)
                && size.equals(other.size)
                && color.equals(other.color)
                && material.equals(other.material)
                && brand.equals(other.brand);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + material.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    /**
     * Повертає рядкове представлення об'єкта одягу.
     *
     * @return рядок з усіма полями
     */
    @Override
    public String toString() {
        return String.format(
                "Clothing{name='%s', size='%s', color='%s', price=%.2f грн, material='%s', brand='%s'}",
                name, size, color, price, material, brand);
    }
}
