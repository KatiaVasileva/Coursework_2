package coursework_2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи: ");
        System.out.println("Введите описание задачи: ");
        System.out.println("Выберите тип задачи: 1 - рабочая, 2 - личная");
        String taskName = scanner.nextLine();
        String taskDescription = scanner.nextLine();*/

        TaskService taskService = new TaskService();

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

    }



   /* public static String getNewTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            System.out.println("Название задачи не введено. Введите название задачи!");
            return getNewTask();
        }
    }

    public static String getNewDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание задачи: ");
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            System.out.println("Описание задачи не введено. Введите описание задачи!");
            return getNewDescription();
        }
    }

    public static Type getNewType() {*/

    /*}*/
    public static void insertSeparator() {
        System.out.println("====================================================================================");
    }
}