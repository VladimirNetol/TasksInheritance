package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllAppropriate() {
        SimpleTask simpleTask = new SimpleTask(5, "Решение домашней работы");

        String[] subtasks = {"Сыр", "Колбаса", "Майонез"};
        Epic epic = new Epic(48, subtasks);

        Meeting meeting = new Meeting(
                37,
                "Решение первоочередной задачи",
                "Приложение Монобанка",
                "К вечеру в среду"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Решение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnyMatches() {
        SimpleTask simpleTask = new SimpleTask(18, "Зайти в магазин");

        String[] subtasks = {"Буханка", "Фрукты", "Лимонад"};
        Epic epic = new Epic(76, subtasks);

        Meeting meeting = new Meeting(
                37,
                "Построение графика",
                "Геометрия",
                "Утром в пятницу"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Занятие");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneMatch() {
        SimpleTask simpleTask = new SimpleTask(39, "Пойти в театр");

        String[] subtasks = {"Картофель", "Телефон", "Тетрадь"};
        Epic epic = new Epic(198, subtasks);

        Meeting meeting = new Meeting(
                37,
                "Посмотреть расписание",
                "Театральная неделя",
                "В субботу после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("неделя");
        Assertions.assertArrayEquals(expected, actual);
    }
}