package store;

public class Customer
{
	//constructors
	public Customer(String name, String email)
	{
		


		int at = email.indexOf("@");
		int dot = email.indexOf(".", at+1);

		if(at < 0 || dot < 0)
			throw new IllegalArgumentException("Invalid email address: " + email);
		this.email = email;
		this.name = name;

	}

	@Override
	public String toString()
	{
		return name + " (" + email + ")";	
	}

	// fields
	private String name;
	private String email;
}
