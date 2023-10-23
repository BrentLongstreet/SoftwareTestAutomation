import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
	//initialize new appt list
  final private List<Appointment> appointmentList = new ArrayList<>();

  private String newUniqueId() {
	  //generate unique id from length 1-10
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  //add new appt with no arguments
  public void newAppointment() {
    Appointment appt = new Appointment(newUniqueId());
    appointmentList.add(appt);
  }
//add new appt with date argument
  public void newAppointment(Date date) {
    Appointment appt = new Appointment(newUniqueId(), date);
    appointmentList.add(appt);
  }
//add new appt with date and description argument
  public void newAppointment(Date date, String description) {
    Appointment appt = new Appointment(newUniqueId(), date, description);
    appointmentList.add(appt);
  }
//delete appt with given id
  public void deleteAppointment(String id) throws Exception {
    appointmentList.remove(searchForAppointment(id));
  }

  protected List<Appointment> getAppointmentList() { return appointmentList; }
//search for appt with given id
  private Appointment searchForAppointment(String id) throws Exception {
    int index = 0;
    while (index < appointmentList.size()) {
    	//if appt is found
      if (id.equals(appointmentList.get(index).getAppointmentId())) {
        return appointmentList.get(index);
      }
      index++;
    }
    //throw error if appt is not found
    throw new Exception("The appointment does not exist!");
  }
}