 // Класс Оперативная память
class RAM {
    private int capacity; // Объем в гигабайтах

    public RAM(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return capacity == ram.capacity;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(capacity);
    }

    @Override
    public String toString() {
        return "RAM{" +
                "Вместимость=" + capacity +
                " GB}";
    }
}