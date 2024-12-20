import org.example.Student;
import org.example.StudentProcessor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class StudentProcessorTest {

    @Test
    public void testFilterAndSortStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Анна", 20, 9.0));
        students.add(new Student("Виктор", 22, 7.5));
        students.add(new Student("Иван", 19, 8.5));
        students.add(new Student("Ольга", 21, 9.5));
        students.add(new Student("Борис", 23, 6.0));

        List<Student> expected = List.of(
                new Student("Анна", 20, 9.0),
                new Student("Иван", 19, 8.5),
                new Student("Ольга", 21, 9.5)
        );

        List<Student> result = StudentProcessor.filterAndSortStudents(students);
        Assertions.assertEquals(expected.size(), result.size());
        Assertions.assertEquals(expected.get(0).getName(), result.get(0).getName());
        Assertions.assertEquals(expected.get(1).getName(), result.get(1).getName());
        Assertions.assertEquals(expected.get(2).getName(), result.get(2).getName());
    }
}
