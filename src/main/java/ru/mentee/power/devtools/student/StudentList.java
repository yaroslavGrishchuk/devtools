package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentList {

    private List<Student> studentList;

    private int totalCount = 0;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            studentList.add(student);
            totalCount++;
        }
    }

    public List<Student> getStudentsByCity(String city) {
        return studentList
                .stream()
                .filter(s -> Objects.equals(s.city(), city))
                .collect(Collectors.toList());
    }

    public List<Student>
    getStudentsByCityAndCityStartingWithA(String city) {
        return studentList.stream().filter(s -> Objects.equals(s.city(), city)
                && city.startsWith("A")).collect(Collectors.toList());
    }

    public void printAll() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public int countByCity(String city) {
        int count = 0;
        for (Student s : studentList) {
            if (Objects.equals(s.city(), city)) {
                count++;
            }
        }
        return count;
    }

    public static final int MAX_SIZE = 1000;

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isEmpty() {
        return studentList.isEmpty();
    }
}
