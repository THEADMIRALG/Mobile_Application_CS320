import java.util.ArrayList;

public class TaskService {

    static ArrayList<Task> taskList = new ArrayList<Task>();

    public void addTask(Task newTask) {
        if (taskList.stream().noneMatch(t -> t.getTaskId().equals(newTask.getTaskId()))) {
            taskList.add(newTask);
        }
    }

    public void delete(String id) {
        taskList.remove(taskList.stream().filter(c -> c.getTaskId().equals(id)).findFirst().orElse(null));
    }

    public void updateTask(Task updateTask) {
        Task matchingTask = taskList.stream().filter(c -> c.getTaskId().equals(updateTask.getTaskId())).findFirst().orElse(null);
        if(matchingTask != null) {
            matchingTask.setTaskName(updateTask.getTaskName());
            matchingTask.setTaskDescription(updateTask.getTaskDescription());

        }
        else{
            throw new IllegalArgumentException("Task Id not found.");
        }
    }
}
