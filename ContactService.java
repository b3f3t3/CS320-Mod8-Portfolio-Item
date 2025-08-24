/* Tobias Burgess
 * CS-320
 * Milestone One
 */

package contactservice;

import java.util.ArrayList;
import java.util.List;

// Defines the ContactService class for managing Contact objects.
public class ContactService {
	
	// Create list for storing contacts
    private final List<Contact> contacts = new ArrayList<>();

    // Validates contact before adding
    public void addContact(Contact newContact) {
        
    	// Ensure contact is not null
    	if (newContact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
    	//Ensure contact ID is unique
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(newContact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists: " + newContact.getContactId());
            }
        }

        contacts.add(newContact); //Add if valid.
    }

    //  Delete a contact by ID
    public void deleteContact(String contactId) {
        boolean removed = contacts.removeIf(contact -> contact.getContactId().equals(contactId));
        if (!removed) {
            throw new IllegalArgumentException("Contact ID not found: " + contactId);
        }
    }

    //  Update contact's first name
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = findContact(contactId);
        contact.setFirstName(newFirstName);
    }

    //  Update contact's last name
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = findContact(contactId);
        contact.setLastName(newLastName);
    }

    //  Update contact's phone number
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = findContact(contactId);
        contact.setPhone(newPhone);
    }

    //  Update contact's address
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = findContact(contactId);
        contact.setAddress(newAddress);
    }

    // Helper method to find contact by ID
    private Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact ID not found: " + contactId);
    }
}
