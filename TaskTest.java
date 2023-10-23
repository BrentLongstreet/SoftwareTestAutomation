import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  private String id, name, description;
  private String tooLongId, tooLongName, tooLongDescription;

  @BeforeEach
  void setUp() {
    id = "1234567890";
    name = "This is a valid name";
    description = "This is a valid description of a task.";
    tooLongId = "1234567890123456789012345678901234567890";
    tooLongName = "This task name is too long. This task name is too long. This task name is too long.";
    tooLongDescription =
        "This is an invalid description because it is greater than 50 characters. This is an invalid description because it is greater than 50 characters. This is an invalid description because it is greater than 50 characters.";
  }

  @Test
  void getTaskIdTest() {
	  //create new task and test if getTaskId return the passed in id
    Task task = new Task(id);
    Assertions.assertEquals(id, task.getTaskId());
  }

  @Test
  void getNameTest() {
	//create new task and test if getName return the passed in name
    Task task = new Task(id, name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void getDescriptionTest() {
	//create new task and test if getDescription return the passed in description
    Task task = new Task(id, name, description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void setNameTest() {
    Task task = new Task();
  //set name and check it is updated
    task.setName(name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void setDescriptionTest() {
    Task task = new Task();
    //set description and check it is updated
    task.setDescription(description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void TaskIdTooLongTest() {
	  //ensure an error is thrown if the Id is too many characters
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(tooLongId));
  }

  @Test
  void setTooLongNameTest() {
	//ensure an error is thrown if the name is too many characters
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(tooLongName));
  }

  @Test
  void setTooLongDescriptionTest() {
	//ensure an error is thrown if the description is too many characters
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(tooLongDescription));
  }

  @Test
  void TaskIdNullTest() {
	//ensure an error is thrown if the Id is null
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(null));
  }

  @Test
  void TaskNameNullTest() {
	//ensure an error is thrown if the name is null
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(null));
  }

  @Test
  void TaskDescriptionNullTest() {
	//ensure an error is thrown if the description is null
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(null));
  }
}
