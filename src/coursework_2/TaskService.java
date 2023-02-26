package coursework_2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private Map<Integer, Task> taskMap = new HashMap<>();
    private List<Task> removedTasks = new ArrayList<>();

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public List<Task> getRemovedTasks() {
        return removedTasks;
    }

    public void setRemovedTasks(List<Task> removedTasks) {
        this.removedTasks = removedTasks;
    }

    public void setTaskMap(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public void addTask(Task task) {
            taskMap.put(task.getId(), task);
    }

    public void printAllTasks(Map<Integer, Task> taskMap) {
        taskMap.forEach((key, value) -> System.out.println(key + ". " + value));
    }

    public Task removeTask(int id) {
        for (Map.Entry<Integer, Task> task : getTaskMap().entrySet()) {
            if (task.getKey() == id) {
                return taskMap.remove(id);
            }
        }
        throw new TaskNotFoundException("Задача не найдена!");
    }

    public void addToRemovedTasks(Task task) {
        removedTasks.add(task);
    }

    public void printAllRemovedTasks(List<Task> removedTasks) {
        removedTasks.forEach(System.out::println);
    }

    public List<Map.Entry<Integer, Task>> getAllByDate(LocalDate localDate) {
        return getTaskMap().entrySet().stream()
                .filter(task -> task.getValue().appearsIn(localDate))
                .collect(Collectors.toList());
    }

    public void printTasksByDate(List<Map.Entry<Integer, Task>> tasksByDate) {
        tasksByDate.forEach(task -> System.out.println(task.getKey() + ". " + task.getValue()));
    }

    public Task updateTitle(int id, String title) {
        Task task = getTaskMap().get(id);
        task.setTitle(title);
        return task;
    }
    public Task updateDescription(int id, String description) {
        Task task = getTaskMap().get(id);
        task.setDescription(description);
        return task;
    }

    /*public Map<LocalDate, Collection<Task>> getAllGroupedByDate(LocalDate localDate) {
        Collection <Task> tasks = new ArrayList<>(getTaskMap().values());
        Map<LocalDate, Collection<Task>> tasksGroupedByDate = tasks.stream()
                .collect(Collectors.toMap(task -> getTaskMap().get, task -> ));*/
        /*Map<LocalDate, Collection<Task>> tasksGroupedByDate = new HashMap<>();
        tasksGroupedByDate = */
       /* return put(localDate, tasks);
                */
//    }

}
