import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    TaskService taskService;

    @BeforeEach
    public void setup() {

        taskService = new TaskService();
        // Clear the list so that tests don't affect each other
        TaskService.taskList.clear();
        TaskService.taskList.add(new Task("1", "Joe1", "This is the first test"));
        TaskService.taskList.add(new Task("2", "Joe2", "This is the second test"));
        TaskService.taskList.add(new Task("3", "Joe3", "This is the third test"));
        TaskService.taskList.add(new Task("4", "Joe4", "This is the fourth test"));
    }

    @Test
    public void addTaskTest_ok() {
        Task taskToBeAdded =new Task("5", "Joe5", "This is a test");
        taskService.addTask(taskToBeAdded);
        assertEquals(5, TaskService.taskList.size());
    }
    @Test
    public void addTaskTest_duplicateID() {
        Task taskToBeAdded =new Task("1", "Joe1", "This is a test");
        taskService.addTask(taskToBeAdded);
        assertEquals(4, taskService.taskList.size());
    }
    @Test
    public void deleteTaskTest_ok () {
        String deleteId = "1";
        taskService.delete(deleteId);
        assertEquals(3, TaskService.taskList.size());
    }
    @Test
    public void deleteTaskTest_noId() {
        String deleteId = "6";
        taskService.delete(deleteId);
        assertEquals(4, TaskService.taskList.size());
    }

    @Test
    public void updateContactTest_ok () {
        Task TaskToBeUpdated =new Task("4", "Joe6", "This is the third test");
        taskService.updateTask(TaskToBeUpdated);
        assertEquals("Joe6", TaskService.taskList.get(3).getTaskName());
        assertEquals("This is the third test", TaskService.taskList.get(3).getTaskDescription());
    }
    @Test
    public void updateTaskTest_duplicate () {
        Task TaskToBeUpdated =new Task("5", "Joe6", "This is the third test");
        assertThrows(IllegalArgumentException.class, () ->taskService.updateTask(TaskToBeUpdated));
    }
}
