package ru.mentee.power.devtools.progress;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProgressTracker {

    /**
     * Суммарный прогресс группы mentee.
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;

        while (index < mentees.length) {
            totalCompleted += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }

        int remaining = totalTotal - totalCompleted;
        return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal
                + " уроков, осталось " + remaining + " уроков";
    }

    public static void main(String[] args) {
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        System.out.println(new ProgressTracker().calculateTotalProgress(mentees));
    }

    public double averageProgressPercent(Mentee[] mentees) {
        if (mentees.length == 0) {
            throw new IllegalArgumentException("Mentees shouldn't be empty");
        }

        double arithmeticMean = Arrays
                .stream(mentees)
                .map(mentee -> mentee.completedLessons() * 100.0 / mentee.totalLessons())
                .collect(Collectors.averagingDouble(Double::doubleValue));

        return arithmeticMean;
    }
}