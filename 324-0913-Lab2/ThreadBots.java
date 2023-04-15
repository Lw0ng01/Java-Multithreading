//The content of this file defines a Java class named 'ThreadBot' 
//This class inherits from the predefined Java class Thread.

public class ThreadBots extends Thread
{

	int Identity; //This integer variable will be the thread identifier
	char init_char;//This character will be used by each thread as the first letter in the password
	//String letters = "abcdefghijklmnopqrstuvwxzy";   
	char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	int counter = 0;

	//Here we redefine the default constructor of this class.
	//By default it has no arguments, but in this example
	//We are using two arguments
	public ThreadBots(int id, char c) 
	{
		//Here we retrieve the value of the identity passed by the main class
		Identity = id;
		//Here we retrieve the value of the character passed by the main class
		init_char = c;
	}
	
	public void run()
	{
		long startTime = System.currentTimeMillis();

		if (ThreadAttacker.found)
		{
			this.stop();
		}
		
		String password;
		
		for (int i = 0; i < letters.length; i++)
		{
			password = "" + init_char;
			password = password + letters[i];
			String char2 = password;
			
			for (int j = 0; j < letters.length; j++)
			{
				password = password + letters[j];
				String char3 = password;
				
				for (int k = 0; k < letters.length; k++)
				{
					password = password + letters[k];
					String char4 = password;
					
					for (int n = 0; n < letters.length; n++)
					{
						password = password + letters[n];
						
						//System.out.println("Password: " + password + " -");
						counter++;
						
						int hash = (password + ThreadAttacker.challenge).hashCode();
						
						if (hash == ThreadAttacker.captured)
						{							
							ThreadAttacker.found = true;
							
							if (ThreadAttacker.found == true) 
							{
								System.out.println("Password Found: " + password);
								
								long endTime = System.currentTimeMillis();
								System.out.println("Time to find password: " + (endTime - startTime) + "ms");
								
								System.out.println("Password was cracked by: Thread(" + this.Identity + ") ");
								
								System.out.println("Number of iterations: " + counter);
							}
		
						}
						
						if (ThreadAttacker.found == true) 
							this.stop();
						
						password = char4;
					}
					
					password = char3;
				}
				
				password = char2;
			}
			
			password = "" + init_char;
			
		}
							
	}

}
