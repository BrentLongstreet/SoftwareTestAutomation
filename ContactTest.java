import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
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
  void contactTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactID()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdConstructorTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor one",
              ()
                  -> assertEquals(contactId, contact.getContactID()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor two",
              ()
                  -> assertEquals(contactId, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor three",
              ()
                  -> assertEquals(contactId, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
              phoneNumberTest, addressTest);
    assertAll("constructor four",
              ()
                  -> assertEquals(contactId, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactId, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    contact.setFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.setFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.setFirstName(outOfBoundsFirstName)));
  }

  @Test
  void updateLastNameTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    contact.setLastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.setLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.setLastName(outOfBoundsLastName)));
  }

  @Test
  void updatePhoneNumberTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    contact.setPhoneNumber(phoneNumberTest);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.setPhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.setPhoneNumber(outOfBoundsPhoneNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.setPhoneNumber(shortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.setPhoneNumber(contactId)));
  }

  @Test
  void updateAddressTest() {
	Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    contact.setAddress(addressTest);
    assertAll("phone number",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.setAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.setAddress(outOfBoundsAddress)));
  }


}