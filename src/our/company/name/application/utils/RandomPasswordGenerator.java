package our.company.name.application.utils;

import java.util.UUID;

public class RandomPasswordGenerator {

	public static String generate() {

		String password = UUID.randomUUID().toString();
		
		password = password.substring(0, 8);
		
		
		//System.out.println("uuid = " + password);

		return password;

	}

	/* The main method is for testing purposes only */
	public static void main (String args[]){
	   
	   
	   for(int i = 0; i <= 8; i++){
	   RandomPasswordGenerator.generate();
	   }
   }

}
