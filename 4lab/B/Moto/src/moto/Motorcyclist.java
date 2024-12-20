 package moto;
import java.util.*;

class Motorcyclist {
    private List<Equipment> equipmentList;

    public Motorcyclist() {
        this.equipmentList = new ArrayList<>();
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public double calculateTotalPrice() {
        return equipmentList.stream().mapToDouble(Equipment::getPrice).sum();
    }

    public void sortEquipmentByWeight() {
        equipmentList.sort(Comparator.comparingDouble(Equipment::getWeight));
    }

    public List<Equipment> findEquipmentByPriceRange(double minPrice, double maxPrice) {
        List<Equipment> result = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            if (equipment.getPrice() >= minPrice && equipment.getPrice() <= maxPrice) {
                result.add(equipment);
            }
        }
        return result;
    }

    public void displayEquipment() {
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment);
        }
    }
}