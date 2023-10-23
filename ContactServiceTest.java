import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String outOfBoundsContactId, outOfBoundsFirstName, outOfBoundsLastName,
  outOfBoundsPhoneNumber, shortPhoneNumber, outOfBoundsAddress;

  @BeforeEach
  void setUp() {
    contactId = "1029F847A6";
    firstNameTest = "Brent";
    lastNameTest = "Longstreet";
    phoneNumberTest = "1234567890";
    addressTest = "123 Random Address Drive";
    outOfBoundsContactId = "12345678901234567890";
    outOfBoundsFirstName = "Brent Tommy Longstreet";
    outOfBoundsLastName = "Brent Tommy Longstreet";
    outOfBoundsPhoneNumber = "1234567890123";
    shortPhoneNumber = "123";
    outOfBoundsAddress = "123 Random Address Drive 123 Random Address Drive 123 Random Address Drive";
  }

  @Test
  void addContactTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    ContactService service = new ContactService();
    service.addContact(contact);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(0).getPhoneNumber()),
        ()
            -> assertEquals(addressTest,
                            service.getContactList().get(0).getAddress()));
    
  }

  @Test
  void deleteContactTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    ContactService service = new ContactService();
    service.addContact(contact);
    assertThrows(Exception.class, () -> service.deleteContact(contactId));
    assertAll(()
                  -> service.deleteContact(
                      service.getContactList().get(0).getContactID()));
  }

  @Test
  void updateFirstNameTest() throws Exception {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	ContactService service = new ContactService();
	service.addContact(contact);
    service.updateFirstName(service.getContactList().get(0).getContactID(),
                            firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactID(),
                         outOfBoundsFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateFirstName(contactId, firstNameTest));
  }

  @Test
  void updateLastNameTest() throws Exception {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	ContactService service = new ContactService();
	service.addContact(contact);
    service.updateLastName(service.getContactList().get(0).getContactID(),
                           lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactID(),
                         outOfBoundsLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateLastName(contactId, lastNameTest));
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	ContactService service = new ContactService();
	service.addContact(contact);
    service.updatePhoneNumber(service.getContactList().get(0).getContactID(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactID(),
                         outOfBoundsPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactID(),
                         shortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        ()
            -> service.updatePhoneNumber(
                service.getContactList().get(0).getContactID(), contactId));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updatePhoneNumber(contactId, lastNameTest));
  }

  @Test
  void updateAddressTest() throws Exception {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	ContactService service = new ContactService();
	service.addContact(contact);
    service.updateAddress(service.getContactList().get(0).getContactID(),
                          addressTest);
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactID(),
                         outOfBoundsAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactID(), null));
    assertThrows(Exception.class,
                 () -> service.updateAddress(contactId, addressTest));
  }
}