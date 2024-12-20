 package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcessor {
    public static List<Student> filterAndSortStudents(List<Student> students) {
        return students.stream()
                .filter(student -> student.getGrade() > 8.0)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Анна", 20, 9.1));
            students.add(new Student("Борис", 21, 8.5));
            students.add(new Student("Виктор", 19, 7.8));
            students.add(new Student("Галина", 22, 9.0));
            students.add(new Student("Дмитрий", 20, 6.5));
            students.add(new Student("Елена", 20, 8.9));

        List<Student> filteredAndSorted = filterAndSortStudents(students);
        filteredAndSorted.forEach(System.out::println);
    }
}
