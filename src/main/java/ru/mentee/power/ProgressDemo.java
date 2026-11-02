package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        System.out.println("feature/DVT-3");
        MenteeProgress progress = new MenteeProgress(
                "Yaroslav", // значение из твоего плана PLAN-2
                1,               // номер спринта
                6                // запланированные часы на спринт
        );

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
