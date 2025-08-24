/* Tobias Burgess
 * CS-320
 * Milestone One
 */

package contactservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Defines test class for ContactService
public class ContactServiceTest {

	//Declares reusable objects for testing.
    private ContactService service;
    private Contact contact;

    //Sets up Contact and Contact Service before each test.
    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("FirstName", "LastName", "1234567890", "123 Main St", "id12345678");
    }

    // Test adding a contact
    @Test
    void testAddContactSuccessfully() {
        service.addContact(contact);
    }

    // Test duplicate ID rejection
    @Test
    void testAddDuplicateContactThrowsException() {
        service.addContact(contact);
        Contact duplicate = new Contact("FirstName", "LastName", "1234567890", "123 Main St", "id12345678");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    // Test delete by ID
    @Test
    void testDeleteContactSuccessfully() {
        service.addContact(contact);
        service.deleteContact(contact.getContactId());        
    }
    
    //Test delete non-existent contact
    @Test
    void testDeleteContactFailsIfNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("ID doesnot exist");
        });
    }

    // Test update first name
    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("id12345678", "updated");
    }

    // Test update last name
    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("id12345678", "updated");
    }

    // Test update phone number
    @Test
    void testUpdatePhoneNumber() {
        service.addContact(contact);
        service.updatePhone("id12345678", "0987654321");
    }

    // Test update address
    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("id12345678", "321 Side St");
    }

    //  Test update on invalid ID
    @Test
    void testUpdateFailsIfIdNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("id12345678", "update");
        });
    }

    //  Test update with invalid phone number
    @Test
    void testUpdatePhoneWithInvalidValue() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("id12345678", "123"); 
        });
    }
}
