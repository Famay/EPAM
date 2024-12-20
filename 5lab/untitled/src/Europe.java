 import java.util.ArrayList;
import java.util.List;

public class Europe {

    private List<CountryHistory> historyList;

    public Europe() {
        this.historyList = new ArrayList<>();
    }

    public void addCountryHistory(String countryName, String eventDescription, int year) {
        this.historyList.add(new CountryHistory(countryName, eventDescription, year));
    }

    public void displayHistory() {
        for (CountryHistory history : historyList) {
            System.out.println(history);
        }
    }

    // Внутренний класс для хранения истории страны
    private class CountryHistory {
        private String countryName;
        private String eventDescription;
        private int year;

        public CountryHistory(String countryName, String eventDescription, int year) {
            this.countryName = countryName;
            this.eventDescription = eventDescription;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Страна: " + countryName + ", Событие: " + eventDescription + ", Год: " + year;
        }
    }

    public static void main(String[] args) {
        Europe europe = new Europe();

        // Добавление данных об изменении территориального деления
        europe.addCountryHistory("Германия", "Объединение Восточной и Западной Германии", 1990);
        europe.addCountryHistory("Чехословакия", "Распад на Чехию и Словакию", 1993);
        europe.addCountryHistory("Югославия", "Распад на несколько независимых государств", 1991);

        System.out.println("История изменения территориального деления Европы:");
        europe.displayHistory();
    }
}
