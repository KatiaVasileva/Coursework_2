package coursework_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();

        /*String title = getTaskTitle();
        String description = getTaskDescription();
        Type type = getTaskType();
        taskService.addTask(getRegularity(title, description, type, LocalDateTime.now()));*/

        taskService.printAllTasks(taskService.getTaskMap());

        Task task1 = new WeeklyTask("Урок Java", "Выполнить домашнее задание", Type.PERSONAL,
                LocalDateTime.now());
        Task task2 = new OneTimeTask("Презентация", "Подготовить презентацию PowerPoint", Type.WORK,
                LocalDateTime.now(),
                LocalDate.of(2023, 3, 25));
        Task task3 = new MonthlyTask("Салон красоты", "Посетить косметолога", Type.PERSONAL,
                LocalDateTime.now());
        Task task4 = new DailyTask("Электронная почта", "Ответить на письма", Type.WORK,
                LocalDateTime.now());
        Task task5 = new YearlyTask("Отчет", "Подготовить годовой отчет", Type.WORK,
                LocalDateTime.now());

        insertSeparator();
        System.out.println("Список всех задач");
        insertSeparator();
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        taskService.addTask(task5);
        taskService.printAllTasks(taskService.getTaskMap());

        insertSeparator();
        LocalDate localDate = LocalDate.of(2023, 3, 25);
        System.out.println("Список задач на " + localDate);
        insertSeparator();
        taskService.printTasksByDate(taskService.getAllByDate(localDate));

        insertSeparator();
        System.out.println("Архив удаленных задач");
        insertSeparator();
        taskService.addToRemovedTasks(taskService.removeTask(3));
        taskService.printAllRemovedTasks(taskService.getRemovedTasks());
        insertSeparator();

        taskService.updateTitle(1, "Курсовая Джава");
        taskService.updateDescription(1, "Выполнить курсовую");
        taskService.printAllTasks(taskService.getTaskMap());

    }



    public static String getTaskTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            System.out.println("Название задачи не введено. Введите название задачи!");
            return getTaskTitle();
        }
    }

    public static String getTaskDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание задачи: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            System.out.println("Описание задачи не введено. Введите описание задачи!");
            return getTaskDescription();
        }
    }

    public static Type getTaskType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип задачи (рабочая, личная): ");
        String typeValue = scanner.nextLine();
        if (typeValue.equals("рабочая")) {
            return Type.WORK;
        } else if (typeValue.equals("личная")) {
            return Type.PERSONAL;
        } else {
            System.out.println("Тип задачи не выбран или выбран не верно.");
            return getTaskType();
        }
    }

    public static Task getRegularity(String title, String description, Type type, LocalDateTime localDateTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите повторяемость задачи (1 - однократно, 2 - ежедневно, 3 - еженедельно, " +
                "4 - ежемесячно, 5 - ежегодно): ");
        int period;
        if (scanner.hasNextInt()) {
            period = scanner.nextInt();
        } else {
            System.out.println("Значение не введено! Введите значение");
            return getRegularity(title, description, type, localDateTime);
        }
        switch (period) {
            case 1:
                System.out.println("Введите дату в формате ГГГГ-ММ-ДД: ");
                scanner.nextLine();
                String date = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date);
                return new OneTimeTask(title, description, type, LocalDateTime.now(), localDate);
            case 2:
                return new DailyTask(title, description, type, LocalDateTime.now());
            case 3:
                return new WeeklyTask(title, description, type, LocalDateTime.now());
            case 4:
                return new MonthlyTask(title, description, type, LocalDateTime.now());
            case 5:
                return new YearlyTask(title, description, type, LocalDateTime.now());
            default:
                System.out.println("Ошибка!");
                return getRegularity(title, description, type, localDateTime);
        }
    }

    public static void insertSeparator() {
        System.out.println("====================================================================================");
    }
}