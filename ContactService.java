import java.util.ArrayList;
import java.util.List;

public class ContactService {
	ArrayList<Contact> contacts;

	public ContactService() {
		contacts = new ArrayList<>();
	}
	// adds contact
	public boolean addContact(Contact newContact) {
		//flag for unique contact id
		boolean isUnique = true;
		for (Contact c : contacts) {
			if(c.getContactID().equalsIgnoreCase(newContact.getContactID())) {
				isUnique = false;
				break;
			}
		}
		//if contact id is not unique
		if(!isUnique) {
			return false;
		}
		//if contact id is unique
		else {
			contacts.add(newContact);
			return true;
		}
	}
	protected List<Contact> getContactList() { return contacts; }
	//deletes contact
	public boolean deleteContact(String contactID) {
		boolean isDeleted = false;
		for (Contact c : contacts) {
			//if passed in contact is in contact list
			if (c.getContactID().equalsIgnoreCase(contactID)) {
				//remove contact
				contacts.remove(c);
				isDeleted = true;
				break;
			}
		}
		return isDeleted;
	}
	//updates contact's first name
	public boolean updateFirstName(String contactID, String newFirstName) {
		boolean isUpdated = false;
		//finds contact matching passed in contactID
		for (Contact c : contacts) {
			if (c.getContactID().equalsIgnoreCase(contactID)) {
				c.setFirstName(newFirstName);
				isUpdated = true;
				break;
			}
		}
		return isUpdated;
	}

	//updates contact's last name
	public boolean updateLastName(String contactID, String newLastName) {
		boolean isUpdated = false;
		//finds contact matching passed in contactID
		for (Contact c : contacts) {
			if (c.getContactID().equalsIgnoreCase(contactID)) {
				c.setLastName(newLastName);
				isUpdated = true;
				break;
			}
		}
		return isUpdated;
	}

	//updates contact's phone number
	public boolean updatePhoneNumber(String contactID, String newNumber) {
		boolean isUpdated = false;
		//finds contact matching passed in contactID
		for (Contact c : contacts) {
			if (c.getContactID().equalsIgnoreCase(contactID)) {
				c.setPhoneNumber(newNumber);
				isUpdated = true;
				break;
			}
		}
		return isUpdated;
	}

	//updates contact's address
	public boolean updateAddress(String contactID, String newAddress) {
		boolean isUpdated = false;
		//finds contact matching passed in contactID
		for (Contact c : contacts) {
			if (c.getContactID().equalsIgnoreCase(contactID)) {
				c.setAddress(newAddress);
				isUpdated = true;
				break;
			}
		}
		return isUpdated;
	}
	
}
