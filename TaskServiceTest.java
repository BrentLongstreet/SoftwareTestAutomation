import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

  private String id, name, description;
  private String tooLongName, tooLongDescription;

  @BeforeEach
  void setUp() {
	    id = "1234567890";
	    name = "This is a valid name";
	    description = "This is a valid description of a task.";
	    tooLongName = "This task name is too long. This task name is too long. This task name is too long.";
	    tooLongDescription =
	        "This is an invalid description because it is greater than 50 characters. This is an invalid description because it is greater than 50 characters. This is an invalid description because it is greater than 50 characters.";
	  }

  @Test
  void newTaskTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
    Assertions.assertNotEquals("PLACEHOLDER",
                               service.getTaskList().get(0).getTaskId());
  }

  @Test
  void newTaskNameTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask(name);
    Assertions.assertNotNull(service.getTaskList().get(0).getName());
    Assertions.assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void newTaskDescriptionTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask(name, description);
    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
    Assertions.assertEquals(description,
                            service.getTaskList().get(0).getDescription());
  }

  @Test
  void newTaskTooLongNameTest() {
	 //creates new task service instance
    TaskService service = new TaskService();
    //test name that is > 10 characters
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> service.newTask(tooLongName));
  }

  @Test
  void newTaskTooLongDescriptionTest() {
    TaskService service = new TaskService();
    //test >50 character description
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, tooLongDescription));
  }

  @Test
  void newTaskNameNullTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //test passing in null for a name of a task
    assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
  }

  @Test
  void newTaskDescriptionNullTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //test passing in null for a name of a description
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, null));
  }

  @Test
  void deleteTaskTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    //test size of list is 1
    assertEquals(1, service.getTaskList().size());
    //delete task
    service.deleteTask(service.getTaskList().get(0).getTaskId());
    //test size of list is 0 after deletion
    assertEquals(0, service.getTaskList().size());
  }

  @Test
  void deleteTaskNotFoundTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    //test size of list is 1
    assertEquals(1, service.getTaskList().size());
    //try to delete a task with an invalid id
    assertThrows(Exception.class, () -> service.deleteTask(id));
    //ensure size of list is still 1 after trying to delete
    assertEquals(1, service.getTaskList().size());
  }

  @Test
  void updateNameTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    //update name
    service.updateName(service.getTaskList().get(0).getTaskId(), name);
    //ensure the name is updated to the new name
    assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void updateDescriptionTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    service.newTask();
    //update description of a task
    service.updateDescription(service.getTaskList().get(0).getTaskId(),
                              description);
    //ensure the description is updated to the new description
    assertEquals(description, service.getTaskList().get(0).getDescription());
  }

  @Test
  void updateNameNotFoundTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    //ensure error is thrown when trying to update name with an invalid id
    assertThrows(Exception.class, () -> service.updateName(id, name));
  }

  @Test
  void updateDescriptionNotFoundTest() throws Exception {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new task to the instance
    service.newTask();
    //ensure error is thrown when trying to update description with an invalid id
    assertThrows(Exception.class,
                 () -> service.updateDescription(id, description));
  }

  @RepeatedTest(4)
  void UuidTest() {
	//creates new task service instance
    TaskService service = new TaskService();
    //adds new tasks to the instance
    service.newTask();
    service.newTask();
    service.newTask();
    assertEquals(3, service.getTaskList().size());
    //ensure each id is unique
    assertNotEquals(service.getTaskList().get(0).getTaskId(),
                    service.getTaskList().get(1).getTaskId());
    assertNotEquals(service.getTaskList().get(0).getTaskId(),
                    service.getTaskList().get(2).getTaskId());
    assertNotEquals(service.getTaskList().get(1).getTaskId(),
                    service.getTaskList().get(2).getTaskId());
  }
}