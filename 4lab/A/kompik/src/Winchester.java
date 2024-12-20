
class Winchester {
    private int size; // Размер в гигабайтах

    public Winchester(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winchester that = (Winchester) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(size);
    }

    @Override
    public String toString() {
        return "Winchester{" +
                "size=" + size +
                " GB}";
    }
}