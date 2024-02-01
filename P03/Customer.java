public class Customer
{
	//constructors
	public Customer(String name, String email)
	{
		this.name = name;


		String emailCheck = email.substring('@');

		if (email.contains(String.valueOf("@")))
		{
			if(emailCheck.contains(String.valueOf(".")))
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

	public Customer(BufferedReader br)
	{

	}

	public save(BufferedWriter bw)
	{

	}

	@Override
	public String toString()
	{

	}

	// fields
	private String name;
	private String email;
}
