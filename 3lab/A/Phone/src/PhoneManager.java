 import java.util.*;

public class PhoneManager {
    public static void main(String[] args) {
        // Создаем массив объектов
        Phone[] phones = {
                new Phone(1, "Иванов", "Иван", "Иванович", "ул. Ленина, 10", "1234-5678-9012-3456", 500.0, 100.0, 120, 50),
                new Phone(2, "Петров", "Петр", "Петрович", "ул. Пушкина, 20", "9876-5432-1098-7654", 300.0, 50.0, 80, 0),
                new Phone(3, "Сидоров", "Семен", "Семенович", "ул. Чехова, 5", "6543-2109-8765-4321", 700.0, 200.0, 150, 30)
        };

        int localCallThreshold = 100;
        System.out.println("\nАбоненты, у которых время внутригородских разговоров превышает " + localCallThreshold + ":");
        for (Phone phone : phones) {
            if (phone.getLocalCallTime() > localCallThreshold) {
                System.out.println(phone);
            }
        }

        System.out.println("\nАбоненты, которые пользовались междугородной связью:");
        for (Phone phone : phones) {
            if (phone.getInterCityCallTime() > 0) {
                System.out.println(phone);
            }
        }

        System.out.println("\nАбоненты в алфавитном порядке:");
        Arrays.sort(phones, Comparator.comparing(Phone::getLastName));
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}
