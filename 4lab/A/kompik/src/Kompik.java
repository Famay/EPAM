 import java.util.Objects;
// Класс Компьютер
class Kompik {
    private Winchester winchester;
    private DiskDrive diskDrive;
    private RAM ram;
    private Processor processor;
    private boolean isOn;

    public Kompik(Winchester winchester, DiskDrive diskDrive, RAM ram, Processor processor) {
        this.winchester = winchester;
        this.diskDrive = diskDrive;
        this.ram = ram;
        this.processor = processor;
        this.isOn = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Компьютер включен.");
        } else {
            System.out.println("Компьютер уже включен.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Компьютер выключен.");
        } else {
            System.out.println("Компьютер уже выключен.");
        }
    }

    public void checkForViruses() {
        if (isOn) {
            System.out.println("Проверка на вирусы завершена. Угроз не обнаружено.");
        } else {
            System.out.println("Невозможно проверить на вирусы. Компьютер выключен.");
        }
    }

    public void displayWinchesterSize() {
        System.out.println("Размер винчестера: " + winchester.getSize() + " GB");
    }

    public void displayRAMInfo() {
        System.out.println("Оперативная память: " + ram.getCapacity() + " GB");
    }

    public void displayDiskDriveInfo() {
        System.out.println("Тип дисковода: " + diskDrive.getType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kompik computer = (Kompik) o;
        return isOn == computer.isOn &&
                winchester.equals(computer.winchester) &&
                diskDrive.equals(computer.diskDrive) &&
                ram.equals(computer.ram) &&
                processor.equals(computer.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winchester, diskDrive, ram, processor, isOn);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "winchester=" + winchester +
                ", diskDrive=" + diskDrive +
                ", ram=" + ram +
                ", processor=" + processor +
                ", isOn=" + isOn +
                '}';
    }
}
