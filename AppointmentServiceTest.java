import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
  private String id, description, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "1234567890";
    description = "This is a description for the appointment.";
    date = new Date(2099, Calendar.JANUARY, 1);
    tooLongDescription =
        "This description for the appointment is too long. This description for the appointment is too long. This description for the appointment is too long.";
    pastDate = new Date(0);
  }

  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();
    //create new appt passing in no arguments
    service.newAppointment();
    //test values are not null
    assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
    assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(0).getDescription());

  //create new appt passing in date
    service.newAppointment(date);
    assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
    assertEquals(date,
                 service.getAppointmentList().get(1).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(1).getDescription());

  //create new appt passing in date and description
    service.newAppointment(date, description);
    assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
    assertEquals(date,
                 service.getAppointmentList().get(2).getAppointmentDate());
    assertEquals(description,
                 service.getAppointmentList().get(2).getDescription());
    //test values are equal
    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                    service.getAppointmentList().get(1).getAppointmentId());
    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                    service.getAppointmentList().get(2).getAppointmentId());
    assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
                    service.getAppointmentList().get(2).getAppointmentId());
    //ensure error when passing in past date
    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(pastDate));
    // ensure error when passing in long description
    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(date, tooLongDescription));
  }

  @Test
  void deleteAppointment() throws Exception {
    AppointmentService service = new AppointmentService();
    //create three new appointments
    service.newAppointment();
    service.newAppointment();
    service.newAppointment();
    //retrieve each appt unique id
    String firstId = service.getAppointmentList().get(0).getAppointmentId();
    String secondId = service.getAppointmentList().get(1).getAppointmentId();
    String thirdId = service.getAppointmentList().get(2).getAppointmentId();
    //ensure id's are unique
    assertNotEquals(firstId, secondId);
    assertNotEquals(firstId, thirdId);
    assertNotEquals(secondId, thirdId);
    
    //test base case
    assertNotEquals(id, firstId);
    assertNotEquals(id, secondId);
    assertNotEquals(id, thirdId);

    assertThrows(Exception.class, () -> service.deleteAppointment(id));
    //call delete appt on first one
    service.deleteAppointment(firstId);
    assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
    assertNotEquals(firstId,
                    service.getAppointmentList().get(0).getAppointmentId());
  }
}
