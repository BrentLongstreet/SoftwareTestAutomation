import java.util.Date;

public class Appointment {

  final private String PLACEHOLDER;
  private String appointmentId;
  private Date appointmentDate;
  private String description;

  {
	  PLACEHOLDER = "PLACEHOLDER";
  }
  //create appointment with no arguments
  Appointment() {
    Date today = new Date();
    appointmentId = PLACEHOLDER;
    appointmentDate = today;
    description = PLACEHOLDER;
  }
//create appointment with only id as an argument
  Appointment(String id) {
    Date today = new Date();
    updateAppointmentId(id);
    appointmentDate = today;
    description = PLACEHOLDER;
  }
//create appointment with id and date as an argument
  Appointment(String id, Date date) {
    updateAppointmentId(id);
    updateDate(date);
    description = PLACEHOLDER;
  }
//create appointment with id, date, description as an argument
  Appointment(String id, Date date, String description) {
    updateAppointmentId(id);
    updateDate(date);
    updateDescription(description);
  }

  public void updateAppointmentId(String id) {
	  //throw error if appt id is null
    if (id == null) {
      throw new IllegalArgumentException("Appointment ID cannot be null.");
    } else if (id.length() > 10) {						//throw error if appt id length is > 10
      throw new IllegalArgumentException("Appointment ID cannot exceed " +
                                         10 +
                                         " characters.");
    } else {
    	//update appt id
      this.appointmentId = id;
    }
  }

  //return appt id
  public String getAppointmentId() { return appointmentId; }

  //update appt date
  public void updateDate(Date date) {
	  //throw error if appt date is null
    if (date == null) {
      throw new IllegalArgumentException("The date entered is null");
    } else if (date.before(new Date())) {		// throw error if appt date is in the past
      throw new IllegalArgumentException(
          "The date entered is in the past.");
    } else {
    	//update appt date
      this.appointmentDate = date;
    }
  }
//returns appt date
  public Date getAppointmentDate() { return appointmentDate; }

  public void updateDescription(String description) {
	  //throw error if appt description is null
    if (description == null) {
      throw new IllegalArgumentException(
          "The description entered is null.");
    } else if (description.length() > 50) {		//throw error if description length > 50
      throw new IllegalArgumentException(
          "Appointment description cannot exceed " +
          50 + " characters.");
    } else {
    	//update appt description
      this.description = description;
    }
  }
//returns appt description
  public String getDescription() { return description; }
}
