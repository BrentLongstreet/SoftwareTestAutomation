import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

  private String id, description;
  private String tooLongId, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "1234567890";
    description = "A fifty char description. A fifty char description";
    date = new Date(2099, Calendar.JANUARY, 1);
    tooLongId = "123456789012345678901234567890";
    tooLongDescription =
        "This description for the appointment is too long. This description for the appointment is too long. This description for the appointment is too long.";
    pastDate = new Date(0);
  }

  @Test
  void testUpdateAppointmentId() {
	  //create new appt
    Appointment appt = new Appointment();
    //update appt id and pass in null
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateAppointmentId(null));
  //update appt id and pass in out of bounds id
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateAppointmentId(tooLongId));
  //update appt id and pass in valid id
    appt.updateAppointmentId(id);
    //ensure it is equal
    assertEquals(id, appt.getAppointmentId());
  }

  @Test
  void testGetAppointmentId() {
	//create new appt
    Appointment appt = new Appointment(id);
    //test appt id is not null
    assertNotNull(appt.getAppointmentId());
    assertDoesNotThrow(() -> {
    	//test appt id length is equal to 10
        assertEquals(appt.getAppointmentId().length(), 10);
        //test appt id is equal to passed in id
        assertEquals(id, appt.getAppointmentId());
    });
  }

  @Test
  void testUpdateDate() {
	//create new appt
    Appointment appt = new Appointment();
    //pass in null as date
    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
    //pass in past date as date
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDate(pastDate));
    //pass in valid date
    appt.updateDate(date);
    //test appt date is equal to passed in date
    assertEquals(date, appt.getAppointmentDate());
  }

  @Test
  void testGetAppointmentDate() {
	//create new appt with passing in id and date
    Appointment appt = new Appointment(id, date);
    //test appt date is not null
    assertNotNull(appt.getAppointmentDate());
    //test appt date is equal to the passed in date
    assertEquals(date, appt.getAppointmentDate());
  }

  @Test
  void testUpdateDescription() {
	//create new appt
    Appointment appt = new Appointment();
    //pass in null as updated description
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDescription(null));
    //pass in out of bounds description to update
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDescription(tooLongDescription));
    assertDoesNotThrow(() -> {
    	 //update description with valid description
        appt.updateDescription(description);
        //test appt description is equal to the passed in description
        assertEquals(description, appt.getDescription());
    });
  }

  @Test
  void testGetDescription() {
	//create new appt with passing in id, date, and description
    Appointment appt = new Appointment(id, date, description);
    //test if description is null
    assertNotNull(appt.getDescription());
    //test if description length is <= 50
    assertTrue(appt.getDescription().length() <= 50);
    //test if description is equal to the passed in description
    assertEquals(description, appt.getDescription());
  }
}