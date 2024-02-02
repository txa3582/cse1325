public class Customer
{
	//constructors
	public Customer(String name, String email)
	{
		this.name = name;


		String emailCheck = email.substring('@');

		if (email.contains(String.valueOf('@')))
		{
			if(emailCheck.contains(String.valueOf('.')))
			{
				this.email = email;
			}
			else
			{
				
				throw new IllegalArgumentException("Invalid email address");
			}
		}
		else
		{
			throw new IllegalArgumentException("Invalid email address");
		}


	}

	@Override
	public String toString()
	{
		return name + "(" + email + ")";	
	}

	// fields
	private String name;
	private String email;
}
