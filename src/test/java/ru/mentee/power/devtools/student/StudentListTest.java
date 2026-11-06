package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentListTest {
    private static StudentList studentList;

    @BeforeAll
    public static void listInit() {
        studentList = new StudentList();
        studentList.addStudent(new Student("Alex", "Moscow"));
        studentList.addStudent(new Student("Senya", "Arkhangelsk"));
        studentList.addStudent(new Student("Dima", "Moscow"));
        studentList.addStudent(new Student("Lera", "Saint-Petersburg"));
    }

    @Test
    @DisplayName("проверка поиска по городу")
    public void checkCitySearch() {
        List<Student> result = studentList.getStudentsByCity("Moscow");

        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Student::name)
                .containsExactlyInAnyOrder("Alex", "Dima");
    }

    @Test
    @DisplayName("поиск по городу возвращает пустой список для неизвестного города")
    public void checkCitySearchReturnsEmptyForUnknownCity() {
        assertThat(studentList.getStudentsByCity("Kazan")).isEmpty();
    }

    @Test
    @DisplayName("Поиск города и буквы")
    public void checkLetterSearch() {
        assertThat(studentList.getStudentsByCityAndCityStartingWithA("Arkhangelsk")
                .size())
                .isEqualTo(1);
        assertThat(studentList.getStudentsByCityAndCityStartingWithA("Arkhangelsk")
                .getFirst()
                .name())
                .contains("Senya");
    }

    @Test
    @DisplayName("поиск города и буквы возвращает пустой список, если город не начинается с A")
    public void checkLetterSearchReturnsEmptyWhenCityDoesNotStartWithA() {
        assertThat(studentList.getStudentsByCityAndCityStartingWithA("Moscow")).isEmpty();
    }

    @Test
    @DisplayName("addStudent добавляет студента и увеличивает общий счётчик")
    public void checkAddStudent() {
        StudentList student_list = new StudentList();

        student_list.addStudent(new Student("Nina", "Kazan"));

        assertThat(student_list.getTotalCount()).isEqualTo(1);
        assertThat(student_list.isEmpty()).isFalse();
        assertThat(student_list.getStudentsByCity("Kazan"))
                .containsExactly(new Student("Nina", "Kazan"));
    }

    @Test
    @DisplayName("addStudent не добавляет null и не увеличивает счётчик")
    public void checkAddNullStudent() {
        StudentList list = new StudentList();

        list.addStudent(null);

        assertThat(list.getTotalCount()).isZero();
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("countByCity считает студентов в городе")
    public void checkCountByCity() {
        assertThat(studentList.countByCity("Moscow")).isEqualTo(2);
        assertThat(studentList.countByCity("Arkhangelsk")).isEqualTo(1);
        assertThat(studentList.countByCity("Kazan")).isZero();
    }

    @Test
    @DisplayName("getTotalCount возвращает количество добавленных студентов")
    public void checkTotalCount() {
        assertThat(studentList.getTotalCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("isEmpty возвращает true для пустого списка и false для заполненного")
    public void checkIsEmpty() {
        assertThat(new StudentList().isEmpty()).isTrue();
        assertThat(studentList.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("printAll выводит всех студентов")
    public void checkPrintAll() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        try {
            studentList.printAll();
        } finally {
            System.setOut(originalOut);
        }

        String printed = output.toString();

        assertThat(printed).contains("Alex", "Senya", "Dima", "Lera");
        assertThat(printed.lines()).hasSize(4);
    }
}
