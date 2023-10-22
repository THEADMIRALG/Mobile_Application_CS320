public class Task {


    private String taskId;
    private String taskName;
    private String taskDescription;


    public Task(String taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public void setTaskId(String taskId) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("ID does not fulfill requirements.");
        }
        else {
            this.taskId = taskId;
        }

    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Name does not fulfill requirements.");
        }
        else {
            this.taskName = taskName;
        }
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 30) {
            throw new IllegalArgumentException("Description does not fulfill requirements.");
        }
        else {
            this.taskDescription = taskDescription;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}