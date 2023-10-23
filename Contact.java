public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//Contact constructor
	public Contact(String contactId, String fName, String lName, String phoneNum, String address) {
		if(contactId.length() <= 10 && contactId != null) {
			this.contactID = contactId;
		}
		this.setFirstName(fName);
		this.setLastName(lName);
		this.setPhoneNumber(phoneNum);
		this.setAddress(address);
	}
	//setter methods
	public void setFirstName(String fName) {
		if(fName.length() <= 10 && fName != null) {
			this.firstName = fName;
		}
	}
	
	public void setLastName(String lName) {
		if(lName.length() <= 10 && lName != null) {
			this.lastName = lName;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() == 10 && phoneNumber != null) {
			this.phoneNumber = phoneNumber;
		}
	}
	
	public void setAddress(String address) {
		if(address.length() <= 30 && address != null) {
			this.address = address;
		}
	}
	//getter methods
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
}
