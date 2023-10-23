import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	//initialize new list
  private final List<Task> taskList = new ArrayList<>();

  //generate new unique id 1-10
  private String newUniqueId() {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  //search for task with the passed in id
  private Task searchForTask(String id) throws Exception {
	  //start at index 0
    int index = 0;
    //loop throughout the list
    while (index < taskList.size()) {
    	//if tasks is found with the given id
      if (id.equals(taskList.get(index).getTaskId())) {
    	  //return found task
        return taskList.get(index);
      }
      //increment index
      index++;
    }
    //if task is not found
    throw new Exception("Unable to locate task.");
  }

  //add new task to list with no given arguments
  public void newTask() {
	  //create task for unique id
    Task task = new Task(newUniqueId());
    //append new task
    taskList.add(task);
  }

  //add new task to list with name as an argument
  public void newTask(String name) {
	//create task for unique id
    Task task = new Task(newUniqueId(), name);
  //append new task
    taskList.add(task);
  }

  //add new task to list with name and description as an argument
  public void newTask(String name, String description) {
	//create task for unique id
    Task task = new Task(newUniqueId(), name, description);
  //append new task
    taskList.add(task);
  }

  //remove task with the given id
  public void deleteTask(String id) throws Exception {
    taskList.remove(searchForTask(id));
  }

  //update name of task of the given id and new name
  public void updateName(String id, String name) throws Exception {
    searchForTask(id).setName(name);
  }

//update description of task of the given id and new description
  public void updateDescription(String id, String description)
      throws Exception {
    searchForTask(id).setDescription(description);
  }

  //return list of tasks
  public List<Task> getTaskList() { return taskList; }
}