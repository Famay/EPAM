 public class test {
    public static void main(String[] args) {
        Winchester winchester = new Winchester(512);
        DiskDrive diskDrive = new DiskDrive("DVD");
        RAM ram = new RAM(16);
        Processor processor = new Processor("Intel Core i7");

        Kompik computer = new Kompik(winchester, diskDrive, ram, processor);

        System.out.println(computer);


        computer.turnOn();
        computer.checkForViruses();
        computer.displayWinchesterSize();
        computer.displayRAMInfo();
        computer.displayDiskDriveInfo();
        computer.turnOff();
    }
}
