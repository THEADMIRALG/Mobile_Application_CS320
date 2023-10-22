import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

    Task task;

    @BeforeEach
    public void setup() {
        task = new Task("testID", "Joe1", "This is the first test");
    }
    @Test
    public void setTaskId_ok() {
        task.setTaskId("123456789");
        assertEquals("123456789", task.getTaskId());
    }

    @Test
    public void setTaskId_null(){
        String newContactId = null;
        assertThrows(IllegalArgumentException.class, ()  -> task.setTaskId(newContactId));
    }

    @Test
    public void setTaskId_longerThan10() {
        String newContactId = "1234567891011";
        assertThrows(IllegalArgumentException.class, () -> task.setTaskId(newContactId));
    }

    // first name tests
    @Test
    public void setTaskNameTest_ok() {
        task.setTaskName("Joseph");
        assertEquals("Joseph", task.getTaskName());
    }
    @Test
    public void setTaskNameTest_null() {
        String newTaskName = null;
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(newTaskName));
    }

    @Test
    public void setTaskNameTest_longerThan20() {
        String newTaskName = "Thistasknameistoolong";
        assertThrows(IllegalArgumentException.class, () -> task.setTaskName(newTaskName));
    }

    @Test
    public void setTaskDescriptionTest_ok() {
        task.setTaskDescription("Joseph");
        assertEquals("Joseph", task.getTaskDescription());
    }
    @Test
    public void setTaskDescriptionTest_null() {
        String taskDescription = null;
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(taskDescription));
    }

    @Test
    public void setTaskDescriptionTest_longerThan30() {
        String taskDescription = "Thistaskdescriptionisabsolutelytoolong";
        assertThrows(IllegalArgumentException.class, () -> task.setTaskDescription(taskDescription));
    }

}
