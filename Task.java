public class Task {

  private String taskId;
  private String name;
  private String description;

  //task constructor with no arguments
  Task() {
    taskId = "PLACEHOLDER";
    name = "PLACEHOLDER";
    description = "PLACEHOLDER DESCRIPTION";
  }
  //task constructor with taskId as argument
  Task(String taskId) {
    checkTaskId(taskId);
    name = "PLACEHOLDER";
    description = "PLACEHOLDER DESCRIPTION";
  }
  //task constructor with taskId and name as arguments
  Task(String taskId, String name) {
    checkTaskId(taskId);
    setName(name);
    description = "PLACEHOLDER DESCRIPTION";
  }
  //task constructor with taskId name and description arguments
  Task(String taskId, String name, String desc) {
    checkTaskId(taskId);
    setName(name);
    setDescription(desc);
  }


  protected void setName(String name) {
	  //check if name is empty or greater than 20 characters
    if (name == null || name.length() > 20) {
      throw new IllegalArgumentException(
          "Task name is either empty and/or greater than 20 characters");
    } else {
    	//valid name, set name
      this.name = name;
    }
  }

  //return name
  public final String getName() { return name; }

  protected void setDescription(String taskDescription) {
	//check if description is empty or greater than 50 characters
    if (taskDescription == null || taskDescription.length() > 50) {
      throw new IllegalArgumentException(
          "Task description is empty and/or greater than 50 characters");
    } else {
    	//valid description, set description
      this.description = taskDescription;
    }
  }

  //return description
  public final String getDescription() { return description; }
  
  private void checkTaskId(String taskId) {
	//check if task id is empty or greater than 10 characters
    if (taskId == null || taskId.length() > 10) {
      throw new IllegalArgumentException(
          "Task id is either empty and/or greater than 10 characters");
    } else {
    	//valid task id, set task id
      this.taskId = taskId;
    }
  }
  
  //return task id
  public final String getTaskId() { return taskId; }
}
