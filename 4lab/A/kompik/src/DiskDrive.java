 class DiskDrive {
    private String type; // Тип дисковода (например, DVD, Blu-ray)

    public DiskDrive(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiskDrive that = (DiskDrive) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "DiskDrive{" +
                "type='" + type + '\'' +
                '}';
    }
}