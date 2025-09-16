package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void simplePositiveTaskTest() {
        SimpleTask task = new SimpleTask(5, "Сделать домашнюю работу");

        boolean actual = true;
        boolean expected = task.matches("Сделать домашнюю работу");

        assertEquals(expected, actual);
    }

    @Test
    public void simpleNegativeTaskTest() {
        SimpleTask task = new SimpleTask(5, "Сделать домашнюю работу");

        boolean actual = false;
        boolean expected = task.matches("Пропустить занятие");

        assertEquals(expected, actual);
    }

    @Test
    public void epicPositiveTaskTest() {
        String[] subtasks = {"Сыр", "Колбаса", "Майонез"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = true;
        boolean expected = epic.matches("Колбаса");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicNegativeTaskTest() {
        String[] subtasks = {"Сыр", "Колбаса", "Майонез"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = false;
        boolean expected = epic.matches("Чипсы");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicPositiveTaskTest() {
        Meeting meeting = new Meeting(
                37,
                "Решение первоочередной задачи",
                "Приложение Монобанка",
                "К вечеру в среду"
        );

        boolean actual = true;
        boolean expected = meeting.matches("Решение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicNegativeTaskTest() {
        Meeting meeting = new Meeting(
                37,
                "Решение первоочередной задачи",
                "Приложение Монобанка",
                "К вечеру в среду"
        );

        boolean actual = false;
        boolean expected = meeting.matches("К вечеру в среду");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectPositiveTaskTest() {
        Meeting meeting = new Meeting(
                37,
                "Решение первоочередной задачи",
                "Приложение Монобанка",
                "К вечеру в среду"
        );

        boolean actual = true;
        boolean expected = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectNegativeTaskTest() {
        Meeting meeting = new Meeting(
                37,
                "Решение первоочередной задачи",
                "Приложение Монобанка",
                "К вечеру в среду"
        );

        boolean actual = false;
        boolean expected = meeting.matches("Мнение");

        Assertions.assertEquals(expected, actual);
    }
}