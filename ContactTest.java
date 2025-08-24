/* Tobias Burgess
 * CS-320
 * Milestone One
 */

package contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Defines the ContactTest class
public class ContactTest {
	
	//Tests that the contact ID is not null or more than 10 characters.
	@Test
	void testContactId() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("FirstName", "LastNAme", "0123456789", "123 Main St", null);
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("FirstName", "LastName", "0123456789", "123 Main St", "id1234567890");
	    });
	    
	    // Test valid contact ID
	    Contact contact = new Contact("FirstName", "LastName", "1234567890", "123 Main St", "id12345678");
	    assertEquals("ID123", contact.getContactId());
	}
	
	// Tests that firstName cannot be null or more than 10 characters.
	@Test
	void testContactFirstName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(null, "LastName", "0123456789", "123 Main St", "id12345678");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("12characters", "LastName", "0123456789", "123 Main St", "id12345678");
	    });
	}
	
	// Tests that firstName cannot be null or more than 10 characters.
	@Test
	void testLasttName() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("FirstName", null, "0123456789", "123 Main St", "id12345678");
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact("FirstName", "12characters", "0123456789", "123 Main St", "id12345678");
	    });
	}
	
	// Tests that phone is not null, exactly 10 digits.
    @Test
    void testPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", null, "123 Main St", "id12345678");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", "123456789", "123 Main St", "id12345678"); // too short
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", "12345678901", "123 Main St", "id12345678"); // too long
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", "isnotdigit", "123 Main St", "id12345678"); // non-numeric
        });
    }
    
    // Tests that the address is not null or more than 30 characters.
    @Test
    void testAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", "0123456789", null, "id12345678");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("FirstName", "LastName", "0123456789", "1234567890 1234567890 1234568790", "id12345678");
        });
    }

}
