/* Tobias Burgess
 * CS-320
 * Milestone One
 */

package contactservice;

// Defines the public class Contact
public class Contact {
	
	// Unique contact ID, max 10 characters, not null, immutable.
	private final String contactId;
	
	// First name of contact, max 10 characters, not null.
	private String firstName;
	
	// Last name of contact, max 10 characters, not null.
	private String lastName;
	
	// Phone number of contact, exactly 10 digits, not null.
	private String phone;
	
	// Address of contact, max 30 characters, not null.
	private String address;
	
	// Constructor to initialize Contact object and it's variables.
	public Contact(String firstName, String lastName, String phone, String address, String contactId) {
        
		/* Validation and initialization for contact ID (not null and max 10 characters).
		 * Throws Illegal Argument Exception if invalid.
		 */
		if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Contact ID can not be null or more than 10 characters");
        this.contactId = contactId; // Initialize if valid.
        
        /* Calls setters for mutable contact fields
         * for validation and initialization.
         */
	    setFirstName(firstName);
	    setLastName(lastName);
	    setPhone(phone);
	    setAddress(address);
	}	
	
	// Getters for all contact fields.
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

	
	//Setter with validation for first name (not null, max 10 characters).
	public void setFirstName(String firstName) {
	    if (firstName == null || firstName.length() > 10) {
	        throw new IllegalArgumentException("First name can not be null or more than 10 characters.");
	    }
	    this.firstName = firstName; //Initialize if valid
	}

	 // Setter with validation for last name (not null, max 10 characters).
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10)
            throw new IllegalArgumentException("Last name must not be null or longer than 10 characters");
        this.lastName = lastName; //Initialize if valid
    }

    // Setter with validation for phone (not null, exactly 10 digits).
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) //uses a regex pattern to match exactly 10 digits
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        this.phone = phone; //Initialize if valid
    }

    // Setter with validation for address (not null, max 30 characters).
    public void setAddress(String address) {
        if (address == null || address.length() > 30)
            throw new IllegalArgumentException("Address must not be null or longer than 30 characters");
        this.address = address; //Initialize if valid
    }
}
