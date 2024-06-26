package store;

/**
 * Holds the name and email of the customer.
 * 
 * @author          Thomas Anderson
 * @version         0.2
 * @since           0.1
 */
public class Customer
{
	//constructors

	/**
	 * Creates a name and email instance.
	 * 
	 * @author          Thomas Anderson
	 * @version         0.2
	 * @since           0.1
	 */
	public Customer(String name, String email)
	{
		int at = email.indexOf("@");
		int dot = email.indexOf(".", at+1);

		if(at < 0 || dot < 0)
			throw new IllegalArgumentException("Invalid email address: " + email);
		this.email = email;
		this.name = name;

	}

	/**
	 * Converts the name and email to a string.
	 * 
	 * @author          Thomas Anderson
	 * @return			the customer name and email string
	 * @version         0.2
	 * @since           0.1
	 */
	@Override
	public String toString()
	{
		return name + " (" + email + ")";	
	}

	// fields
	private String name;
	private String email;
}
